package console;

import db.Data;

import java.time.ZonedDateTime;

public class Info extends CommandBase {


    @Override
    public void execute(String idStr) {
        System.out.println("Тип коллекции: ArrayDeque");
        System.out.println("Дата инициализации: " + ZonedDateTime.now());
        try{
        System.out.println("Количество элементов: " + Data.getInstance().size());
        }
        catch (Exception e){
            System.out.println("Коллекция пустая");
        }

    }
}
