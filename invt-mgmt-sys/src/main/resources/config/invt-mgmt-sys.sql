-- Database: inventory_system

-- DROP DATABASE inventory_system;

CREATE DATABASE inventory_system
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;
       
-- Schema: static_data

-- DROP SCHEMA static_data;

CREATE SCHEMA static_data
  AUTHORIZATION postgres;

GRANT ALL ON SCHEMA static_data TO postgres;
GRANT ALL ON SCHEMA static_data TO root;

-- Table: static_data.country

-- DROP TABLE static_data.country;

CREATE TABLE static_data.country
(
  country character varying(50) NOT NULL,
  deleted_on date,
  CONSTRAINT country_country_pkey PRIMARY KEY (country)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE static_data.country
  OWNER TO postgres;
GRANT ALL ON TABLE static_data.country TO postgres;
GRANT SELECT, UPDATE, INSERT, REFERENCES ON TABLE static_data.country TO root;

-- Table: static_data.state

-- DROP TABLE static_data.state;

CREATE TABLE static_data.state
(
  state character varying(50) NOT NULL,
  country character varying(50) NOT NULL,
  deleted_on date,
  CONSTRAINT state_state_country_pkey PRIMARY KEY (state, country),
  CONSTRAINT state_country_fkey FOREIGN KEY (country)
      REFERENCES static_data.country (country) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT state_country_ukey UNIQUE (country),
  CONSTRAINT state_state_ukey UNIQUE (state)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE static_data.state
  OWNER TO postgres;
GRANT ALL ON TABLE static_data.state TO postgres;
GRANT SELECT, UPDATE, INSERT, REFERENCES ON TABLE static_data.state TO root;


-- Table: static_data.city

-- DROP TABLE static_data.city;

CREATE TABLE static_data.city
(
  city character varying(50) NOT NULL,
  state character varying(50) NOT NULL,
  country character varying(50) NOT NULL,
  deleted_on date,
  CONSTRAINT city_city_state_country_pkey PRIMARY KEY (city, state, country),
  CONSTRAINT city_state_country_fkey FOREIGN KEY (country)
      REFERENCES static_data.country (country) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT city_state_fkey FOREIGN KEY (state)
      REFERENCES static_data.state (state) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT city_city_ukey UNIQUE (city),
  CONSTRAINT city_country_ukey UNIQUE (country),
  CONSTRAINT city_state_ukey UNIQUE (state)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE static_data.city
  OWNER TO postgres;
GRANT ALL ON TABLE static_data.city TO postgres;
GRANT SELECT, UPDATE, INSERT, REFERENCES ON TABLE static_data.city TO root;


-- Schema: shop_data

-- DROP SCHEMA shop_data;

CREATE SCHEMA shop_data
  AUTHORIZATION postgres;

GRANT ALL ON SCHEMA shop_data TO postgres;
GRANT ALL ON SCHEMA shop_data TO root;



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
  tan_number bigint,
  pincode bigint,
  registration_date date,
  deleted_on date,
  shop_start_date date,
  CONSTRAINT shop_id_pkey PRIMARY KEY (shop_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE shop_data.shop_details
  OWNER TO postgres;
GRANT ALL ON TABLE shop_data.shop_details TO postgres;
GRANT SELECT, UPDATE, INSERT, REFERENCES ON TABLE shop_data.shop_details TO root;

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
)
WITH (
  OIDS=FALSE
);
ALTER TABLE shop_data.available_stock
  OWNER TO postgres;
GRANT ALL ON TABLE shop_data.available_stock TO postgres;
GRANT SELECT, UPDATE, INSERT, REFERENCES ON TABLE shop_data.available_stock TO root;


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
)
WITH (
  OIDS=FALSE
);
ALTER TABLE shop_data.stock
  OWNER TO postgres;
GRANT ALL ON TABLE shop_data.stock TO postgres;
GRANT SELECT, UPDATE, INSERT, REFERENCES ON TABLE shop_data.stock TO root;

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
)
WITH (
  OIDS=FALSE
);
ALTER TABLE shop_data.cust_details
  OWNER TO postgres;
GRANT ALL ON TABLE shop_data.cust_details TO postgres;
GRANT SELECT, UPDATE, INSERT, REFERENCES ON TABLE shop_data.cust_details TO root;

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
)
WITH (
  OIDS=FALSE
);
ALTER TABLE shop_data.cust_cr_dr_details
  OWNER TO postgres;
GRANT ALL ON TABLE shop_data.cust_cr_dr_details TO postgres;
GRANT SELECT, UPDATE, INSERT, REFERENCES ON TABLE shop_data.cust_cr_dr_details TO root;


-- Schema: user_data

-- DROP SCHEMA user_data;

CREATE SCHEMA user_data
  AUTHORIZATION postgres;

GRANT ALL ON SCHEMA user_data TO postgres;
GRANT ALL ON SCHEMA user_data TO root;

-- Table: user_data.menu_item_access

-- DROP TABLE user_data.menu_item_access;

CREATE TABLE user_data.menu_item_access
(
  menu_item_access_id bigserial NOT NULL,
  shop_id bigint,
  role character varying,
  menu_item character varying,
  deleted_on timestamp without time zone,
  CONSTRAINT pk_menu_item_access_id PRIMARY KEY (menu_item_access_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_data.menu_item_access
  OWNER TO postgres;
GRANT ALL ON TABLE user_data.menu_item_access TO postgres;
GRANT SELECT, UPDATE, INSERT, REFERENCES ON TABLE user_data.menu_item_access TO root;

-- Table: user_data.roles

-- DROP TABLE user_data.roles;

CREATE TABLE user_data.roles
(
  role_id bigserial NOT NULL,
  role character varying(20),
  deleted_on date,
  CONSTRAINT roles_role_id_pkey PRIMARY KEY (role_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_data.roles
  OWNER TO postgres;
GRANT ALL ON TABLE user_data.roles TO postgres;
GRANT SELECT, UPDATE, INSERT, REFERENCES ON TABLE user_data.roles TO root;

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
  is_active boolean,
  pincode bigint,
  deleted_on date,
  CONSTRAINT user_name_pkey PRIMARY KEY (user_name),
  CONSTRAINT shop_id_fkey FOREIGN KEY (shop_id)
      REFERENCES shop_data.shop_details (shop_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT user_login_role_id_fkey FOREIGN KEY (role_id)
      REFERENCES user_data.roles (role_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_data.user_login
  OWNER TO postgres;
GRANT ALL ON TABLE user_data.user_login TO postgres;
GRANT SELECT, UPDATE, INSERT, REFERENCES ON TABLE user_data.user_login TO root;
