package ParkTicketing;

import java.io.IOException;
import java.util.Scanner;

public class InputClass {
	private Scanner scan = null;
	public OutputClass outclass = null;
	public InputClass() throws IOException {
		scan = new Scanner(System.in);
		outclass = new OutputClass();
	}

	public int ticketType() {
		int select;
		System.out.println("������ �����ϼ���.\n1. �ְ���\n2. �߰���");
		while (true) {
			select = scan.nextInt();
			if (select == 1 || select == 2) {
				return select;
			} else {
				outclass.printError();
			}
		}	
	}
	
	public String numID() {
		String idNumber;
		System.out.println("�ֹι�ȣ ��7�ڸ��� �Է��ϼ���(����, - ���� ���ڸ� �Է�)");
		while (true) {
			idNumber = scan.next();
			if (idNumber.length() == ConstValueClass.MAX_ID_DIGITS) {
				return idNumber;
			} else {
				outclass.printError();
			}
		}
	}
	
	public int numTickets() {
		int tickets;
		System.out.println("���� �߱��Ͻðڽ��ϱ�? (�ִ� 10��)");
		while (true) {
			tickets = scan.nextInt();
			if (tickets <= ConstValueClass.MAX_COUNT && 
					tickets >= ConstValueClass.MIN_COUNT) {
			return tickets;
			} else {
				outclass.printError();
			}
		}
	}
	
	public int prefOptions() {
		int option;
		System.out.println("�������� �����ϼ���.\n1. ���� (���� ���� �ڵ�ó��)\n"
				+ "2. �����\n"
				+ "3. ����������\n"
				+ "4. ���ڳ�\n"
				+ "5. �ӻ��");
		while (true) {
			option = scan.nextInt();
			if (option >= 1 && option <= 5) {
				return option;
			} else {
				outclass.printError();
			}		
		}
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
	
}
