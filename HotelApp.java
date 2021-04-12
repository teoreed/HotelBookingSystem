package hotel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class HotelApp {
	
	public static void main( String[] args ) {
		
		String roomFile = "/Users/Ben/eclipse-workspace/CA/data/rooms.txt";
		String guestFile = "/Users/Ben/eclipse-workspace/CA/data/guests.txt";
		String bookingFile = "/Users/Ben/eclipse-workspace/CA/data/bookings.txt";
		String paymentFile = "/Users/Ben/eclipse-workspace/CA/data/payments.txt";
		HotelImpl hotel = new HotelImpl(roomFile, guestFile, bookingFile, paymentFile);
		
		
		
		System.out.println("");
		/*
		System.out.println("****************************************************");
		System.out.println("ROOMS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllRooms();
		System.out.println("****************************************************");
		System.out.println("GUESTS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllGuests();
		System.out.println("****************************************************");
		System.out.println("BOOKINGS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllBookings();
		System.out.println("****************************************************");
		System.out.println("PAYMENTS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllPayments();
		*/
		//hotel.addRoom(101, RoomType.SINGLE, 12.15, 30, "xbox360");
		//hotel.displayAllRooms();
		//hotel.addGuest(teo, reed, LocalDate.parse("2020-03-10"));
		//hotel.availableRooms(RoomType.SINGLE, lDate.parse("2020-03-57"), LocalDate.parse("2020-03-10")));
		//hotel.addGuest("Ben", "Trotter", LocalDate.now());
		//hotel.removeGuest(10006);
		//hotel.removeRoom(101);
		//int[] test = hotel.availableRooms(RoomType.SINGLE, LocalDate.parse("2020-04-02"), LocalDate.parse("2017-02-01") );
		//for (int i: test) {
		//		System.out.println(i);}
		//System.out.println(test);
		
		hotel.bookOneRoom(16, RoomType.SINGLE, LocalDate.parse("2021-02-01"), LocalDate.parse("2020-04-02"));
		//}
		//System.out.println(test);
		//hotel.bookOneRoom(10001, RoomType.DOUBLE,LocalDate.parse("2020-04-02"), LocalDate.parse("2017-02-01"));
		/*
		System.out.println("1) AVAILABLE:");
		hotel.isAvailable(301, LocalDate.parse("2019-03-07"), LocalDate.parse("2019-03-10")); // should say available
		System.out.println("");
		System.out.println("2) UNAVAILABLE:");
		hotel.isAvailable(301, LocalDate.parse("2019-03-06"), LocalDate.parse("2019-04-02")); // should say unavailable
		System.out.println("");
		System.out.println("3) UNAVAILABLE:");
		hotel.isAvailable(301, LocalDate.parse("2019-03-06"), LocalDate.parse("2019-04-10")); // should say unavailable
		System.out.println("");
		System.out.println("4)UNAVAILABLE:");
		hotel.isAvailable(301, LocalDate.parse("2019-04-05"), LocalDate.parse("2019-04-10")); // should say unavailable
		System.out.println("");
		System.out.println("5)AVAILABLE:");
		hotel.isAvailable(301, LocalDate.parse("2019-04-10"), LocalDate.parse("2019-04-13")); // should say available
		System.out.println("");
		System.out.println("6) UNAVAILABLE:");
		hotel.isAvailable(101, LocalDate.parse("2019-04-02"), LocalDate.parse("2019-04-03")); // should say unavailable
		System.out.println("");
		System.out.println("7) UNAVAILABLE:");
		hotel.isAvailable(101, LocalDate.parse("2019-04-01"), LocalDate.parse("2019-04-04")); // should say unavailable
		System.out.println("");
		System.out.println("8) UNAVAILABLE:");
		hotel.isAvailable(101, LocalDate.parse("2019-04-01"), LocalDate.parse("2019-04-03")); // should say unavaialble
		System.out.println("");
		System.out.println("9) UNAVAILABLE:");
		hotel.isAvailable(101, LocalDate.parse("2019-04-02"), LocalDate.parse("2019-04-04")); // should say unavailable
		System.out.println("");
		System.out.println("10) AVAILABLE:");
		hotel.isAvailable(101, LocalDate.parse("2019-04-04"), LocalDate.parse("2019-04-13")); // should say available
		System.out.println("");
		System.out.println("11) AVAILABLE:");
		hotel.isAvailable(301, LocalDate.parse("2019-03-10"), LocalDate.parse("2019-04-01")); // should say available
		System.out.println("");
		System.out.println("Sandwich) AVAILABLE:  note you need to add the sandwich booking");
		hotel.isAvailable(104, LocalDate.parse("2019-04-07"), LocalDate.parse("2019-04-12")); // should say available
		System.out.println("");
		System.out.println("12) UNAVAILABLE:");
		hotel.isAvailable(104, LocalDate.parse("2019-04-04"), LocalDate.parse("2020-04-01")); //
		System.out.println("");
		System.out.println("13) UNAVAILABLE:");
		hotel.isAvailable(104, LocalDate.parse("2019-02-10"), LocalDate.parse("2019-04-07"));
		*//*
		System.out.println("****************************************************");
		System.out.println("ROOMS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllRooms();
		System.out.println("****************************************************");
		System.out.println("GUESTS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllGuests();
		System.out.println("****************************************************");
		System.out.println("BOOKINGS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllBookings();
		System.out.println("****************************************************");
		System.out.println("PAYMENTS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllPayments();
		System.out.println("");
		//int[] test = hotel.availableRooms(RoomType.DOUBLE, LocalDate.parse("2019-04-05"), LocalDate.parse("2019-04-07"));
		//for (int i: test) {
		//	System.out.println(i);
		//}
		//int ab = hotel.bookOneRoom(10008, RoomType.FAMILY, LocalDate.parse("2019-03-01"), LocalDate.parse("2019-03-02"));
		//System.out.println("New rm num:");
		//System.out.println(a);
		//System.out.println("");
		//hotel.displayAllBookings();
		//hotel.checkOut(100009, LocalDate.parse("2019-04-05"));
		//hotel.displayAllBookings();
		//hotel.addGuest("John", "Cooper", LocalDate.parse("2019-04-05"));
		//hotel.addGuest("John", "VIPCooper", LocalDate.parse("2019-04-05"), LocalDate.parse("2019-01-01"), LocalDate.parse("2020-01-01"));
		//int[] test = hotel.searchGuest("John", "Cooper");
		//for (int i: test) {
		//	System.out.println(i);}
		//int[]a = hotel.searchGuest("John", "Cooper");
		//System.out.println("");
		//for (int i: a) {
		//	System.out.println(i);}
		//hotel.displayAllRooms();
		//hotel.saveRoomsData("/Users/Ben/eclipse-workspace/CA/data/rooms.txt");
		//hotel.removeRoom(99);
		//hotel.saveRoomsData("/Users/Ben/eclipse-workspace/CA/data/rooms.txt");
		//hotel.displayAllGuests();
		//hotel.saveGuestsData(guestFile);
		System.out.println("THIS DATE:");
		System.out.println("");
		hotel.displayBookingsOn(LocalDate.parse("2019-04-05"));
		//hotel.displayPaymentsOn(LocalDate.parse("2019-02-12"));
	*/
	
		
		
		
		
		
		
		
	// Complete Hotel Tester with a designed answer sheet
		
	/*
		
		String roomFile = "/Users/Ben/eclipse-workspace/CA/data/rooms.txt";
		String guestFile = "/Users/Ben/eclipse-workspace/CA/data/guests.txt";
		String bookingFile = "/Users/Ben/eclipse-workspace/CA/data/bookings.txt";
		String paymentFile = "/Users/Ben/eclipse-workspace/CA/data/payments.txt";
		HotelImpl hotel = new HotelImpl(roomFile, guestFile, bookingFile, paymentFile);
		System.out.println("****************************************************");
		System.out.println("Teo and Ben's Hotel (FIRST Display):");
		System.out.println("****************************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("****************************************************");
		System.out.println("ROOMS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllRooms();
		System.out.println("****************************************************");
		System.out.println("GUESTS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllGuests();
		System.out.println("****************************************************");
		System.out.println("BOOKINGS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllBookings();
		System.out.println("****************************************************");
		System.out.println("PAYMENTS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllPayments();
		System.out.println("");
		hotel.addRoom(20, RoomType.DOUBLE, 444.00, 10, "Xbox One");
		hotel.addRoom(101, RoomType.DOUBLE, 444.00, 10, "Xbox One");
		hotel.removeRoom(301);
		hotel.addGuest("Ian", "Cooper", LocalDate.now());
		hotel.addGuest("Ben", "Trotter", LocalDate.now(), LocalDate.now(), LocalDate.parse("2019-03-07")); // expiry date put in manually 1 yr after
		hotel.removeGuest(10004);
		hotel.bookOneRoom(10007, RoomType.SINGLE, LocalDate.parse("2019-04-04"), LocalDate.parse("2019-04-07"));
		hotel.bookOneRoom(10007, RoomType.SINGLE, LocalDate.parse("2019-03-09"), LocalDate.parse("2019-03-12")); // make dates work for refund check
		hotel.checkOut(100001, LocalDate.parse("2019-03-20"));
		hotel.checkOut(100008, LocalDate.parse("2019-04-02"));
		hotel.cancelBooking(100005);
		System.out.println("");
		System.out.println("****************************************************");
		System.out.println("Teo and Ben's Hotel (SECOND Display):");
		System.out.println("****************************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("****************************************************");
		System.out.println("ROOMS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllRooms();
		System.out.println("****************************************************");
		System.out.println("GUESTS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllGuests();
		System.out.println("****************************************************");
		System.out.println("BOOKINGS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllBookings();
		System.out.println("****************************************************");
		System.out.println("PAYMENTS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllPayments();
		System.out.println("");
		hotel.removeRoom(20);
		hotel.removeGuest(10008);
		System.out.println("");
		System.out.println("****************************************************");
		System.out.println("Teo and Ben's Hotel (THIRD Display):");
		System.out.println("****************************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("****************************************************");
		System.out.println("ROOMS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllRooms();
		System.out.println("****************************************************");
		System.out.println("GUESTS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllGuests();
		System.out.println("****************************************************");
		System.out.println("BOOKINGS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllBookings();
		System.out.println("****************************************************");
		System.out.println("PAYMENTS:");
		System.out.println("****************************************************");
		System.out.println("");
		hotel.displayAllPayments();
		System.out.println("");
		
		*/
	}
}