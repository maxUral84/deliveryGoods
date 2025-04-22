import java.util.Scanner;

public class Utils {

    public static String readString(Scanner scanner, String text) {
        String value;

        while (true) {
            System.out.print("\n" + text);
            value = scanner.nextLine().toLowerCase().trim();

            if (value.isEmpty()) {
                System.out.println("Ошибка: поле не может быть пустым.");
                continue;
            }

            try {
                Integer.parseInt(value);
                System.out.println("Ошибка: введено числовое значение. Введите текст.");
            } catch (NumberFormatException e) {
                return value;
            }
        }
    }

    public static int readInt(Scanner scanner, String text){
        int value = -1;
        boolean isValid = false;

        while(isValid == false){
            System.out.print("\n" + text);
            String userInput = scanner.nextLine();

            if (userInput == null || userInput.trim().isEmpty()) {
                System.out.println("Ошибка ввода. Попробуйте снова.");
                continue;
            }

            try {
                value = Integer.parseInt(userInput.trim());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не число. Попробуйте снова.");
            }
        }

        return value;
    }
}
