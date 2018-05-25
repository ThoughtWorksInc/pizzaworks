package model;

public class NutritionalValues {

    private int energyPerSlice;

    public NutritionalValues(int energyPerSlice) {
        this.energyPerSlice = energyPerSlice;
    }

    public int getEnergyPerSlice() {
        return energyPerSlice;
    }

    public void setEnergyPerSlice(int energyPerSlice) {
        this.energyPerSlice = energyPerSlice;
    }

    // TODO: 25/05/2018 Maybe change how values are stored (maybe a list or a hashMap?)
    // TODO: 25/05/2018 Add energyPerSlice column to DB
}
