package klodnicki.robotv2.command;

public class CloseApplication implements MenuCommand{
    @Override
    public String getName() {
        return "Close application";
    }

    @Override
    public void execute() {
        System.out.println("Closing application");
        System.exit(0);
    }
}
