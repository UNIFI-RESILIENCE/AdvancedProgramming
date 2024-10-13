package hotel;

public class Main {

	public static void main(String[] args) {
		
		String describeRoom = "This cozy and comfortable room is perfect for a relaxing stay. "
				+ "It features a comfortable double bed, a small desk for working or writing, and a "
				+ "closet for your belongings. The room also has a private bathroom with a shower.";
		Double amount = 50000.00; 
		int roomNumber = 10;
	
		Room room = new Room(describeRoom,roomNumber, amount);
		room.setRoomDetails();
		
		System.out.println(room.getRoomDescription());
		
		room.publish();
		


	}

}
