package Entitys;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Агрегатор комических кораблей (СинглТон)
 */
public class Starships implements JsonDeserializer<Starships> {

    private static Starships instance;  // единственный экземпляр класса
    private List<Starship> results;

    private Starships() {
        this.results = new ArrayList<Starship>();
    }

    public static Starships getStarships() {
        if (instance == null) {
            instance = new Starships();
        }
        return instance;
    }

    public void addStarship(Starship starship) {
        this.results.add(starship);
    }

    public Starships deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Starships starships = Starships.getStarships();

        JsonArray results = jsonObject.getAsJsonArray("results");
        for (JsonElement element : results) {
            Starship starship = context.deserialize(element, Starship.class);
            starships.addStarship(starship);
        }
        return starships;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(this);
    }
}
