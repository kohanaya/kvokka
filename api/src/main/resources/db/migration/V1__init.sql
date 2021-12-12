create table user_profile
(
    id         int auto_increment primary key,
    username   varchar(50) not null,
    password   varchar(72) not null,
    full_name  varchar(50) not null,
    created_at datetime    not null default now()
);

create table project
(
    id   int auto_increment primary key,
    name varchar(50) not null
);

create table task
(
    id          int auto_increment primary key,
    title       varchar(50)                                      not null,
    description text                                             null,
    status      enum ('BACKLOG', 'READY', 'IN_PROGRESS', 'DONE') not null default 'BACKLOG',
    project_id  int                                              not null,
    assigned_to int                                              null,
    created_at  datetime                                         not null default NOW(),
    updated_at  datetime                                         not null default NOW(),

    constraint fk_task_project
        foreign key (project_id)
            references project (id)
            on delete cascade
            on update cascade,

    constraint fk_task_user
        foreign key (assigned_to)
            references user_profile (id)
            on delete cascade
            on update cascade
);

-- TEST DATA

insert into user_profile (id, username, password, full_name, created_at)
values (1, 'admin', '$2a$10$QJ/XEuXhFNOX7Z76NcmH6ePi5Qd63bmdEeTchxhpiIBTRe2wBCN6i', 'John Johnson', now());
