import Entitys.*;

import static Entitys.Entitis.PLANETS;

public class MainClass {

    public static void main(String[] args) {

        System.out.println(Client.instance().getPeopleByName("Darth Vader"));
        System.out.println(Client.instance().getPeopleById(1));
        System.out.println(Client.instance().getPeopleById(8));
        System.out.println(Client.instance().getPeopleById(10));
        System.out.println(Client.instance().getPeopleById(1546));
        //System.out.println(Client.instance().getAllPeople());
        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println(Client.instance().getSpeciesByName("Mon Calamari"));
        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println(Client.instance().getVehicleById(1));
        System.out.println(Client.instance().getVehicleByName("Snowspeeder"));
        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println(Client.instance().getStarshipsById(3));
        System.out.println("------------------------------------------------------------------------------------------");

        Utility.instance().deserealizeEntites(PLANETS);              //десериализуем планеты из Json

        System.out.println("Планеты с диаметром более 10000: ");       // ищем планеты с радиусом более 10000 попугаев
        for (Planet planet : Planets.instance().getAllPlants()) {
            if (planet.getDiameter() > 12000)
                System.out.println(planet);
        }

        System.out.println(Utility.instance().serialixedEntitis(PLANETS)); //сериализуем планеты Json

    }


}
