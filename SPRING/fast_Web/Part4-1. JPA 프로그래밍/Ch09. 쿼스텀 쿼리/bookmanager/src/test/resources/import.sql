insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (1, 'martin', 'martin@fastcampus.com', now(), now());

insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (2, 'dennis', 'dennis@fastcampus.com', now(), now());

insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (3, 'sophia', 'sophia@slowcampus.com', now(), now());

insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (4, 'james', 'james@slowcampus.com', now(), now());

insert into user (`id`, `name`, `email`, `created_at`, `updated_at`) values (5, 'martin', 'martin@another.com', now(), now());

insert into publisher (`id`, `name`, `created_at`, `updated_at`) values (1, '패스트캠퍼스', now(), now());

insert into book(`id`, `name`, `publisher_id`, `deleted`, `status`) values (1, 'JPA 초격차 패키지', 1, false, 100);

insert into book(`id`, `name`, `publisher_id`, `deleted`, `status`) values (2, 'Spring security 초격차 패키지', 1, false, 200);

insert into book(`id`, `name`, `publisher_id`, `deleted`, `status`) values (3, 'SpringBoot 올인원 패키지', 1, true, 100);

