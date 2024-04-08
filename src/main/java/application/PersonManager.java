package application;

import java.util.*;

import console.*;

public class PersonManager {
    private HashMap<String, CommandBase> commands = new HashMap<>();
    private final Add add = new Add();
    private final AddIfMax addIfMax = new AddIfMax();
    private final Clear clear = new Clear();
    private final ExecuteCommandsFromFile executeCommandsFromFile = new ExecuteCommandsFromFile();
    private final FillCollectionFromFile fillCollectionFromFile = new FillCollectionFromFile();
    private final FilterGreaterThanHeight filterGreaterThanHeight = new FilterGreaterThanHeight();
    private final Help help = new Help();
    private final History history = new History();
    private final Info info = new Info();
    private final PrintAscending printAscending = new PrintAscending();
    private final PrintUniqueNationality printUniqueNationality = new PrintUniqueNationality();
    private final RemoveById removeById = new RemoveById();
    private final RemoveFirst removeFirst = new RemoveFirst();
    private final SaveCollectionToFile saveCollectionToFile = new SaveCollectionToFile();
    private final Show show = new Show();
    private final UpdatePersonById updatePersonById = new UpdatePersonById();
    private final String[] namesOfCommandsArray = new String[]{"add", "info", "show", "help", "update", "remove_by_id", "clear", "save", "remove_first", "add_if_max", "history", "filter_greater_than_height", "print_ascending", "print_unique_nationality", "execute_script"};
    private final CommandBase[] commandsArray = new CommandBase[]{add, info, show, help, updatePersonById, removeById, clear, saveCollectionToFile, removeFirst, addIfMax, history, filterGreaterThanHeight, printAscending, printUniqueNationality, executeCommandsFromFile};
    public static List<String> scripts = new ArrayList<>();

    public void initializing_commands() {
        for (int i = 0; i < namesOfCommandsArray.length; i++) {
            commands.put(namesOfCommandsArray[i], commandsArray[i]);
        }
    }

    public void launch(List<String> personOfData) {
        boolean exitBool = false;
        for (String namesCommand : namesOfCommandsArray) {
            if (personOfData.get(0).equals(namesCommand)) {
                if (personOfData.size() == 2) {
                    commands.get(namesCommand).execute(personOfData.get(1));
                } else {
                    commands.get(namesCommand).execute("person_data.get(1)");
                }
                history.setCommandHistory(namesCommand);
                exitBool = true;
                break;
            }
        }
        if (!exitBool && !personOfData.get(0).equals("exit")) {
            System.out.println("Введенная команда не корректная!");
        }

    }
}