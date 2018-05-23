ALTER TABLE pizza
  ADD COLUMN slug VARCHAR(50);

UPDATE pizza
SET
  slug = 'veggie'
WHERE name = 'Veggie';

UPDATE pizza
SET
  slug = 'pepperoni-feast'
WHERE name = 'Pepperoni feast';

UPDATE pizza
SET
  slug = 'margherita'
WHERE name = 'Margherita';

UPDATE pizza
SET
  slug = 'hawaiian'
WHERE name = 'Hawaiian';

ALTER TABLE pizza ADD UNIQUE(slug);
ALTER TABLE pizza ALTER COLUMN slug SET NOT NULL;
