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

-- INSERT INTO parking_boy (parkingboy_id) VALUES ('1')
-- INSERT INTO parking_boy VALUES ('2')
--
-- INSERT INTO parking_lot (parkinglot_id,capacity,parkingboy_id) VALUES ('001',10,'1');
-- INSERT INTO parking_lot (parkinglot_id,capacity,parkingboy_id) VALUES ('002',10,'1');
-- INSERT INTO parking_lot (parkinglot_id,capacity,parkingboy_id) VALUES ('003',10,'2');
-- commit;

