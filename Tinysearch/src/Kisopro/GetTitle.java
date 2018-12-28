package Kisopro;

	import java.io.IOException;
	import java.util.List;
	import java.util.ArrayList;

	import org.jsoup.Jsoup;
	import org.jsoup.nodes.Document;
	import org.jsoup.nodes.Element;
	import org.jsoup.select.Elements;

	public class GetTitle {
	 private GetTitle() {}

	public static List<String>extractLinks(String url) throws IOException {
	final ArrayList<String> result = new ArrayList<String>();

	Document doc = Jsoup.connect("https://www.dendai.ac.jp/").get();

	Elements links = doc.select("a[href]");
	Elements imports = doc.select("link[href]");


	for (Element link : links) {
	  result.add(link.attr("abs:href"));
	}



	// js, css, ...
	for (Element link : imports) {
	  result.add(link.attr("abs:href"));
	}
	return result;
	}


	public final static void main(String[] args) throws Exception{
	String site = "https://www.dendai.ac.jp/";
	List<String> links = GetTitle.extractLinks(site);
	for (String link : links) {
	  System.out.println(link);
	}
	 }
	}

//https://www.dendai.ac.jp/common/css/style_sp.css
