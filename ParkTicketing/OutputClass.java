package ParkTicketing;

import java.util.Scanner;

public class OutputClass {
	private Scanner scan = null;
		
	public OutputClass() {
		scan = new Scanner(System.in);
	}
	public void printPrice(int finalPrice) {
		
		System.out.printf("가격은 %d원 입니다.\n감사합니다.\n", finalPrice);
	}
	
	public void printError() {
		System.out.println("잘못 입력하셨습니다");
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
	
	public String ageType(int age) {
		String type;
		if (age >= 65) {
			type = "경로";
		} else if (age < 65 && age >= 19) {
			type = "대인";
		} else if (age < 19 && age >= 13) {
			type = "청소년";
		} else if (age < 13 && age >= 3) {
			type = "소인";
		} else {
			type = "유아(무료)";
		}
		return type;
	}
	
	public void startofReceipt() {
		System.out.println("================== 폴리랜드 ==================");
	}
	
	public String receipt(int type, String ageType, int numTicket, int fee, int prefType) {
		String ticketType = "";
		if (type == 1) {
			ticketType = "주간권";
		} else if (type == 2) {
			ticketType = "야간권";
		}
		
		String pref = "";
		if (prefType == 1) {
			pref = "우대적용 없음";
		} else if (prefType == 2) {
			pref = "장애인 우대적용";
		} else if (prefType == 3) {
			pref = "국가유공자 우대적용";
		} else if (prefType == 4) {
			pref = "다자녀 우대적용";
		} else if (prefType == 5) {
			pref = "임산부 우대적용";
		}
		
		String transaction = String.format("%s %s X %d %d원 *%s\n", 
				ticketType, ageType, numTicket, fee, pref);
		
		return transaction;
	}
	
	public void receiptTotal(int totalFee) {
		System.out.println();
		System.out.printf("입장료 총액은 %d원 입니다\n", totalFee);
	}
	
	public void endofReceipt() {
		System.out.println("==============================================\n");
	}
}
