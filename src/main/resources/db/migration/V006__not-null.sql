ALTER TABLE tab_order MODIFY COLUMN
    col_sub_total decimal(19,2) NOT NULL;

ALTER TABLE tab_order MODIFY COLUMN
    col_tax_shipping decimal(19,2) NOT NULL;

ALTER TABLE tab_order MODIFY COLUMN
    col_amount decimal(19,2) NOT NULL;

ALTER TABLE tab_order MODIFY COLUMN
    col_address_logradouro varchar(255) NOT NULL;

ALTER TABLE tab_order MODIFY COLUMN
    col_client_user_id bigint(20) NOT NULL;

ALTER TABLE tab_order MODIFY COLUMN
    col_order_status varchar(10) NOT NULL;