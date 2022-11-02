create table tab_cuisine(
	id bigint not null auto_increment,
	col_name varchar(60) not null,
	col_desc varchar(255),
	
	primary key (id)
)engine=InnoDB default charset=utf8;