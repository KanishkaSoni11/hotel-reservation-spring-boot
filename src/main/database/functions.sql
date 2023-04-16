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
