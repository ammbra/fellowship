create table Friend
(
    id int8 not null,
    country varchar(255),
    language varchar(255),
    content varchar(255),
    name varchar(255),
    persistent boolean,
    primary key (id)
);
insert into Friend(name, content, country, language, persistent, id) values('Friend1','Hello', 'United Kingdom', 'en', false, nextval('hibernate_sequence'));
insert into Friend(name, content, country, language, persistent, id) values('Friend2', 'Hola', 'Spain', 'es', true, nextval('hibernate_sequence'));
insert into Friend(name, content, country, language, persistent,id) values('Friend3', 'Salut', 'Romania', 'ro', true, nextval('hibernate_sequence'));
insert into Friend(name, content, country, language, persistent,id) values('Friend4', 'Bonjour', 'France', 'fr', false, nextval('hibernate_sequence'));