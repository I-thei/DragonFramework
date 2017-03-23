package customframework;
import room.RoomCommandManager;

//This is where the we make our framework

public class DragonFramework {
	RoomCommandManager rcm = new RoomCommandManager();
	SessionHandler s = new SessionHandler();
	boolean isRunning = false;
	
	public DragonFramework(){
		
	}
	
	public void in(String input){
		Validator v = new Validator();
		Class<?> c = SessionHandler.class;
		//parse input (regex)
		s.setCommand(input);
		
		try {
			//v.validate(s, c.getDeclaredField("command").get(s), c.getMethod("setCommand", String.class))
			//System.out.println(rcm.process( params here));
		} catch (RuntimeException e){
			System.out.println("Invalid Input.")
		}
	}

}
