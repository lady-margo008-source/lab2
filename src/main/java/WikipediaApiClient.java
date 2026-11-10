import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
public class WikipediaApiClient {
    private static final String BASE_URL = "https://wikipedia.org";
    public String sendSearchQuery(String rawQuery) throws Exception {
        // Кодируем запрос
        String encodedQuery = URLEncoder.encode(rawQuery, StandardCharsets.UTF_8);

        // Правильный URL с параметрами API
        String fullUrl = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=" + encodedQuery;

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
