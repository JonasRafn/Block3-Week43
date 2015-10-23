package scraper;

import entity.Group;
import java.util.concurrent.Callable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebScraper implements Callable<Group> {

    private String url;

    public WebScraper(String url) {
        this.url = url;
    }

    @Override
    public Group call() throws Exception {
        try {
            Document doc = Jsoup.connect(url).get();

            String authors = doc.getElementById("authors").text();
            String schoolClass = doc.getElementById("class").text();
            String group = doc.getElementById("group").text();

            if (authors == null) {
                authors = "";
            }

            if (schoolClass == null) {
                schoolClass = "";
            }

            if (group == null) {
                group = "";
            }

            return new Group(authors, schoolClass, group);

        } catch (Exception ex) {
            System.out.println("An errror happened: " + ex);
        }

        return null;
    }
}
