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
     * сериализуем объект java в json (путем переопределения метода toString)
     * @param entitis
     */
    public void serialixedEntitis(Entitis entitis) {
        switch (entitis) {
            case PEOPLES:
                System.out.println(Peoples.instance());
            case PLANETS:
                System.out.println(Planets.instance());
            case STARSHIPS:
                System.out.println(Starships.instance());
            case FILMS:
                System.out.println(Films.instance());
            case VEHICLES:
                System.out.println(Vehicles.instance());
            case SPECIES:
                System.out.println(Species.instance());
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
        if (Peoples.instance().getAllPeoples().isEmpty()) {
            deserealizeEntites(Entitis.PEOPLES);
        }
        People people = new People();
        for (People all : Peoples.instance().getAllPeoples()) {
            if (all.getName().equals(name))
                people = all;
        }
        return people;
    }

    /**
     * Поиск по id. Сперва проверяем существует ли список объктов, если нет то десериализуем кго из json.
     * @param id - номер id
     * @return объект
     */
    public People getPeopleById(int id) {
        if (Peoples.instance().getAllPeoples().isEmpty()) {
            deserealizeEntites(Entitis.PEOPLES);
        }
        if (Peoples.instance().getAllPeoples().size() > id) {
            return Peoples.instance().getAllPeoples().get(id + 1);
        }
        return null;
    }

    /**
     * возвращаем все объекты списка. Сперва проверяем существует ли список объктов, если нет то десериализуем кго из json.
     * @return - массив объектов
     */
    public List<People> getAllPeople() {
        if (Peoples.instance().getAllPeoples().isEmpty()) {
            deserealizeEntites(Entitis.PEOPLES);
        }
        return Peoples.instance().getAllPeoples();
    }

    ///////////////////// Планиеты ////////////////////////

    public Planet getPlanetByName(String name) {
        if (Planets.instance().getAllPlants().isEmpty()) {
            deserealizeEntites(Entitis.PLANETS);
        }
        Planet planet = new Planet();
        for (Planet all : Planets.instance().getAllPlants()) {
            if (all.getName().equals(name))
                planet = all;
        }
        return planet;
    }

    public Planet getPlanetById(int id) {
        if (Planets.instance().getAllPlants().isEmpty()) {
            deserealizeEntites(Entitis.PLANETS);
        }
        if (Planets.instance().getAllPlants().size() > id) {
            return Planets.instance().getAllPlants().get(id + 1);
        }
        return new Planet("Данная планета не найдена");
    }

    public List<Planet> getAllPlanet() {
        if (Planets.instance().getAllPlants().isEmpty()) {
            deserealizeEntites(Entitis.PLANETS);
        }
        return Planets.instance().getAllPlants();
    }

    ///////////////// Фильмы ////////////////////////

    public Film getFilmByName(String name) {
        if (Films.instance().getAllFilms().isEmpty()) {
            deserealizeEntites(Entitis.FILMS);
        }
        Film it = new Film();
        for (Film all : Films.instance().getAllFilms()) {
            if (all.getTitle().equals(name))
                it = all;
        }
        return it;
    }

    public Film getFilmById(int id) {
        if (Films.instance().getAllFilms().isEmpty()) {
            deserealizeEntites(Entitis.FILMS);
        }
        if (Films.instance().getAllFilms().size() > id) {
            return Films.instance().getAllFilms().get(id + 1);
        }
        return new Film("Данный фильм не найден");
    }

    public List<Film> getAllFilms() {
        if (Films.instance().getAllFilms().isEmpty()) {
            deserealizeEntites(Entitis.FILMS);
        }
        return Films.instance().getAllFilms();
    }

    ////////////////////// Species /////////////////////

    public Specie getSpeciesByName(String name) {
        if (Species.instance().getAllSpecies().isEmpty()) {
            deserealizeEntites(Entitis.SPECIES);
        }
        Specie it = new Specie();
        for (Specie all : Species.instance().getAllSpecies()) {
            if (all.getName().equals(name))
                it = all;
        }
        return it;
    }

    public Specie getSpeciesById(int id) {
        if (Species.instance().getAllSpecies().isEmpty()) {
            deserealizeEntites(Entitis.SPECIES);
        }
        if (Species.instance().getAllSpecies().size() > id) {
            return Species.instance().getAllSpecies().get(id + 1);
        }
        return new Specie("Данное существо не найдено");
    }

    public List<Specie> getAllSpecies() {
        if (Species.instance().getAllSpecies().isEmpty()) {
            deserealizeEntites(Entitis.SPECIES);
        }
        return Species.instance().getAllSpecies();
    }

    //////////////////// Starships /////////////////////////

    public Starship getStarshipByName(String name) {
        if (Starships.instance().getAllStarshops().isEmpty()) {
            deserealizeEntites(Entitis.STARSHIPS);
        }
        Starship it = new Starship();
        for (Starship all : Starships.instance().getAllStarshops()) {
            if (all.getName().equals(name))
                it = all;
        }
        return it;
    }

    public Starship getStarshipsById(int id) {
        if (Starships.instance().getAllStarshops().isEmpty()) {
            deserealizeEntites(Entitis.STARSHIPS);
        }
        if (Starships.instance().getAllStarshops().size() > id) {
            return Starships.instance().getAllStarshops().get(id + 1);
        }
        return new Starship("Данный космический корабль не найдне");
    }

    public List<Starship> getAllStarship() {
        if (Starships.instance().getAllStarshops().isEmpty()) {
            deserealizeEntites(Entitis.STARSHIPS);
        }
        return Starships.instance().getAllStarshops();
    }

    /////////////////////// Vehicles //////////////////////////////

    public Vehicle getVehicleByName(String name) {
        if (Vehicles.instance().getAllVehicles().isEmpty()) {
            deserealizeEntites(Entitis.VEHICLES);
        }
        Vehicle it = new Vehicle();
        for (Vehicle all : Vehicles.instance().getAllVehicles()) {
            if (all.getName().equals(name))
                it = all;
        }
        return it;
    }

    public Vehicle getVehicleById(int id) {
        if (Vehicles.instance().getAllVehicles().isEmpty()) {
            deserealizeEntites(Entitis.VEHICLES);
        }
        if (Vehicles.instance().getAllVehicles().size() > id) {
            return Vehicles.instance().getAllVehicles().get(id + 1);
        }
        else
            return new Vehicle("Данное транспортное средство не найдено");
    }

    public List<Vehicle> getAllVehicles() {
        if (Vehicles.instance().getAllVehicles().isEmpty()) {
            deserealizeEntites(Entitis.VEHICLES);
        }
        return Vehicles.instance().getAllVehicles();
    }

}



