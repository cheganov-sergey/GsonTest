package Entitys;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Species implements JsonDeserializer<Species> {

    public static Species instance;
    public List<Specie> results;

    private Species() {
        this.results = new ArrayList<Specie>();
    }

    public static Species getSpecies() {
        if (instance == null)
            instance = new Species();
        return instance;
    }

    public void addSpecies(Specie results) {
        this.results.add(results);
    }

    public Species deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Species species = Species.getSpecies();

        JsonArray results = jsonObject.getAsJsonArray("results");
        for (JsonElement element : results) {
            Specie specie = context.deserialize(element, Specie.class);
            species.addSpecies(specie);
        }

        return species;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(this);
    }
}
