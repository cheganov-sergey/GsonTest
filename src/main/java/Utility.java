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

    private static Utility instance;

    private Utility() {}

    public static Utility instance() {
        if (instance == null)
            instance = new Utility();
        return instance;
    }

    /**
     * Вызываем десериализацию json объекта в lava класс
     * @param entitis - перечисляемый параметр
     * @throws UnirestException
     */
    public void deserealizeEntites(Entitis entitis)  {
        Gson gson;
        HttpResponse<JsonNode> jsonResponse;

        switch (entitis) {
            case PLANETS:
                try {
                    jsonResponse = Unirest.get("https://swapi.co/api/planets/").asJson();
                    gson = new GsonBuilder()
                            .registerTypeAdapter(Planet.class, new Planet())
                            .registerTypeAdapter(Planets.class, Planets.instance())
                            .create();
                    gson.fromJson(String.valueOf(jsonResponse.getBody()), Planets.class);
                }
                catch (UnirestException e) {
                e.printStackTrace();
            }

            case PEOPLES:
                try {
                    jsonResponse = Unirest.get("https://swapi.co/api/people/").asJson();
                    gson = new GsonBuilder()
                            .registerTypeAdapter(People.class, new People())
                            .registerTypeAdapter(Peoples.class, Peoples.instance())
                            .create();
                    gson.fromJson(String.valueOf(jsonResponse.getBody()), Peoples.class);
                }
                catch (UnirestException e) {
                    e.printStackTrace();
                }

            case STARSHIPS:
                try {
                jsonResponse = Unirest.get("https://swapi.co/api/starships/").asJson();
                gson = new GsonBuilder()
                        .registerTypeAdapter(Starship.class, new Starship())
                        .registerTypeAdapter(Starships.class, Starships.instance())
                        .create();
               gson.fromJson(String.valueOf(jsonResponse.getBody()), Starships.class);
               }
                catch (UnirestException e) {
                    e.printStackTrace();
                }

           case FILMS:
               try {
                   jsonResponse = Unirest.get("https://swapi.co/api/films").asJson();
                   gson = new GsonBuilder()
                           .registerTypeAdapter(Film.class, new Film())
                           .registerTypeAdapter(Films.class, Films.instance())
                           .create();
                   gson.fromJson(String.valueOf(jsonResponse.getBody()), Films.class);
               }
               catch (UnirestException e) {
                   e.printStackTrace();
               }

            case VEHICLES:
                try {
                    jsonResponse = Unirest.get("https://swapi.co/api/vehicles").asJson();
                    gson = new GsonBuilder()
                            .registerTypeAdapter(Vehicle.class, new Vehicle())
                            .registerTypeAdapter(Vehicles.class, Vehicles.instance())
                            .create();
                    gson.fromJson(String.valueOf(jsonResponse.getBody()), Vehicles.class);
                }
                catch (UnirestException e) {
                    e.printStackTrace();
                }

            case SPECIES:
                try {
                    jsonResponse = Unirest.get("https://swapi.co/api/species/").asJson();
                    gson = new GsonBuilder()
                            .registerTypeAdapter(Specie.class, new Specie())
                            .registerTypeAdapter(Species.class, Species.instance())
                            .create();
                    gson.fromJson(String.valueOf(jsonResponse.getBody()), Species.class);
                }
                catch (UnirestException e) {
                    e.printStackTrace();
                }
        }


    }

    /**
     * сериализуем объект java в json;
     * @param entitis Список сущьностей Entitis
     */
    public String serialixedEntitis(Entitis entitis) {

        Gson gson;

        switch (entitis) {
            case PEOPLES:
                gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
                return gson.toJson(Peoples.instance().getAllPeoples());
            case PLANETS:
                gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
                return gson.toJson(Planets.instance().getAllPlants());
            case STARSHIPS:
                gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
                return gson.toJson(Starships.instance().getAllStarshops());
            case FILMS:
                gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
                return gson.toJson(Films.instance().getAllFilms());
            case VEHICLES:
                gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
                return gson.toJson(Vehicles.instance().getAllVehicles());
            case SPECIES:
                gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
                return gson.toJson(Species.instance().getAllSpecies());
            default:
                return "Неверные параметры запроса";
        }
    }


}



