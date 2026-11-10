import java.util.List;
public class OutputService {
    public void showResults(List<WikiArticle> articles){
        if(articles==null||articles.isEmpty()){
            System.out.println("По вашему запросу ничего не найдено! Попробуйте другой ввести другой запрос!");
        }
        System.out.println("\n===РЕЗУЛЬТАТЫ ПОИСКА В ВИКИПЕДИИ===");
        int number=1;
        for (WikiArticle article : articles) {
            System.out.println(number + ". Название: " + article.GetTitle() + " (ID: " + article.getPageid() + ")");
            number++;
        }
        System.out.println("=====================================\n");
    }
}
