package hotel;
import java.time.*;
import java.util.*;
import java.io.*;

public class HotelImpl implements Hotel {
	
	/*
	* Constructor
	*/
	
	public HotelImpl(String roomsTxtFileName, String guestsTxtFileName, String bookingsTxtFileName, String paymentsTxtFileName) {

	// Your code to load all the data from the four files
		importRoomsData(roomsTxtFileName);
		importGuestsData(guestsTxtFileName);
		importBookingsData(bookingsTxtFileName);
		importPaymentsData(paymentsTxtFileName);
	}

	/*
	* Attributes
	*/
	
	private ArrayList<Room> rooms = new ArrayList<Room>();
	private ArrayList<Guest> guests = new ArrayList<Guest>();
	private ArrayList<Booking> bookings = new ArrayList<Booking>();
	private ArrayList<Payment> payments = new ArrayList<Payment>();
	
	/*
	* Interface Methods
	*/
	
	public boolean importRoomsData(String roomsTxtFileName) {
		
		ArrayList<String> roomList = readFile(roomsTxtFileName);
		
        for (String info : roomList) { 
            String[] splitArray = info.split(",");
            rooms.add(
                new Room(
                    Integer.valueOf(splitArray[0]), roomTypeEnum(splitArray[1]), Double.valueOf(splitArray[2]),
                    Integer.valueOf(splitArray[3]), splitArray[4] 
                )
            );
        }        
        if (roomList.size() != rooms.size()) {
        	return false;
        } else {
        	return true;
        }
	}

	public boolean importGuestsData(String guestsTxtFileName) {
		
		ArrayList<String> guestList = readFile(guestsTxtFileName);
		
		for (String info : guestList) {
			String[] splitArray = info.split(",");
			if (splitArray.length == 6) { // Split array will contain six elements if the guest is VIP
				guests.add(
					new Guest(
						Integer.valueOf(splitArray[0]), splitArray[1], splitArray[2], LocalDate.parse(splitArray[3]),
						LocalDate.parse(splitArray[4]), LocalDate.parse(splitArray[5])
					)
				);
			} else {
				guests.add(
					new Guest(
						Integer.valueOf(splitArray[0]), splitArray[1], splitArray[2], LocalDate.parse(splitArray[3])
					)
				);
			}
				
		}
        if (guestList.size() != guests.size()) {
        	return false;
        } else {
        	return true;
        }
	}
	
	public boolean importBookingsData(String bookingsTxtFileName) {
		
		ArrayList<String> bookingList = readFile(bookingsTxtFileName);
		
        for (String info : bookingList) { 
            String[] splitArray = info.split(",");
            bookings.add(
                new Booking(
                    Integer.valueOf(splitArray[0]), Integer.valueOf(splitArray[1]), Integer.valueOf(splitArray[2]),
                    LocalDate.parse(splitArray[3]), LocalDate.parse(splitArray[4]), LocalDate.parse(splitArray[5]),
                    Double.valueOf(splitArray[6])
                )
            );
        }
        if (bookingList.size() != bookings.size()) {
        	return false;
        } else {
        	return true;
        }
	}
	
	
	public boolean importPaymentsData(String paymentsTxtFileName) {
		
		ArrayList<String> paymentList = readFile(paymentsTxtFileName);
		
		for ( String info : paymentList) {
			String[] splitArray = info.split(",");
			payments.add(
				new Payment(
					LocalDate.parse(splitArray[0]), Integer.valueOf(splitArray[1]), Double.valueOf(splitArray[2]),
					splitArray[3]
				)
			);
		}
        if (paymentList.size() != payments.size()) {
        	return false;
        } else {
        	return true;
        }
	}
	
	public void displayAllRooms() {
        for (Room i: rooms){ 
            System.out.printf(
                "Room Number: %d%nRoom Type: %s%nPrice: %.2f%nCapacity: %d%nFacilities: %s%n%n", 
                i.getRoomNumber(), i.getRoomType(), i.getPrice(), i.getCapacity(), i.getFacilities()
            );
        }
	}
	
