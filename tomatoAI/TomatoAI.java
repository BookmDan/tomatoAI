import java.util.HashMap;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.Headers;

public class TomatoAI {
    public static HashMap<String, Integer> plantDB = new HashMap<String, Integer>();
    public static HashMap<String, Integer> weatherDB = new HashMap<String, Integer>();


    public static void main (String[] args) throws IOException {
        plantDB = new HashMap<String, Integer>();
        plantDB.put("tomato", 1);
        plantDB.put("potato", 1);
        plantDB.put("peach", 8085);

        weatherDB = new HashMap<String, Integer>();
        weatherDB.put("sunny", 3);
        weatherDB.put("cloudy", 2);
        weatherDB.put("rainy", 1);

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/get", new GetHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        Plant test = new Plant("test", "tomato", "sunny", 100, 100, 100, 20, 50, 30, 100);
        System.out.println(calculateSeconds(weatherDB, plantDB, test));

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
        double trueHoseFlowWeight = p.getHoseFlow() * hoseFlowWeight;

        return (trueWeather + trueAge + trueSize + trueAge + trueConsumption + trueSoilWeight + trueHoseFlowWeight) * 0.30;

    }

    static class GetHandler implements HttpHandler {

        public void handle(HttpExchange t) throws IOException {
            Plant test = new Plant("test", "tomato", "sunny", 100, 100, 100, 20, 50, 30, 100);

            // add the required response header for a PDF file
            Headers h = t.getResponseHeaders();
            h.add("Content-Type", "text/html");

            // a PDF (you provide your own!)
            File file = new File ("c:/temp/doc.pdf");
            byte [] bytearray  = String.valueOf(TomatoAI.calculateSeconds(TomatoAI.weatherDB, TomatoAI.plantDB, test)).getBytes("UTF-8");

            // ok, we are ready to send the response.
            t.sendResponseHeaders(200, file.length());
            OutputStream os = t.getResponseBody();
            os.write(bytearray,0,bytearray.length);
            os.close();
        }
    }

}