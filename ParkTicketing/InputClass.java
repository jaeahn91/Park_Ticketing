package ParkTicketing;

import java.util.Scanner;

public class InputClass {
	private Scanner scan = null;
	
	public InputClass() {
		scan = new Scanner(System.in);
	}
	
	public int ticketType() {
		int type;
		System.out.println("������ �����ϼ���.\n1. �ְ���\n2. �߰���");
		type = scan.nextInt();
		
		return type;
				
	}
	
	public String numID() {
		String idNumber;
		System.out.println("�ֹι�ȣ ��7�ڸ��� �Է��ϼ���(����, - ���� ���ڸ� �Է�)\n");
		idNumber = scan.next();
		return idNumber;
	}
	
	public int numTickets() {
		int tickets;
		System.out.println("���� �߱��Ͻðڽ��ϱ�? (�ִ� 10��)\n");
		tickets = scan.nextInt();
		return tickets;
	}
	
	public int prefOptions() {
		int option;
		System.out.println("�������� �����ϼ���.\n1. ���� (���� ���� �ڵ�ó��)\n"
				+ "2. �����\n"
				+ "3. ����������\n"
				+ "4. ���ڳ�\n"
				+ "5. �ӻ��\n");
		option = scan.nextInt();
		
		return option;
	}
	
}
