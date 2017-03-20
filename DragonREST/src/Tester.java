import room.RoomCommandManager;

public class Tester {

	public static void main(String[] args)
	{
		RoomCommandManager rcm = new RoomCommandManager();
		System.out.println(rcm.processRoom("Room2", 0, "checkRoom"));
		
		// processRoom returns a HashMap with the "message","status" (this is the gameState)
		System.out.println(rcm.processRoom("Room2", 0, "swim")); // returns status 1
		System.out.println(rcm.processRoom("Room2", 1, "takeSword")); // returns status 5
	}
}
