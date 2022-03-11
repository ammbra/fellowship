package org.example.cloud.nativ;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Friend extends PanacheEntityBase{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String content;

    private String language;

    private String country;

    private boolean persistent;

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

    public boolean isPersistent() {
        return persistent;
    }

    public void setPersistent(boolean reciprocal) {
        this.persistent = reciprocal;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", persistent=" + persistent +
                '}';
    }
}