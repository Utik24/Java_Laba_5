package console;

import db.Data;

public class Clear extends CommandBase {
    @Override
    public void execute(String str) {
        Data.clearData();
        System.out.println("Коллекция успешно очищена");
    }
}
