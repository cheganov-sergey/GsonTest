
import Entitys.People;
import Entitys.Peoples;
import Entitys.Planet;
import Entitys.Planets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import static Entitys.Planets.getPlanets;

public class MainClass {

    public static void main(String[] args) throws UnirestException {

        HttpResponse<JsonNode> jsonResponse = Unirest.get("https://swapi.co/api/people/").asJson();
        System.out.println(jsonResponse.getBody());

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(People.class, new People())
                .registerTypeAdapter(Peoples.class, Peoples.getPeoples())
                .create();

        Peoples peoples = gson.fromJson(String.valueOf(jsonResponse.getBody()), Peoples.class);
        System.out.println(peoples);


//        HttpResponse<JsonNode> jsonRespPlanet = Unirest.get("https://swapi.co/api/planets/").asJson();
//        System.out.println(jsonRespPlanet.getBody());
//
//        Gson gson2 = new GsonBuilder()
//                 .registerTypeAdapter(Planet.class, new Planet())
//                .registerTypeAdapter(Planets.class, Planets.getPlanets())
//                .create();
//
//        Planets planet = gson2.fromJson(String.valueOf(jsonRespPlanet.getBody()), Planets.class);
//        System.out.println(planet);
    }
}
