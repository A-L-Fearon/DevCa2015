# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table brand (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_brand primary key (id))
;

create table product (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  price                     integer,
  store_id                  bigint,
  constraint pk_product primary key (id))
;

create table product_size (
  id                        bigint auto_increment not null,
  description               varchar(255),
  constraint pk_product_size primary key (id))
;

create table store (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  address                   varchar(255),
  address2                  varchar(255),
  parish                    varchar(255),
  latitude                  double,
  longitude                 double,
  type                      varchar(255),
  town                      varchar(255),
  telenum                   varchar(255),
  constraint pk_store primary key (id))
;

alter table product add constraint fk_product_store_1 foreign key (store_id) references store (id) on delete restrict on update restrict;
create index ix_product_store_1 on product (store_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table brand;

drop table product;

drop table product_size;

drop table store;

SET FOREIGN_KEY_CHECKS=1;

