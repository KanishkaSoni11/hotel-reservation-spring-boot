delimiter $$
create function isReservationPossible (
to_date date,
from_date date,
num_rooms int,
room_type varchar(20))
returns int
deterministic
begin
	declare result boolean;
    declare count_rooms int;
    select count(*) into count_rooms from
	(
		select r.*, ra.reservation_number from room r
		left join reservation_assignment ra
		on r.room_number = ra.room_number
	) as t
	left join reservation res on
	res.reservation_number = t.reservation_number
	where t.room_number not in (
		select room_number from reservation res join
		reservation_assignment ra
		on res.reservation_number = ra.reservation_number
		where res.date_to >= to_date
		and res.date_from <= from_date
	);

    if (num_rooms <= count_rooms) then
		set result = 1;
	end if;
	if (num_rooms > count_rooms) then
		set result = 0;
	end if;
    return result;
end $$
delimiter;



delimiter $$
create procedure create_reservation(
p_from_date date,
p_to_date date,
p_num_room int,
p_num_guests int,
p_date_of_res date,
p_room_type varchar(100),
customer_id int)
begin
	declare max_id int;
    select max(reservation_number) into max_id from reservation;
    insert into reservation values (max_id + 1, p_num_room, p_num_guests, p_room_type, p_date_of_res, p_from_date, p_to_date);
    insert into reservation_placed values (customer_id, max_id + 1);
    select * from reservation where reservation_number = max_id + 1;
end $$
delimiter ;


delimiter $$
create procedure update_order_cost_bill(
p_order_id int,
p_room_number int,
p_bill_date date)
begin
	declare food_total_cost int;
    declare bill_desc varchar(300);
    set bill_desc = concat('Food bill for order', p_order_id);
    select  sum(ofl.quantity * fi.cost) into food_total_cost from order_food_link ofl
	join food_item fi
	on ofl.item_id = fi.item_id
	where ofl.order_id = 3;
    update order_details set total_cost = food_total_cost where order_id = p_order_id;
    insert into bill_details (room_number, cost, bill_description, payment_method, payment_details, bill_date)
    values (p_room_number, food_total_cost, bill_desc,'Cash', 'Cash', p_bill_date);
end $$
delimiter ;
