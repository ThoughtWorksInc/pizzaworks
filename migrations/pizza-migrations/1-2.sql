CREATE TABLE pizza (
  uuid SERIAL PRIMARY KEY,
  name CHARACTER(50) NOT NULL
);

INSERT INTO pizza (name)
VALUES ('Pepperoni pizza');

INSERT INTO pizza (name)
VALUES ('Veggie pizza');

GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO superpizza;