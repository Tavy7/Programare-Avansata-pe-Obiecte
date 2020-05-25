CREATE TABLE `masina`(
	`pret` FLOAT NOT NULL,
	`capacitateCiclindrica` INTEGER NOT NULL,
	`putere` INTEGER NOT NULL,
	`anFabricatie` INTEGER NOT NULL,
	`capacitateRezervor` FLOAT NOT NULL,
	`denumire` VARCHAR(255) NOT NULL,
	`serie` VARCHAR(255) NOT NULL,
	`culoare` VARCHAR(255) NOT NULL,
	`numarPortiere` INTEGER NOT NULL,
	`numarLocuri` INTEGER NOT NULL,
	`gpl` BOOL NOT NULL,
	PRIMARY KEY (`serie`)
);

CREATE TABLE `motocicleta`(
	`pret` FLOAT NOT NULL,
	`capacitateCiclindrica` INTEGER NOT NULL,
	`putere` INTEGER NOT NULL,
	`anFabricatie` INTEGER NOT NULL,
	`capacitateRezervor` FLOAT NOT NULL,
	`denumire` VARCHAR(255) NOT NULL,
	`serie` VARCHAR(255) NOT NULL,
	`culoare` VARCHAR(255) NOT NULL,
	`permitePasager` BOOL NOT NULL,
	`permiteAtas` BOOL NOT NULL,
	PRIMARY KEY (`serie`)
);

CREATE TABLE `vanzator`(
	`employee_id` INTEGER NOT NULL,
	`nume` VARCHAR(255) NOT NULL,

	PRIMARY KEY (`employee_id`)
);

CREATE TABLE `mecanic`(
	`employee_id` INTEGER NOT NULL,
	`nume` VARCHAR(255) NOT NULL,

	PRIMARY KEY (`employee_id`)
);