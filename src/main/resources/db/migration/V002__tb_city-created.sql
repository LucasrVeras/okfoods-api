create table tab_city(
	id bigint not null auto_increment,
	col_name varchar(80) not null,
	col_state_name varchar(80) not null,
	
	primary key (id)
)engine=InnoDB default charset=utf8;