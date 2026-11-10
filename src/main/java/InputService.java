import java.util.Scanner;
public class InputService {
    private final Scanner scanner = new Scanner(System.in);
    public String readSearchQuery(){
        System.out.print("Введите запрос для Википедии:");
        String input = scanner.nextLine();

        if (input==null||input.trim().isEmpty()){
            System.out.print("Запрос не может быть пустым! Повторите ввод!");
            return readSearchQuery();
        }
        return input.trim();
    }

    public int chooseArticleIndex(int maxCount){
        while (true){
            System.out.print("\nВведите номер нужной статьи для открытия в браузере (0 для выхода):");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 0 && choice <= maxCount) {
                    return choice;
                }
                System.out.print("Некорректный выбор! Выберите число от 1 до " + maxCount + " или 0");
            } catch (NumberFormatException e){
                System.out.print("\nПожалуйста, введите корректное число!");}
            }
        }
    }
