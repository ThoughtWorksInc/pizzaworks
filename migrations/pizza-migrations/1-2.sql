CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE pizza (
  uuid UUID PRIMARY KEY,
  name CHARACTER(50) NOT NULL
);

INSERT INTO pizza (uuid, name)
VALUES (uuid_generate_v4(), 'Pepperoni pizza');

INSERT INTO pizza (uuid, name)
VALUES (uuid_generate_v4(), 'Veggie pizza');

GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO superpizza;