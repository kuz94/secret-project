alter table `equip_type` add column `parent_type_id` bigint;

alter table `equip_type` add constraint foreign key (`parent_type_id`) references `equip_type`(`id`);