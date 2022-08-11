DROP TABLE IF EXISTS `articulos`;
DROP table IF EXISTS fabricantes;


CREATE TABLE `fabricantes` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
);

CREATE TABLE `articulos` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `precio` int DEFAULT NULL,
  `fabricante` int DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  CONSTRAINT `articulos_fk` FOREIGN KEY (`fabricante`) REFERENCES `fabricantes` (`codigo`)
);


insert into fabricantes (nombre)values('Jose');
insert into fabricantes (nombre)values('Juan');
insert into fabricantes (nombre)values('Pedro');
insert into fabricantes (nombre)values('Jordi');
insert into fabricantes (nombre)values('Jonatan');

insert into articulos (nombre, precio,fabricante) values ('Tuerca',10,1);
insert into articulos (nombre, precio,fabricante) values ('Manguito',10,2);
insert into articulos (nombre, precio,fabricante) values ('Telefono',10,3);
insert into articulos (nombre, precio,fabricante) values ('Ibuprofeno',10,5);