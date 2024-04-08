package console;

import db.Data;
import personClasses.Person;

import java.util.Optional;

public class RemoveById extends CommandBase {

    @Override
    public void execute(String idStr) {
        int id;
        do {
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат ID. Введите целое число.");
                idStr = inputStringWithValidation(scanner, "Введите id персоны для удаления: ");
                continue;
            }

            final int ID = id;
            Optional<Person> optionalPerson = Data.getInstance().stream()
                    .filter(person -> person.getId() == ID)
                    .findFirst();
            if (!optionalPerson.isPresent()) {
                System.out.println("Персона с id " + id + " не найдена в коллекции. Попробуйте ввести другой id:");
                idStr = inputStringWithValidation(scanner, "Введите id персоны для удаления: ");
            } else {
                // Удаляем персону из коллекции
                Person personToRemove = optionalPerson.get();
                Data.getInstance().remove(personToRemove);
                System.out.println("Персона с id " + id + " успешно удалена.");
                break;
            }
        } while (true);
    }

}
