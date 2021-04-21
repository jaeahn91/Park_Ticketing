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
		// 날짜,시간,환전요청금액,수령외화,달러잔고,100달러,50달러,20달러,10달러,5달러,1달러
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
		// 날짜,시간,환전요청금액,수령외화,유로잔고,100유로,50유로,20유로,10유로,5유로
		fw.write(numbers);
		fw.close();		
	}
	
	public void recordJPY (int inputWon, int actualJPY, int outputJPY10K,int outputJPY5K, 
			int outputJPY2K, int outputJPY1K) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\recordJPY.csv", true);

		String numbers = String.format(sdf1.format(cal.getTime()) + "," +
				 "%d,%d,%f,%d,%d,%d,%d,",
				 inputWon, actualJPY, ConstValueClass.BALANCE_JPY, outputJPY10K, outputJPY5K, outputJPY2K, outputJPY1K);
		// 날짜,시간,환전요청금액,수령외화,엔화잔고,10000엔,5000엔,2000엔,1000엔
//		fw.write(header);
		fw.write(numbers);    
		fw.close();		
	}
	
	public void recordWonChange (int change_inWon, int changeKRW5000, int changeKRW1000, int changeKRW500, 
			int changeKRW100, int changeKRW50, int changeKRW10) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\bookkeeping.csv", true);
		
//		String header = "거스름돈총액,5000원,1000원,500원,100원,50원,10원\n";
		String numbers = String.format("%d,%d,%d,%d,%d,%d,%d\n",
				change_inWon, changeKRW5000, changeKRW1000, changeKRW500, changeKRW100, changeKRW50, changeKRW10);
		// 거스름돈총액,5000원,1000원,500원,100원,50원,10원
//		fw.write(header);
		fw.write(numbers);
		fw.close();		
	}
	
	public void recordChangeUSD (int change_inWon) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\recordUSD.csv", true);

		String numbers = String.format("%d\n",
				change_inWon);
		// 달러화 환전에 대한 거스름돈총액
		fw.write(numbers);
		fw.close();		
	}	
	
	public void recordChangeEUR (int change_inWon) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\recordEUR.csv", true);

		String numbers = String.format("%d\n",
				change_inWon);
		// 유로화 환전에 대한 거스름돈총액
		fw.write(numbers);
		fw.close();		
	}	
	
	public void recordChangeJPY (int change_inWon) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\recordJPY.csv", true);

		String numbers = String.format("%d\n",
				change_inWon);
		// 엔화 환전에 대한 거스름돈총액
		fw.write(numbers);
		fw.close();		
	}	
}
