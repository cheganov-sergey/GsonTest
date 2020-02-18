package Entitys;
import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Starship implements JsonDeserializer<Starship> {

   private String name;
   private String model;
   private String manufacturer;
   private String cost_in_credits;
   private double length;
   private String max_atmosphering_speed;
   private int crew;
   private int passengers;
   private long cargo_capacity;
   private String consumables;
   private String hyperdrive_rating;
   private int MGLT;
   private String starship_class;
   private List<String> pilots;
   private  List<String> films;
   private String created;
   private String edited;
   private String url;

   ////////////////////// Constructor //////////////////////////////
    public Starship() {
        this.pilots = new ArrayList<String>();
        this.films = new ArrayList<String>();
    }

    /////////////////////// Setters //////////////////////////////////
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

    public void setCargo_capacity(long cargo_capacity) {
        this.cargo_capacity = cargo_capacity;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public void setHyperdrive_rating(String hyperdrive_rating) {
        this.hyperdrive_rating = hyperdrive_rating;
    }

    public void setMGLT(int MGLT) {
        this.MGLT = MGLT;
    }

    public void setStarship_class(String starship_class) {
        this.starship_class = starship_class;
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
     * Десериализатор
     * @param jsonElement что десереализуем
     * @param type куда ресериализуем
     * @param jsonDeserializationContext контекст
     * @return Космический корабль
     * @throws JsonParseException
     */
    public Starship deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Starship starship = new Starship();

        starship.setName(jsonObject.get("name").getAsString());
        starship.setModel(jsonObject.get("model").getAsString());
        starship.setManufacturer(jsonObject.get("manufacturer").getAsString());
        starship.setCost_in_credits(jsonObject.get("cost_in_credits").getAsString());
        starship.setLength(jsonObject.get("length").getAsDouble());
        starship.setMax_atmosphering_speed(jsonObject.get("max_atmosphering_speed").getAsString());
        starship.setCrew(jsonObject.get("crew").getAsInt());
        starship.setCargo_capacity(jsonObject.get("cargo_capacity").getAsLong());
        starship.setConsumables(jsonObject.get("consumables").getAsString());
        starship.setHyperdrive_rating(jsonObject.get("hyperdrive_rating").getAsString());
        starship.setMGLT(jsonObject.get("MGLT").getAsInt());
        starship.setStarship_class(jsonObject.get("starship_class").getAsString());

        JsonArray pilots = jsonObject.getAsJsonArray("pilots");
        for (JsonElement element : pilots) {
            starship.addPilots(element.getAsString());
        }

        JsonArray films = jsonObject.getAsJsonArray("films");
        for (JsonElement element : films) {
            starship.addFilms(element.getAsString());
        }
        starship.setCreated(jsonObject.get("created").getAsString());
        starship.setEdited(jsonObject.get("edited").getAsString());
        starship.setUrl(jsonObject.get("url").getAsString());

        return starship;
    }

    @Override
    public String toString() {
        return "Starship{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", cost_in_credits='" + cost_in_credits + '\'' +
                ", length=" + length +
                ", max_atmosphering_speed='" + max_atmosphering_speed + '\'' +
                ", crew=" + crew +
                ", passengers=" + passengers +
                ", cargo_capacity=" + cargo_capacity +
                ", consumables='" + consumables + '\'' +
                ", hyperdrive_rating='" + hyperdrive_rating + '\'' +
                ", MGLT=" + MGLT +
                ", starship_class='" + starship_class + '\'' +
                ", pilots=" + pilots +
                ", films=" + films +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
