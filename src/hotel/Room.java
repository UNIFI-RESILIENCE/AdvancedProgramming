package hotel;

public class Room {
	private int InitialRoomNumber = 0;
	int roomNumber ;
	String description;
	Double amount;
	String roomDetails;
	
	Room(String description, int roomNumber, Double amount) {
		this.description = description;
		this.roomNumber = roomNumber;
		this.amount  =  amount;
		
	}
	
	void setRoomDetails () {
		this.roomDetails = "Room: "+ this.roomNumber + "." + " Cost: " + this.amount + ". "+ " \n Details \n"+ this.description;
	}
	
	String getRoomDescription() {
		return this.roomDetails;
	}
	
	void publish()  {
		System.out.println(this.roomDetails + " \n" + " Saved to the database");
	}
}
