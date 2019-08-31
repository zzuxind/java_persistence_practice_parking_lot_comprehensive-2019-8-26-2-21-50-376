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



