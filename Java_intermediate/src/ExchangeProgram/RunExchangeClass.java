package ExchangeProgram;

import java.io.IOException;

public class RunExchangeClass {


	public OutputClass outClass = null;
	
	public RunExchangeClass() {
		outClass = new OutputClass();
	}
	
	private boolean checkBalanceUSD(int requestUSD) {
		if (requestUSD <= ConstValueClass.BALANCE_USD) {
			return true;
		} else {
			return false;
		}
	}
	private boolean checkBalanceEUR(int requestEUR) {
		if (requestEUR <= ConstValueClass.BALANCE_EUR) {
			return true;
		} else {
			return false;
		}
	}
	private boolean checkBalanceJPY(int requestJPY) {
		if (requestJPY <= ConstValueClass.BALANCE_JPY) {
			return true;
		} else {
			return false;
		}
	}
	public void changeToUSD(int inputWon) throws IOException {
		int actualUSD, changeUSD, change_inWon;
		double outputUSD;
	
		outputUSD = inputWon/ConstValueClass.EX_USD;
		actualUSD = (int)outputUSD;
		// ���� �ֳ� ??
		if (checkBalanceUSD(actualUSD)) {
			// ������
		
			
			changeUSD = (int)((outputUSD - actualUSD) * ConstValueClass.EX_USD);
			change_inWon = (changeUSD / 10) * 10;
				
			ConstValueClass.BALANCE_USD -= actualUSD;
			outClass.outputResultUSD(inputWon, actualUSD);	
			outClass.outputResultWonChange(change_inWon); 
			outClass.manageBalanceUSD(change_inWon, ConstValueClass.BALANCE_USD);

		} else { //������
			outClass.printErrorMessage(ConstValueClass.ERR_BALANCE_USD);
		}
	}		
		

	public void changeToEUR(int inputWon) throws IOException {
		int actualEUR, changeEUR, change_inWon;
		double outputEUR;
	
		outputEUR = inputWon/ConstValueClass.EX_EUR;
		actualEUR = (int)outputEUR;
		// ���� �ֳ� ??
		if (checkBalanceEUR(actualEUR)) {
		// ������
		
			changeEUR = (int)((outputEUR - actualEUR) * ConstValueClass.EX_EUR);
			change_inWon = (changeEUR / 10) * 10;
				
			ConstValueClass.BALANCE_EUR -= actualEUR;
			outClass.outputResultEUR(inputWon, actualEUR);
			outClass.outputResultWonChange(change_inWon);
			outClass.manageBalanceEUR(change_inWon, ConstValueClass.BALANCE_EUR);
		
		} else { //������
			outClass.printErrorMessage(ConstValueClass.ERR_BALANCE_EUR);
		}
	}	
	
	public void changeToJPY(int inputWon) throws IOException {
		
		int actualJPY, changeJPY, change_inWon;
		
		double outputJPY;
	
		outputJPY = inputWon/ConstValueClass.EX_JPY;
		actualJPY = (int)outputJPY;
		// ���� �ֳ� ??
		if (checkBalanceJPY(actualJPY)) {
		// ������
			
			changeJPY = (int)((outputJPY - actualJPY) * ConstValueClass.EX_JPY);
			change_inWon = (changeJPY / 10) * 10;
					
			ConstValueClass.BALANCE_JPY -= actualJPY;
			outClass.outputResultJPY(inputWon, actualJPY);
			outClass.outputResultWonChange(change_inWon);
			outClass.manageBalanceJPY(change_inWon, ConstValueClass.BALANCE_JPY);
			
		} else {
			outClass.printErrorMessage(ConstValueClass.ERR_BALANCE_JPY);
		}
	}
	
	
}
		
	
