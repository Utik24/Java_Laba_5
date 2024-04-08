package console;

import db.Data;
import personClasses.Person;

import java.util.Optional;

public class UpdatePersonById extends CommandBase {
    Add addPersonInteractive = new Add();
    @Override
    public void execute(String idStr) {
        int id;
        do {
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат ID. Введите целое число.");
                idStr = inputStringWithValidation(scanner, "Введите id персоны для обновления: ");
                continue;
            }
            final int ID = id;
            Optional<Person> optionalPerson = Data.getInstance().stream().filter(person -> person.getId().equals(ID)).findFirst();
            if (!optionalPerson.isPresent()) {
                System.out.println("Персона с id " + id + " не найдена в коллекции. Попробуйте ввести другой id:");
                idStr = inputStringWithValidation(scanner, "Введите id персоны для обновления: ");
            } else {
                Person updatedPerson = addPersonInteractive.addPersonInteractive(scanner);
                // Продолжаем выполнение метода: обновляем данные персоны
                Person personToUpdate = optionalPerson.get();
                personToUpdate.setName(updatedPerson.getName());
                personToUpdate.setCoordinates(updatedPerson.getCoordinates());
                personToUpdate.setBirthday(updatedPerson.getBirthday());
                personToUpdate.setHeight(updatedPerson.getHeight());
                personToUpdate.setHairColor(updatedPerson.getHairColor());
                personToUpdate.setNationality(updatedPerson.getNationality());
                personToUpdate.setLocation(updatedPerson.getLocation());
                System.out.println("Персона с id " + id + " успешно обновлена.");
                break;
            }
        } while (true);
    }
}
