package ParkTicketing;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class OutputClass {
	private Scanner scan = null;
	public RunCalculator run = null;
	Calendar cal = null;
	SimpleDateFormat sdt = null;
	public OutputClass() throws IOException {
		scan = new Scanner(System.in);
		run = new RunCalculator();
		cal = Calendar.getInstance();
		sdt = new SimpleDateFormat("yyyyMMdd");
	}
	
	
	public void printPrice(int finalPrice) {
		
		System.out.printf("가격은 %d원 입니다.\n감사합니다.\n", finalPrice);
	}
	
	public void printError() {
		System.out.println("잘못 입력하셨습니다");
	}
	
	
	public String printAgeCohort(int age) {
		String type = "";
		if (age >= 65) {
			type = ConstValueClass.cohort_ELDERLY; // 노인
		} else if (age < 65 && age >= 19) {
			type = ConstValueClass.cohort_ADULT; // 어른
		} else if (age < 19 && age >= 13) {
			type = ConstValueClass.cohort_TEEN; // 청소년
		} else if (age < 13 && age >= 3) {
			type = ConstValueClass.cohort_CHILD; // 어린이
		} else {
			type = ConstValueClass.cohort_INFANT + "(무료)"; // 유아(무료)
		}
		return type;
	}
	
	public void startofReceipt() {
		System.out.println("================== 폴리랜드 ==================");
	}
	
	public String receipt(int type, String ageType, int numTicket, int fee, int prefType) {
		String ticketType = "";
		if (type == 1) {
			ticketType = ConstValueClass.DAYPASS; // 주간권
		} else if (type == 2) {
			ticketType = ConstValueClass.NIGHTPASS; // 야간권
		}
		
		String pref = "";
		if (prefType == ConstValueClass.type_NoPref) {
			pref = "우대적용 없음";
		} else if (prefType == ConstValueClass.type_Disabled) {
			pref = "장애인 우대적용";
		} else if (prefType == ConstValueClass.type_NatMerit) {
			pref = "국가유공자 우대적용";
		} else if (prefType == ConstValueClass.type_ManyKids) {
			pref = "다자녀 우대적용";
		} else if (prefType == ConstValueClass.type_Pregnant) {
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
	

	public void printSellingData(int sellbyType[][]) {
		System.out.printf("\n================== 권종 별 판매현황 ==================\n");
		System.out.printf("주간권 총 %s매\n", sellbyType[0][0]);
		System.out.printf("유아 %s매, 어린이 %s매, 청소년 %s매, 어른 %s매, 노인 %s매\n",
				sellbyType[0][1], sellbyType[0][2], sellbyType[0][3], sellbyType[0][4], sellbyType[0][5]);
		System.out.printf("주간권 매출 : %s원\n\n", sellbyType[0][6]);
		System.out.printf("야간권 총 %s매\n", sellbyType[1][0]);
		System.out.printf("유아 %s매, 어린이 %s매, 청소년 %s매, 어른 %s매, 노인 %s매\n",
				sellbyType[1][1], sellbyType[1][2], sellbyType[1][3], sellbyType[1][4], sellbyType[1][5]);
		System.out.printf("야간권 매출 : %s원\n", sellbyType[1][6]);
		System.out.printf("----------------------------------------------------");
	}
	

}
