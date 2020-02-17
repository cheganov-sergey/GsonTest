package Entitys;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Фильмы
 */
public class Film implements JsonDeserializer<Film> {

    private String title;
    private int episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    private ArrayList<String> characters;
    private ArrayList<String> planets;
    private ArrayList<String> starships;
    private ArrayList<String> vehicles;
    private ArrayList<String> species;
    private String created;
    private String edited;
    private String url;

    ///////////////////// Constructor ////////////////////////
    public Film() {
                characters = new ArrayList<String>();
        planets = new ArrayList<String>();
        vehicles = new ArrayList<String>();
        species = new ArrayList<String>();
        starships = new ArrayList<String>();
    }

    ///////////////////// Setters ///////////////////////////////
    public void setTitle(String title) {
        this.title = title;
    }

    public void setEpisode_id(int episode_id) {
        this.episode_id = episode_id;
    }

    public void setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void addCharacters(String characters) {
        this.characters.add(characters);
    }

    public void addPlanets(String planets) {
        this.planets.add(planets);
    }

    public void addVehicles(String vehicles) {
        this.vehicles.add(vehicles);
    }

    public void addSpecies(String species) {
        this.species.add(species);
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

    public void addStarships(String starships) {
        this.starships.add(starships);
    }

    public String getTitle() {
        return this.title;
    }

    /**
     * Десериализатор класса
     * @param jsonElement что десереализум
     * @param type куда десереализуем
     * @param context контекст
     * @return Фильм (объект)
     * @throws JsonParseException
     */
    public Film deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Film film = new Film();

        film.setTitle(jsonObject.get("title").getAsString());
        film.setEpisode_id(jsonObject.get("episode_id").getAsInt());
        film.setOpening_crawl(jsonObject.get("opening_crawl").getAsString());
        film.setDirector(jsonObject.get("director").getAsString());
        film.setProducer(jsonObject.get("producer").getAsString());
        film.setRelease_date(jsonObject.get("release_date").getAsString());

        JsonArray character = jsonObject.getAsJsonArray("characters");
        for (JsonElement element : character) {
            film.addCharacters(element.getAsString());
        }

        JsonArray planets = jsonObject.getAsJsonArray("planets");
        for (JsonElement element : planets) {
            film.addPlanets(element.getAsString());
        }

        JsonArray starships = jsonObject.getAsJsonArray("starships");
        for (JsonElement element : starships) {
            film.addStarships(element.getAsString());
        }

        JsonArray vehicles = jsonObject.getAsJsonArray("vehicles");
        for (JsonElement element : vehicles) {
            film.addVehicles(element.getAsString());
        }

        JsonArray species = jsonObject.getAsJsonArray("species");
        for (JsonElement element : species) {
            film.addSpecies(element.getAsString());
        }

        film.setCreated(jsonObject.get("created").getAsString());
        film.setEdited(jsonObject.get("edited").getAsString());
        film.setUrl(jsonObject.get("url").getAsString());

        return film;
    }
}
