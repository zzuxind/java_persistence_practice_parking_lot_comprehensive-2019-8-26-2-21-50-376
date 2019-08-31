CREATE TABLE `parking_boy` (
`id`  varchar(36) NOT NULL ,

)
;

CREATE TABLE `parking_lot` (
`id`  varchar(36) NOT NULL ,
`capacity`  int NULL ,
`parkingboyid`  varchar(36) NULL ,

FOREIGN KEY (`parkingboyid`) REFERENCES `parking_boy` (`id`)
)
;



insert into parking_boy (id) values (1);
insert into parking_boy (id) values (2);
insert into parking_lot (id, capacity) values (100,10);
insert into parking_lot (id, capacity,parkingboyid) values (101,2,2);
commit ;