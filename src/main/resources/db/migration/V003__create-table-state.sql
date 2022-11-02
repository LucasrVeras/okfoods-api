create table tab_state(
	id bigint not null auto_increment,
	col_name varchar(60) not null,
	
	primary key (id)
)engine=InnoDB default charset=utf8;

insert into tab_state (col_name) select distinct col_state_name from tab_city;

alter table tab_city add column col_state_id bigint not null;

update tab_city tc set tc.col_state_id = (select ts.id from tab_state ts where ts.col_name = tc.col_state_name);

alter table tab_city add constraint fk_city_state
foreign key (col_state_id) references tab_state(id);

alter table tab_city drop column col_state_name;