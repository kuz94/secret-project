create table `user` (
    `id` bigint not null auto_increment,
    `name` nvarchar(255) not null,
    `email` nvarchar(255),
    
    primary key(`id`)    
);

create table `shop` (
    `id` bigint not null auto_increment,
    `name` nvarchar(255) not null,
    
    primary key(`id`)    
);