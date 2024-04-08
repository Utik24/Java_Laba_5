import application.Run;
import db.Data;


public class Main {
    public static void main(String[] args) {
        Data.getInstance();
        Run run = new Run();
        run.run();
    }
}