import Entitys.*;
import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

/**
 * Класс преобразования из Json в Java объекьы и обратно
 */
public class Utility {

    private static Utility instance;

    private Utility() {}

    public static Utility getUtility() {
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
                            .registerTypeAdapter(Planets.class, Planets.getPlanets())
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
                            .registerTypeAdapter(Peoples.class, Peoples.getPeoples())
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
                        .registerTypeAdapter(Starships.class, Starships.getStarships())
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
                           .registerTypeAdapter(Films.class, Films.getFilms())
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
                            .registerTypeAdapter(Vehicles.class, Vehicles.getVegicles())
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
                            .registerTypeAdapter(Species.class, Species.getSpecies())
                            .create();
                    gson.fromJson(String.valueOf(jsonResponse.getBody()), Species.class);
                }
                catch (UnirestException e) {
                    e.printStackTrace();
                }
        }


    }

    /**
     * сериализуем объект java в json (путем переопределения метода toString)
     * @param entitis
     */
    public void serialixedEntitis(Entitis entitis) {
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

    /**
     * Далее идет реализация методов для каждого класса:
     * getByName - найти по имени
     * getById - найти по id
     * getAll - показать все
     */

    ////////////////// Персоонажи /////////////////////
    /**
     *  поиск по имени. Сперва проверяем существует ли список объктов, если нет то десериализуем кго из json.
     * @param name искомое имя
     * @return объект с указаным именим
     */
    public People getPeopleByName(String name) {
        if (Peoples.getPeoples().getAllPeoples().isEmpty()) {
            deserealizeEntites(Entitis.PEOPLES);
        }
        People people = new People();
        for (People all : Peoples.getPeoples().getAllPeoples()) {
            if (all.getName().equals(name))
                people = all;
        }
        return people;
    }

    /**
     * Поиск по id. Сперва проверяем существует ли список объктов, если нет то десериализуем кго из json.
     * @param i - номер id
     * @return объект
     */
    public People getPeopleById(int i) {
        if (Peoples.getPeoples().getAllPeoples().isEmpty()) {
            deserealizeEntites(Entitis.PEOPLES);
        }
        if (Peoples.getPeoples().getAllPeoples().size() > i) {
            return Peoples.getPeoples().getAllPeoples().get(i);
        }
        return null;
    }

    /**
     * возвращаем все объекты списка. Сперва проверяем существует ли список объктов, если нет то десериализуем кго из json.
     * @return - массив объектов
     */
    public List<People> getAllPeople() {
        if (Peoples.getPeoples().getAllPeoples().isEmpty()) {
            deserealizeEntites(Entitis.PEOPLES);
        }
        return Peoples.getPeoples().getAllPeoples();
    }

    ///////////////////// Планиеты ////////////////////////

    public Planet getPlanetByName(String name) {
        if (Planets.getPlanets().getAllPlants().isEmpty()) {
            deserealizeEntites(Entitis.PLANETS);
        }
        Planet planet = new Planet();
        for (Planet all : Planets.getPlanets().getAllPlants()) {
            if (all.getName().equals(name))
                planet = all;
        }
        return planet;
    }

    public Planet getPlanetById(int i) {
        if (Planets.getPlanets().getAllPlants().isEmpty()) {
            deserealizeEntites(Entitis.PLANETS);
        }
        if (Planets.getPlanets().getAllPlants().size() > i) {
            return Planets.getPlanets().getAllPlants().get(i);
        }
        return null;
    }

    public List<Planet> getAllPlanet() {
        if (Planets.getPlanets().getAllPlants().isEmpty()) {
            deserealizeEntites(Entitis.PLANETS);
        }
        return Planets.getPlanets().getAllPlants();
    }

    ///////////////// Фильмы ////////////////////////

    public Film getFilmByName(String name) {
        if (Films.getFilms().getAllFilms().isEmpty()) {
            deserealizeEntites(Entitis.FILMS);
        }
        Film it = new Film();
        for (Film all : Films.getFilms().getAllFilms()) {
            if (all.getTitle().equals(name))
                it = all;
        }
        return it;
    }

    public Film getFilmById(int i) {
        if (Films.getFilms().getAllFilms().isEmpty()) {
            deserealizeEntites(Entitis.FILMS);
        }
        if (Films.getFilms().getAllFilms().size() > i) {
            return Films.getFilms().getAllFilms().get(i);
        }
        return null;
    }

    public List<Film> getAllFilms() {
        if (Films.getFilms().getAllFilms().isEmpty()) {
            deserealizeEntites(Entitis.FILMS);
        }
        return Films.getFilms().getAllFilms();
    }

    ////////////////////// Species /////////////////////

    public Specie getSpeciesByName(String name) {
        if (Species.getSpecies().getAllSpecies().isEmpty()) {
            deserealizeEntites(Entitis.SPECIES);
        }
        Specie it = new Specie();
        for (Specie all : Species.getSpecies().getAllSpecies()) {
            if (all.getName().equals(name))
                it = all;
        }
        return it;
    }

    public Specie getSpeciesById(int i) {
        if (Species.getSpecies().getAllSpecies().isEmpty()) {
            deserealizeEntites(Entitis.SPECIES);
        }
        if (Species.getSpecies().getAllSpecies().size() > i) {
            return Species.getSpecies().getAllSpecies().get(i);
        }
        return null;
    }

    public List<Specie> getAllSpecies() {
        if (Species.getSpecies().getAllSpecies().isEmpty()) {
            deserealizeEntites(Entitis.SPECIES);
        }
        return Species.getSpecies().getAllSpecies();
    }

    //////////////////// Starships /////////////////////////

    public Starship getStarshipByName(String name) {
        if (Starships.getStarships().getAllStarshops().isEmpty()) {
            deserealizeEntites(Entitis.STARSHIPS);
        }
        Starship it = new Starship();
        for (Starship all : Starships.getStarships().getAllStarshops()) {
            if (all.getName().equals(name))
                it = all;
        }
        return it;
    }

    public Starship getStarshipsById(int i) {
        if (Starships.getStarships().getAllStarshops().isEmpty()) {
            deserealizeEntites(Entitis.STARSHIPS);
        }
        if (Starships.getStarships().getAllStarshops().size() > i) {
            return Starships.getStarships().getAllStarshops().get(i);
        }
        return null;
    }

    public List<Starship> getAllStarship() {
        if (Starships.getStarships().getAllStarshops().isEmpty()) {
            deserealizeEntites(Entitis.STARSHIPS);
        }
        return Starships.getStarships().getAllStarshops();
    }

    /////////////////////// Vehicles //////////////////////////////

    public Vehicle getVehicleByName(String name) {
        if (Vehicles.getVegicles().getAllVehicles().isEmpty()) {
            deserealizeEntites(Entitis.VEHICLES);
        }
        Vehicle it = new Vehicle();
        for (Vehicle all : Vehicles.getVegicles().getAllVehicles()) {
            if (all.getName().equals(name))
                it = all;
        }
        return it;
    }

    public Vehicle getVehicleById(int i) {
        if (Vehicles.getVegicles().getAllVehicles().isEmpty()) {
            deserealizeEntites(Entitis.VEHICLES);
        }
        if (Vehicles.getVegicles().getAllVehicles().size() > i) {
            return Vehicles.getVegicles().getAllVehicles().get(i);
        }
        else
            return null;
    }

    public List<Vehicle> getAllVehicles() {
        if (Vehicles.getVegicles().getAllVehicles().isEmpty()) {
            deserealizeEntites(Entitis.VEHICLES);
        }
        return Vehicles.getVegicles().getAllVehicles();
    }

}



