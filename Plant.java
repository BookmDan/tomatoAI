public class Plant {

    String name = "";
    String plantType = "";
    String weather = "";
    int plantAge = 0;
    double plantSize = 0;
    double waterConsumption = 0;
    double loamAmount = 0;
    double clayAmount = 0;
    double sandAmount = 0;
    double hoseFlow = 0;

    Plant(String name, String plantType, String weather, int plantAge, double plantSize, double waterConsumption, double loamAmount, double clayAmount, double sandAmount, double hoseFlow) {
        this.name = name;
        this.plantType = plantType;
        this.weather = weather;
        this.plantAge = plantAge;
        this.plantSize = plantSize;
        this.waterConsumption = waterConsumption;
        this.loamAmount = loamAmount;
        this.clayAmount = clayAmount;
        this.sandAmount = sandAmount;
        this.hoseFlow = hoseFlow;
    }

    public String getName() {
        return name;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setWeather(String newWeather) {
        weather = newWeather;
    }

    public String getWeather() {
        return weather;
    }

    public int getPlantAge() {
        return plantAge;
    }

    public void setPlantSize(int newSize) {
        plantSize = newSize;
    }

    public double getPlantSize() {
        return plantSize;
    }

    public double getWaterConsumption() {
        return waterConsumption;
    }

    public double getLoamAmount() {
        return loamAmount;
    }

    public double getClayAmount() {
        return clayAmount;
    }

    public double getSandAmount() {
        return sandAmount;
    }

    public void setHoseFlow(double newHoseFlow) {
        hoseFlow = newHoseFlow;
    }

    public double getHoseFlow() {
        return hoseFlow;
    }

    public void setNewSoilComp(int newLoam, int newClay, int newSand) {
        loamAmount = newLoam;
        clayAmount = newClay;
        sandAmount = newSand;
    }

}
