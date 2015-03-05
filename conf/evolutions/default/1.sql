# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table products (
  name                      varchar(255),
  product_id                bigint,
  price                     integer)
;

create table stores (
  name                      varchar(255),
  parish                    varchar(255),
  coordinates               varchar(255))
;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists products;

drop table if exists stores;

SET REFERENTIAL_INTEGRITY TRUE;

