import Entitys.*;

import java.util.List;

/**
 * В классе содержится реализация методов запроса информации для каждого класса:
 * getByName - найти по имени
 * getById - найти по id
 * getAll - показать все
 */

public class Client {

    private static Client instance;

    private Client() {}

    public static Client instance() {
        if (instance == null)
            instance = new Client();
        return instance;
    }

    ////////////////// Персоонажи /////////////////////
    /**
     *  поиск по имени. Сперва проверяем существует ли список объктов, если нет то десериализуем кго из json.
     * @param name искомое имя
     * @return объект с указаным именим
     */
    public People getPeopleByName(String name) {
        if (Peoples.instance().getAllPeoples().isEmpty()) {
            Utility.instance().deserealizeEntites(Entitis.PEOPLES);
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
            Utility.instance().deserealizeEntites(Entitis.PEOPLES);
        }
        if (Peoples.instance().getAllPeoples().size() > id) {
            return Peoples.instance().getAllPeoples().get(id - 1);
        }
        return new People("Данный человек не найден");
    }

    /**
     * возвращаем все объекты списка. Сперва проверяем существует ли список объктов, если нет то десериализуем кго из json.
     * @return - массив объектов
     */
    public List<People> getAllPeople() {
        if (Peoples.instance().getAllPeoples().isEmpty()) {
            Utility.instance().deserealizeEntites(Entitis.PEOPLES);
        }
        return Peoples.instance().getAllPeoples();
    }

    ///////////////////// Планиеты ////////////////////////

    public Planet getPlanetByName(String name) {
        if (Planets.instance().getAllPlants().isEmpty()) {
            Utility.instance().deserealizeEntites(Entitis.PLANETS);
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
            Utility.instance().deserealizeEntites(Entitis.PLANETS);
        }
        if (Planets.instance().getAllPlants().size() > id) {
            return Planets.instance().getAllPlants().get(id - 1);
        }
        return new Planet("Данная планета не найдена");
    }

    public List<Planet> getAllPlanet() {
        if (Planets.instance().getAllPlants().isEmpty()) {
            Utility.instance().deserealizeEntites(Entitis.PLANETS);
        }
        return Planets.instance().getAllPlants();
    }

    ///////////////// Фильмы ////////////////////////

    public Film getFilmByName(String name) {
        if (Films.instance().getAllFilms().isEmpty()) {
            Utility.instance().deserealizeEntites(Entitis.FILMS);
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
            Utility.instance().deserealizeEntites(Entitis.FILMS);
        }
        if (Films.instance().getAllFilms().size() > id) {
            return Films.instance().getAllFilms().get(id - 1);
        }
        return new Film("Данный фильм не найден");
    }

    public List<Film> getAllFilms() {
        if (Films.instance().getAllFilms().isEmpty()) {
            Utility.instance().deserealizeEntites(Entitis.FILMS);
        }
        return Films.instance().getAllFilms();
    }

    ////////////////////// Species /////////////////////

    public Specie getSpeciesByName(String name) {
        if (Species.instance().getAllSpecies().isEmpty()) {
            Utility.instance().deserealizeEntites(Entitis.SPECIES);
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
            Utility.instance().deserealizeEntites(Entitis.SPECIES);
        }
        if (Species.instance().getAllSpecies().size() > id) {
            return Species.instance().getAllSpecies().get(id - 1);
        }
        return new Specie("Данное существо не найдено");
    }

    public List<Specie> getAllSpecies() {
        if (Species.instance().getAllSpecies().isEmpty()) {
            Utility.instance().deserealizeEntites(Entitis.SPECIES);
        }
        return Species.instance().getAllSpecies();
    }

    //////////////////// Starships /////////////////////////

    public Starship getStarshipByName(String name) {
        if (Starships.instance().getAllStarshops().isEmpty()) {
            Utility.instance().deserealizeEntites(Entitis.STARSHIPS);
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
            Utility.instance().deserealizeEntites(Entitis.STARSHIPS);
        }
        if (Starships.instance().getAllStarshops().size() > id) {
            return Starships.instance().getAllStarshops().get(id - 1);
        }
        return new Starship("Данный космический корабль не найдне");
    }

    public List<Starship> getAllStarship() {
        if (Starships.instance().getAllStarshops().isEmpty()) {
            Utility.instance().deserealizeEntites(Entitis.STARSHIPS);
        }
        return Starships.instance().getAllStarshops();
    }

    /////////////////////// Vehicles //////////////////////////////

    public Vehicle getVehicleByName(String name) {
        if (Vehicles.instance().getAllVehicles().isEmpty()) {
            Utility.instance().deserealizeEntites(Entitis.VEHICLES);
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
            Utility.instance().deserealizeEntites(Entitis.VEHICLES);
        }
        if (Vehicles.instance().getAllVehicles().size() > id) {
            return Vehicles.instance().getAllVehicles().get(id - 1);
        }
        else
            return new Vehicle("Данное транспортное средство не найдено");
    }

    public List<Vehicle> getAllVehicles() {
        if (Vehicles.instance().getAllVehicles().isEmpty()) {
            Utility.instance().deserealizeEntites(Entitis.VEHICLES);
        }
        return Vehicles.instance().getAllVehicles();
    }
    
}
