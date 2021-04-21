package ExchangeProgram;

import java.io.IOException;

public class MoneyExchange {


	public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
		int inputWon = 0;
		int inputCurrencyType = 0;
		InputClass inputClass = new InputClass();
		
		do {
			inputWon = inputClass.inputFromConsoleWon();
			inputCurrencyType = inputClass.inputFromConsoleType();
			
			RunExchangeClass runClass = new RunExchangeClass();
			
			switch (inputCurrencyType) {
			case ConstValueClass.CHANGE_TYPE_USD:
				runClass.changeToUSD(inputWon);
				break;
					
			}
			
			switch (inputCurrencyType) {
			case ConstValueClass.CHANGE_TYPE_EUR:
				runClass.changeToEUR(inputWon);
				break;
			}
			
			switch (inputCurrencyType) {
			case ConstValueClass.CHANGE_TYPE_JPY:
				runClass.changeToJPY(inputWon);
				break;
			}
		} while (inputWon != 0);
	}
}


