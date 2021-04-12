package hotel;
import java.time.LocalDate;

public class Booking {
	
	private int id;
	private int guestID;
	private int roomNumber;
	private LocalDate bookingDate;
	private LocalDate checkinDate;
	private LocalDate checkoutDate;
	private double totalAmount;
	
	public Booking(int id, int guestID, int roomNumber, LocalDate bookingDate, LocalDate checkinDate,
			LocalDate checkoutDate, double totalAmount) {
		this.id = id;
		this.guestID = guestID;
		this.roomNumber = roomNumber;
		this.bookingDate = bookingDate;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.totalAmount = totalAmount;
	}
	
	public int getId() {
		return id;
	}
	
	public int getGuestID() {
		return guestID;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	
	public LocalDate getCheckinDate() {
		return checkinDate;
	}
	
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}
	/*
	public String toString() {
		return "Id: "+this.id+" "
	}*/
}
