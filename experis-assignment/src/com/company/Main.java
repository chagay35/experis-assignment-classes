package com.company;

import java.io.IOException;

public class Main {

    /**
     * main methd that start everything
     * @param args not used
     * @throws IOException when needed
     */
    public static void main(String[] args) throws IOException {
        WebScrapper webScrapper = new WebScrapper();
        webScrapper.run();
    }
}
