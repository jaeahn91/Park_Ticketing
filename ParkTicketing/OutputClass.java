package ParkTicketing;

import java.util.Scanner;

public class OutputClass {
	private Scanner scan = null;
		
	public OutputClass() {
		scan = new Scanner(System.in);
	}
	public void printPrice(int finalPrice) {
		
		System.out.printf("������ %d�� �Դϴ�.\n�����մϴ�.\n", finalPrice);
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
	
	public String ageType(int age) {
		String type;
		if (age >= 65) {
			type = "���";
		} else if (age < 65 && age >= 19) {
			type = "����";
		} else if (age < 19 && age >= 13) {
			type = "û�ҳ�";
		} else if (age < 13 && age >= 3) {
			type = "����";
		} else {
			type = "����(����)";
		}
		return type;
	}
}
