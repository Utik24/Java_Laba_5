package console;

import application.PersonManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static application.PersonManager.scripts;

public class ExecuteCommandsFromFile extends CommandBase {
    private List<String> person_data = new ArrayList<>();

    @Override
    public void execute(String fileName) {
        scripts.add(fileName);
        PersonManager personManager = new PersonManager();
        personManager.initializing_commands();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            if (scripts.size() <= 2) {
                while ((line = reader.readLine()) != null) {
                    person_data = List.of(line.split(" "));
                    personManager.launch(person_data);
                }
            } else {
                System.out.println("Рекурсия");
                scripts.clear();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

}
