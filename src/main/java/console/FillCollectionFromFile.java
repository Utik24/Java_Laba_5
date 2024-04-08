package console;

import db.Data;
import personClasses.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FillCollectionFromFile extends CommandBase {



    @Override
    public void execute(String fileName) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length >= 8) {
                    try {
                        String name = data[0];
                        long x = Long.parseLong(data[1]);
                        Long y = Long.parseLong(data[2]);
                        Coordinates coordinates = new Coordinates(x, y);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        dateFormat.setLenient(false);
                        Date date = dateFormat.parse(data[3]);
                        Long height = data[5].isEmpty() ? null : Long.parseLong(data[4]);
                        Color hairColor = data[6].isEmpty() ? null : Color.valueOf(data[6]);
                        Country nationality = Country.valueOf(data[7]);
                        long locationX = Long.parseLong(data[8]);
                        int locationY = Integer.parseInt(data[9]);
                        String locationName = data[10];
                        Location location = new Location(locationX, locationY, locationName);

                        // Создаем объект personClasses.Person и добавляем его в коллекцию
                        Person person = new Person(name, coordinates, height, date, hairColor, nationality, location);
                        Data.getInstance().add(person);
                    } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | ParseException e) {
                        System.out.println("Ошибка при чтении строки: " + line);
                    }
                } else {
                    System.out.println("Некорректное количество данных в строке: " + line);
                }
            }
            System.out.println("Данные успешно загружены из файла.");
        } catch (
                IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
