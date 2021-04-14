package ParkTicketing;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import ExchangeProgram.ConstValueClass;

public class WriteClass {

	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd,HH:mm:ss");

	
	public void recordSells (String ticketType, String ageType, int numTickets, 
								int totalPrice, boolean prefDC) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\recordSells.csv", true);
		String data = String.format("%s,%s,%d,%d,%s", ticketType, ageType, numTickets, totalPrice, prefDC);
		fw.write(data);
		fw.close();
	}
}
