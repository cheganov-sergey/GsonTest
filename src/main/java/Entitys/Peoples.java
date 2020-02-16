package Entitys;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * People агрегатор (людей) - Singleton
 */
public class Peoples implements JsonDeserializer<Peoples> {

    private static Peoples instance;  // единственный экземпляр класса
    private List<People> results;

    private Peoples() {
        this.results = new ArrayList<People>();
    }

    public static Peoples getPeoples() {
        if (instance == null) {
            instance = new Peoples();
        }
        return instance;
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

        Peoples peoples = Peoples.getPeoples();
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