CREATE TABLE IF NOT EXISTS `${Activity}` (
    `activity_id`     INTEGER     PRIMARY KEY AUTOINCREMENT NOT NULL,
    `consumption_id`  INTEGER     NOT NULL,
    `timestamp`       INTEGER,
                      FOREIGN KEY(`consumption_id`)
                          REFERENCES  `Consumption`(`consumption_id`)
                          ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE  INDEX `index_Activity_consumption_id` ON `${Activity}` (`
	    consumption_id`

);



CREATE TABLE IF NOT EXISTS `${Consumption}` (
    `consumption_id`  INTEGER     PRIMARY KEY AUTOINCREMENT,
    `time`            INTEGER     NOT NULL,
    `score`           REAL
);

