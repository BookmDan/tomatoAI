import java.util.HashMap;
public class TomatoAI {
    public static void main (String[] args) {
        HashMap<String, Integer> plantDB = new HashMap<String, Integer>();
        plantDB.put("tomato", 1);
        plantDB.put("potato", 1);
        plantDB.put("peach", 8085);

        HashMap<String, Integer> weatherDB = new HashMap<String, Integer>();
        weatherDB.put("sunny", 3);
        weatherDB.put("cloudy", 2);
        weatherDB.put("rainy", 1);

        // Plant test = new Plant("test", "tomato", "sunny", 100, 100, 100, 20, 50, 30);
        // System.out.println(calculateSeconds(weatherDB, plantDB, test));

    }
    public static int consumptionNumber(HashMap<String, Integer> map, String name) {
        return map.get(name);
    }

    public static int weatherNum(HashMap<String, Integer> map, String type) {
        return map.get(type);
    }

    public static double calculateSeconds(HashMap<String, Integer> weatherDB, HashMap<String, Integer> plantDB, Plant p) {
        double weatherWeight = 0.1;
        double ageWeight = 0.05;
        double sizeWeight = 0.025;
        double consumptionWeight = 0.2;
        double soilCompWeight = 0.125;
        double hoseFlowWeight = 0.5;

        double trueWeather = weatherNum(weatherDB, p.getWeather()) * weatherWeight;
        double trueAge = p.getPlantAge() * ageWeight;
        double trueSize = p.getPlantSize() * sizeWeight;
        double trueConsumption = consumptionNumber(plantDB, p.getPlantType()) * consumptionWeight;
        double trueSoilWeight = (p.getLoamAmount() + p.getClayAmount() + p.getSandAmount()) * soilCompWeight;
        double truehoseFlowWeight = p.getHoseFlow() * hoseFlowWeight;

        return (trueWeather + trueAge + trueSize + trueAge + trueConsumption + trueSoilWeight + trueHoseFlowWeight) * 0.30;

    }
}