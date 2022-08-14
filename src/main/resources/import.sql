insert into tab_cuisine (id, col_name) values (1, 'Thai');
insert into tab_cuisine (id, col_name) values (2, 'Indian');
insert into tab_cuisine (id, col_name) values (3, 'Brasilian');

insert into tab_restaurant (col_name, col_tax_shipping, col_cuisine_id) values ('Thai Gourmet', 10, 1);
insert into tab_restaurant (col_name, col_tax_shipping, col_cuisine_id) values ('Indi ganesha', 7.30, 2);

insert into tab_state (id, col_name) values (1, 'CE')
insert into tab_state (id, col_name) values (2, 'BA')

insert into tab_city (id, col_name, col_state_id) values (1, 'Fortaleza', 1);
insert into tab_city (id, col_name, col_state_id) values (2, 'Salvador', 2);
insert into tab_city (id, col_name, col_state_id) values (3, 'Crateús', 1);

insert into tab_method_payment (col_description) values ('Pix')
insert into tab_method_payment (col_description) values ('Credit card')

insert into tab_permission (col_description) values ('Adm')
insert into tab_permission (col_description) values ('Client')
