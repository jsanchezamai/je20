package http;

import java.net.URI;

import com.google.gson.Gson;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import bots.Bot;

class pojo1
{
   String name;
   String age;
   //generate setter and getters
}

/**
 * This class shows how to send a POST Request with JSON using Java 11 HttpClient API. 
 * @author Deepak Verma
 */
public class WorldRestApi {


    void post() {
        // @Deprecated HttpClient httpClient = new DefaultHttpClient();
        HttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpPost request = new HttpPost("http://yoururl");
            Gson         gson          = new Gson();
            String parseed = gson.toJson(new Bot(null, "test", null));
            StringEntity params = new StringEntity("details={\"name\":\"xyz\",\"age\":\"20\"} ");
            request.addHeader("content-type", "application/x-www-form-urlencoded");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            System.out.println(response.getStatusLine());
            System.out.println(response.getEntity().getContent());
        } catch (Exception ex) {
        } finally {
            // @Deprecated httpClient.getConnectionManager().shutdown(); 
        };
    }

}

