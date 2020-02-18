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
        results = new ArrayList<Planet>();
    }

    /**
     * Silgleton
     * @return единственный экземпяр класса
     */
    public static Planets getPlanets() {
        if (instance == null) {
            instance = new Planets();
        }
        return instance;
    }

    /**
     * Добавляем планету в список (дубликаты игнорируются)
     * @param planet планета
     */
    public void addPlanet(Planet planet) {
        boolean repeat = false;
        for (Planet arr : results) {
            if (arr.getName().equals(planet.getName()))
                repeat = true;
        }
        if (!repeat)
        results.add(planet);
    }

    public List<Planet> getAllPlants() {
        return this.results;
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
        return gson.toJson(results);
    }

}
