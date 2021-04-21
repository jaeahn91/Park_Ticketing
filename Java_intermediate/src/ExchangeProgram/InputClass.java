package ExchangeProgram;

import java.util.Scanner;

public class InputClass {
	private Scanner scan = null;
	
	public InputClass() {
		scan = new Scanner(System.in);
	}
	
	public int inputFromConsoleWon() {
		int inputWon;
		System.out.println("Input Amount in Won(종료는 0 입력): ");
		inputWon = scan.nextInt();
		return inputWon;
	}
	
	public int inputFromConsoleType() {
		int inputCurrencyType;
		System.out.println("Choose the Currency Type to Receive\n"
				+ "1. USD\n"
				+ "2. EUR\n"
				+ "3. JPY\n"
				+ "0. Exit");
		inputCurrencyType = scan.nextInt();
		return inputCurrencyType;
	}
}
	