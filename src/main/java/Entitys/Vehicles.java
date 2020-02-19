package Entitys;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Агрегатор транспортных средств
 */
public class Vehicles implements JsonDeserializer<Vehicles> {

    private static Vehicles instance;
    private List<Vehicle> results;

    private Vehicles() {
        results = new ArrayList<Vehicle>();
    }

    /**
     * Singleton
     * @return единственный экземпяр класса
     */
    public static Vehicles instance() {
        if (instance == null)
            instance = new Vehicles();
        return instance;
    }

    /**
     * Добавляем транспорт в список (дубликаты игнорируются)
     * @param vehicle транспорт
     */
    public void addVehicle( Vehicle vehicle) {
        boolean repeat = false;
        for (Vehicle arr : results) {
            if (arr.getName().equals(vehicle.getName()))
                repeat = true;
        }
        if (!repeat)
        results.add(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return this.results;
    }

    /**
     * десериализатор класса
     * @param jsonElement что дессериализуем
     * @param type куда
     * @param context контекст
     * @return Транспорт
     * @throws JsonParseException
     */
    public Vehicles deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Vehicles vehicles = Vehicles.instance();
        JsonArray results = jsonObject.getAsJsonArray("results");

        for (JsonElement element : results) {
            Vehicle vehicle = context.deserialize(element, Vehicle.class);
            vehicles.addVehicle(vehicle);
        }
        return vehicles;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(results);
    }
}
