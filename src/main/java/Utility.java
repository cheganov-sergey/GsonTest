import Entitys.*;
import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Класс преобразования из Json в Java объекьы
 */
public class Utility {

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
                jsonResponse = Unirest.get("https://swapi.co/api/starships").asJson();
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
        }


    }

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
        }
    }

  


}