	public void displayAllGuests() {
		for (Guest i: guests){  
            System.out.printf(
                "Guest ID: %d%nFirst Name: %s%nLast Name: %s%nDate Joined: %s%nVIP Start Date: %s%n"
                + "VIP Expiry Date: %s%n%n",
                i.getGuestID(), i.getFName(), i.getLName(), i.getDateJoin(), i.getVIPstartDate(),
                i.getVIPexpiryDate()
            );
        }
	}
	
	public void displayAllBookings() {
		for (Booking i: bookings) {
			System.out.printf(
				"ID: %d%nGuest ID: %d%nRoom Number: %d%nBooking Date: %s%nCheckin Date: %s%n"
				+ "Checkout Date: %s%nTotal Amount: %.2f%n%n", 
	            i.getId(), i.getGuestID(), i.getRoomNumber(), i.getBookingDate(), i.getCheckinDate(),
	            i.getCheckoutDate(), i.getTotalAmount()
	        );
		}
	}
	
	public void displayAllPayments() {
		for (Payment i: payments){  
            System.out.printf(
                "Date: %s%nGuest ID: %d%nAmount: %.2f%nPay Reason: %s%n%n", 
                i.getDate(), i.getGuestID(), i.getAmount(), i.getPayReason()
            );
        }
	}
	
	public boolean addRoom(int roomNumber, RoomType roomType, double price, int capacity, String facilities) {
		
		for(Room i: rooms) {
			if( i.getRoomNumber() == roomNumber) {
				assert i.getRoomNumber() == roomNumber: "Room " +i.getRoomNumber()+ " can actually be added";
				return false;
			}
		}
		rooms.add(new Room(roomNumber, roomType, price, capacity, facilities));
		return true;
	}
	
	public boolean removeRoom(int roomNumber) {
		
		int roomsSize = rooms.size();
		
		for (Booking i: bookings) {
			if (i.getRoomNumber() == roomNumber && i.getCheckoutDate().isAfter(LocalDate.now())) {
				//System.out.println("Cannot remove room " +roomNumber+ " as it has a booking in the future");
				return false;
			}
		}
		for (Iterator<Room>i = rooms.iterator(); i.hasNext(); ) {
			Room value = i.next();
			if (value.getRoomNumber() == roomNumber) {
				i.remove();
			}
		}
		
		assert roomsSize - 1 == rooms.size(): "Error in room removal";
		return true;
	}
	
