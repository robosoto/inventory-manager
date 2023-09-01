DROP TABLE if exists products;
CREATE TABLE products (
	product_id int NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL,
    description varchar(255) NOT NULL,
    warehouse_id int NOT NULL,
    FOREIGN KEY (warehouse_id) references warehouses(warehouse_id)
);