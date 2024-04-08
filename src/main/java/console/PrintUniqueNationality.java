package console;

import db.Data;
import personClasses.Country;
import personClasses.Person;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueNationality extends CommandBase {
    @Override
    public void execute(String str) {
        Set<Country> uniqueNationalities = new HashSet<>();
        for (Person person : Data.getInstance()) {
            uniqueNationalities.add(person.getNationality());
        }
        System.out.println("Уникальные поля nationality всех элементов " + uniqueNationalities);
    }
}