	public boolean addGuest(String fName, String lName, LocalDate dateJoin) {
		
		int guestsSize = guests.size();
		
		try {
			int id = guests.get(guests.size()-1).getGuestID() + 1; // adds one to previous guest ID
			guests.add(new Guest(id, fName, lName, dateJoin));
		} catch (ArrayIndexOutOfBoundsException ex) {
			guests.add(new Guest(10001, fName, lName, dateJoin)); // If the guests list contains no Guest objects
		} 
		
		if (guests.size() == guestsSize + 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addGuest(String fName, String lName, LocalDate dateJoin, LocalDate VIPstartDate, LocalDate VIPexpiryDate) {
		
		int guestsSize = guests.size();
		
		try {
			int id = guests.get(guests.size()-1).getGuestID() + 1; 
			guests.add(new Guest(id, fName, lName, dateJoin, VIPstartDate, VIPexpiryDate));
			payments.add(new Payment(LocalDate.now(), id, 50.00, "VIPmembership"));
		} catch (ArrayIndexOutOfBoundsException ex) {
			int id = guests.get(guests.size()-1).getGuestID() + 1; 
			guests.add(new Guest(id, fName, lName, dateJoin, VIPstartDate, VIPexpiryDate));
			payments.add(new Payment(LocalDate.now(), id, 50.00, "VIPmembership"));
		} 
		
		if (guests.size() == guestsSize + 1) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean removeGuest(int guestID) {
		
		int guestsSize = guests.size();
		
		for (Booking i: bookings) {
			if (i.getGuestID() == guestID && i.getCheckoutDate().isAfter(LocalDate.now())) {
				//System.out.println("Cannot remove guest with ID " +guestID+ " as the guest has a booking in the future");
				return false;
			}
		}
		for (Iterator<Guest>i = guests.iterator(); i.hasNext(); ) { 
			Guest value = i.next();
			if (value.getGuestID() == guestID) {
				i.remove();
			}
		}
		assert guests.size() == guestsSize - 1: "Error in guest removal";
		return true;
	}
	
	public boolean isAvailable(int roomNumber, LocalDate checkin, LocalDate checkout) {
		
		try {
			
			if (checkin.isAfter(checkout)) {
				throw new IllegalArgumentException("ERROR : Checkin date is after checkout date");
			}
			
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
			for (Booking i: bookings) {
				
				if (i.getRoomNumber() == roomNumber
						&& ((i.getCheckoutDate().isAfter(checkout) && i.getCheckinDate().isBefore(checkin))
						|| (i.getCheckinDate().isBefore(checkout) && i.getCheckoutDate().isAfter(checkout))
						|| (i.getCheckinDate().isBefore(checkin) && i.getCheckoutDate().isAfter(checkin))
						|| (i.getCheckinDate().isAfter(checkin) && i.getCheckoutDate().isBefore(checkout))
						|| (i.getCheckinDate().isEqual(checkin)) || i.getCheckoutDate().isEqual(checkout)))
				{	
					System.out.println("unavailable");
					return false;
				}
			}
			System.out.println("available");
			return true;
			
	}
	
	public int[] availableRooms(RoomType roomType, LocalDate checkin, LocalDate checkout) {
		
		ArrayList<Integer> freeRoomsList = new ArrayList<Integer>();
		//if checkin date is before checkout, it will be caught since isAvailable() is called.
		
		for (Room it: rooms) {
			if (it.getRoomType().equals(roomType)) {
				if (isAvailable(it.getRoomNumber(), checkin, checkout)) {
					if (freeRoomsList.contains(it.getRoomNumber())) {
						continue;
					} else {
						freeRoomsList.add(it.getRoomNumber());
					}
				}
			}
		}
		int[] freeRooms = freeRoomsList.stream().mapToInt(i -> i).toArray();		
		return freeRooms;
		
	}
	
	public int bookOneRoom(int guestID, RoomType roomType, LocalDate checkin, LocalDate checkout) { 
		
		try {
			
			if (checkin.isAfter(checkout)) {
				throw new IllegalArgumentException("ERROR : Checkin date is after checkout date");
			}
			boolean isGuest = false;
			for (Guest i: guests) {
				if (i.getGuestID() == guestID) {
					isGuest = true;
				} 
			}
			if (!isGuest) {
				throw new IllegalArgumentException("ERROR : Guest ID doesn't exist");
			}
			
			
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			return -1;
		}
		
		int[] emptyRooms = availableRooms(roomType, checkin, checkout);
		if (emptyRooms.length == 0) {
			//System.out.println("No rooms available to book");
			return -1;
		}
		Random ran = new Random();
		int x = ran.nextInt(emptyRooms.length);
		int bookingRoomNumber = emptyRooms[x];
		int id = bookings.get(bookings.size()-1).getId() + 1;
		double days = daysBetween(checkin, checkout);
		double amount = 0;
		for (Room i: rooms) {
			if (i.getRoomNumber() == bookingRoomNumber) {
				amount = i.getPrice() * days;
			}
		}
		if (isVIPValid(guestID, LocalDate.now())) {
			amount *= 0.9;
		}
		
		payments.add(new Payment(LocalDate.now(), guestID, amount, "booking"));
		
		bookings.add(new Booking(id, guestID, bookingRoomNumber, LocalDate.now(), checkin, checkout, amount));
		return bookingRoomNumber;
	}
	
	public boolean checkOut(int bookingID, LocalDate actualCheckoutDate) {
		//think about scenario
		for (Iterator<Booking>i = bookings.iterator(); i.hasNext(); ) {
			Booking value = i.next();
			if (bookingID == value.getId()) {
				if (actualCheckoutDate.isAfter(value.getCheckoutDate()) || actualCheckoutDate.isBefore(value.getCheckinDate())) {
					System.out.println("Cannot Checkout"); //maybe delete
					return false;
				} else {
					i.remove();
				}
			}
		}
		return true;
	}
	
	public boolean cancelBooking(int bookingID) {
		
		for(Iterator<Booking>i = bookings.iterator(); i.hasNext(); ) {
			Booking value = i.next();
			if(bookingID == value.getId()) {
				Period daysBetween = LocalDate.now().until(value.getCheckinDate());
				int days = daysBetween.getDays();
				if(days > 2) {
					payments.add(new Payment(LocalDate.now(), value.getGuestID(), value.getTotalAmount(), "refund"));
					i.remove();
					return true;
				} else {          // see if can simplify. ALso booleon return will need to be a tester
					i.remove();   // make it able to deal with certain cases
					return true;
				}
			}
		}
		return false;
	}
	
	public int [] searchGuest(String firstName, String lastName) {
		
		ArrayList<Integer> searchedGuests = new ArrayList<Integer>();
		
		for(Guest i: guests) {
			if (firstName.equals(i.getFName()) && lastName.equals(i.getLName())) { //think about case
				searchedGuests.add(i.getGuestID());
				displayGuestBooking(i.getGuestID());
			}
		}
		
		int[] foundGuests = searchedGuests.stream().mapToInt(i -> i).toArray();
		
		return foundGuests;
	}
	
	public void displayGuestBooking(int guestID) {
			
		for (Booking i: bookings) {
			if (i.getGuestID() == guestID) {
				System.out.println("ID: " +i.getId());//check spelling of method
				System.out.println("Guest ID: " +i.getGuestID());
				System.out.println("Room Number " +i.getRoomNumber());
				System.out.println("Booking Date: " +i.getBookingDate());
				System.out.println("Checkin Date: " +i.getCheckinDate());
				System.out.println("Checkout Date: " +i.getCheckoutDate());
				System.out.println("Total Amount: " +i.getTotalAmount());
				System.out.println("");
			}
		}
		
	}
	
	public void displayBookingsOn(LocalDate thisDate) {
		
		ArrayList<Booking> bookingOnDate = new ArrayList<Booking>();
		for(Booking i: bookings) {
			if (thisDate.isBefore(i.getCheckoutDate()) && thisDate.isAfter(i.getCheckinDate())) {
				bookingOnDate.add(i);
			}
		}
		for(Booking iBooking: bookingOnDate) {
			System.out.println("Booking ID: " +iBooking.getId());
			for(Guest iGuest: guests) {
				if(iBooking.getGuestID() == iGuest.getGuestID()) {
					System.out.println("Guest Name: " +iGuest.getFName()+ " " +iGuest.getLName());
				}
			}
			for(Room iRoom: rooms) {
				if(iBooking.getRoomNumber() == iRoom.getRoomNumber()) {
					System.out.println("Room Number: " +iRoom.getRoomNumber());
					System.out.println("Room Type: " +iRoom.getRoomType());
					double days = daysBetween(iBooking.getCheckinDate(), iBooking.getCheckoutDate());
					double roomPrice = days * iRoom.getPrice();
					System.out.println("Room Price: " +roomPrice);
				}
			}
			System.out.println("Payment Price " +iBooking.getTotalAmount());
			System.out.println("");
		}
	}
	
	public void displayPaymentsOn(LocalDate thisDate) {
		
		for(Payment i: payments) {
			if(i.getDate().equals(thisDate)) {
				System.out.println("Guest ID: " +i.getGuestID());
				System.out.println("Payment Amount: " +i.getAmount());
				System.out.println("Payment Reason: " +i.getPayReason());
				System.out.println("");
			}
		}
	}
	
	public boolean saveRoomsData(String roomsTxtFileName) {
		
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(roomsTxtFileName));
            
            for (Room i : rooms){
                bufferedWriter.write(
                    i.getRoomNumber() + "," + i.getRoomType() + "," + 
                    i.getPrice() + "," + i.getCapacity()+ "," + 
                    i.getFacilities()
                );
                bufferedWriter.newLine();
                
            }
            bufferedWriter.close();
            
        } catch(IOException ex){
            System.out.println("Unable to save data");
        }
        
		return true;
	}
	
	public boolean saveGuestsData(String guestsTxtFileName) {
		
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(guestsTxtFileName));
            
            for (Guest i : guests){
                	if (isVIPValid(i.getGuestID(), LocalDate.now())) {
                		bufferedWriter.write(
		                    i.getGuestID() + "," + i.getFName() + "," + 
		                    i.getLName() + "," + i.getDateJoin()+ "," + 
		                    i.getVIPstartDate() + "," + i.getVIPexpiryDate());
                	} else {
                		bufferedWriter.write(
	                		i.getGuestID() + "," + i.getFName() + "," + 
	                		i.getLName() + "," + i.getDateJoin());
                	}
               
                bufferedWriter.newLine();
       
            }
            bufferedWriter.close();
            
        } catch(IOException ex){
            System.out.println("Unable to save data");
        }
        
		return true;
	}
	
