
CREATE TABLE  IF NOT EXISTS
    clients (
    client_id INT,
    client_name VARCHAR(75),
    client_lastname VARCHAR(75),
    client_dni VARCHAR(8),
    PRIMARY KEY (client_id)
    );

CREATE TABLE IF NOT EXISTS
    sales (
    sale_id INT,
    sale_purchase_date DATE,
    sale_total DOUBLE PRECISION,
    client_id INT,
    PRIMARY KEY (sale_id),
    CONSTRAINT fk_sales_clients FOREIGN KEY (client_id) REFERENCES clients(client_id)
    );
CREATE TABLE  IF NOT EXISTS
    products(
    product_id INT,
    product_description VARCHAR(150),
    product_code VARCHAR(50),
    product_stock INT,
    product_price DOUBLE PRECISION ,
    PRIMARY KEY (product_id)
    );

CREATE TABLE IF NOT EXISTS
    sale_details (
    sale_detail_id INT,
    sale_detail_amount INT,
    sale_detail_price DOUBLE PRECISION,
    sale_id INT,
    product_id INT,
    PRIMARY KEY (sale_detail_id),
    CONSTRAINT fK_sale_details_sale FOREIGN KEY (sale_id) REFERENCES sales(sale_id),
    CONSTRAINT fk_sale_details_products FOREIGN KEY (product_id) REFERENCES products(product_id)
    );

INSERT INTO clients (client_id, client_name, client_lastname, client_dni) VALUES
    (1, 'Juan', 'Fuentes Perez', '1234587'),
    (2, 'Maria', 'Gomez Rodriguez', '9876543'),
    (3, 'Carlos', 'Martinez Lopez', '5678901'),
    (4, 'Ana', 'Ruiz Herrera', '3456789'),
    (5, 'David', 'Santos Jimenez', '2109876');

INSERT INTO sales (sale_id, sale_purchase_date, sale_total, client_id) VALUES
    (1, '2012-12-12', 20.0, 1),
    (2, '2013-01-15', 20.0, 2),
    (3, '2014-03-20', 20.0, 3),
    (4, '2015-05-25', 20.0, 4),
    (5, '2016-07-10', 20.0, 5);


INSERT INTO products (product_id, product_description, product_code, product_stock, product_price) VALUES
    (1, 'Producto 1', 'ABC123', 50, 10.00),
    (2, 'Producto 2', 'XYZ456', 30, 10.00),
    (3, 'Producto 3', '123DEF', 25, 10.00),
    (4, 'Producto 4', '456GHI', 40, 10.00),
    (5, 'Producto 5', '789JKL', 60, 10.00);


INSERT INTO sale_details (sale_detail_id, sale_detail_amount, sale_detail_price, sale_id, product_id) VALUES
   (1, 2, 10.00 , 1, 1),
   (2, 2, 10.00 , 2, 2),
   (3, 2, 10.00 , 3, 3),
   (4, 2, 10.00 , 4, 4),
   (5, 2, 10.00 , 5, 5);