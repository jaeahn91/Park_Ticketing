package ParkTicketing;

import java.io.IOException;
import java.util.Scanner;



public class Main {

	public static int type, numTickets, prefType, age, type_ageCohort, fee, fee_ActuallyPaid;
	public static int totalfee, nextRound, exitproceed;
	public static String idNumber, ageCohort, transaction;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		InputClass inputclass = new InputClass();
		RunCalculator run = new RunCalculator();
		OutputClass outclass = new OutputClass();

//		ReadCSV read = new ReadCSV();
		int sellbyType [][]; // 권종별 판매내역 저장


			while(true) {
		
				type = inputclass.ticketType();
				idNumber = inputclass.numID();
				
				numTickets = inputclass.numTickets();
				
				prefType = inputclass.prefOptions();
				
				age = run.ageCal(idNumber);
				type_ageCohort = run.type_AgeCohort(age);
				fee = run.feeCal(type, age);
				fee_ActuallyPaid = run.prefCal(fee, prefType);
				fee_ActuallyPaid = numTickets * fee_ActuallyPaid;
				ageCohort = outclass.printAgeCohort(age);
		
				outclass.printPrice(fee_ActuallyPaid);
				
				totalfee += fee_ActuallyPaid;
				run.savingFormat(type, age, numTickets, fee_ActuallyPaid, prefType, ConstValueClass.csInfoArr);
				transaction += outclass.receipt(type, ageCohort, numTickets, fee_ActuallyPaid, prefType);
				

				nextRound = inputclass.nextRound();
				
				if (nextRound == 2) {
					outclass.startofReceipt();
					System.out.println(transaction);
					outclass.receiptTotal(totalfee);
					outclass.endofReceipt();
					exitproceed = inputclass.exitorProceed();
					transaction = "";
					totalfee = 0;
					if (exitproceed == 2) {
						outclass.saveFile(ConstValueClass.csInfoArr);

						break;
					} 
	
				} 				

			} 
		} 
		
//		sellbyType = read.parseTicketData();
//		outclass.printSellingData(sellbyType);

//	}

}
