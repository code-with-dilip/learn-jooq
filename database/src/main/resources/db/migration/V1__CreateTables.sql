create table delivery (
	id serial primary key,
	update_ts timestamptz default current_timestamp,
  	crte_user text,
  	crte_ts timestamptz default current_timestamp,
  	update_user text
);

create table delivery_leg (
	id serial primary key,
	load_id int references delivery(id),
	type text,
	name text,
	location_id text,
	sequence_num integer,
	event_date_time timestamp,
	update_ts timestamptz default current_timestamp,
  	crte_user text,
  	crte_ts timestamptz default current_timestamp,
  	update_user text
);