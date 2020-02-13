package Entitys;

import java.util.ArrayList;

/**
 * Фильмы
 */
public class Film {

    private String title;
    private int episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    private ArrayList<People> characters;
    private ArrayList<Planet> planets;
    private ArrayList<Vehicles> vehicles;
    private ArrayList<Species> species;
    private String created;
    private String edited;
    private String url;

    public Film(String url) {
        this.url = url;
    }
}
