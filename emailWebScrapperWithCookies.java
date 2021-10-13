package com.dylanmurphy;

//used Jsoup library
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
            //get email from user
            System.out.print("Enter email address: ");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            String userInput = reader.readLine();
            //parse id from the email (takes what is before the @)
            userInput = userInput.split("@")[0];
            //create url that is going to be used to search
            String ecsUrl = "http://secure.ecs.soton.ac.uk/people/" + userInput;
            //get webpage, added in cookies to trick secure.ecs.soton.ac.uk
            Document ecsDoc = Jsoup.connect(ecsUrl)
                    .cookie(INSERT_NAME, INSERT_VALUE)
                    .get();
            //get title of webpage
            String name = ecsDoc.title();
            //extract name from title of webpage
            name = name.split("ECS - ")[1];
            System.out.println(name);
    }
}
