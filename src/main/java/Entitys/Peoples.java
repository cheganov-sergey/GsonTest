package Entitys;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * People агрегатор (людей)
 */
public class Peoples implements JsonDeserializer<Peoples> {

    private List<People> results;

    public Peoples() {
        this.results = new ArrayList<People>();
    }

    public void addPeoples(People people) {
        this.results.add(people);
    }

    /**
     * Десериализатор json
     * @param jsonElement  - десериализируемый объект
     * @param type  - объект к которому приводим
     * @param context  - контекст
     * @return объект People
     * @throws JsonParseException
     */
     public Peoples deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {

        Peoples peoples = new Peoples();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonArray results = jsonObject.getAsJsonArray("results");
        for (JsonElement element : results) {
           People people = context.deserialize(element, People.class);
           peoples.addPeoples(people);
        }
        return peoples;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(this);
    }
}
