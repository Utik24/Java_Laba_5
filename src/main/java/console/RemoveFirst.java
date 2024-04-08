package console;

import db.Data;

public class RemoveFirst extends CommandBase {
    @Override
    public void execute(String idStr) {
        if (!Data.getInstance().isEmpty()) {
            Data.getInstance().poll();
            System.out.println("первый элемент удален из коллекции");
        } else {
            System.out.println("коллекция пуста ничего не добавлено");
        }
    }
}
