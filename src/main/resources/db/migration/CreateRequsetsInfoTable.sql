create table translates(
   id integer PRIMARY KEY auto_increment,
   ip_id varchar not null references requests_info(ip),
   input_text varchar not null,
   output_text varchar not null,
   input_language varchar not null,
   output_language varchar not null
)

create table requests_info(
    id integer not null AUTO_INCREMENT,
    ip varchar(15) not null unique ,
    primary key (id),
);