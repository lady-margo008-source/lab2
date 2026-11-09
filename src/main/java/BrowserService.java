import java.awt.Desktop;
import java.net.URI;
public class BrowserService {
    private static final String ARTICLE_URL = "https://wikipedia.org";
    public void openArticleByPageId(int pageId) throws Exception {
        String fullUrl = ARTICLE_URL + pageId;
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI(fullUrl));
            System.out.println("Ссылка успешно передана в браузер.");
        } else {
            throw new RuntimeException("Открытие браузера не поддерживается.");
        }
    }
}

