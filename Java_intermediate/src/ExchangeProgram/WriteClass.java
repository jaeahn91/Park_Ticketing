package ExchangeProgram;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class WriteClass {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyMMdd,HH:mm:ss");
//	SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
	
	public void recordUSD (int inputWon, int actualUSD, int outputUSD100, 
			int outputUSD50, int outputUSD20, int outputUSD10, int outputUSD5, int outputUSD1, double balance) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\recordUSD.csv", true);

		String numbers = String.format(sdf1.format(cal.getTime()) + "," +
					"%d,%d,%f,%d,%d,%d,%d,%d,%d,",
					inputWon, actualUSD, ConstValueClass.BALANCE_USD, outputUSD100, outputUSD50, 
					outputUSD20, outputUSD10, outputUSD5, outputUSD1);
		// ��¥,�ð�,ȯ����û�ݾ�,���ɿ�ȭ,�޷��ܰ�,100�޷�,50�޷�,20�޷�,10�޷�,5�޷�,1�޷�
//		fw.write(header);
		fw.write(numbers);
		fw.close();		
	}

	public void recordEUR (int inputWon, int actualEUR, int outputEUR100, int outputEUR50, 
			int outputEUR20, int outputEUR10, int outputEUR5) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\recordEUR.csv", true);

		String numbers = String.format(sdf1.format(cal.getTime()) + "," +
					"%d,%d,%f,%d,%d,%d,%d,%d,",
					inputWon, actualEUR, ConstValueClass.BALANCE_EUR, outputEUR100, outputEUR50, outputEUR20,outputEUR10, outputEUR5);
		// ��¥,�ð�,ȯ����û�ݾ�,���ɿ�ȭ,�����ܰ�,100����,50����,20����,10����,5����
		fw.write(numbers);
		fw.close();		
	}
	
	public void recordJPY (int inputWon, int actualJPY, int outputJPY10K,int outputJPY5K, 
			int outputJPY2K, int outputJPY1K) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\recordJPY.csv", true);

		String numbers = String.format(sdf1.format(cal.getTime()) + "," +
				 "%d,%d,%f,%d,%d,%d,%d,",
				 inputWon, actualJPY, ConstValueClass.BALANCE_JPY, outputJPY10K, outputJPY5K, outputJPY2K, outputJPY1K);
		// ��¥,�ð�,ȯ����û�ݾ�,���ɿ�ȭ,��ȭ�ܰ�,10000��,5000��,2000��,1000��
//		fw.write(header);
		fw.write(numbers);    
		fw.close();		
	}
	
	public void recordWonChange (int change_inWon, int changeKRW5000, int changeKRW1000, int changeKRW500, 
			int changeKRW100, int changeKRW50, int changeKRW10) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\bookkeeping.csv", true);
		
//		String header = "�Ž������Ѿ�,5000��,1000��,500��,100��,50��,10��\n";
		String numbers = String.format("%d,%d,%d,%d,%d,%d,%d\n",
				change_inWon, changeKRW5000, changeKRW1000, changeKRW500, changeKRW100, changeKRW50, changeKRW10);
		// �Ž������Ѿ�,5000��,1000��,500��,100��,50��,10��
//		fw.write(header);
		fw.write(numbers);
		fw.close();		
	}
	
	public void recordChangeUSD (int change_inWon) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\recordUSD.csv", true);

		String numbers = String.format("%d\n",
				change_inWon);
		// �޷�ȭ ȯ���� ���� �Ž������Ѿ�
		fw.write(numbers);
		fw.close();		
	}	
	
	public void recordChangeEUR (int change_inWon) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\recordEUR.csv", true);

		String numbers = String.format("%d\n",
				change_inWon);
		// ����ȭ ȯ���� ���� �Ž������Ѿ�
		fw.write(numbers);
		fw.close();		
	}	
	
	public void recordChangeJPY (int change_inWon) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\recordJPY.csv", true);

		String numbers = String.format("%d\n",
				change_inWon);
		// ��ȭ ȯ���� ���� �Ž������Ѿ�
		fw.write(numbers);
		fw.close();		
	}	
}
