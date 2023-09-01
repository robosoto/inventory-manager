DROP TABLE if exists warehouses;
CREATE TABLE if not exists warehouses (
	warehouse_id int NOT NULL PRIMARY KEY,
    max_capacity int NOT NULL,
    name varchar(255) NOT NULL
);