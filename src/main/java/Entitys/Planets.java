package Entitys;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Агрегатор планет  -  Planet (СинглТон)
 */
public class Planets implements JsonDeserializer<Planets> {

    private static Planets instance;  // единственный экземпляр класса
    private List<Planet> results;

    private Planets() {
        this.results = new ArrayList<Planet>();
    }

    /**
     * СинглТон
     * @return список планет
     */
    public static Planets getPlanets() {
        if (instance == null) {
            instance = new Planets();
        }
        return instance;
    }

    public void addPlanet(Planet planet) {
        this.results.add(planet);
    }

    public Planets deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Planets planets = Planets.getPlanets();

        JsonArray results = jsonObject.getAsJsonArray("results");
        for (JsonElement element : results) {
            Planet planet = context.deserialize(element, Planet.class);
            planets.addPlanet(planet);
        }

        return planets;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(this);
    }

}
