package org.example.cloud.nativ;

import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class FriendService {

    @Transactional
    public Uni<Integer> update(String content, String language) {
        return Uni.createFrom().item(content).onItem()
                .transform(n -> Friend.update("content=?1 where language=?2", content, language));
    }
}
