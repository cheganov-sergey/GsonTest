import com.mashape.unirest.http.exceptions.UnirestException;
import static Entitys.Entitis.*;

public class MainClass {

    public static void main(String[] args) throws UnirestException {

       Utility.deserealizeEntites(VEHICLES);
        Utility.serialixedEntitis(VEHICLES);

    }
}
