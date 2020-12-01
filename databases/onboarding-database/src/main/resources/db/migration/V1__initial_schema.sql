create table customer (
  id  bigint(20) not null auto_increment,
  name VARCHAR(255),

  primary key (id),
  unique key name (name)
);