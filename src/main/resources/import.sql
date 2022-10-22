insert into tab_cuisine (col_name) values ('Thai');
insert into tab_cuisine (col_name) values ('Indian');
insert into tab_cuisine (col_name) values ('Brasilian');

insert into tab_restaurant (col_name, col_tax_shipping, col_cuisine_id) values ('Thai Gourmet', 10, 1);
insert into tab_restaurant (col_name, col_tax_shipping, col_cuisine_id) values ('Indi ganesha', 7.30, 2);
insert into tab_restaurant (col_name, col_tax_shipping, col_cuisine_id) values ('Nordeste', 0.0, 3);

insert into tab_state (col_name) values ('Ceará');
insert into tab_state (col_name) values ('Bahia');

insert into tab_city (col_name, col_state_id) values ('Fortaleza', 1);
insert into tab_city (col_name, col_state_id) values ('Salvador', 2);
insert into tab_city (col_name, col_state_id) values ('Crateús', 1);

insert into tab_method_payment (col_description) values ('Pix');
insert into tab_method_payment (col_description) values ('Credit card');

insert into tab_permission (col_description) values ('Adm');
insert into tab_permission (col_description) values ('Client');
