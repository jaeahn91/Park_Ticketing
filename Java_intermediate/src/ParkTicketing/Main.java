package ParkTicketing;

import java.io.IOException;
import java.util.Scanner;



public class Main {

	public static int type, numTickets, prefType, age, type_ageCohort, fee, fee_ActuallyPaid;
	public static int totalfee, nextRound, exitproceed;
	public static String idNumber, ageCohort, transaction;
	public static void main(String[] args) throws IOException {
		
		InputClass inputclass = new InputClass();
		RunCalculator run = new RunCalculator();
		OutputClass outclass = new OutputClass();
		
//		ReadCSV read = new ReadCSV(); // ���� ����м��� Ȱ���� Ŭ����. ����м���� ���� �̱���
		
		int sellbyType [][]; // ������ �Ǹų��� ����, ���� ����м��� Ȱ��
		
		while(true) {
			type = inputclass.ticketType(); // ��/�߰��� ���� �Է¹ޱ�
			idNumber = inputclass.numID(); // �ֹι�ȣ 7�ڸ� �Է¹ޱ� 
			numTickets = inputclass.numTickets(); // �߱� ��� Ƽ�� ��� �Է¹ޱ�
			prefType = inputclass.prefOptions(); // ������ �Է¹ޱ�
			
			age = run.ageCal(idNumber); // �Է¹��� �ֹι�ȣ�� ���̸� ����� age�� ����
			type_ageCohort = run.type_AgeCohort(age); // ���� ���̸� �̿��� ������ ����
			fee = run.feeCal(type, age); // ������ ���̸� �̿��� ��� ���
			fee_ActuallyPaid = run.prefCal(fee, prefType); // ��뿩�� Ȯ���� �������� �ݾ� ����
			fee_ActuallyPaid = numTickets * fee_ActuallyPaid; // �������� �ݾ׿� �߱� ����� ���� �����ұݾ� ���			
			ageCohort = outclass.printAgeCohort(age); // ���ɱ��� ��°���� ��Ʈ�������� ����
			
			outclass.printPrice(fee_ActuallyPaid); // �����ұݾ� �ȳ� �޽��� �ֿܼ� ���
			
			totalfee += fee_ActuallyPaid; // �����ұݾ��� int������ ����, �߱��� �������� �̷����� ��쿡�� ���
			// �����ϵ��� ó��			
			run.savingFormat(type, age, numTickets, fee_ActuallyPaid, prefType, ConstValueClass.csInfoArr);
			// ���� ���� �޼ҵ忡�� ������ �ڷᱸ���� �µ��� �Է� ������ ����
			// ���������δ� ConstValueClass�� savePATH�� ����, OutputClass�� saveFile �޼ҵ忡�� ȣ��
			transaction += outclass.receipt(type,  ageCohort, numTickets, fee_ActuallyPaid, prefType);			
			// �ֿܼ� ������ �ŷ����� ��� �޼ҵ� ���Ŀ� �°� �Է� ������ ����, ��Ʈ�������� ���� ����
			// �ֿܼ� ������ ����غ��� ù��° �ŷ����� type(����) �տ� null�پ� ��µǴ� ����. ���� ���� �ȵ� 
			
			nextRound = inputclass.nextRound(); // ���� �߱����� ���� Ȯ���ϴ� �޼ҵ�(1: Ƽ�Ϲ߱� 2: ����)
			
			if (nextRound == 2) { // 2�� �Է¹��� ���(��� �߱� ����)
				outclass.startofReceipt(); // ������ ù �� ��� �޼ҵ�
				System.out.println(transaction); // �ŷ����� ���		
				outclass.receiptTotal(totalfee); // ����� �Ѿ��� _�� �Դϴ�
				outclass.endofReceipt(); // ������ �������� ���
				exitproceed = inputclass.exitorProceed(); // ���������� �ֿܼ� ��µ� �� ���� �۾� Ȯ���ϴ� �޼ҵ�
				// 1(���ο� �ֹ�) 2(���α׷� ����)
				transaction = ""; // ���� �������� ��µ����� �ٽ� �ŷ����� �ʱ�ȭ
				totalfee = 0; // ����� �Ѿ� �ʱ�ȭ
				if (exitproceed == 2) { // ���α׷� ���Ḧ �����ߴٸ�
					outclass.saveFile(ConstValueClass.csInfoArr); // ���Ͽ� �Ǹų��� ����
					break; // while���� �����������ν� ���α׷� ����
				}
			}
			
		}
	}
}
