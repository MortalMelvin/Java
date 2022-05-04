package hotelMelvin;

import java.util.ArrayList;

public class BookingLists {
    private String myHotel;
    private ArrayList<Booking> myBookings;

    public BookingLists(String myHotel) {
        this.myHotel = myHotel;
        this.myBookings = new ArrayList<Booking>();
    }

    public boolean addNewBooking(Booking booking) {
        if(findBooking(booking.getBookingId()) >=0) {
            System.out.println("Booking is already on file");
            return false;
        }

        myBookings.add(booking);
        return true;

    }


    private int findBooking(Booking booking) {
        return this.myBookings.indexOf(booking);
    }

    private int findBooking(String bookingId) {
        for(int i=0; i<this.myBookings.size(); i++) {
        	Booking booking = this.myBookings.get(i);
            if(booking.getBookingId().equals(bookingId)) {
                return i;
            }
        }
        return -1;
    }

    public String queryBooking(Booking booking) {
        if(findBooking(booking) >=0) {
            return booking.getBookingId();
        }
        return null;
    }

    public Booking queryBooking(String bookingId) {
        int position = findBooking(bookingId);
        if(position >=0) {
            return this.myBookings.get(position);
        }

        return null;
    }

    public void printBookings() {
        System.out.println("Booking List");
        for(int i=0; i<this.myBookings.size(); i++) {
            System.out.println((i+1) + "." +
                        this.myBookings.get(i).getBookingRoomId() + " -> " +
                        this.myBookings.get(i).getBookingRoomCapacity() + " -> " +
                        this.myBookings.get(i).getBooking_room_number_of_days());
        }
    }    
    
    
    public String findBookingsByRoomId(String bookingRoomId) {
    	String returnBookingID = null;

        for(int i=0; i<this.myBookings.size(); i++) {
        	if ( this.myBookings.get(i).getBookingRoomId().equals(bookingRoomId)) {
        		returnBookingID = this.myBookings.get(i).getBookingId();
        		return returnBookingID;
        	}
        }
		return returnBookingID;
    }
}