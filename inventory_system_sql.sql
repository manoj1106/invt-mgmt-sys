-- Database: inventory_system

-- DROP DATABASE inventory_system;

CREATE DATABASE inventory_system;
	   
-- Schema: shop_data

-- DROP SCHEMA shop_data;

CREATE SCHEMA shop_data;

-- Table: shop_data.shop_details

-- DROP TABLE shop_data.shop_details;

CREATE TABLE shop_data.shop_details
(
  shop_name character varying(300),
  shop_id bigserial NOT NULL,
  shop_licence_no character varying(20),
  address_line_1 character varying(100),
  address_line_2 character varying(100),
  town character varying(30),
  city character varying(30),
  state character varying(30),
  country character varying(30),
  shop_owner character varying(30),
  CONSTRAINT shop_id_pkey PRIMARY KEY (shop_id)
);

alter table shop_data.shop_details add column tan_number bigint;
alter table shop_data.shop_details add column pincode bigint;
alter table shop_data.shop_details add column registration_date date;
alter table shop_data.shop_details add column deleted_on date;
alter table shop_data.shop_details add column shop_start_date date;

-- Table: shop_data.stock

-- DROP TABLE shop_data.stock;

CREATE TABLE shop_data.stock
(
  item_name character varying(300) NOT NULL,
  item_code character varying(15) NOT NULL,
  shop_id bigint,
  CONSTRAINT item_name_code_pkey PRIMARY KEY (item_name, item_code),
  CONSTRAINT stock_shop_id_fkey FOREIGN KEY (shop_id)
      REFERENCES shop_data.shop_details (shop_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
 
-- Table: shop_data.available_stock

-- DROP TABLE shop_data.available_stock;

CREATE TABLE shop_data.available_stock
(
  item_id bigserial NOT NULL,
  item_name character varying(300),
  item_code character varying(15),
  item_qty bigint,
  item_price numeric,
  shop_id bigint,
  CONSTRAINT available_stock_item_id_pkey PRIMARY KEY (item_id),
  CONSTRAINT available_stock_item_name_code_fkey FOREIGN KEY (item_name, item_code)
      REFERENCES shop_data.stock (item_name, item_code) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT available_stock_shop_id_fkey FOREIGN KEY (shop_id)
      REFERENCES shop_data.shop_details (shop_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Table: shop_data.cust_details

-- DROP TABLE shop_data.cust_details;

CREATE TABLE shop_data.cust_details
(
  cust_acc_no bigserial NOT NULL,
  cust_first_name character varying(300),
  cust_middle_name character varying(300),
  cust_last_name character varying(300),
  total_balance numeric,
  address_line_1 character varying(100),
  address_line_2 character varying(100),
  town character varying(30),
  city character varying(30),
  state character varying(30),
  country character varying(30),
  shop_id bigint,
  CONSTRAINT cust_details_cust_acc_no_pkey PRIMARY KEY (cust_acc_no),
  CONSTRAINT cust_details_shop_id_fkey FOREIGN KEY (shop_id)
      REFERENCES shop_data.shop_details (shop_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Table: shop_data.cust_cr_dr_details

-- DROP TABLE shop_data.cust_cr_dr_details;

CREATE TABLE shop_data.cust_cr_dr_details
(
  cust_cr_dr_details_id bigserial NOT NULL,
  cust_acc_no bigint,
  cust_cr_amount numeric,
  cust_dr_amount numeric,
  cust_cur_balance numeric,
  cust_remarks character varying(300),
  CONSTRAINT cust_cr_dr_details_cust_cr_dr_details_id_pkey PRIMARY KEY (cust_cr_dr_details_id),
  CONSTRAINT cust_cr_dr_details_cust_acc_no_fkey FOREIGN KEY (cust_acc_no)
      REFERENCES shop_data.cust_details (cust_acc_no) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Schema: user_data

-- DROP SCHEMA user_data;

CREATE SCHEMA user_data;

-- Table: user_data.roles

-- DROP TABLE user_data.roles;

CREATE TABLE user_data.roles
(
  role_id bigserial NOT NULL,
  role character varying(20),
  CONSTRAINT roles_role_id_pkey PRIMARY KEY (role_id)
)

-- Table: user_data.user_login

-- DROP TABLE user_data.user_login;

CREATE TABLE user_data.user_login
(
  user_name character varying(300) NOT NULL,
  password character varying(15),
  shop_id bigint,
  first_name character varying(100),
  middle_name character varying(100),
  last_name character varying(100),
  address_line_1 character varying(100),
  address_line_2 character varying(100),
  town character varying(30),
  city character varying(30),
  state character varying(30),
  country character varying(30),
  role_id bigint,
  CONSTRAINT user_name_pkey PRIMARY KEY (user_name),
  CONSTRAINT shop_id_fkey FOREIGN KEY (shop_id)
      REFERENCES shop_data.shop_details (shop_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT user_login_role_id_fkey FOREIGN KEY (role_id)
      REFERENCES user_data.roles (role_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

alter table user_data.user_login add column is_active boolean;

CREATE TABLE user_data.menu_item_access
(
  menu_item_access_id bigserial NOT NULL,
  shop_id bigint,
  role character varying,
  menu_item character varying,
  deleted_on timestamp,
  CONSTRAINT pk_menu_item_access_id PRIMARY KEY (menu_item_access_id)
);
