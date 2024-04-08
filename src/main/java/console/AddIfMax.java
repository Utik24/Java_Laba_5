package console;

import db.Data;
import personClasses.Person;

import java.util.Comparator;
import java.util.Objects;

public class AddIfMax extends CommandBase {
    Add addPersonInteractive = new Add();

    @Override
    public void execute(String idStr) {
        Person person = addPersonInteractive.addPersonInteractive(scanner);
        if (Data.getInstance().isEmpty() || person.compareTo(Objects.requireNonNull(Data.getInstance().stream().max(Comparator.naturalOrder()).orElse(null))) > 0) {
            Data.getInstance().add(person);
            System.out.println("personClasses.Person успешно добавлен");
        } else {
            System.out.println("personClasses.Person не добавлен, значение меньше чем у максимального элемента коллекции");
        }

    }
}
