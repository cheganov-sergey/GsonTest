import Entitys.People;
import Entitys.Peoples;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class MainClass {

    public static void main(String[] args) throws UnirestException {

        HttpResponse<JsonNode> jsonResponse = Unirest.get("https://swapi.co/api/people/").asJson();
        System.out.println(jsonResponse.getBody());

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(People.class, new People())
                .registerTypeAdapter(Peoples.class, new Peoples())
                .create();

        Peoples peoples = gson.fromJson(String.valueOf(jsonResponse.getBody()), Peoples.class);
        System.out.println(peoples);

    }
}
