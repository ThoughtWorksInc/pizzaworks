ALTER TABLE pizza
  ADD COLUMN ingredients VARCHAR(500);
ALTER TABLE pizza
  ADD COLUMN price NUMERIC(5, 2);

UPDATE pizza
SET
  ingredients = 'Pizza sauce, vegan alternative to cheese, spinach, sweetcorn, mixed peppers, red onion, mushrooms',
  price       = 12.99
WHERE name = 'Veggie';

UPDATE pizza
SET
  ingredients = 'Pizza sauce, mozzarella cheese, pepperoni',
  price       = 13.99
WHERE name = 'Pepperoni feast';

UPDATE pizza
SET
  ingredients = 'Pizza sauce, mozzarella cheese',
  price       = 14.49
WHERE name = 'Margherita';

UPDATE pizza
SET
  ingredients = 'Pizza sauce, mozzarella cheese, ham, pineapple',
  price       = 12.99
WHERE name = 'Hawaiian';