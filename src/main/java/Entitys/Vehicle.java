package Entitys;
import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс - транспортное средство
 */
public class Vehicle implements JsonDeserializer<Vehicle> {

    private String name;
    private String model;
    private String manufacturer;
    private String cost_in_credits;
    private double length;
    private String max_atmosphering_speed;
    private int crew;
    private int passengers;
    private String cargo_capacity;
    private String consumables;
    private String vehicle_class;
    private List<String> pilots;
    private List<String> films;
    private String created;
    private String edited;
    private String url;

    /////////////////////// Constructors //////////////////////////////
    public Vehicle() {
        this.pilots = new ArrayList<String>();
        this.films = new ArrayList<String>();
    }

    public Vehicle(String name) {
        this.name = name;
        this.pilots = new ArrayList<String>();
        this.films = new ArrayList<String>();
    }

    /////////////////////// Setters ////////////////////////////

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCost_in_credits(String cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setMax_atmosphering_speed(String max_atmosphering_speed) {
        this.max_atmosphering_speed = max_atmosphering_speed;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void setCargo_capacity(String cargo_capacity) {
        this.cargo_capacity = cargo_capacity;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public void setVehicle_class(String vehicle_class) {
        this.vehicle_class = vehicle_class;
    }

    public void addPilots(String pilots) {
        this.pilots.add(pilots);
    }

    public void addFilms(String films) {
        this.films.add(films);
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Десериализатор класса
     * @param jsonElement что
     * @param type куда
     * @param context в контексте
     * @return транспорт
     * @throws JsonParseException
     */
    public Vehicle deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Vehicle vehicle = new Vehicle();

        vehicle.setName(jsonObject.get("name").getAsString());
        vehicle.setModel(jsonObject.get("model").getAsString());
        vehicle.setManufacturer(jsonObject.get("manufacturer").getAsString());
        vehicle.setCost_in_credits(jsonObject.get("cost_in_credits").getAsString());
        vehicle.setLength(jsonObject.get("length").getAsDouble());
        vehicle.setMax_atmosphering_speed(jsonObject.get("max_atmosphering_speed").getAsString());
        vehicle.setCrew(jsonObject.get("crew").getAsInt());
        vehicle.setCargo_capacity(jsonObject.get("cargo_capacity").getAsString());
        vehicle.setConsumables(jsonObject.get("consumables").getAsString());
        vehicle.setVehicle_class(jsonObject.get("vehicle_class").getAsString());

        JsonArray pilots = jsonObject.getAsJsonArray("pilots");
        for (JsonElement element : pilots) {
            vehicle.addPilots(element.getAsString());
        }

        JsonArray films = jsonObject.getAsJsonArray("films");
        for (JsonElement element : films) {
            vehicle.addFilms(element.getAsString());
        }
        vehicle.setCreated(jsonObject.get("created").getAsString());
        vehicle.setEdited(jsonObject.get("edited").getAsString());
        vehicle.setUrl(jsonObject.get("url").getAsString());

        return vehicle;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return "Транспортное средство: " + gson.toJson(this);
    }
}
