package ParkTicketing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadDatabaseClass {
	private Connection con;
	private Statement stmt;
	public ReadDatabaseClass() {
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
	
	public void printOnConsole() {
		try {
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report`");
			System.out.println("날짜,권종,연령,장수,가격,우대사항");
			while(rset.next()) {
				System.out.println(rset.getString(1) + "," + rset.getString(2) + "," +
						rset.getString(3) + "," + rset.getString(4) + "," +
						rset.getString(5) + "," + rset.getString(6));
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getSum() {
		try {
			int sum = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report`");
			System.out.print("입장권 판매총액 : ");
			while(rset.next()) {
				sum = sum + Integer.parseInt(rset.getString(5));
			}
			System.out.print(sum);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
