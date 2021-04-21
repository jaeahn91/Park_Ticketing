package reporting;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Output output = new Output();
		FileWrite fw = new FileWrite();
		try {
			output.total_Report();
			fw.ticket_Count();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
