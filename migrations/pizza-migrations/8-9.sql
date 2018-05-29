ALTER TABLE pizza
  ADD COLUMN energyPerSlice INTEGER;

UPDATE pizza
SET
  energyPerSlice = 144
WHERE name = 'Veggie';