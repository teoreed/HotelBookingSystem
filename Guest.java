package hotel;
import java.time.LocalDate;

public class Guest {
	
	private int guestID;
	private String fName;
	private String lName;
	private LocalDate dateJoin;
	private LocalDate VIPstartDate;
	private LocalDate VIPexpiryDate;
	
	public Guest(int guestID, String fName, String lName, LocalDate dateJoin) {
		this.guestID = guestID;
		this.fName = fName;
		this.lName = lName;
		this.dateJoin = dateJoin;
	}
	
	public Guest(int guestID, String fName, String lName, LocalDate dateJoin, 
			LocalDate VIPstartDate, LocalDate VIPexpiryDate) {
		this.guestID = guestID;
		this.fName = fName;
		this.lName = lName;
		this.dateJoin = dateJoin;
		this.VIPstartDate = VIPstartDate;
		this.VIPexpiryDate = VIPexpiryDate;
	}
	
	public int getGuestID() {
		return guestID;
	}
	
	public String getFName() {
		return fName;
	}
	
	public String getLName() {
		return lName;
	}
	
	public LocalDate getDateJoin() {
		return dateJoin;
	}
	
	public LocalDate getVIPstartDate() {
		return VIPstartDate;
	}
	
	public LocalDate getVIPexpiryDate() {
		return VIPexpiryDate;
	}
}
