package ExchangeProgram;

import java.io.IOException;

public class OutputClass {

	private WriteClass bookKeeping = null;
//	private RunExchangeClass runClass = null;
	
	public OutputClass() {
		bookKeeping = new WriteClass();
//		runClass = new RunExchangeClass();
	}
		
	public void outputResultUSD(int inputWon, int actualUSD) throws IOException {
		int outputUSD100, outputUSD50, outputUSD20;
		int outputUSD10, outputUSD5, outputUSD1;
	

		outputUSD100 = actualUSD / ConstValueClass.USD100;
		outputUSD50 = (actualUSD % ConstValueClass.USD100) / ConstValueClass.USD50;
		outputUSD20 = ((actualUSD % ConstValueClass.USD100)
						% ConstValueClass.USD50) / ConstValueClass.USD20;
		outputUSD10 = (((actualUSD % ConstValueClass.USD100)
						% ConstValueClass.USD50) %	ConstValueClass.USD20)
						/ ConstValueClass.USD10;
		outputUSD5 = ((((actualUSD % ConstValueClass.USD100) 
						% ConstValueClass.USD50) % ConstValueClass.USD20)
						% ConstValueClass.USD10) / ConstValueClass.USD5;
		outputUSD1 = (actualUSD % ConstValueClass.USD5);
		
		printResultUSD(actualUSD, outputUSD100, outputUSD50, outputUSD20, 
									outputUSD10, outputUSD5, outputUSD1);
		bookKeeping.recordUSD(inputWon, actualUSD, outputUSD100, outputUSD50, outputUSD20, 
				outputUSD10, outputUSD5, outputUSD1, ConstValueClass.BALANCE_USD
				);

	
	}
	
	private void printResultUSD(int actualUSD, int outputUSD100, 
			int outputUSD50, int outputUSD20, int outputUSD10, int outputUSD5, int outputUSD1) {


		System.out.println(actualUSD + " Dollar");
		System.out.println("100�޷� : " 
							+ outputUSD100 + " �� ");
		System.out.println("50�޷� : " 
							+ outputUSD50 + " �� ");
		System.out.println("20�޷� : "
							+ outputUSD20 + " �� ");
		System.out.println("10�޷� : " 
							+ outputUSD10 + " �� ");
		System.out.println("5�޷� : " 
							+ outputUSD5 + " �� ");
		System.out.println("1�޷� : " 
							+ outputUSD1 + " �� ");
		
	}
	
	public void outputResultEUR(int inputWon, int actualEUR) throws IOException {
		int outputEUR100, outputEUR50, outputEUR20; 
		int outputEUR10, outputEUR5;
		
		
		outputEUR100 = actualEUR / ConstValueClass.EUR100;
		outputEUR50 = (actualEUR % ConstValueClass.EUR100) / ConstValueClass.EUR50;
		outputEUR20 = ((actualEUR % ConstValueClass.EUR100) 
						% ConstValueClass.EUR50) / ConstValueClass.EUR20;
		outputEUR10 = (((actualEUR % ConstValueClass.EUR100) 
						% ConstValueClass.EUR50) % ConstValueClass.EUR20) 
						/ ConstValueClass.EUR10;
		outputEUR5 = ((((actualEUR % ConstValueClass.EUR100) 
						% ConstValueClass.EUR50) % ConstValueClass.EUR20) 
						% ConstValueClass.EUR10) / ConstValueClass.EUR5;
		
		printResultEUR(actualEUR, outputEUR100, outputEUR50, 
						outputEUR20, outputEUR10, outputEUR5);
		bookKeeping.recordEUR(inputWon, actualEUR, outputEUR100, outputEUR50, outputEUR20, 
				outputEUR10, outputEUR5
				);
	
		}
	
	private void printResultEUR(int actualEUR, 
			int outputEUR100, int outputEUR50, int outputEUR20,	
			int outputEUR10, int outputEUR5) {

		System.out.println(actualEUR + " Euro");
		System.out.println("100���� : " + outputEUR100 + " �� ");
		System.out.println("50���� : " + outputEUR50 + " �� ");
		System.out.println("20���� : " + outputEUR20 + " �� ");
		System.out.println("10���� : " + outputEUR10 + " �� ");
		System.out.println("5���� : " + outputEUR5 + " �� ");					
		
	}
	
