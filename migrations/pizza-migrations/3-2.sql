CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

UPDATE pizza
SET name = 'Pepperoni pizza'
WHERE name = 'Veggie';

UPDATE pizza
SET name = 'Veggie pizza'
WHERE name = 'Pepperoni feast';

DELETE from pizza
WHERE name = 'Margarita';

DELETE from pizza
WHERE name = 'Hawaiian';