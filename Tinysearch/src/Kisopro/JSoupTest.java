package Kisopro;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JSoupTest {


public static void main(String args[]) {

    try {


        Document doc=Jsoup.connect("http://dendai.ac.jp").get();

        // get page title
        String title = doc.title();
        System.out.println(title);

        //gets all links
        Elements links = doc.select("a[href]");
        for (Element link : links) {

        // get the value from href attribute
        System.out.println("\nlink : " + link.attr("href"));

        }

        for( Element element : doc.select("li") )    
                    // Select all 'p'-Tags and loop over them
        {
            if( element.hasText() )                 
                    // Check if the element has text (since there are some empty too)
            {
              System.out.println(element.text()); // print the element's text
            }
        }


    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}