create table `category` (
    `id` bigint not null auto_increment,
    `name` nvarchar(255) not null,
    `parent_id` bigint,
    `type_id` bigint,

    primary key(`id`),

    foreign key (`parent_id`)
        references `category`(`id`),
    foreign key (`type_id`)
        references `equip_type`(`id`)

);

create table `equip_type` (
    `id` bigint not null auto_increment,
    `name` nvarchar(255) not null,
    `category_id` bigint not null,

    primary key(`id`),

    foreign key (`category_id`)
        references `category`(`id`)
);

create table `equip_attributes` (
    `id` bigint not null auto_increment,
    `name` nvarchar(255) not null,
    `type_id` bigint not null,
    `data_type` int not null,
    
    primary key (`id`),
    
    foreign key (`type_id`)
      references `equip_type`(`id`)
);

create table `equip` (
    `id` bigint not null auto_increment,
    `name` nvarchar(255) not null,
    `type_id` bigint not null,
    `shop_id` bigint not null,

    primary key (`id`),
    
    foreign key (`shop_id`)
      references `shop`(`id`),
    foreign key (`type_id`)
      references `equip_type`(`id`)
);