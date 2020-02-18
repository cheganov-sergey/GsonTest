package Entitys;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * Добавляем вид в список (дубликаты игнорируются)
     * @param res вид
     */
    public void addSpecies(Specie res) {
        boolean repeat = false;
        for (Specie spec : results) {
            if (spec.getName().equals(res.getName()))
                repeat = true;
        }
        if (!repeat)
         this.results.add(res);
    }

    public List<Specie> getAllSpecies() {
        return results;
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
