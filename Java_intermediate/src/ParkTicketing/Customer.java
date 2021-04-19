package ParkTicketing;

public class Customer {

	private int ticketType = 0;
	private int type_ageCohort = 0;
	private int numTickets = 0;
	private int ticketPrice = 0;
	private int prefType = 0;
	private String ticketName = "";
	private String ageCohort = "";
	private String prefOption = "";
	private String date = "";
	
	public int getTicketType() {
		return ticketType;
	}
	
	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}
	
	public int getAgeCohortType() {
		return type_ageCohort;
	}
	
	public void setAgeCohortType(int type_ageCohort) {
		this.type_ageCohort = type_ageCohort;
	}
	
	public int getNumTickets() {
		return numTickets;
	}
	
	public void setNumTickets(int numTickets) {
		this.numTickets = numTickets;
	}
	
	public int getTicketPrice() {
		return ticketPrice;
	}
	
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public int getPrefType() {
		return prefType;
	}
	
	public void setPrefType(int prefType) {
		this.prefType = prefType;
	}
	
	public String getTicketName() {
		return ticketName;
	}
	
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public String getAgeCohort() {
		return ageCohort;
	}
	
	public void setAgeCohort(String ageCohort) {
		this.ageCohort = ageCohort;
	}
	
	public String getPrefOption() {
		return prefOption;
	}
	
	public void setPrefOption(String prefOption) {
		this.prefOption = prefOption;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
		
}
