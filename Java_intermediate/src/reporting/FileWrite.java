package reporting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;



public class FileWrite {

	// 일자별 매출 출력
	public <Array> void day_Profit(ArrayList<String> date, int[] date_Price) {

		try {
			BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream (ConstValue.daily),"MS949"));
			fw.write("일자" + "," + "총 매출\n");
			for (int i = 0; i < date.size(); i++) {
				fw.write(date.get(i)+ "," + date_Price[i] + "\n");
			}
			fw.close();
		} catch (Exception e) {

		}
	}

	// 권종별 판매 개수
	public void ticket_Count() {
		
		try {
			BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream (ConstValue.type_Count),"MS949"));
			fw.write("구분" + "," + ConstValue.type_Ticket[1] + "," + ConstValue.type_Ticket[2] + "\n");
			for (int i = 0; i < ConstValue.type_Person.length; i++) {
				fw.write(ConstValue.type_Person[i] + "," + ConstValue.type_Day_Count[i] + ","
						+ ConstValue.type_Night_Count[i] + "\n");
			}
			fw.write("합계" + "," + ConstValue.day_count + "," + ConstValue.night_count + "\n");
			fw.write("매출" + "," + ConstValue.day_Total_Price + "," + ConstValue.night_Total_Price + "\n");
			fw.close();
		} catch (Exception e) {

		}
	}
}