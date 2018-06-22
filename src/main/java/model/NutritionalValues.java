package model;

public class NutritionalValues {

    private int weight;
    private int num_slices;
    private int energy_per_slice;
    private float protein_per_slice;
    private float carbohydrate_per_slice;
    private float sugars_per_slice;
    private float fat_per_slice;
    private float saturated_fat_per_slice;
    private float salt_per_slice;
    private int energy_per_100;
    private float protein_per_100;
    private float carbohydrate_per_100;
    private float sugars_per_100;
    private float fat_per_100;
    private float saturated_fat_per_100;
    private float salt_per_100;
    private String allergens;
    private String vegetarian;
    private String vegan;


    public NutritionalValues(int weight, int num_slices, int energy_per_slice, float protein_per_slice, float carbohydrate_per_slice, float sugars_per_slice, float fat_per_slice, float saturated_fat_per_slice, float salt_per_slice, int energy_per_100, float protein_per_100, float carbohydrate_per_100, float sugars_per_100, float fat_per_100, float saturated_fat_per_100, float salt_per_100, String allergens, boolean vegetarian, boolean vegan) {

        this.weight = weight;
        this.num_slices = num_slices;
        this.energy_per_slice = energy_per_slice;
        this.protein_per_slice = Math.round(protein_per_slice * 10.0f)/10.0f;
        this.carbohydrate_per_slice = Math.round(carbohydrate_per_slice * 10.0f)/10.0f;
        this.sugars_per_slice = Math.round(sugars_per_slice * 10.0f)/10.0f;
        this.fat_per_slice = Math.round(fat_per_slice * 10.0f)/10.0f;
        this.saturated_fat_per_slice = Math.round(saturated_fat_per_slice * 10.0f)/10.0f;
        this.salt_per_slice = Math.round(salt_per_slice*100.0f)/100.0f;
        this.energy_per_100 = energy_per_100;
        this.protein_per_100 = Math.round(protein_per_100 * 10.0f)/10.0f;
        this.carbohydrate_per_100 = Math.round(carbohydrate_per_100 * 10.0f)/10.0f;
        this.sugars_per_100 = Math.round(sugars_per_100 * 10.0f)/10.0f;
        this.fat_per_100 = Math.round(fat_per_100 * 10.0f)/10.0f;
        this.saturated_fat_per_100 = Math.round(saturated_fat_per_100 * 10.0)/10.0f;
        this.salt_per_100 = Math.round(salt_per_100*100.0f)/100.0f;
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
