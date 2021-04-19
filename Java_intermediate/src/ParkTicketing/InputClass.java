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
		System.out.println("권종을 선택하세요.\n1. 주간권\n2. 야간권");
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
		System.out.println("주민번호 앞7자리를 입력하세요(공백, - 없이 숫자만 입력)");
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
		System.out.println("몇장 발권하시겠습니까? (최대 10장)");
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
		System.out.println("우대사항을 선택하세요.\n1. 없음 (나이 우대는 자동처리)\n"
				+ "2. 장애인\n"
				+ "3. 국가유공자\n"
				+ "4. 다자녀\n"
				+ "5. 임산부");
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
		System.out.printf("계속 발권하시겠습니까?\n1: 티켓 발권\n2: 종료\n");
		nextRound = scan.nextInt();
		return nextRound;
	}

	public int exitorProceed() {
		int exitproceed;
		System.out.printf("계속 진행(1: 새로운 주문, 2: 프로그램 종료) : ");
		exitproceed = scan.nextInt();
		return exitproceed;
	}
	
}
