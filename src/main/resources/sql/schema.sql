create schema if not exists barbershop collate utf8mb4_0900_ai_ci;

use barbershop;

create table if not exists reservation
(
    reservation_id int null,
    client_name char(30) not null,
    client_email char(50) not null,
    client_mobile int(10) not null,
    location_id int(10) not null,
    workitem_id int(10) not null
);

create table if not exists workitem
(
    workitem_id int not null,
    workitem_name char(15) not null,
    workitem_fee int(3) not null,
    workitem_duration int(2) not null
);

INSERT INTO barbershop.workitem (workitem_id, workitem_name, workitem_fee, workitem_duration) VALUES (1, 'haircut', 30, 20);
INSERT INTO barbershop.workitem (workitem_id, workitem_name, workitem_fee, workitem_duration) VALUES (2, 'shave', 50, 20);
INSERT INTO barbershop.workitem (workitem_id, workitem_name, workitem_fee, workitem_duration) VALUES (3, 'haircutAndShave', 80, 40);