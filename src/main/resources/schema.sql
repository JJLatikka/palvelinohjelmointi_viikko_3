
DROP TABLE IF EXISTS customers;

CREATE TABLE IF NOT EXISTS customers (
    id int(10) NOT NULL AUTO_INCREMENT,
    name varchar(50) DEFAULT NULL,
    PRIMARY KEY(id)
);

