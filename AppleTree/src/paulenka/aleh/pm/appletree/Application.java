package paulenka.aleh.pm.appletree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    private final static String COMMAND_GROW = "grow";
    private final static String COMMAND_SHAKE = "shake";
    private final static String COMMAND_EXIT = "exit";

    private AppleTree appleTree;

    public Application(String[] args) {
        appleTree = new AppleTree();
    }

    public static void main(String[] args) {
        Application application = new Application(args);
        application.execute();
    }

    protected AppleTree getAppleTree() {
        return appleTree;
    }

    protected void execute() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Apple tree is ready!");
            String command;
            do {
                command = in.readLine();
                switch (command) {
                    case COMMAND_GROW:
                        executeGrow();
                        break;
                    case COMMAND_SHAKE:
                        executeShake();
                        break;
                    case COMMAND_EXIT:
                        executeExit();
                        break;
                    default:
                        executeError(command);
                        break;
                }
            } while (!COMMAND_EXIT.equals(command));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void executeGrow() {
        getAppleTree().grow();
    }

    protected void executeShake() {
        getAppleTree().shake();
    }

    private void executeExit() {
        System.out.println("You've just cut your wonderful apple tree down...");
    }

    protected void executeError(String command) {
        System.out.println("\"" + command + "\" is an incorrect command.");
        System.out.println("Available commands: " + COMMAND_GROW + ", " + COMMAND_SHAKE + ", " + COMMAND_EXIT);
    }
}