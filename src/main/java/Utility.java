import Entitys.*;
import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Класс преобразования из Json в Java объекьы и обратно
 */
public class Utility {

    /**
     * Вызываем десериализацию json объекта в lava класс
     * @param entitis - перечисляемый параметр
     * @throws UnirestException
     */
    public static void deserealizeEntites(Entitis entitis) throws UnirestException {

        Gson gson;
        HttpResponse<JsonNode> jsonResponse;

        switch (entitis) {
            case PLANETS:
                jsonResponse = Unirest.get("https://swapi.co/api/planets/").asJson();
               gson = new GsonBuilder()
                        .registerTypeAdapter(Planet.class, new Planet())
                        .registerTypeAdapter(Planets.class, Planets.getPlanets())
                        .create();
                gson.fromJson(String.valueOf(jsonResponse.getBody()), Planets.class);

            case PEOPLES:
               jsonResponse = Unirest.get("https://swapi.co/api/people/").asJson();
               gson = new GsonBuilder()
                        .registerTypeAdapter(People.class, new People())
                        .registerTypeAdapter(Peoples.class, Peoples.getPeoples())
                        .create();
                gson.fromJson(String.valueOf(jsonResponse.getBody()), Peoples.class);

            case STARSHIPS:
                jsonResponse = Unirest.get("https://swapi.co/api/starships/").asJson();
                gson = new GsonBuilder()
                        .registerTypeAdapter(Starship.class, new Starship())
                        .registerTypeAdapter(Starships.class, Starships.getStarships())
                        .create();
               gson.fromJson(String.valueOf(jsonResponse.getBody()), Starships.class);

           case FILMS:
               jsonResponse = Unirest.get("https://swapi.co/api/films").asJson();
               gson = new GsonBuilder()
                       .registerTypeAdapter(Film.class, new Film())
                       .registerTypeAdapter(Films.class, Films.getFilms())
                       .create();
               gson.fromJson(String.valueOf(jsonResponse.getBody()), Films.class);

            case VEHICLES:
                jsonResponse = Unirest.get("https://swapi.co/api/vehicles").asJson();
                gson = new GsonBuilder()
                        .registerTypeAdapter(Vehicle.class, new Vehicle())
                        .registerTypeAdapter(Vehicles.class, Vehicles.getVegicles())
                        .create();
                gson.fromJson(String.valueOf(jsonResponse.getBody()), Vehicles.class);

            case SPECIES:
                jsonResponse = Unirest.get("https://swapi.co/api/species/").asJson();
                gson = new GsonBuilder()
                        .registerTypeAdapter(Specie.class, new Specie())
                        .registerTypeAdapter(Species.class, Species.getSpecies())
                        .create();
                gson.fromJson(String.valueOf(jsonResponse.getBody()), Species.class);
        }


    }

    /**
     * сериализуем объект java в json
     * @param entitis
     */
    public static void serialixedEntitis(Entitis entitis) {
        switch (entitis) {
            case PEOPLES:
                System.out.println(Peoples.getPeoples());
            case PLANETS:
                System.out.println(Planets.getPlanets());
            case STARSHIPS:
                System.out.println(Starships.getStarships());
            case FILMS:
                System.out.println(Films.getFilms());
            case VEHICLES:
                System.out.println(Vehicles.getVegicles());
            case SPECIES:
                System.out.println(Species.getSpecies());
        }
    }

  


}
