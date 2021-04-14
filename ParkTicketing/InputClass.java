package ParkTicketing;

import java.util.Scanner;

public class InputClass {
	private Scanner scan = null;
	
	public InputClass() {
		scan = new Scanner(System.in);
	}
	
	public int ticketType() {
		int type;
		System.out.println("권종을 선택하세요.\n1. 주간권\n2. 야간권");
		type = scan.nextInt();
		
		return type;
				
	}
	
	public String numID() {
		String idNumber;
		System.out.println("주민번호 앞7자리를 입력하세요(공백, - 없이 숫자만 입력)\n");
		idNumber = scan.next();
		return idNumber;
	}
	
	public int numTickets() {
		int tickets;
		System.out.println("몇장 발권하시겠습니까? (최대 10장)\n");
		tickets = scan.nextInt();
		return tickets;
	}
	
	public int prefOptions() {
		int option;
		System.out.println("우대사항을 선택하세요.\n1. 없음 (나이 우대는 자동처리)\n"
				+ "2. 장애인\n"
				+ "3. 국가유공자\n"
				+ "4. 다자녀\n"
				+ "5. 임산부\n");
		option = scan.nextInt();
		
		return option;
	}
	
}
