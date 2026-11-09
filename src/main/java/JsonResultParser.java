import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;

public class JsonResultParser {

    public List<WikiArticle> parseResponse(String jsonResponse) throws Exception {
        List<WikiArticle> articlesList = new ArrayList<>();
        Gson gson = new Gson();

        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

        JsonObject queryObj = jsonObject.getAsJsonObject("query");

        if (queryObj == null) {
            return articlesList;
        }

        JsonArray searchArray = queryObj.getAsJsonArray("search");
        if (searchArray == null) {
            return articlesList;
        }

        for (JsonElement element : searchArray) {
            WikiArticle article = gson.fromJson(element, WikiArticle.class);
            articlesList.add(article);
        }

        return articlesList;
    }
}
