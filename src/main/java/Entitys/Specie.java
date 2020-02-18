package Entitys;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Specie implements JsonDeserializer<Specie> {

    private String name;
    private String classification;
    private String designation;
    private int average_height;
    private String skin_colors;
    private String hair_colors;
    private String eye_colors;
    private String average_lifespan;
    private String homeworld;
    private String language;
    private List<String> people;
    private List<String> films;
    private String created;
    private String edited;
    private String url;

    //////////////////// Constructors ////////////////////
    public Specie() {
       this.people = new ArrayList<String>();
       this.films = new ArrayList<String>();
    }

    ///////////////////// Setters ////////////////////////
    public void setName(String name) {
        this.name = name;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setAverage_height(int average_height) {
        this.average_height = average_height;
    }

    public void setSkin_colors(String skin_colors) {
        this.skin_colors = skin_colors;
    }

    public void setHair_colors(String hair_colors) {
        this.hair_colors = hair_colors;
    }

    public void setEye_colors(String eye_colors) {
        this.eye_colors = eye_colors;
    }

    public void setAverage_lifespan(String average_lifespan) {
        this.average_lifespan = average_lifespan;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void addPeople(String people) {
        this.people.add(people);
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

    public Specie deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Specie specie = new Specie();

        specie.setName(jsonObject.get("name").getAsString());
        specie.setClassification(jsonObject.get("classification").getAsString());
        specie.setDesignation(jsonObject.get("designation").getAsString());
        specie.setAverage_height(jsonObject.get("average_height").getAsInt());
        specie.setSkin_colors(jsonObject.get("skin_colors").getAsString());
        specie.setHair_colors(jsonObject.get("hair_colors").getAsString());
        specie.setEye_colors(jsonObject.get("eye_colors").getAsString());
        specie.setAverage_lifespan(jsonObject.get("average_lifespan").getAsString());
        specie.setHomeworld(jsonObject.get("homeworld").getAsString());
        specie.setLanguage(jsonObject.get("language").getAsString());

        JsonArray people = jsonObject.getAsJsonArray("people");
        for (JsonElement element : people) {
            specie.addPeople(element.getAsString());
        }

        JsonArray films = jsonObject.getAsJsonArray("people");
        for (JsonElement element : films) {
            specie.addFilms(element.getAsString());
        }

        specie.setCreated(jsonObject.get("created").getAsString());
        specie.setEdited(jsonObject.get("edited").getAsString());
        specie.setUrl(jsonObject.get("url").getAsString());

        return specie;
    }

    @Override
    public String toString() {
        return "Specie{" +
                "name='" + name + '\'' +
                ", classification='" + classification + '\'' +
                ", designation='" + designation + '\'' +
                ", average_height=" + average_height +
                ", skin_colors='" + skin_colors + '\'' +
                ", hair_colors='" + hair_colors + '\'' +
                ", eye_colors='" + eye_colors + '\'' +
                ", average_lifespan='" + average_lifespan + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", language='" + language + '\'' +
                ", people=" + people +
                ", films=" + films +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
