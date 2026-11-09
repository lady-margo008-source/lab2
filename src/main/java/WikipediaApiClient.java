import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
public class WikipediaApiClient {
    private static final String BASE_URL = "https://wikipedia.org";
    public String sendSearchQuery(String rawQuery) throws Exception {
        String encodedQuery = URLEncoder.encode(rawQuery, StandardCharsets.UTF_8);
        String fullUrl = BASE_URL + "\"" + encodedQuery + "\"";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullUrl))
                .header("User-Agent", "LETIWikiSearchJava/1.0")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
