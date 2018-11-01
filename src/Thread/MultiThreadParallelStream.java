package Thread;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadParallelStream {

    public static void main(String args[]) throws Exception {
        List<String> hostList = Arrays.asList(
                "http://crunchify.com",
                "http://yahoo.com",
                "http://www.ebay.com",
                "http://google.com",
                "http://www.example.co",
                "https://paypal.com",
                "http://bing.com/",
                "http://techcrunch.com/",
                "http://mashable.com/",
                "http://thenextweb.com/",
                "http://wordpress.com/",
                "http://wordpress.org/",
                "http://example.com/",
                "http://sjsu.edu/",
                "http://ebay.co.uk/",
                "http://google123.co.uk/",
                "http://wikipedia.org/",
                "http://en.wikipedia.org");

        hostList.parallelStream().forEach(it -> processConnection(it));


        System.out.println("\nFinished all threads");
    }

    public static void processConnection(String url){
        String result;
        String threadName = Thread.currentThread().getName();
        int code;
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            connection.connect();

            code = connection.getResponseCode();
            if (code == 200) {
                result = "-> Green <-\t" + "Code: " + code;
            } else {
                result = "-> Yellow <-\t" + "Code: " + code;
            }
        } catch (Exception e) {
            result = "-> Red <-\t" + "Wrong domain - Exception: " + e.getMessage();

        }
        System.out.println(url + "\t\tStatus:" + result + "\t\t" + threadName);
    }
}

