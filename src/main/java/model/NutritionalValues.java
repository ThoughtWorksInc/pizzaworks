package model;

public class NutritionalValues {

    private int weight;
    private int numSlices;
    private int energyPerSlice;
    private double proteinPerSlice;
    private double carbohydratePerSlice;
    private double sugarsPerSlice;
    private double fatPerSlice;
    private double saturatedFatPerSlice;
    private double saltPerSlice;
    private int energyPer100;
    private double proteinPer100;
    private double carbohydratePer100;
    private double sugarsPer100;
    private double fatPer100;
    private double saturatedFatPer100;
    private double saltPer100;
    private String allergens;
    private boolean vegetarian;
    private boolean vegan;


    public NutritionalValues(int weight, int numSlices, int energyPerSlice, double proteinPerSlice, double carbohydratePerSlice, double sugarsPerSlice, double fatPerSlice, double saturatedFatPerSlice, double saltPerSlice, int energyPer100, double proteinPer100, double carbohydratePer100, double sugarsPer100, double fatPer100, double saturatedFatPer100, double saltPer100, String allergens, boolean vegetarian, boolean vegan) {
        this.weight = weight;
        this.numSlices = numSlices;
        this.energyPerSlice = energyPerSlice;
        this.proteinPerSlice = proteinPerSlice;
        this.carbohydratePerSlice = carbohydratePerSlice;
        this.sugarsPerSlice = sugarsPerSlice;
        this.fatPerSlice = fatPerSlice;
        this.saturatedFatPerSlice = saturatedFatPerSlice;
        this.saltPerSlice = saltPerSlice;
        this.energyPer100 = energyPer100;
        this.proteinPer100 = proteinPer100;
        this.carbohydratePer100 = carbohydratePer100;
        this.sugarsPer100 = sugarsPer100;
        this.fatPer100 = fatPer100;
        this.saturatedFatPer100 = saturatedFatPer100;
        this.saltPer100 = saltPer100;
        this.allergens = allergens;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
    }

    public int getWeight() {
        return weight;
    }

    public int getNumSlices() {
        return numSlices;
    }

    public int getEnergyPerSlice() {
        return energyPerSlice;
    }

    public double getProteinPerSlice() {
        return proteinPerSlice;
    }

    public double getCarbohydratePerSlice() {
        return carbohydratePerSlice;
    }

    public double getSugarsPerSlice() {
        return sugarsPerSlice;
    }

    public double getFatPerSlice() {
        return fatPerSlice;
    }

    public double getSaturatedFatPerSlice() {
        return saturatedFatPerSlice;
    }

    public double getSaltPerSlice() {
        return saltPerSlice;
    }

    public int getEnergyPer100() {
        return energyPer100;
    }

    public double getProteinPer100() {
        return proteinPer100;
    }

    public double getCarbohydratePer100() {
        return carbohydratePer100;
    }

    public double getSugarsPer100() {
        return sugarsPer100;
    }

    public double getFatPer100() {
        return fatPer100;
    }

    public double getSaturatedFatPer100() {
        return saturatedFatPer100;
    }

    public double getSaltPer100() {
        return saltPer100;
    }

    public String getAllergens() {
        return allergens;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }
}
