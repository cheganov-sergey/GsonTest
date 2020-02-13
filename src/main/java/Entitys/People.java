package Entitys;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Персоонажи
 */
public class People implements JsonDeserializer<People> {

    private String name;
    private int height;
    private int mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private ArrayList<String> films;
    private ArrayList<String> species;
    private ArrayList<String> vehicles;
    private ArrayList<String> starships;
    private String created;
    private String edited;
    private String url;

    // Конструкторы:

    public People() {
        films = new ArrayList<String>();
        species = new ArrayList<String>();
        vehicles = new ArrayList<String>();
        starships = new ArrayList<String>();
    }

    // Сеттеры:

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public void setFilms(String film) {
        this.films.add(film);
    }

    public void setSpecies(String species) {
        this.species.add(species);
    }

    public void setVehicles(String vehicles) {
        this.vehicles.add(vehicles);
    }

    public void setStarships(String starships) {
        this.starships.add(starships);
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

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", mass=" + mass +
                ", hair_color='" + hair_color + '\'' +
                ", skin_color='" + skin_color + '\'' +
                ", eye_color='" + eye_color + '\'' +
                ", birth_year='" + birth_year + '\'' +
                ", gender='" + gender + '\'' +
                ", homeworld=" + homeworld +
                ", films=" + films +
                ", species=" + species +
                ", vehicles=" + vehicles +
                ", starships=" + starships +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public People deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();

            People people = new People();
            people.setName(jsonObject.get("name").getAsString());
            people.setHeight(jsonObject.get("height").getAsInt());
            people.setMass(jsonObject.get("mass").getAsInt());
            people.setHair_color(jsonObject.get("hair_color").getAsString());
            people.setSkin_color(jsonObject.get("skin_color").getAsString());
            people.setEye_color(jsonObject.get("eye_color").getAsString());
            people.setBirth_year(jsonObject.get("birth_year").getAsString());
            people.setGender(jsonObject.get("gender").getAsString());
            people.setHomeworld(jsonObject.get("homeworld").getAsString());

            JsonArray films = jsonObject.getAsJsonArray("films");
            for (JsonElement film : films ) {
                people.setFilms(film.getAsString());
            }

            JsonArray species = jsonObject.getAsJsonArray("species");
            for (JsonElement specie : species ) {
                people.setSpecies(specie.getAsString());
            }

            JsonArray vehicles = jsonObject.getAsJsonArray("vehicles");
            for (JsonElement vehicle : vehicles ) {
                people.setVehicles(vehicle.getAsString());
            }

            JsonArray starships = jsonObject.getAsJsonArray("starships");
            for (JsonElement starship : starships ) {
                people.setStarships(starship.getAsString());
            }

            people.setCreated(jsonObject.get("created").getAsString());
            people.setEdited(jsonObject.get("edited").getAsString());
            people.setUrl(jsonObject.get("url").getAsString());

        return people;
    }
}