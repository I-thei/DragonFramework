package customframework;
import room.RoomCommandManager;

//This is where the we make our framework

public class DragonRestFramework {
	RoomCommandManager;
	SessionHandler s;
	boolean isRunning = false;
	
	public DragonRestFramework(){
		rcm = new RoomCommandManager();
		s = new SessionHandler();
		
		//startgame
		
	}
	
	//public String getGameState(int gamestate){
	//   int to Binary,
	//	 use Binary to get status
	//	 out String with definition of game status
	
	
	//public void startgame
		//this.isRunning = true;
		//game();
	
	//public void game()
		//instantiate validator for session handler
		//print welcom to game : use <command here> to create user
		//while game is true 
			//Run main
			//	(get new input from Main: room no, gamestate, command || create user/save user progress || hint)
			//pass parameters to session handler
			//try 
			//	call validator.validate
			// 	if room: rcm.process(room no, game state(binary), command + params from session handler) 	
			//  if user 
			//		instantiate EntryPoint
			//
			//		create user
			//			create user and save to database
			//		load user
			//			load user and game state
			//		exit 
			//			save to database
			//			set isRunning false
			//  if hint
			//		return gamestate (from roomcommandmanager?)
			//catch
			//	print try again
}