	public boolean saveBookingsData(String bookingsTxtFileName) {
		
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(bookingsTxtFileName));
            
            for (Booking i : bookings){
                bufferedWriter.write(
                    i.getId() + "," + i.getGuestID() + "," + 
                    i.getRoomNumber() + "," + i.getBookingDate()+ "," + 
                    i.getCheckinDate() + "," + i.getCheckoutDate() + "," + i.getTotalAmount()
                );
                bufferedWriter.newLine();
                
            }
            bufferedWriter.close();
            
        } catch(IOException ex){
            System.out.println("Unable to save data");
        }
		return true;
	}

	public boolean savePaymentsData(String paymentsTxtFileName) {
		
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(paymentsTxtFileName));
            
            for (Payment i : payments){
                bufferedWriter.write(
                    i.getDate() + "," + i.getGuestID() + "," + 
                    i.getAmount() + "," + i.getPayReason()
                );
                bufferedWriter.newLine();
                
            }
            bufferedWriter.close();
            
        } catch(IOException ex){
            System.out.println("Unable to save data");
        }
		return true;
	}
		
	/*
	* Other methods

	*/
	
	private ArrayList<String> readFile(String file) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line = bufferedReader.readLine();
				
			while(line != null) {
				list.add(line);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
				
			} catch (FileNotFoundException ex) {
				System.out.println(ex.getMessage());
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			} 
		
		return list;
	}
	
	
	public String roomTypeString(RoomType type) { // May not need check!
		
		if (type.equals(RoomType.SINGLE)) {
			return "single";
		} else if (type.equals(RoomType.DOUBLE)) {
			return "double";
		} else if (type.equals(RoomType.FAMILY)) {
			return "family";
		} else {
			return "twin";
		}
	}
	
	
	public RoomType roomTypeEnum(String type) { // change to switch statments
		
		if (type.equals("single")) {
			return RoomType.SINGLE;
		} else if (type.equals("double")) {
			return RoomType.DOUBLE;
		} else if (type.equals("family")) {
			return RoomType.FAMILY;
		} else if (type.contentEquals("twin")) {
			return RoomType.TWIN;
		} else {
			return RoomType.SINGLE; //put assert in here maybe
		}
	}
	
	public boolean isVIPValid(int guestID, LocalDate date) {
		
		for (Guest i: guests) {
			if (i.getGuestID() == guestID) {
				if (i.getVIPstartDate() != null) {
					if (date.isAfter(i.getVIPstartDate()) && date.isBefore(i.getVIPexpiryDate())) {
						//maybe assert number of attributes
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public double daysBetween(LocalDate firstDate, LocalDate secondDate) {
		
		Period daysBetween = firstDate.until(secondDate);
		double days = daysBetween.getDays();  // maybe put into function
		return days;
	}
}