# Calumet ejercicio
Proyecto para practicar con las tecnologías usadas en el desarrollo de aplicaciones web en el grupo 
de desarrollo Calumet.

## Contexto
Este proyecto trata de sobre la creación de una cola de pedidos para una pizería. Su objetivo es 
organizar los pedidos del más antigüo al más reciente para poder antender a los clientes en orden. 
Vamos a poder visualizar algunos detalles de la orden que le permitirán al pizzero determinar 
aproximadente cuantas pizzas de un mismo sabor hacer para mantener una alta eficiencia.

## Base de Datos
Para esta aplicación se decidió usar MySQL como gestor de base de datos.
### Modelo Relacional

### Códigos para la Creación de la Base de Datos
Creación de base de datos.
```SQL
CREATE DATABASE calumet-ejercicio;
USE calumet-ejercicio;
```
Creación de tablas.
```SQL
CREATE TABLE client (
id INT UNSIGNED AUTO_INCREMENT,
name VARCHAR(100),
telephone_number VARCHAR(20),
PRIMARY KEY (id)
) TYPE=INNODB;

CREATE TABLE order (
id INT UNSIGNED AUTO_INCREMENT,
client BIGINT NOT NULL,
pizza_flavor VARCHAR(50) NOT NULL,
notes VARCHAR(100),
PRIMARY KEY (id),
INDEX (client),
FOREIGN KEY (client) REFERENCES client(id)
) TYPE=INNODB;
```
Registros básicos para poblar la base de datos.
```SQL
INSERT INTO client VALUES (
"Juan Andrés Perez",
"+57 3213749045"
);

INSERT INTO client VALUES (
"Andrés Felipe Rodríguez",
"+57 3105244759"
);

INSERT INTO client VALUES (
"Oscar Galindo Gómez",
"+57 3174825789"
);

INSERT INTO order VALUES (
1,
"Pepperoni",
"With a lot of cheese"
);

INSERT INTO order VALUES (
2,
"Hawaiana",
"Please, the most fast you can"
);

INSERT INTO order VALUES (
3,
"Meat",
""
);
```

## Diagrama de Clases
