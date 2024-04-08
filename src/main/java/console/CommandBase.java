package console;


import personClasses.Coordinates;
import personClasses.Location;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class CommandBase {
    Scanner scanner = new Scanner(System.in);
    public abstract void execute(String str);

    // Метод для ввода строки с проверкой на null и пустоту
    protected String inputStringWithValidation(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Строка не может быть пустой. Повторите ввод.");
            }
        } while (input.isEmpty());
        return input;
    }

    // Метод для ввода целого числа с проверкой на диапазон и null
    protected Integer inputIntegerWithValidation(Scanner scanner, String prompt, int min, int max) {
        Integer value = null;
        do {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Значение не может быть пустым. Повторите ввод.");
                continue;
            }
            try {
                value = Integer.parseInt(input);
                if (value < min || value > max) {
                    System.out.printf("Значение должно быть от %d до %d. Повторите ввод.\n", min, max);
                    value = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат числа. Повторите ввод.");
            }
        } while (value == null);
        return value;
    }

    // Метод для ввода и проверки значения типа Long (для длинных чисел)
    protected Long inputLongWithValidation(Scanner scanner, String prompt, long min, long max) {
        Long value = null;
        do {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Значение не может быть пустым. Повторите ввод.");
                continue;
            }
            try {
                value = Long.parseLong(input);
                if (value < min || value > max) {
                    System.out.printf("Значение должно быть от %d до %d. Повторите ввод.\n", min, max);
                    value = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат числа. Повторите ввод.");
            }
        } while (value == null);
        return value;
    }

    // Метод для ввода даты с проверкой на null
    protected Date inputDateWithValidation(Scanner scanner, String prompt) {
        Date date = null;
        do {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Дата не может быть пустой. Повторите ввод.");
                continue;
            }
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                dateFormat.setLenient(false);
                date = dateFormat.parse(input);
                if(!(Integer.parseInt(input.split("\\.")[2])>=1924 && Integer.parseInt(input.split("\\.")[2])<=2024)){
                    System.out.println("Дата не может быть больше 2024 или меньше 1950. Повторите ввод.");
                    date = null;
                }
            } catch (ParseException e) {
                System.out.println("Некорректный формат даты. Используйте формат dd.MM.yyyy. Повторите ввод.");
            }
        } while (date == null);
        return date;
    }

    // Метод для ввода и проверки значения перечисления
    protected <E extends Enum<E>> E inputEnumWithValidation(Scanner scanner, String prompt, Class<E> enumClass) {
        E value = null;
        do {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                value = Enum.valueOf(enumClass, input);
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректное значение. Повторите ввод.");
            }
        } while (value == null);
        return value;
    }

    // Метод для ввода координат с проверкой на null
    protected Coordinates inputCoordinatesWithValidation(Scanner scanner) {
        long x = inputLongWithValidation(scanner, "Введите значение x для координат: ", Long.MIN_VALUE, 613);
        Long y = inputLongWithValidation(scanner, "Введите значение y для координат: ", Long.MIN_VALUE, 962);
        return new Coordinates(x, y);
    }

    // Метод для ввода местоположения с проверкой на null
    protected Location inputLocationWithValidation(Scanner scanner) {
        long x = inputLongWithValidation(scanner, "Введите значение x для местоположения: ", Long.MIN_VALUE, Long.MAX_VALUE);
        Integer y = inputIntegerWithValidation(scanner, "Введите значение y для местоположения: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        String name = inputStringWithValidation(scanner, "Введите имя местоположения: ");
        return new Location(x, y, name);
    }

}
