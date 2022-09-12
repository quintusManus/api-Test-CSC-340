package com.mycompany.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("http://worldtimeapi.org/api/timezone/America/Argentina/Salta");

        StringBuilder informationString = new StringBuilder();
        try ( Scanner scanner = new Scanner(url.openStream())) {
            while (scanner.hasNext()) {
                informationString.append(scanner.nextLine());
            }
            //Close the scanner
        }

        System.out.println("Returned Information: " + informationString);

        String string = informationString.toString();

        JsonObject obj = new Gson().fromJson(string, JsonObject.class);

        System.out.println("\nThe day of the year for Salta Argentina is "
                + obj.get("day_of_year").toString());

    }
}
