package hotel;
import java.time.LocalDate;

public class Payment {
	
	private LocalDate date;
	private int guestID;
	private double amount;
	private	String payReason;
	
	public Payment(LocalDate date, int guestID, double amount, String payReason) {
		this.date = date;
		this.guestID = guestID;
		this.amount = amount;
		this.payReason = payReason;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public int getGuestID() {
		return guestID;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getPayReason() {
		return payReason;
	}
}
