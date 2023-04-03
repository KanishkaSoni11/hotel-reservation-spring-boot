create database hotel_reservation_system;

use hotel_reservation_system;

create table room(
                     room_number int primary key not null,
                     room_type varchar(60) not null,
                     availability_status varchar(20) not null,
                     cost decimal(12, 2) not null
);

create table bill_details(
                             bill_id int primary key not null,
                             room_number int not null,
                             payment_method varchar(15) not null,
                             payment_details varchar(100) not null,
                             bill_date date not null,
                             foreign key(room_number) references room(room_number) on update cascade on delete cascade
);

create table staff(
                      staff_id int primary key not null,
                      first_name varchar(60) not null,
                      last_name varchar(60) not null,
                      street varchar(50) not null,
                      state varchar(20) not null,
                      zipcode int not null,
                      email_id varchar(100) not null,
                      contact_no int not null,
                      salary decimal(12,2) not null,
                      joining_date date not null
);

create table reservation(
                            reservation_number int primary key  not null,
                            number_of_rooms int not null,
                            number_of_guests int not null,
                            type_of_room varchar(40) not null,
                            date_of_reservation date not null,
                            date_from date not null,
                            date_to date not null
);

create table reservation_assignment(
                                       reservation_number int not null,
                                       staff_id int not null,
                                       room_number int not null,
                                       foreign key(reservation_number) references reservation(reservation_number) on update cascade on delete cascade,
                                       foreign key(staff_id) references staff(staff_id) on update cascade on delete cascade,
                                       foreign key(room_number) references room(room_number) on update cascade on delete cascade,
                                       primary key(reservation_number, staff_id, room_number)
);


create table order_details (
                               order_id int primary key not null,
                               cost decimal(10,2) not null,
                               room_number int not null,
                               staff_responsible int not null,
                               foreign key(room_number) references room(room_number) on update cascade on delete cascade,
                               foreign key(staff_responsible) references staff(staff_id) on update cascade on delete cascade
);

create table food_item(
                          item_id int primary key not null,
                          item_name varchar(20) not null,
                          item_desc varchar(50) not null,
                          item_available boolean not null,
                          cost decimal(10,2) not null
);

create table order_quantity(
                               order_id int not null,
                               item_id int not null,
                               foreign key(order_id) references order_details(order_id) on update cascade on delete cascade,
                               foreign key(item_id) references food_item(item_id) on update cascade on delete cascade,
                               primary key(order_id, item_id)
);

create table customer(
                         customer_id int primary key not null,
                         first_name varchar(60) not null,
                         last_name varchar(60) not null,
                         street varchar(50) not null,
                         state varchar(20) not null,
                         zipcode int not null,
                         email_id varchar(100) not null,
                         contact_no int not null,
                         identification_number varchar(50) not null
);

create table reservation_placed(
                                   customer_id int not null,
                                   reservation_id int not null,
                                   primary key(customer_id, reservation_id),
                                   foreign key(reservation_id) references reservation(reservation_number) on update cascade on delete cascade,
                                   foreign key(customer_id) references customer(customer_id) on update cascade on delete cascade
);

create table room_bill_details(
                                  room_number int not null,
                                  bill_id int not null,
                                  foreign key(room_number) references room(room_number) on update cascade on delete cascade,
                                  foreign key(bill_id) references bill_details(bill_id) on update cascade on delete cascade,
                                  primary key(room_number, bill_id)
);

alter table customer add password varchar(20);

alter table staff add password varchar(20);

alter table order_quantity add quantity int;