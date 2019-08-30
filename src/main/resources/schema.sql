CREATE TABLE `parking_boy` (
`parkingboy_id`  varchar(36) NOT NULL ,
PRIMARY KEY (`parkingboy_id`)
)
;

CREATE TABLE `parking_lot` (
`parkinglot_id`  varchar(36) NOT NULL ,
`capacity`  int NULL ,
`parkingboy_id`  varchar(36) NULL ,
PRIMARY KEY (`parkinglot_id`),
FOREIGN KEY (`parkingboy_id`) REFERENCES `parking_boy` (`parkingboy_id`)
)
;