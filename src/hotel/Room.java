package hotel;

import java.sql.*;


public class Room {
	int roomNumber ;
	String description;
	Double amount;
	private String roomDetails;
	
	Room(String description, int roomNumber, Double amount) {
		this.description = description;
		this.roomNumber = roomNumber;
		this.amount  =  amount;
	}
	
	void setRoomDetails () {
		this.roomDetails = "Room: "+ this.roomNumber + "." + " Cost: " + this.amount + ". "+ " \n Details \n"+ this.description;
	}
	
	String getRoomDetails() {
		return this.roomDetails;
	}
	
	
	
	void publish()  {
		
		
		String dbuser = "postgres";
		
		String url = "jdbc:postgresql://localhost:5432/hoteldb";
		
		String dbpassword = "/Pass@098/";
		
		String getAllQuery = "select * from rooms";
		
		
		  String sql = "INSERT INTO rooms (id, room_number, room_description, room_amount) VALUES ((SELECT MAX(id) FROM rooms) + 1, ?, ?, ?)";

		
		try {
			
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection(url, dbuser, dbpassword);
         // Create a statement   object to execute SQL queries
            
			
			if(conn !=null) {
				System.out.println("Connection established");
				
				Statement statement = conn.createStatement();
				
		        PreparedStatement preparedStatement = conn.prepareStatement(sql);
		        preparedStatement.setInt(1, this.roomNumber);
		        preparedStatement.setString(2, this.description);
		        preparedStatement.setDouble(3, this.amount);
		        int rowSaved = preparedStatement.executeUpdate();
				
		        if (rowSaved == 1) {
		        	
		        	System.out.println("Record saved to the db");
		        	
		        }else {
		        	System.out.println("No record saved to db");
		        }
//				
//				ResultSet rst = statement.executeQuery(saveRoomQuery);
//				
//				while (rst.next()) {
//					String description = rst.getString("roomDescription");
//					
//					System.out.println(description);
//				}
//			rst.close();
		    preparedStatement.close();
			conn.close();
				
			}else {
				
				System.out.println("Connection not established");
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		//System.out.println(this.roomDetails + " \n" + " Saved to the database");
	}
}
