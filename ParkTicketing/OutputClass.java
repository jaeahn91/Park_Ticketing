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
		System.out.printf("��� �߱��Ͻðڽ��ϱ�?\n1: Ƽ�� �߱�\n2: ����\n");
		nextRound = scan.nextInt();
		return nextRound;
	}

	public int exitorProceed() {
		int exitproceed;
		System.out.printf("��� ����(1: ���ο� �ֹ�, 2: ���α׷� ����) : ");
		exitproceed = scan.nextInt();
		return exitproceed;
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
	
	public void startofReceipt() {
		System.out.println("================== �������� ==================");
	}
	
	public String receipt(int type, String ageType, int numTicket, int fee, int prefType) {
		String ticketType = "";
		if (type == 1) {
			ticketType = "�ְ���";
		} else if (type == 2) {
			ticketType = "�߰���";
		}
		
		String pref = "";
		if (prefType == 1) {
			pref = "������� ����";
		} else if (prefType == 2) {
			pref = "����� �������";
		} else if (prefType == 3) {
			pref = "���������� �������";
		} else if (prefType == 4) {
			pref = "���ڳ� �������";
		} else if (prefType == 5) {
			pref = "�ӻ�� �������";
		}
		
		String transaction = String.format("%s %s X %d %d�� *%s\n", 
				ticketType, ageType, numTicket, fee, pref);
		
		return transaction;
	}
	
	public void receiptTotal(int totalFee) {
		System.out.println();
		System.out.printf("����� �Ѿ��� %d�� �Դϴ�\n", totalFee);
	}
	
	public void endofReceipt() {
		System.out.println("==============================================\n");
	}
}
