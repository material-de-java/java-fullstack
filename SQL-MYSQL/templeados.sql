CREATE TABLE EMPRESAABC.templeados (
	id INT auto_increment NOT NULL,
	nombres varchar(100) NOT NULL,
	apellidos varchar(100) NOT NULL,
	telefono BIGINT UNSIGNED NOT NULL,
	correo varchar(100) NOT NULL,
	passw VARCHAR(40) NOT NULL,
	CONSTRAINT templeados_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_bin
COMMENT='tabla de empleados';

-- DATOS DE PRUEBAS
INSERT INTO templeados (nombres, apellidos, telefono, correo, passw)  VALUES ("Pedro", "Picasso", 6166,"pedro@correo.net", "abc123");
INSERT INTO templeados (nombres, apellidos, telefono, correo, passw)  VALUES ("Pablo", "Moreno", 6155, "pablo@correo.net", "abc456");
INSERT INTO templeados (nombres, apellidos, telefono, correo, passw)  VALUES ("Victor", "Sierra", 6144, "victor@correo.net", "abc789");
