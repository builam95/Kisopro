package Kisopro;

import java.io.IOException;



import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;


public class GetDescription {


    public static void main(String[] args) {


        Document doc;

        try {


            // need http protocol

            doc = Jsoup.connect("http://dendai.ac.jp").get();


            // get page title

            String title = doc.title();

            System.out.println("title : " + title);


            // get all links

            Elements links = doc.select("a[href]");
            Elements imports = doc.select("link[href]");
            for (Element link: links) {


                // get the value from href attribute

                System.out.println("\nlink : " + link.attr("href"));

                System.out.println("Description : " + link.text());


            }


        } catch (IOException e) {

            e.printStackTrace();

        }


    }

}