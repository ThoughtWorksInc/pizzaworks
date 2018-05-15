CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

UPDATE pizza
SET name = 'Veggie'
WHERE name = 'Pepperoni pizza';

UPDATE pizza
SET name = 'Pepperoni feast'
WHERE name = 'Veggie pizza';

INSERT INTO pizza (uuid, name)
VALUES (uuid_generate_v4(), 'Margarita');

INSERT INTO pizza (uuid, name)
VALUES (uuid_generate_v4(), 'Hawaiian');
