create table tab_order (

    id bigint not null auto_increment,

	col_sub_total decimal(19,2),
	col_tax_shipping decimal(19,2),
	col_amount decimal(19,2),
    col_method_payment_id bigint(20) not null,

    col_restaurant_id bigint(20) not null,
    col_client_user_id bigint(20) null,

    col_address_city_id bigint(20) not null,
    col_address_cep varchar(255) not null,
	col_address_logradouro varchar(255) null,
	col_address_number varchar(255) not null,
	col_address_complement varchar(255) null,
	col_address_district varchar(255) not null,


    col_order_status varchar(10) not null not null,
	col_creation_date datetime not null,
	col_confirmation_date datetime null,
	col_cancellation_date datetime null,
	col_delivery_date datetime null,

    primary key (id),

    constraint fk_order_restaurant_city foreign key (col_address_city_id) references tab_city (id),
    constraint fk_order_restaurant foreign key (col_restaurant_id) references tab_restaurant (id),
    constraint fk_order_user_client foreign key (col_client_user_id) references tab_user (id),
    constraint fk_order_method_payment foreign key (col_method_payment_id) references tab_method_payment (id)

) engine = InnoDB default charset=utf8;


create table tab_order_item (

	id bigint not null auto_increment,

	col_quantity smallint(6) not null,
	col_unit_price decimal(19,2) not null,
	col_total_price decimal(19,2)not null,
	col_notes varchar(255) null,

	col_order_id bigint(20) not null,
	col_product_id bigint(20) not null,

    primary key (id),

    unique key uk_item_order_product (col_order_id, col_product_id),

    constraint fk_item_order_order foreign key (col_order_id) references tab_order (id),
    constraint fk_item_order_product foreign key (col_product_id) references tab_product (id)

) engine = InnoDB default charset=utf8;