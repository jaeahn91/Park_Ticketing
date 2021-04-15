package ParkTicketing;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int type = 0;
		int numTicket = 0;
		int prefType = 0;
		int age = 0;
		int fee = 0;
		int dcFee = 0;
		int totalfee = 0;
		int nextRound = 0;
		int exitproceed = 0;
		String idNumber;
		String ageType;
		String transaction = "";
		
		InputClass inputclass = new InputClass();
		RunCalculator run = new RunCalculator();
		OutputClass outclass = new OutputClass();
		
		while(true) {
	
			type = inputclass.ticketType();
			idNumber = inputclass.numID();
			numTicket = inputclass.numTickets();
			prefType = inputclass.prefOptions();
			
			age = run.ageCal(idNumber);
			fee = run.feeCal(type, age);
			dcFee = run.prefCal(fee, prefType);
			dcFee = numTicket * dcFee;
			ageType = outclass.ageType(age);
	
			outclass.printPrice(dcFee);
			
			totalfee += dcFee;
			transaction += outclass.receipt(type, ageType, numTicket, dcFee, prefType);
			
			nextRound = outclass.nextRound();
			
			if (nextRound == 2) {
				outclass.startofReceipt();
				System.out.println(transaction);
				outclass.receiptTotal(totalfee);
				outclass.endofReceipt();
				exitproceed = outclass.exitorProceed();
				transaction = "";
				totalfee = 0;
				if (exitproceed == 2) {
					break;
				} 
			} 
			
		}

	}

}
