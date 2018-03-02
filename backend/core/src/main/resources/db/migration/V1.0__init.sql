create table `user` (
    `id` bigint not null,
    `name` nvarchar(255) not null,
    `email` nvarchar(255),
    
    primary key(`id`)    
);

create table `shop` (
    `id` bigint not null,
    `name` nvarchar(255) not null,
    
    primary key(`id`)    
);

create table `equip_type` (
    `id` bigint not null,
    `name` nvarchar(255) not null,
    
    primary key(`id`)    
);

create table `equip_attributes` (
    `id` bigint not null,
    `type_id` bigint not null,
    `name` nvarchar(255) not null,
    `data_type` int not null,
    
    primary key (`id`),
    
    foreign key (`type_id`)
      references `equip_type`(`id`)
);

create table `equip` (
    `id` bigint not null,
    `shop_id` bigint not null,
    `type_id` bigint not null,
    `name` nvarchar(255) not null,
    `data_type` int not null,
    
    primary key (`id`),
    
    foreign key (`shop_id`)
      references `shop`(`id`),
    foreign key (`type_id`)
      references `equip_type`(`id`)
);

create table `order` (
    `id` bigint not null,
    `shop_id` bigint not null,
    `user_id` bigint not null,
    `equip_id` bigint not null,
    `start` timestamp not null,
    
    primary key (`id`),
    
    foreign key (`shop_id`)
      references `shop`(`id`),
    foreign key (`user_id`)
      references `user`(`id`),
    foreign key (`equip_id`)
      references `equip`(`id`)
);