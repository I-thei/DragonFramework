package customframework;
import methodvalidator.annotations.*;

public class SessionHandler {
    private String command;
    
    @Command
    public void setCommand(String command) {
        this.command = command;
    }
    
    public String getCommand(){
    	return command;
    }
}
