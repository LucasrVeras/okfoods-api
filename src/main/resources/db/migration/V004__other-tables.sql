create table tab_group (
	id bigint not null auto_increment,
	col_name varchar(255),
	primary key (id)
) engine = InnoDB default charset=utf8;

create table tab_group_permission (
	col_group_id bigint not null,
	col_permission_id bigint not null
) engine = InnoDB default charset=utf8;

create table tab_method_payment (
	id bigint not null auto_increment,
	col_description varchar(255),
	primary key (id)
) engine = InnoDB default charset=utf8;

create table tab_permission (
	id bigint not null auto_increment,
	col_description varchar(255),
	primary key (id)
) engine = InnoDB default charset=utf8;

create table tab_product (
	id bigint not null auto_increment,
	col_active bit,
	col_description varchar(255),
	col_name varchar(255),
	col_price decimal(19,2),
	col_restaurant_id bigint,
	primary key (id)
) engine = InnoDB default charset=utf8;

create table tab_restaurant (
	id bigint not null auto_increment,
	col_address_cep varchar(255),
	col_address_complement varchar(255),
	col_address_district varchar(255),
	col_address_logradouro varchar(255),
	col_address_number varchar(255),
	col_date_register datetime not null,
	col_date_update datetime not null,
	col_name varchar(255) not null,
	col_tax_shipping decimal(19,2) not null,
	col_address_city_id bigint,
	col_cuisine_id bigint not null,
	primary key (id)
) engine = InnoDB default charset=utf8;

create table tab_restaurant_methods_payment (
	col_restaurant_id bigint not null,
	col_method_payment_id bigint not null
) engine = InnoDB default charset=utf8;

create table tab_user (
	id bigint not null auto_increment,
	col_date_registration datetime,
	col_name varchar(255),
	primary key (id)
) engine = InnoDB default charset=utf8;

create table tab_user_group (
	col_user_id bigint not null,
	col_group_id bigint not null
) engine = InnoDB default charset=utf8;

alter table tab_city add constraint fk_tab_city_tab_state 
foreign key (col_state_id) references tab_state (id);

alter table tab_group_permission add constraint fk_tab_group_permission_tab_permission 
foreign key (col_permission_id) references tab_permission (id);

alter table tab_group_permission add constraint fk_tab_group_permission_tab_group 
foreign key (col_group_id) references tab_group (id);

alter table tab_product add constraint fk_tab_product_tab_restaurant 
foreign key (col_restaurant_id) references tab_restaurant (id);

alter table tab_restaurant add constraint fk_tab_restaurant_tab_city 
foreign key (col_address_city_id) references tab_city (id);

alter table tab_restaurant add constraint fk_tab_restaurant_tab_cuisine 
foreign key (col_cuisine_id) references tab_cuisine (id);

alter table tab_restaurant_methods_payment add constraint fk_tab_restaurant_methods_payment_tab_method_payment 
foreign key (col_method_payment_id) references tab_method_payment (id);

alter table tab_restaurant_methods_payment add constraint fk_tab_restaurant_methods_payment_tab_restaurant 
foreign key (col_restaurant_id) references tab_restaurant (id);

alter table tab_user_group add constraint fk_tab_user_group_tab_group 
foreign key (col_group_id) references tab_group (id);

alter table tab_user_group add constraint fk_tab_user_group_tab_user 
foreign key (col_user_id) references tab_user (id);