	public void outputResultJPY(int inputWon, int actualJPY) throws IOException {
		
		int outputJPY10K, outputJPY5K, outputJPY2K, outputJPY1K;
		
		outputJPY10K = actualJPY / ConstValueClass.JPY10K;
		outputJPY5K = (actualJPY % ConstValueClass.JPY10K) / ConstValueClass.JPY5K;
		outputJPY2K = ((actualJPY % ConstValueClass.JPY10K) % ConstValueClass.JPY5K)
						/ ConstValueClass.JPY2K;
		outputJPY1K = (((actualJPY % ConstValueClass.JPY10K) *ConstValueClass.JPY5K)
						% ConstValueClass.JPY2K) / ConstValueClass.JPY1K;
		
		printResultJPY(actualJPY, outputJPY10K, outputJPY5K, outputJPY2K, outputJPY1K);
		bookKeeping.recordJPY(inputWon, actualJPY, outputJPY10K, outputJPY5K, outputJPY2K, 
				outputJPY1K);
	
			
	}
	
	private void printResultJPY(int actualJPY, int outputJPY10K, int outputJPY5K, 
								int outputJPY2K, int outputJPY1K) {
		

		System.out.println(actualJPY + " Yen");
		System.out.println("10000�� : " + outputJPY10K + " �� ");
		System.out.println("5000�� : " + outputJPY5K + " �� ");
		System.out.println("2000�� : " + outputJPY2K + " �� ");
		System.out.println("1000�� : " + outputJPY1K + " �� ");
		
	}
		
	public void outputResultWonChange(int change_inWon) throws IOException {
		int changeKRW5000, changeKRW1000, changeKRW500, changeKRW100, changeKRW50, changeKRW10;
		
		changeKRW5000 = change_inWon / ConstValueClass.KRW5K;
		changeKRW1000 = (change_inWon % ConstValueClass.KRW5K) 
						/ ConstValueClass.KRW1K;
		changeKRW500 = ((change_inWon % ConstValueClass.KRW5K) 
						% ConstValueClass.KRW1K) / ConstValueClass.KRW500;
		changeKRW100 = (((change_inWon % ConstValueClass.KRW5K) 
						% ConstValueClass.KRW1K) % ConstValueClass.KRW500)
						/ ConstValueClass.KRW100;
		changeKRW50 = ((((change_inWon % ConstValueClass.KRW5K) 
						% ConstValueClass.KRW1K) % ConstValueClass.KRW500)
						% ConstValueClass.KRW100) / ConstValueClass.KRW50;
		changeKRW10 = (((((change_inWon % ConstValueClass.KRW5K)
						% ConstValueClass.KRW1K) % ConstValueClass.KRW500)
						% ConstValueClass.KRW100) % ConstValueClass.KRW50)
						/ ConstValueClass.KRW10;
		
		printResultWonChange(change_inWon, changeKRW5000, changeKRW1000, changeKRW500,
								changeKRW100, changeKRW50, changeKRW10);
		
		bookKeeping.recordWonChange(change_inWon, changeKRW5000, changeKRW1000, 
				changeKRW500, changeKRW100, changeKRW50, changeKRW10);
	}
		
	private void printResultWonChange(int change_inWon, int changeKRW5000, int changeKRW1000,
										int changeKRW500, int changeKRW100, int changeKRW50,
										int changeKRW10) {
		

		System.out.println("�ܵ� : " + change_inWon + " �� ");
		System.out.println("5000�� : " + changeKRW5000 + " �� ");
		System.out.println("1000�� : " + changeKRW1000 + " �� ");
		System.out.println("500�� : " + changeKRW500 + " �� ");
		System.out.println("100�� : " + changeKRW100 + " �� ");
		System.out.println("50�� : " + changeKRW50 + " �� ");
		System.out.println("10�� : " + changeKRW10 + " �� ");
		
	}
	
	public void printErrorMessage(int errorCode) {
		switch(errorCode) {
			case ConstValueClass.ERR_BALANCE_USD:
				System.out.print("�޷� ");
			case ConstValueClass.ERR_BALANCE_EUR:
				System.out.print("���� ");
			case ConstValueClass.ERR_BALANCE_JPY:
				System.out.print("��ȭ ");
		}
		System.out.println("���� �ܾ��� �����մϴ�.");
		
	}
	
	public void manageBalanceUSD(int change_inWon, double balance) throws IOException {
		System.out.println("Dollar Balance: " + balance);
		bookKeeping.recordChangeUSD(change_inWon);
	}

	public void manageBalanceEUR(int change_inWon, double balance) throws IOException {
		System.out.println("Euro Balance: " + balance);
		bookKeeping.recordChangeEUR(change_inWon);
	}
	public void manageBalanceJPY(int change_inWon, double balance) throws IOException {
		System.out.println("Yen Balance: " + balance);
		bookKeeping.recordChangeJPY(change_inWon);
	}
	
}
		
		
		