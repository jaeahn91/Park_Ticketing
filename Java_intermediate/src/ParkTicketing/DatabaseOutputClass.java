package ParkTicketing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseOutputClass {

	private Connection con;
	private Statement stmt;
	public DatabaseOutputClass() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/test",
					"root", 
					"kopo0000");
		
			stmt = conn.createStatement();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addToDatabase(Customer csInfo) {
		try {
			stmt.execute("INSERT INTO `report` (`date`, `ticket_Type`, `age_Cohort`, `count`, "
					+ "`price`, `preference`) "
					+ "VALUES (now(), "
							+ "'" + csInfo.getTicketType() + "', "
							+ "'" + csInfo.getAgeCohortType() + "', "
							+ "'" + csInfo.getNumTickets() + "', "
							+ "'" + csInfo.getTicketPrice() + "', "
							+ "'" + csInfo.getPrefType() + "');");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
			

}
