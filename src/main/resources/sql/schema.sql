create schema if not exists barbershop collate utf8mb4_0900_ai_ci;

use barbershop;

create table if not exists reservation
(
    reservation_id int not null auto_increment primary key ,
    client_name char(30) not null,
    client_email char(50) not null,
    client_mobile int(10) not null,
    location_id int(10) not null,
    workitem_id int(10) not null
);

create table if not exists workitem
(
    workitem_id int not null  primary key ,
    workitem_name char(15) not null,
    workitem_fee int(3) not null,
    workitem_duration int(2) not null
);

create table if not exists location
(
    location_id int not null  primary key ,
    location_name char (15) not null,
    location_adress char (100) not null
);


ALTER TABLE reservation
    ADD constraint fk_reservation_location FOREIGN KEY (location_id)
        REFERENCES location(location_id);

ALTER TABLE reservation
    ADD CONSTRAINT fk_reservatin_workitem FOREIGN KEY (workitem_id)
        REFERENCES workitem(workitem_id);
INSERT INTO barbershop.workitem (workitem_id, workitem_name, workitem_fee, workitem_duration) VALUES (1, 'haircut', 30, 20);
INSERT INTO barbershop.workitem (workitem_id, workitem_name, workitem_fee, workitem_duration) VALUES (2, 'shave', 50, 20);
INSERT INTO barbershop.workitem (workitem_id, workitem_name, workitem_fee, workitem_duration) VALUES (3, 'haircutAndShave', 80, 40);
INSERT INTO barbershop.location (location_id, location_name, location_adress) VALUES (1,'Bucuresti', 'Calea Mosilor, nr.24');
INSERT INTO barbershop.location(location_id, location_name, location_adress) VALUES (2, 'Sibiu', 'Str. Barbierilor nr.1');
INSERT INTO barbershop.reservation (reservation_id, client_name, client_email, client_mobile, location_id, workitem_id) VALUES (1,'Catalin','catalin@gmail.com',0767549228,1,2);
INSERT INTO barbershop.reservation (reservation_id, client_name, client_email, client_mobile, location_id, workitem_id) VALUES (2,'Vladimir','vladimir@gmail.com',0757666666,2,2);
INSERT INTO barbershop.reservation(reservation_id, client_name, client_email, client_mobile, location_id, workitem_id) VALUES (3,'Daniel','daniel@yahoo.com',0474231213,1,3);
INSERT INTO barbershop.reservation(reservation_id, client_name, client_email, client_mobile, location_id, workitem_id) VALUES (4,'Florin','florin@yahoo.com',042123456,1,1);
INSERT INTO barbershop.reservation(reservation_id, client_name, client_email, client_mobile, location_id, workitem_id) VALUES (5,'Andrei','andrei@gmail.com',021303045,2,3);
INSERT INTO barbershop.reservation(reservation_id, client_name, client_email, client_mobile, location_id, workitem_id) VALUES (6,'Geo','geo@gmail.com',0755453123,2,1);
INSERT INTO barbershop.reservation(reservation_id, client_name, client_email, client_mobile, location_id, workitem_id) VALUES (7,'Ilie','ilei@yahoo.com',0766445522,2,2);