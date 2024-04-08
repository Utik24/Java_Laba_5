package application;
import java.util.*;

/**
 * this class is for reading and splitting data, as well as for running our application
 * @author Kirill Shishkinskiy
 */
public class Run {
    private Scanner scanner = new Scanner(System.in);
    private List<String> personData = new ArrayList<>();

    private String input = "";
    public void run() {
        PersonManager personManager = new PersonManager();
        personManager.initializing_commands();
        while (!Objects.equals(input, "exit")) {
            try {
                System.out.println("Введите команду (help для справки):");
                input = scanner.nextLine().trim();
                String[] tokens = input.split(" ");
                personData = List.of(tokens);
                personManager.launch(personData);
            }
            catch (Exception e){
                System.out.println("Введены не корректные данные: "+e.getMessage());
                System.out.println("Программа завершает свою работу");
                System.exit(0);
            }
        }
        System.out.println("Программа завершает свою работу");
    }
}
