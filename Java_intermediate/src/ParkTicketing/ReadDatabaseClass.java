package ParkTicketing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report`");
			System.out.println("=============================================");
			System.out.println("날짜,권종,연령구분,수량,가격,우대사항");
			while(rset.next()) {
				System.out.println(rset.getString(1) + "," + rset.getString(2) + "," +
						rset.getString(3) + "," + rset.getString(4) + "," +
						rset.getString(5) + "," + rset.getString(6));
			}
			System.out.println("---------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getSum() {
		try {
			int sum = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report`");

			while(rset.next()) {
				sum = sum + Integer.parseInt(rset.getString(5));
			}
			System.out.printf("총 판매금액 %d 원\n", sum);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getSumByType() {
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////
//		                                  주간권 판매현황                                  
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("====================== 권종별 판매현황 ======================");
		try {
			int sum = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` LIKE '주간권'");
			while(rset.next()) {
				sum = sum + Integer.parseInt(rset.getString(4));
			}
			System.out.printf("주간권 총 %d 매\n", sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			int sumDayInfant = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` "
					+ "LIKE '주간권' AND `age_Cohort` LIKE '유아'");
			while(rset.next()) {
				sumDayInfant = sumDayInfant + Integer.parseInt(rset.getString(4));
			}
			System.out.printf("유아 %d 매, ", sumDayInfant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			int sumDayChild = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` "
					+ "LIKE '주간권' AND `age_Cohort` LIKE '어린이'");
			while(rset.next()) {
				sumDayChild = sumDayChild + Integer.parseInt(rset.getString(4));
			}
			System.out.printf("어린이 %d 매, ", sumDayChild);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			int sumDayTeen = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` "
					+ "LIKE '주간권' AND `age_Cohort` LIKE '청소년'");
			while(rset.next()) {
				sumDayTeen = sumDayTeen + Integer.parseInt(rset.getString(4));
			}
			System.out.printf("청소년 %d 매, ", sumDayTeen);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			int sumDayAdult = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` "
					+ "LIKE '주간권' AND `age_Cohort` LIKE '어른'");
			while(rset.next()) {
				sumDayAdult = sumDayAdult + Integer.parseInt(rset.getString(4));
			}
			System.out.printf("어른 %d 매, ", sumDayAdult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			int sumDayElderly = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` "
					+ "LIKE '주간권' AND `age_Cohort` LIKE '노인'");
			while(rset.next()) {
				sumDayElderly = sumDayElderly + Integer.parseInt(rset.getString(4));
			}
			System.out.printf("노인 %d 매\n", sumDayElderly);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			int sum = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` LIKE '주간권'");
			while(rset.next()) {
				sum = sum + Integer.parseInt(rset.getString(5));
			}
			System.out.printf("주간권 매출 : %d 원\n", sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////	
//                                        야간권 판매현황                                
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		try {
			int sum = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` LIKE '야간권'");
			while(rset.next()) {
				sum = sum + Integer.parseInt(rset.getString(4));
			}
			System.out.printf("야간권 총 %d 매\n", sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			int sumDayInfant = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` "
					+ "LIKE '야간권' AND `age_Cohort` LIKE '유아'");
			while(rset.next()) {
				sumDayInfant = sumDayInfant + Integer.parseInt(rset.getString(4));
			}
			System.out.printf("유아 %d 매, ", sumDayInfant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			int sumDayChild = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` "
					+ "LIKE '야간권' AND `age_Cohort` LIKE '어린이'");
			while(rset.next()) {
				sumDayChild = sumDayChild + Integer.parseInt(rset.getString(4));
			}
			System.out.printf("어린이 %d 매, ", sumDayChild);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			int sumDayTeen = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` "
					+ "LIKE '야간권' AND `age_Cohort` LIKE '청소년'");
			while(rset.next()) {
				sumDayTeen = sumDayTeen + Integer.parseInt(rset.getString(4));
			}
			System.out.printf("청소년 %d 매, ", sumDayTeen);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			int sumDayAdult = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` "
					+ "LIKE '야간권' AND `age_Cohort` LIKE '어른'");
			while(rset.next()) {
				sumDayAdult = sumDayAdult + Integer.parseInt(rset.getString(4));
			}
			System.out.printf("어른 %d 매, ", sumDayAdult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			int sumDayElderly = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` "
					+ "LIKE '야간권' AND `age_Cohort` LIKE '노인'");
			while(rset.next()) {
				sumDayElderly = sumDayElderly + Integer.parseInt(rset.getString(4));
			}
			System.out.printf("노인 %d 매\n", sumDayElderly);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			int sum = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` LIKE '야간권'");
			while(rset.next()) {
				sum = sum + Integer.parseInt(rset.getString(5));
			}
			System.out.printf("야간권 매출 : %d 원\n", sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("----------------------------------------------------------");
		
	}
	
	public void getSumByDate() {
		try {
			int sum = 0;
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report`");

			while(rset.next()) {
				sum = sum + Integer.parseInt(rset.getString(5));
			}
			System.out.printf("총 판매금액 %d 원\n", sum);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
