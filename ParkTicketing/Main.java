package ParkTicketing;

import java.util.Scanner;

public class Main {

	public static int nextRound;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int type = 0;
		String idNumber;
		int tickets = 0;
		int option = 0;
		int age = 0;
		int fee = 0;
		int dcFee = 0;
		do {
		InputClass inputclass = new InputClass();
		
		RunCalculator run = new RunCalculator();
		type = inputclass.ticketType();
		idNumber = inputclass.numID();
		tickets = inputclass.numTickets();
		option = inputclass.prefOptions();
		
		age = run.ageCal(idNumber);
		fee = run.feeCal(type, age);
		dcFee = run.prefCal(fee, option);
		dcFee = tickets * dcFee;
		
		OutputClass outclass = new OutputClass();
		outclass.printPrice(dcFee);
		
		nextRound = outclass.nextRound();
		} while (nextRound == 1);
		

	}

}
