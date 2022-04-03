package org.example.cloud.nativ;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="friendly_message")
public class FriendlyMessage extends PanacheEntity {

    private String name;

    private String content;

    private String language;

    private String country;

    private boolean romanic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String message) {
        this.content = message;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isRomanic() {
        return romanic;
    }

    public void setRomanic(boolean reciprocal) {
        this.romanic = reciprocal;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", romanic=" + romanic +
                '}';
    }
}