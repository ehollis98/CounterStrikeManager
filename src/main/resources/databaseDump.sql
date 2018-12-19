CREATE TABLE user
		(
		  user_Id            INT AUTO_INCREMENT
		    PRIMARY KEY,
		  first_name    VARCHAR(25) NULL,
		  last_name     VARCHAR(30) NULL,
		  user_name     VARCHAR(15) NOT NULL,
		  pass          VARCHAR(30) NULL,
		  CONSTRAINT user_id_uindex
		  UNIQUE (user_Id),
		  CONSTRAINT users_user_name_uindex
		  UNIQUE (user_name)
		)
		  ENGINE = InnoDB;


CREATE TABLE role
		(
		  id        INT AUTO_INCREMENT
		    PRIMARY KEY,
		  role_name VARCHAR(25) NOT NULL,
		  user_name VARCHAR(15) NOT NULL,
		  user_id   INT         NOT NULL,
		  CONSTRAINT role_id_uindex
		  UNIQUE (id),
		  CONSTRAINT role_user_user_id_fk
		  FOREIGN KEY (user_id) REFERENCES user (user_Id)
		    ON UPDATE CASCADE
		    ON DELETE CASCADE
		)
		  ENGINE = InnoDB;

		CREATE INDEX role_user_user_id_fk
		  ON role (user_id);


CREATE TABLE report
		(
		  id        INT AUTO_INCREMENT
		    PRIMARY KEY,
		  date      DATE        NULL,
		  name VARCHAR(15)   NOT NULL,
		  steam_number_one   INT         NOT NULL,
                  steam_number_two   INT         NOT NULL,
                  statistic_type     VARCHAR(50)      NOT NULL,
                  user_id   INT           DEFAULT NULL,
		  UNIQUE (id),
		  CONSTRAINT report_user_user_id_fk
		  FOREIGN KEY (user_id) REFERENCES user (user_Id)
		    ON UPDATE CASCADE
		    ON DELETE CASCADE
		)
		  ENGINE = InnoDB;