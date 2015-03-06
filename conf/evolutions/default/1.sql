# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table brand (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_brand primary key (id))
;

create table product (
  id                        bigint not null,
  name                      varchar(255),
  price                     integer,
  store_id                  bigint,
  constraint pk_product primary key (id))
;

create table product_size (
  id                        bigint not null,
  description               varchar(255),
  constraint pk_product_size primary key (id))
;

create table store (
  id                        bigint not null,
  name                      varchar(255),
  parish                    varchar(255),
  latitude                  double,
  longitude                 double,
  constraint pk_store primary key (id))
;

create sequence brand_seq;

create sequence product_seq;

create sequence product_size_seq;

create sequence store_seq;

alter table product add constraint fk_product_store_1 foreign key (store_id) references store (id) on delete restrict on update restrict;
create index ix_product_store_1 on product (store_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists brand;

drop table if exists product;

drop table if exists product_size;

drop table if exists store;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists brand_seq;

drop sequence if exists product_seq;

drop sequence if exists product_size_seq;

drop sequence if exists store_seq;

