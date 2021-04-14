package ParkTicketing;

import java.util.Scanner;

public class OutputClass {
	private Scanner scan = null;
		
	public OutputClass() {
		scan = new Scanner(System.in);
	}
	public void printPrice(int finalPrice) {
		
		System.out.printf("가격은 %d원 입니다.\n감사합니다.", finalPrice);
	}
	
	public void printError() {
		System.out.println("잘못 입력하셨습니다");
	}
	
	public int nextRound() {
		int nextRound;
		System.out.printf("계속 진행(1: 새로운 주문, 2: 프로그램 종료) : ");
		nextRound = scan.nextInt();
		return nextRound;
	}
}
