package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebScrapper {
    /**
     * the method that run anything
     * @throws IOException when needed
     */
    public void run() throws IOException {
        String imdbid = "tt4154796";
        imdbid = reader();
        List<ArrayList<String>> list = scrap(imdbid);
        Writer writer = new Writer();
        writer.writeToFile(list);
    }

    /**
     * read from console
     * @return the imdbid
     */
    public String reader(){
        String imdbid = "tt4154796";
        System.out.println("please enter imdb id:");
        Scanner sc = new Scanner(System.in);
        imdbid = sc.nextLine();
        return imdbid;
    }

    /**
     * here we are scraping for the details on the movie in imdb
     * @param imdbid that we are looking for
     * @return struct with all the information
     * @throws IOException if happend
     */
    public List<ArrayList<String>> scrap(String imdbid) throws IOException {
        Document doc = Jsoup.connect("https://www.imdb.com/title/"+imdbid).get();
        List<ArrayList<String>> listOfDetails = new ArrayList<>();
        String title = doc.select("h1").first().text();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add(title);
        listOfDetails.add(list1);
        Elements el = doc.select("span.ipc-chip__text");
        ArrayList<String> genres = (ArrayList<String>) el.eachText();
        listOfDetails.add(genres);
        List<String> list = doc.select("li.ipc-inline-list__item").eachText();
        ArrayList<String> mpaa = new ArrayList<>();
        mpaa.add(list.get(1));
        listOfDetails.add(mpaa);
        ArrayList<String> duration = new ArrayList<>();
        duration.add(list.get(2));
        listOfDetails.add(duration);
        ArrayList<String> direct = (ArrayList<String>) doc.getElementsByClass("ipc-inline-list ipc-inline-list--show-dividers ipc-inline-list--inline ipc-metadata-list-item__list-content base").eachText();
        ArrayList<String> directors = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            directors.add(direct.get(i));
        }
        listOfDetails.add(directors);
        ArrayList<String> actors = (ArrayList<String>) doc.getElementsByClass("StyledComponents__ActorName-y9ygcu-1 eyqFnv").eachText();
        listOfDetails.add(actors);
        return listOfDetails;
    }
}
