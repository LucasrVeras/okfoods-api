set foreign_key_checks = 0;

delete from tab_city;
delete from tab_cuisine;
delete from tab_group;
delete from tab_group_permission;
delete from tab_method_payment;
delete from tab_permission;
delete from tab_product;
delete from tab_restaurant;
delete from tab_restaurant_methods_payment;
delete from tab_state;
delete from tab_user;
delete from tab_user_group;

set foreign_key_checks = 1;

alter table tab_city auto_increment = 1;
alter table tab_cuisine auto_increment = 1;
alter table tab_group auto_increment = 1;
alter table tab_method_payment auto_increment = 1;
alter table tab_permission auto_increment = 1;
alter table tab_product auto_increment = 1;
alter table tab_restaurant auto_increment = 1;
alter table tab_state auto_increment = 1;
alter table tab_user auto_increment = 1;

insert into tab_cuisine (col_name) values ('Thai');
insert into tab_cuisine (col_name) values ('Indian');
insert into tab_cuisine (col_name) values ('Brazilian');
insert into tab_cuisine (col_name) values ('Japan');

insert into tab_state (col_name) values ('Ceará');
insert into tab_state (col_name) values ('Bahia');

insert into tab_city (col_name, col_state_id) values ('Fortaleza', 1);
insert into tab_city (col_name, col_state_id) values ('Salvador', 2);
insert into tab_city (col_name, col_state_id) values ('Crateús', 1);

insert into tab_restaurant (col_name, col_tax_shipping, col_cuisine_id, col_date_register, col_date_Update) values ('Thai Gourmet', 10, 1, current_timestamp, current_timestamp);
insert into tab_restaurant (col_name, col_tax_shipping, col_cuisine_id, col_date_register, col_date_Update) values ('Indi ganesha', 7.30, 2, current_timestamp, current_timestamp);
insert into tab_restaurant (col_name, col_tax_shipping, col_cuisine_id, col_date_register, col_date_Update, col_address_cep, col_address_logradouro, col_address_number, col_address_complement, col_address_district, col_address_city_id) values ('Tradição Mineira', 0.0, 3, current_timestamp, current_timestamp, '99999999', 'Vasco da Gama', '4003', 'Loja 212', 'ADEOTA', 1);

insert into tab_product (col_name, col_description, col_price, col_active, col_restaurant_id) values ('Pad Thai', 'Prato de macarrão com arroz frito', 55.00, true, 1);

insert into tab_method_payment (col_description) values ('Pix');
insert into tab_method_payment (col_description) values ('Credit card');

insert into tab_restaurant_methods_payment (col_restaurant_id,col_method_payment_id) values (1, 1), (1, 2),(2, 1),(2, 2),(3, 1);

insert into tab_permission (col_description) values ('Adm');
insert into tab_permission (col_description) values ('Client');