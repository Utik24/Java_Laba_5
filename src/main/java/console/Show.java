package console;

import db.Data;

import java.util.Objects;

public class Show extends CommandBase {
    @Override
    public void execute(String idStr) {
        Objects.requireNonNull(Data.getInstance()).forEach(System.out::println);
    }
}
