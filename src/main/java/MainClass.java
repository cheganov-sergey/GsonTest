import Entitys.*;
import com.mashape.unirest.http.exceptions.UnirestException;

import static Entitys.Entitis.PLANETS;

public class MainClass {

    public static void main(String[] args) throws UnirestException {

        System.out.println(Utility.getUtility().getPeopleByName("Darth Vader"));
        System.out.println(Utility.getUtility().getPeopleById(2));
        System.out.println(Utility.getUtility().getAllPeople());
        System.out.println();

        System.out.println(Utility.getUtility().getSpeciesByName("Mon Calamari"));
        System.out.println();

        System.out.println(Utility.getUtility().getVehicleById(1));
        System.out.println(Utility.getUtility().getVehicleByName("Snowspeeder"));
        System.out.println();

        System.out.println(Utility.getUtility().getStarshipsById(3));

        Utility.getUtility().deserealizeEntites(PLANETS);
        System.out.println("Планеты с диаметром более 10000: ");
        for (Planet planet : Planets.getPlanets().getAllPlants()) {
            if (planet.getDiameter() > 10000)
                System.out.println(planet);
        }

    }


}
