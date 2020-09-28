CREATE TABLE `testdb`.`ships` (
  `id`    INT         NOT NULL AUTO_INCREMENT,
  `type`  VARCHAR(45) NULL,
  `state` TINYINT     NULL,
  `x`     INT         NULL,
  `y`     INT         NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
);

create table battlefield
(
  id int         not null
    primary key,
  a  varchar(45) null,
  b  varchar(45) null,
  c  varchar(45) null,
  d  varchar(45) null,
  e  varchar(45) null,
  constraint field_id_uindex
  unique (id)
)
  engine = InnoDB;


