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
	
	public void getSumByType() { //  주간권, 야간권 권종별 판매현황 출력
		String [] list = {ConstValueClass.cohort_INFANT, 
				ConstValueClass.cohort_CHILD, 
				ConstValueClass.cohort_TEEN,
				ConstValueClass.cohort_ADULT, 
				ConstValueClass.cohort_ELDERLY};
		
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
		
		for (int i = 0; i < list.length; i++) {
			try {

				int sumDayInfant = 0;
				if (i != list.length - 1) { 
					ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` "
							+ "LIKE '주간권' AND `age_Cohort` LIKE '" + list[i] + "'");
					while(rset.next()) {
						sumDayInfant = sumDayInfant + Integer.parseInt(rset.getString(4));
					}
					System.out.printf("%s %d 매, ", list[i], sumDayInfant);
				} 
				else if (i == list.length - 1){
					ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` "
							+ "LIKE '주간권' AND `age_Cohort` LIKE '" + list[i] + "'");
					while(rset.next()) {
						sumDayInfant = sumDayInfant + Integer.parseInt(rset.getString(4));
					}
					System.out.printf("%s %d 매\n", list[i], sumDayInfant);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
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
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` "
					+ "LIKE '야간권'");
			while(rset.next()) {
				sum = sum + Integer.parseInt(rset.getString(4));
			}
			System.out.printf("%s 총 %d 매\n", ConstValueClass.NIGHTPASS, sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < list.length; i++) {
			try {

				int sumDayInfant = 0;
				if (i != list.length - 1) { 
					ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` "
							+ "LIKE '야간권' AND `age_Cohort` LIKE '" + list[i] + "'");
					while(rset.next()) {
						sumDayInfant = sumDayInfant + Integer.parseInt(rset.getString(4));
					}
					System.out.printf("%s %d 매, ", list[i], sumDayInfant);
				} 
				else if (i == list.length - 1){
					ResultSet rset = stmt.executeQuery("SELECT * FROM `report` WHERE `ticket_Type` "
							+ "LIKE '야간권' AND `age_Cohort` LIKE '" + list[i] + "'");
					while(rset.next()) {
						sumDayInfant = sumDayInfant + Integer.parseInt(rset.getString(4));
					}
					System.out.printf("%s %d 매\n", list[i], sumDayInfant);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
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
			System.out.println("==================== 일자별 매출 현황 ====================");
			ResultSet rset = stmt.executeQuery("SELECT date, SUM(price) FROM `report` GROUP BY `date`"
					+ "ORDER BY `date` ASC");
			while(rset.next()) {
				System.out.printf("%s : 총 매출 %s\n", rset.getString(1), rset.getString(2)); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
