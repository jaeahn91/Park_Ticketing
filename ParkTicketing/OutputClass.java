package ParkTicketing;

import java.util.Scanner;

public class OutputClass {
	private Scanner scan = null;
		
	public OutputClass() {
		scan = new Scanner(System.in);
	}
	public void printPrice(int finalPrice) {
		
		System.out.printf("������ %d�� �Դϴ�.\n�����մϴ�.", finalPrice);
	}
	
	public void printError() {
		System.out.println("�߸� �Է��ϼ̽��ϴ�");
	}
	
	public int nextRound() {
		int nextRound;
		System.out.printf("��� ����(1: ���ο� �ֹ�, 2: ���α׷� ����) : ");
		nextRound = scan.nextInt();
		return nextRound;
	}
}
