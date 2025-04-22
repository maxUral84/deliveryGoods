import java.util.*;

public class Main {
    private static final String COMMAND_EXT_TEXT = "end";
    private static final int COMMAND_ADD_ORDER = 1;
    private static final int COMMAND_EXIT_PROGRAM = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Address, Integer> costPerAddress = new HashMap<>();
        Set<String> uniqueCountries = new HashSet<>();
        String country;
        String city;
        int totalCost = 0;
        int weight;
        boolean shouldRun = true;

        costPerAddress.put(new Address("Россия".toLowerCase(), "Москва"), 100);
        costPerAddress.put(new Address("Россия", "Казань"), 200);
        costPerAddress.put(new Address("США", "Нью-Йорк"), 300);
        costPerAddress.put(new Address("Германия", "Берлин"), 400);

        System.out.println("Доставки товаров по миру.");

        while (shouldRun) {
            printMenu();

            int choice = Utils.readInt(scanner, "Выберите операцию: ");

            switch (choice) {
                case COMMAND_ADD_ORDER:
                    System.out.println("\nЗаполнение нового заказа.");

                    country = Utils.readString(scanner, "\nВведите страну: ");

                    city = Utils.readString(scanner, "Введите город: ");

                    weight = Utils.readInt(scanner, "Введите вес (кг): ");

                    Address address = new Address(country, city);

                    if (costPerAddress.containsKey(address)) {
                        int cost = costPerAddress.get(address) * weight;
                        totalCost += cost;

                        uniqueCountries.add(country.toLowerCase());

                        System.out.println("\nСтоимость доставки составит: " + cost + " руб.");

                        System.out.println("\nОбщая стоимость всех доставок: " + totalCost + " руб.");

                        System.out.println("Количество уникальных стран с доставкой: " + uniqueCountries.size());
                    } else {
                        System.out.println("\nДоставки по этому адресу нет");
                    }
                    break;

                case COMMAND_EXIT_PROGRAM:
                    shouldRun = false;
                    break;

                default:
                    System.out.println("Нет такой команды!");
            }
        }

        System.out.println("\nСпасибо за использование сервиса!");
    }

    public static void printMenu() {
        System.out.println("\nСписок операций:");
        System.out.println(COMMAND_ADD_ORDER + " Добавить заказ");
        System.out.println(COMMAND_EXIT_PROGRAM + " Выйти из программы");
    }
}
