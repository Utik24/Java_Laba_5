package db;

import personClasses.Person;

import java.util.ArrayDeque;
import java.util.Deque;

public class Data {
    private static Deque<Person> people;

    private Data() {
    }

    public static Deque<Person> getInstance() {
        if (people == null) {
            // Создание экземпляра Deque, если он еще не был создан
            people = new ArrayDeque<>();
        }
        return people;
    }

    public static void clearData() {
        while (people.poll() != null) {
            people.poll();
        }
    }

    public static void addPerson(Person e) {
        people.add(e);
    }
}
