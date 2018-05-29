CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE pizza_order (
  uuid UUID PRIMARY KEY,
  order_number INTEGER NOT NULL UNIQUE,
  customer_name VARCHAR(50) NOT NULL,
  pizza_id UUID REFERENCES pizza(uuid),
  price FLOAT NOT NULL,
  timestamp TIMESTAMP NOT NULL
);
