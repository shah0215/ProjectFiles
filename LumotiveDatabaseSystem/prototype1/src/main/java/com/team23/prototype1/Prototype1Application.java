package com.team23.prototype1;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Prototype1Application {

    /**
     * 
     * Main method launches the spring boot application
     */
    public static void main(String[] args) {
        load();
        SpringApplication.run(Prototype1Application.class, args);

    }

    /**
     * This method opens the default browser and launches the application
     */
    public static void load() {
        String url = "http://localhost:8080/loginToDb";
        try {
            Desktop.getDesktop().browse(new URL(url).toURI());
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
