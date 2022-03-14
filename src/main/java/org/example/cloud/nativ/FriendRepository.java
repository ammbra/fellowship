package org.example.cloud.nativ;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class FriendRepository implements PanacheRepository<Friend> {


    @Transactional
    public Uni<Integer> update(String greeting, String language) {
        return Uni.createFrom().item(greeting)
                .onItem().transform(n -> Friend.update("content=?1 where language=?2", greeting, language));
    }

}
