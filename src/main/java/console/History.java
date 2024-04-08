package console;

import java.util.ArrayList;
import java.util.List;

public class History extends CommandBase {
    private List<String> commandHistory = new ArrayList<>();

    public void setCommandHistory(String _commandHistory) {
        commandHistory.add(0,_commandHistory);
    }
    @Override
    public void execute(String str) {
        System.out.println("История команд:");
        if (commandHistory.size() > 9) {
            for (int i = 0; i < 10; i++) {
                System.out.println(commandHistory.get(i));
            }
        } else {
            for (String command1 : commandHistory) {
                System.out.println(command1);
            }
        }
    }

}
