DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id|niocoder|2019-03-07',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT 'client name|niocoder|2019-03-07',
  `address` varchar(100) NOT NULL DEFAULT '' COMMENT 'client address|niocoder|2019-03-07',
  `city` varchar(30) NOT NULL DEFAULT '' COMMENT 'client city|niocoder|2019-03-07',
  `telephone` varchar(20) NOT NULL DEFAULT '' COMMENT 'client telephone|niocoder|2019-03-07',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id|niocoder|2019-03-07',
  `number` varchar(20) NOT NULL DEFAULT '' COMMENT 'card number|niocoder|2019-03-07',
  `ccv` int(4) NOT NULL DEFAULT '0' COMMENT 'card ccv|niocoder|2019-03-07',
  `type` varchar(50) NOT NULL DEFAULT '' COMMENT 'card type|niocoder|2019-03-07',
  `client_id` int(20) NOT NULL DEFAULT '0' COMMENT 'client id|niocoder|2019-03-07',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `consumption_his`;
CREATE TABLE `consumption_his` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id|niocoder|2019-03-07',
  `client_id` int(20) NOT NULL DEFAULT '0' COMMENT 'client id|niocoder|2019-03-07',
  `card_id` int(20) NOT NULL DEFAULT '0' COMMENT 'client id|niocoder|2019-03-07',
  `consumption_date` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT 'consumption_date|niocoder|2019-03-07',
  `description` varchar(100) NOT NULL DEFAULT '' COMMENT 'description|niocoder|2019-03-07',
  `amount` varchar(12) NOT NULL DEFAULT '' COMMENT 'amount|niocoder|2019-03-07',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `bank_advisors`;
CREATE TABLE `bank_advisors` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id|niocoder|2019-03-07',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT 'bank_advisors name|niocoder|2019-03-07',
  `specialty` varchar(50) NOT NULL DEFAULT '' COMMENT 'bank_advisors specialty|niocoder|2019-03-07',
  `consumption_his_id` int(20)  NOT NULL  COMMENT 'consumption_his|niocoder|2019-03-07',
  PRIMARY KEY (`id`)
);