package Entitys;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс - Планета
 */
public class Planet implements JsonDeserializer<Planet> {

    private String name;
    private int rotation_period;
    private int orbital_period;
    private int diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;
    private List<String> residents;
    private List<String> films;
    private String created;
    private String edited;
    private String url;

    ///////////////////// Constructors ////////////////////////
   public Planet() {
       this.residents = new ArrayList<String>();
       this.films = new ArrayList<String>();
   }

   ///////////////////// Setters /////////////////////////////
    public void setName(String name) {
        this.name = name;
    }

    public void setRotation_period(int rotation_period) {
        this.rotation_period = rotation_period;
    }

    public void setOrbital_period(int orbital_period) {
        this.orbital_period = orbital_period;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public void setSurface_water(String surface_water) {
        this.surface_water = surface_water;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public void addResidents(String residents) {
        this.residents.add(residents);
    }

    public void addFilms(String  films) {
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
     * Десереализация планет из Json
     * @param jsonElement - откуда десереализуем
     * @param type что десереализеум
     * @param context контекст
     * @return - новая планета
     * @throws JsonParseException
     */
    public Planet deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Planet planet = new Planet();

        planet.setName(jsonObject.get("name").getAsString());
        planet.setRotation_period(jsonObject.get("rotation_period").getAsInt());
        planet.setOrbital_period(jsonObject.get("orbital_period").getAsInt());
        planet.setDiameter(jsonObject.get("diameter").getAsInt());
        planet.setClimate(jsonObject.get("climate").getAsString());
        planet.setGravity(jsonObject.get("gravity").getAsString());
        planet.setTerrain(jsonObject.get("terrain").getAsString());
        planet.setSurface_water(jsonObject.get("surface_water").getAsString());
        planet.setPopulation(jsonObject.get("population").getAsString());

        JsonArray residents = jsonObject.getAsJsonArray("residents");
        for (JsonElement resident : residents ) {
            planet.addResidents(resident.getAsString());
        }

        JsonArray films = jsonObject.getAsJsonArray("films");
        for (JsonElement film : films ) {
            planet.addFilms(film.getAsString());
        }

        planet.setCreated(jsonObject.get("created").getAsString());
        planet.setEdited(jsonObject.get("edited").getAsString());
        planet.setUrl(jsonObject.get("url").getAsString());

       return planet;
    }
}
