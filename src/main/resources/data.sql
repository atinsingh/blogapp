create table USER
(
    USER_ID     int          not null,
    FIRST_NAME  VARCHAR(255) null,
    LAST_NAME   VARCHAR(255) null,
    CREATE_DATE datetime     null,
    constraint USER_pk
        primary key (USER_ID)
);

create table BLOG
(
    BLOG_ID int not null,
    USER_ID int not null,
    BLOG_TXT varchar(2500),
    BLOG_CATEGORY varchar(255),
    constraint BLOCK_pk
        primary key (BLOG_ID)
);