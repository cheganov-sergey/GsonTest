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
    public static Vehicles getVegicles() {
        if (instance == null)
            instance = new Vehicles();
        return instance;
    }

    public void addVehicle( Vehicle vehicle) {
        this.results.add(vehicle);
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
        Vehicles vehicles = Vehicles.getVegicles();

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
        return gson.toJson(this);
    }
}
