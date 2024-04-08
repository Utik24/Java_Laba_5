package console;

import db.Data;
import personClasses.*;

import java.util.Date;
import java.util.Scanner;

public class Add extends CommandBase {
    public void addPerson(Person person) {
        Data.addPerson(person);
        System.out.println("Person успешно добавлен");
    }


    // Метод для ввода всех данных о персоне
    public void addPerson_Interactive(Scanner scanner) {
        String name = inputStringWithValidation(scanner, "Введите имя: ");
        Coordinates coordinates = inputCoordinatesWithValidation(scanner);
        Date birthday = inputDateWithValidation(scanner, "Введите дату рождения в формате dd.MM.yyyy: ");
        Long height = inputLongWithValidation(scanner, "Введите рост: ", 1, Long.MAX_VALUE);
        Color hairColor = inputEnumWithValidation(scanner, "Введите цвет волос (GREEN, BLACK, BLUE): ", Color.class);
        Country nationality = inputEnumWithValidation(scanner, "Введите национальность (RUSSIA, FRANCE, CHINA, SOUTH_KOREA, JAPAN): ", Country.class);
        Location location = inputLocationWithValidation(scanner);
        Person person = new Person(name, coordinates, height, birthday, hairColor, nationality, location);
        addPerson(person);
    }

    public Person addPersonInteractive(Scanner scanner) {
        String name = inputStringWithValidation(scanner, "Введите имя: ");
        Coordinates coordinates = inputCoordinatesWithValidation(scanner);
        Date birthday = inputDateWithValidation(scanner, "Введите дату рождения в формате dd.MM.yyyy: ");
        Long height = inputLongWithValidation(scanner, "Введите рост: ", 1, Long.MAX_VALUE);
        Color hairColor = inputEnumWithValidation(scanner, "Введите цвет волос (GREEN, BLACK, BLUE): ", Color.class);
        Country nationality = inputEnumWithValidation(scanner, "Введите национальность (RUSSIA, FRANCE, CHINA, SOUTH_KOREA, JAPAN): ", Country.class);
        Location location = inputLocationWithValidation(scanner);
        return new Person(name, coordinates, height, birthday, hairColor, nationality, location);
    }

    @Override
    public void execute(String str) {
        Scanner scanner1 = new Scanner(System.in);
        addPerson_Interactive(scanner1);
    }
}
