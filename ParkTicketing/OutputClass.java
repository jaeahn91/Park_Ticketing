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
		
		System.out.printf("������ %d�� �Դϴ�.\n�����մϴ�.\n", finalPrice);
	}
	
	public void printError() {
		System.out.println("�߸� �Է��ϼ̽��ϴ�");
	}
	
	
	public String printAgeCohort(int age) {
		String type = "";
		if (age >= 65) {
			type = ConstValueClass.cohort_ELDERLY; // ����
		} else if (age < 65 && age >= 19) {
			type = ConstValueClass.cohort_ADULT; // �
		} else if (age < 19 && age >= 13) {
			type = ConstValueClass.cohort_TEEN; // û�ҳ�
		} else if (age < 13 && age >= 3) {
			type = ConstValueClass.cohort_CHILD; // ���
		} else {
			type = ConstValueClass.cohort_INFANT + "(����)"; // ����(����)
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
		if (prefType == ConstValueClass.type_NoPref) {
			pref = "������� ����";
		} else if (prefType == ConstValueClass.type_Disabled) {
			pref = "����� �������";
		} else if (prefType == ConstValueClass.type_NatMerit) {
			pref = "���������� �������";
		} else if (prefType == ConstValueClass.type_ManyKids) {
			pref = "���ڳ� �������";
		} else if (prefType == ConstValueClass.type_Pregnant) {
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
	
	public void saveFile(ArrayList<Customer> csInfoArr) throws IOException {
		// ��¥,����,���ɱ���,����,����,������ 
		// ex)20210415,�ְ���,����,1,56000,����
		BufferedWriter bw = new BufferedWriter
				(new OutputStreamWriter(new FileOutputStream(ConstValueClass.savePATH, true), "MS949"));
		
		String text = "";
		for (int i = 0; i < csInfoArr.size(); i++) {
			Customer info = csInfoArr.get(i);
			text += info.getDate() +"," +info.getTicketType() + "," + info.getAgeCohortType()
					+"," + info.getNumTickets() +"," + info.getTicketPrice() +"," +info.getPrefType() + "\n";
			bw.write(text);
			text = "";
		}
		bw.close();
	}
	
	public void printSellingData(int sellbyType[][]) {
		System.out.printf("\n================== ���� �� �Ǹ���Ȳ ==================\n");
		System.out.printf("�ְ��� �� %s��\n", sellbyType[0][0]);
		System.out.printf("���� %s��, ��� %s��, û�ҳ� %s��, � %s��, ���� %s��\n",
				sellbyType[0][1], sellbyType[0][2], sellbyType[0][3], sellbyType[0][4], sellbyType[0][5]);
		System.out.printf("�ְ��� ���� : %s��\n\n", sellbyType[0][6]);
		System.out.printf("�߰��� �� %s��\n", sellbyType[1][0]);
		System.out.printf("���� %s��, ��� %s��, û�ҳ� %s��, � %s��, ���� %s��\n",
				sellbyType[1][1], sellbyType[1][2], sellbyType[1][3], sellbyType[1][4], sellbyType[1][5]);
		System.out.printf("�߰��� ���� : %s��\n", sellbyType[1][6]);
		System.out.printf("----------------------------------------------------");
	}
	

}
