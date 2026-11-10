import java.util.List;
    public static void main(String[] args) {
        System.out.println("=== КОНСОЛЬНЫЙ ПОИСКОВИК ПО ВИКИПЕДИИ ===");

        InputService inputService = new InputService();
        WikipediaApiClient apiClient = new WikipediaApiClient();
        JsonResultParser resultParser = new JsonResultParser();
        OutputService outputService = new OutputService();
        BrowserService browserService = new BrowserService();

        while (true) {
            try {
                String query = inputService.readSearchQuery();

                System.out.println("Отправка запроса к серверам Википедии...");

                String jsonResponse = apiClient.sendSearchQuery(query);

                List<WikiArticle> articles = resultParser.parseResponse(jsonResponse);

                outputService.showResults(articles);

                if (articles.isEmpty()) {
                    System.out.println("=======================================");
                    continue;
                }

                int articleIndex = inputService.chooseArticleIndex(articles.size());

                if (articleIndex == 0) {
                    System.out.println("Выход из программы. До свидания!");
                    break;
                }

                WikiArticle selectedArticle = articles.get(articleIndex - 1);

                System.out.println("Открываем статью \"" + selectedArticle.GetTitle() + "\"...");
                browserService.openArticleByPageId(selectedArticle.getPageid());

            } catch (Exception e) {
                System.out.println("\n[ВНИМАНИЕ] Произошла сетевая или системная ошибка: " + e.getMessage());
                System.out.println("Пожалуйста, проверьте интернет-соединение и попробуйте снова.");
            }

            System.out.println("=======================================");
        }
    }

