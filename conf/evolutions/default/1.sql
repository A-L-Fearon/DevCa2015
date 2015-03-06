# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table product (
  id                        bigint not null,
  name                      varchar(255),
  price                     integer,
  store_id                  integer,
  constraint pk_product primary key (id))
;

create table stores (
  id                        integer not null,
  name                      varchar(255),
  parish                    varchar(255),
  coordinates               varchar(255),
  constraint pk_stores primary key (id))
;

create sequence product_seq;

create sequence stores_seq;

alter table product add constraint fk_product_store_1 foreign key (store_id) references stores (id) on delete restrict on update restrict;
create index ix_product_store_1 on product (store_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists product;

drop table if exists stores;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists product_seq;

drop sequence if exists stores_seq;

