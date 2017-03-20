package customframework;
import methodvalidator.annotations.*;


public class SessionHandler {
	
    private String username;
    private String room;
    private String room5passphrase;
    private int room4answer;
    private int roomNo;
    
    @StringLength
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
  
    public void setRoom() {
        this.room = "Room" + roomNo;
    }
    public String getRoom(){
        return room;
    }

    @Range(lowerbound = 1, upperbound = 5)
    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
    public String getRoomNo(){
        return roomNo;
    }
    
    @IsInteger
    public void setRoom4answer(int room4answer) {
        this.room4answer = room4answer;
    
    public int getRoom4answer() {
        return room4answer;
    }

    @IsString
    public void set(String room5passphrase) {
        this.room5passphrase = room5passphrase;
    }
    public String getroom5passphrase() {
        return room5passphrase;
    }
    
}
