package console;

import db.Data;
import personClasses.Person;

public class FilterGreaterThanHeight extends CommandBase {
    @Override
    public void execute(String Str) {
        long heigh = java.lang.Long.parseLong(Str, 10);
        for (Person person : Data.getInstance()) {
            if (person.getHeight() != null && person.getHeight() > heigh) {
                System.out.println(person);
            }
        }
    }
}
