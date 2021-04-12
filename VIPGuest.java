package hotel;

import java.time.LocalDate;

public class VIPGuest extends Guest {

	private LocalDate VIPstartDate;
	private LocalDate VIPexpiryDate;
	
	public VIPGuest(LocalDate VIPstartDate, LocalDate VIPexpiryDate) {
		this.VIPstartDate = VIPstartDate;
		this.VIPexpiryDate = VIPexpiryDate;
	}
	
	public LocalDate getVIPstartDate() {
		return VIPstartDate;
	}
	
	public LocalDate getVIPexpiryDate() {
		return VIPexpiryDate;
	}
}

