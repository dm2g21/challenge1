package com.dylanmurphy;

//used Jsoup library
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
        //get the title of the webpage
        Document doc = Jsoup.connect("https://www.ecs.soton.ac.uk/people/" + userInput).get();
        String name = doc.title();
        //parse the name from the title of the webpage, get the part before " |"
        name = name.split(" \\|")[0];
        //output name
        System.out.println(name);
    }
}
