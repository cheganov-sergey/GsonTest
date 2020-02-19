import Entitys.*;
import com.mashape.unirest.http.exceptions.UnirestException;

import static Entitys.Entitis.PLANETS;

public class MainClass {

    public static void main(String[] args) throws UnirestException {

        System.out.println(Utility.instance().getPeopleByName("Darth Vader"));
        System.out.println(Utility.instance().getPeopleById(2));
        System.out.println(Utility.instance().getAllPeople());
        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println(Utility.instance().getSpeciesByName("Mon Calamari"));
        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println(Utility.instance().getVehicleById(1));
        System.out.println(Utility.instance().getVehicleByName("Snowspeeder"));
        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println(Utility.instance().getStarshipsById(3));
        System.out.println("------------------------------------------------------------------------------------------");

        Utility.instance().deserealizeEntites(PLANETS);
        System.out.println("Планеты с диаметром более 10000: ");
        for (Planet planet : Planets.instance().getAllPlants()) {
            if (planet.getDiameter() > 10000)
                System.out.println(planet);
        }

    }


}
