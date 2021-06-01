package hotelMelvin;

import java.util.ArrayList;
import java.util.Arrays;


public class Booking {
    private String bookingId;
    private String bookingGuestId;
    private String bookingGuestName;
	private String bookingRoomId;
    private int bookingRoomCapacity;
    private int booking_checkin_month;
    private int booking_checkin_day;
    private int booking_checkout_month;
    private int booking_checkout_day;
    private boolean[] booking_room_number_of_days = new boolean[366];
	/**
	 * @return the bookingId
	 */
	public String getBookingId() {
		return bookingId;
	}
	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	/**
	 * @return the bookingGuestId
	 */
	public String getBookingGuestId() {
		return bookingGuestId;
	}
	/**
	 * @param bookingGuestId the bookingGuestId to set
	 */
	public void setBookingGuestId(String bookingGuestId) {
		this.bookingGuestId = bookingGuestId;
	}
	/**
	 * @return the bookingGuestName
	 */
	public String getBookingGuestName() {
		return bookingGuestName;
	}
	/**
	 * @param bookingGuestName the bookingGuestName to set
	 */
	public void setBookingGuestName(String bookingGuestName) {
		this.bookingGuestName = bookingGuestName;
	}
	/**
	 * @return the bookingRoomId
	 */
	public String getBookingRoomId() {
		return bookingRoomId;
	}
	/**
	 * @param bookingRoomId the bookingRoomId to set
	 */
	public void setBookingRoomId(String bookingRoomId) {
		this.bookingRoomId = bookingRoomId;
	}
	/**
	 * @return the bookingRoomCapacity
	 */
	public int getBookingRoomCapacity() {
		return bookingRoomCapacity;
	}
	/**
	 * @param bookingRoomCapacity the bookingRoomCapacity to set
	 */
	public void setBookingRoomCapacity(int bookingRoomCapacity) {
		this.bookingRoomCapacity = bookingRoomCapacity;
	}
	/**
	 * @return the booking_checkin_month
	 */
	public int getBooking_checkin_month() {
		return booking_checkin_month;
	}
	/**
	 * @param booking_checkin_month the booking_checkin_month to set
	 */
	public void setBooking_checkin_month(int booking_checkin_month) {
		this.booking_checkin_month = booking_checkin_month;
	}
	/**
	 * @return the booking_checkin_day
	 */
	public int getBooking_checkin_day() {
		return booking_checkin_day;
	}
	/**
	 * @param booking_checkin_day the booking_checkin_day to set
	 */
	public void setBooking_checkin_day(int booking_checkin_day) {
		this.booking_checkin_day = booking_checkin_day;
	}
	/**
	 * @return the booking_checkout_month
	 */
	public int getBooking_checkout_month() {
		return booking_checkout_month;
	}
	/**
	 * @param booking_checkout_month the booking_checkout_month to set
	 */
	public void setBooking_checkout_month(int booking_checkout_month) {
		this.booking_checkout_month = booking_checkout_month;
	}
	/**
	 * @return the booking_checkout_day
	 */
	public int getBooking_checkout_day() {
		return booking_checkout_day;
	}
	/**
	 * @param booking_checkout_day the booking_checkout_day to set
	 */
	public void setBooking_checkout_day(int booking_checkout_day) {
		this.booking_checkout_day = booking_checkout_day;
	}
	/**
	 * @return the booking_room_number_of_days
	 */
	public boolean[] getBooking_room_number_of_days() {
		return booking_room_number_of_days;
	}
	/**
	 * @param booking_room_number_of_days the booking_room_number_of_days to set
	 */
	public void setBooking_room_number_of_days(boolean[] booking_room_number_of_days) {
		this.booking_room_number_of_days = booking_room_number_of_days;
	}
	public Booking(String bookingId, String bookingGuestId, String bookingGuestName, String bookingRoomId,
			int bookingRoomCapacity, int booking_checkin_month, int booking_checkin_day, int booking_checkout_month,
			int booking_checkout_day, boolean[] booking_room_number_of_days) {
		super();
		this.bookingId = bookingId;
		this.bookingGuestId = bookingGuestId;
		this.bookingGuestName = bookingGuestName;
		this.bookingRoomId = bookingRoomId;
		this.bookingRoomCapacity = bookingRoomCapacity;
		this.booking_checkin_month = booking_checkin_month;
		this.booking_checkin_day = booking_checkin_day;
		this.booking_checkout_month = booking_checkout_month;
		this.booking_checkout_day = booking_checkout_day;
		this.booking_room_number_of_days = booking_room_number_of_days;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingGuestId=" + bookingGuestId + ", bookingGuestName="
				+ bookingGuestName + ", bookingRoomId=" + bookingRoomId + ", bookingRoomCapacity=" + bookingRoomCapacity
				+ ", booking_checkin_month=" + booking_checkin_month + ", booking_checkin_day=" + booking_checkin_day
				+ ", booking_checkout_month=" + booking_checkout_month + ", booking_checkout_day="
				+ booking_checkout_day + ", booking_room_number_of_days=" + Arrays.toString(booking_room_number_of_days)
				+ "]";
	}

	public static Booking createBooking(String bookingId, String bookingGuestId, String bookingGuestName, String bookingRoomId, int bookingRoomCapacity, int booking_checkin_month, int booking_checkin_day, int booking_checkout_month, int booking_checkout_day, boolean booking_room_number_of_days[]) {
        return new Booking( bookingId,  bookingGuestId,  bookingGuestName,  bookingRoomId,  bookingRoomCapacity,  booking_checkin_month,  booking_checkin_day,  booking_checkout_month,  booking_checkout_day,  booking_room_number_of_days);
    }

}
