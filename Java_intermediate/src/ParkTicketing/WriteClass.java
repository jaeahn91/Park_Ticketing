package ParkTicketing;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class WriteClass {

	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd,HH:mm:ss");


	public void saveFile(ArrayList<Customer> csInfoArr) throws IOException {
		// 날짜,권종,연령구분,수량,가격,우대사항
		// ex)20210415,주간권,대인,1,56000,없음
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream
				(ConstValueClass.savePATH, true), "MS949"));
		String text = "";
		for (int i = 0; i < csInfoArr.size(); i++) {
			Customer info = csInfoArr.get(i);
			text += info.getDate() + "," + info.getTicketType() + "," + info.getAgeCohortType() + 
					"," + info.getNumTickets() + "," + info.getTicketPrice() + "," + info.getPrefType() + "\n";
			bw.write(text);
			text = "";
		}
		bw.close();
	}
	
	public void insertDB(ArrayList<Customer> csInfoArr) throws ClassNotFoundException, SQLException {
		for (int i = 0; i < csInfoArr.size(); i++) {
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1:3306/test",
						"root", 
						"kopo0000");
			
				Statement stmt = conn.createStatement();
	
					Customer info = csInfoArr.get(i);
				
					stmt.execute("INSERT INTO `report` (`date`, `ticket_Type`, `age_Cohort`, `count`, "
						+ "`price`, `preference`) VALUES ('"+ info.getDate() + "', '" + info.getTicketType() + 
						"', '" + info.getAgeCohortType() + "', '" + info.getNumTickets() + "', '" + 
						info.getTicketPrice() + "', '" + info.getPrefType() + "');");
				
	
				
			} catch(Exception e) {
				e.printStackTrace();
			}
	
		}
	
	}
	
}
