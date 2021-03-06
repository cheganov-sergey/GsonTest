package Entitys;
import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Films implements JsonDeserializer<Films>{

        private static Films instance;  // единственный экземпляр класса
        private List<Film> results;

        private Films() {
            this.results = new ArrayList<Film>();
        }

    /**
     * Silgleton
     * @return единственный экземпяр класса
     */
        public static Films instance() {
            if (instance == null) {
                instance = new Films();
            }
            return instance;
        }

        public List<Film> getAllFilms() {
            return results;
        }

    /**
     * Добавляем фильм в список (дубликаты игнорируются)
     * @param film фильм
     */
    public void addFilms(Film film) {
            boolean repeat = false;
            for (Film arr : results) {
                if (arr.getTitle().equals(film.getTitle()))
                    repeat = true;
            }
            if (!repeat)
            this.results.add(film);
        }

        /**
         * Десериализатор класса
         * @param jsonElement  - десериализируемый объект
         * @param type  - объект к которому приводим
         * @param context  - контекст
         * @return объект Film
         * @throws JsonParseException
         */
        public Films deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
            Films films = Films.instance();
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonArray results = jsonObject.getAsJsonArray("results");

            for (JsonElement element : results) {
                Film film = context.deserialize(element, Film.class);
                films.addFilms(film);
            }
            return films;
        }

        @Override
        public String toString() {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            return gson.toJson(this);
        }

    
}
