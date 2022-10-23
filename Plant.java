public class Plant {

    String name = "";
    String plantType = "";
    String weather = "";
    int plantAge = 0;
    int plantSize = 0;
    int waterConsumption = 0;
    int loamAmount = 0;
    int clayAmount = 0;
    int sandAmount = 0;

    Plant(String name, String plantType, String weather, int plantAge, int plantSize, int waterConsumption, int loamAmount, int clayAmount, int sandAmount) {
        this.name = name;
        this.plantType = plantType;
        this.weather = weather;
        this.plantAge = plantAge;
        this.plantSize = plantSize;
        this.waterConsumption = waterConsumption;
        this.loamAmount = loamAmount;
        this.clayAmount = clayAmount;
        this.sandAmount = sandAmount;
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

    public int getPlantSize() {
        return plantSize;
    }

    public int getWaterConsumption() {
        return waterConsumption;
    }

    public int getLoamAmount() {
        return loamAmount;
    }

    public int getClayAmount() {
        return clayAmount;
    }

    public int getSandAmount() {
        return sandAmount;
    }

    public void setNewSoilComp(int newLoam, int newClay, int newSand) {
        loamAmount = newLoam;
        clayAmount = newClay;
        sandAmount = newSand;
    }

}
