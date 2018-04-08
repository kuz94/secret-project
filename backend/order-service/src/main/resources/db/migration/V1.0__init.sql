create table `order` (
    `id` bigint not null auto_increment,
    `shop_id` bigint not null,
    `user_id` bigint not null,
    `equip_id` bigint not null,
    `start` timestamp not null,
    
    primary key (`id`)
);