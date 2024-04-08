package console;

import db.Data;

public class PrintAscending extends CommandBase {
    @Override
    public void execute(String str) {
        Data.getInstance().stream().sorted().forEach(System.out::println);
    }
}
