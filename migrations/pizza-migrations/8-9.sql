ALTER TABLE pizza
  ADD COLUMN weight SMALLINT,
  ADD COLUMN num_slices SMALLINT,
  ADD COLUMN energy_per_slice SMALLINT,
  ADD COLUMN protein_per_slice FLOAT,
  ADD COLUMN carbohydrate_per_slice FLOAT,
  ADD COLUMN sugars_per_slice FLOAT,
  ADD COLUMN fat_per_slice FLOAT,
  ADD COLUMN saturated_fat_per_slice FLOAT,
  ADD COLUMN salt_per_slice FLOAT,
  ADD COLUMN energy_per_100 SMALLINT,
  ADD COLUMN protein_per_100 FLOAT,
  ADD COLUMN carbohydrate_per_100 FLOAT,
  ADD COLUMN sugars_per_100 FLOAT,
  ADD COLUMN fat_per_100 FLOAT,
  ADD COLUMN saturated_fat_per_100 FLOAT,
  ADD COLUMN salt_per_100 FLOAT,
  ADD COLUMN allergens VARCHAR(500),
  ADD COLUMN vegetarian BOOLEAN,
  ADD COLUMN vegan BOOLEAN;

UPDATE pizza
SET
  weight = 481,
  num_slices = 6,
  energy_per_slice = 144,
  protein_per_slice = 6.6,
  carbohydrate_per_slice = 20.4,
  sugars_per_slice = 1.4,
  fat_per_slice = 3.8,
  saturated_fat_per_slice = 0.8,
  salt_per_slice = 0.67,
  energy_per_100 = 180,
  protein_per_100 = 8.2,
  carbohydrate_per_100 = 24,
  sugars_per_100 = 1.7,
  fat_per_100 = 4.7,
  saturated_fat_per_100 = 0.3,
  salt_per_100 = 0.84,
  allergens = 'Gluten, soya',
  vegetarian = TRUE,
  vegan = TRUE
WHERE slug = 'veggie';

UPDATE pizza
SET
  weight = 406,
  num_slices = 6,
  energy_per_slice = 194,
  protein_per_slice = 7.3,
  carbohydrate_per_slice = 20.3,
  sugars_per_slice = 1.4,
  fat_per_slice = 9.1,
  saturated_fat_per_slice = 2.8,
  salt_per_slice = 0.76,
  energy_per_100 = 287,
  protein_per_100 = 10.8,
  carbohydrate_per_100 = 30,
  sugars_per_100 = 2.1,
  fat_per_100 = 13.4,
  saturated_fat_per_100 = 4.2,
  salt_per_100 = 1.13,
  allergens = 'Gluten, soya, milk/milk products, Sulphur Dioxide, Mustard products',
  vegetarian = FALSE,
  vegan = FALSE
WHERE slug = 'pepperoni-feast';

UPDATE pizza
SET
  weight = 511,
  num_slices = 6,
  energy_per_slice = 213,
  protein_per_slice = 11.0,
  carbohydrate_per_slice = 19.9,
  sugars_per_slice = 1.0,
  fat_per_slice = 9.4,
  saturated_fat_per_slice = 5.4,
  salt_per_slice = 0.05,
  energy_per_100 = 250,
  protein_per_100 = 12.9,
  carbohydrate_per_100 = 23.4,
  sugars_per_100 = 1.2,
  fat_per_100 = 6.3,
  saturated_fat_per_100 = 6.3,
  salt_per_100 = 1.23,
  allergens = 'Gluten, soya, milk/milk products, Sulphur Dioxide',
  vegetarian = TRUE,
  vegan = FALSE
WHERE slug = 'margherita';

UPDATE pizza
SET
  weight = 415,
  num_slices = 6,
  energy_per_slice = 153,
  protein_per_slice = 5.2,
  carbohydrate_per_slice = 20.8,
  sugars_per_slice = 2.7,
  fat_per_slice = 5.0,
  saturated_fat_per_slice = 1.9,
  salt_per_slice = 0.74,
  energy_per_100 = 221,
  protein_per_100 = 7.5,
  carbohydrate_per_100 = 30.0,
  sugars_per_100 = 3.9,
  fat_per_100 = 7.3,
  saturated_fat_per_100 = 2.7,
  salt_per_100 = 1.07,
  allergens = 'Milk/milk products, Sulphur Dioxide',
  vegetarian = FALSE,
  vegan = FALSE
WHERE slug = 'hawaiian';

ALTER TABLE pizza ALTER COLUMN vegetarian SET NOT NULL;
ALTER TABLE pizza ALTER COLUMN vegan SET NOT NULL;
