package model;

public class NutritionalValues {

    private int weight;
    private int num_slices;
    private int energy_per_slice;
    private double protein_per_slice;
    private double carbohydrate_per_slice;
    private double sugars_per_slice;
    private double fat_per_slice;
    private double saturated_fat_per_slice;
    private double salt_per_slice;
    private int energy_per_100;
    private double protein_per_100;
    private double carbohydrate_per_100;
    private double sugars_per_100;
    private double fat_per_100;
    private double saturated_fat_per_100;
    private double salt_per_100;
    private String allergens;
    private String vegetarian;
    private String vegan;


    public NutritionalValues(int weight, int num_slices, int energy_per_slice, double protein_per_slice, double carbohydrate_per_slice, double sugars_per_slice, double fat_per_slice, double saturated_fat_per_slice, double salt_per_slice, int energy_per_100, double protein_per_100, double carbohydrate_per_100, double sugars_per_100, double fat_per_100, double saturated_fat_per_100, double salt_per_100, String allergens, boolean vegetarian, boolean vegan) {

        this.weight = weight;
        this.num_slices = num_slices;
        this.energy_per_slice = energy_per_slice;
        this.protein_per_slice = protein_per_slice;
        this.carbohydrate_per_slice = carbohydrate_per_slice;
        this.sugars_per_slice = sugars_per_slice;
        this.fat_per_slice = fat_per_slice;
        this.saturated_fat_per_slice = saturated_fat_per_slice;
        this.salt_per_slice = salt_per_slice;
        this.energy_per_100 = energy_per_100;
        this.protein_per_100 = protein_per_100;
        this.carbohydrate_per_100 = carbohydrate_per_100;
        this.sugars_per_100 = sugars_per_100;
        this.fat_per_100 = fat_per_100;
        this.saturated_fat_per_100 = saturated_fat_per_100;
        this.salt_per_100 = salt_per_100;
        this.allergens = allergens;

        if (vegetarian) {
            this.vegetarian = "Yes";
        } else {
            this.vegetarian = "No";
        }

        if (vegan) {
            this.vegan = "Yes";
        } else {
            this.vegan = "No";
        }
    }

    public int getWeight() {
        return weight;
    }

    public int getNum_slices() {
        return num_slices;
    }

    public int getEnergy_per_slice() {
        return energy_per_slice;
    }

    public double getProtein_per_slice() {
        return protein_per_slice;
    }

    public double getCarbohydrate_per_slice() {
        return carbohydrate_per_slice;
    }

    public double getSugars_per_slice() {
        return sugars_per_slice;
    }

    public double getFat_per_slice() {
        return fat_per_slice;
    }

    public double getSaturated_fat_per_slice() {
        return saturated_fat_per_slice;
    }

    public double getSalt_per_slice() {
        return salt_per_slice;
    }

    public int getEnergy_per_100() {
        return energy_per_100;
    }

    public double getProtein_per_100() {
        return protein_per_100;
    }

    public double getCarbohydrate_per_100() {
        return carbohydrate_per_100;
    }

    public double getSugars_per_100() {
        return sugars_per_100;
    }

    public double getFat_per_100() {
        return fat_per_100;
    }

    public double getSaturated_fat_per_100() {
        return saturated_fat_per_100;
    }

    public double getSalt_per_100() {
        return salt_per_100;
    }

    public String getAllergens() {
        return allergens;
    }

    public String getVegetarian() {
        return vegetarian;
    }

    public String getVegan() {
        return vegan;
    }
}
