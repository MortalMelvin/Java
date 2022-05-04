//*****************************************************************************************************************************
//              Author : Melvin M. Flores
//          Student ID : 30352985
//        Date Created : O4 October 2019
//        Program Name : HotelRoomBookings.java
// Program Description : A text-based program for storing data on Hotel Room Bookings
//          Input File : none
//         Output File : none
//    Program Features : 1. This application allows user to add guest.
//                     : 2. This application allows user to add a room.
//                     : 3. This application allows user to add a booking.
//                     : 4. This application allows user to view  bookings.
//                     : 5. This application allows user to quit the program.
//  Program Limitation : Once the user chooses the quit option, all the saved data in the array lists will not exist anymore.
//        Java classes : Guest class
//                     : Room class
//                     : Booking class
//*****************************************************************************************************************************

package hotelMelvin;

import java.util.Scanner;
import java.util.Arrays;

public class HotelRoomBookings {
    private static Scanner scanner = new Scanner(System.in);
    private static GuestLists guestLists = new GuestLists("FedUni Hotel Guests");
    private static RoomLists roomLists = new RoomLists("FedUni Hotel Rooms");
    private static BookingLists bookingLists = new BookingLists("FedUni Hotel Bookings");

    
    static int guestIdNum = 0;
    static int roomIdNum = 0;
    static int bookingIdNum = 0;
    
    String bookingId = "";
    String bookingGuestId = "";
    String bookingGuestName = "";
    

//    static int bookingIdNum = 0;

    public static void main(String[] args) {
        boolean quit_switch = false;
        startHotelBooking();
        
        while(quit_switch == false) {
        	printActions();
			char action;
			System.out.println("\nEnter action (1, 2, 3 4, or 5):");
			String s = scanner.next();
			action = s.charAt(0);
			
			//***********************************************************************************************
			//*** Code fix for bug of skipping the next user input ("\nEnter action (1-9, a-c, or x-z):") ***
			//***********************************************************************************************
			scanner.nextLine();

            switch (action) {
            	case '1':
	                addNewGuest();
	                addMoreGuest();
	                quit_switch  = false;
					continue;

            	case '2':
	                addNewRoom();
	                addMoreRoom();
	                quit_switch  = false;

	                continue;

            	case '3':
	                addNewBooking();
	                addMoreBooking();
	                quit_switch  = false;

	                continue;
	                
            	case '4':
	                viewBookings();
            		continue;

                case '5':
                    System.out.println("\nShutting down...");
                    quit_switch = true;
                    break;

                    
                default:
                	System.out.println("Unknown option-please try again.");
                	
            }
        }

    }
    
    
    private static void addNewBooking() {
        boolean valid_booking = false;
        boolean valid_booking_guest_id = false;
        boolean valid_booking_room_id = false;
        boolean valid_booking_room_capacity = false;
        boolean valid_booking_checkin_month = false;
        boolean valid_booking_checkin_day = false;
        boolean valid_booking_checkout_month = false;
        boolean valid_booking_checkout_day = false;
        
        String bookingGuestId = "";

        
        valid_booking = false;
        while (valid_booking == false  ) {

            valid_booking_guest_id = false;
        	while (valid_booking_guest_id == false) {
	        	System.out.println("Please enter guest ID: ");
	        	bookingGuestId = scanner.nextLine();
            	if (findGuest(bookingGuestId) != null) {
            		Guest booking_guest = findGuest(bookingGuestId);
            		String bookingGuestName;
            		valid_booking = true;
            		valid_booking_guest_id = true;
            		break;
            	}
            	else {
            		System.out.println("Guest does not exist.");
            		valid_booking = false;
            		valid_booking_guest_id = false;
            	}
            }
        }
        
        valid_booking_room_id = false;
    	while (valid_booking_room_id == false) {

        	System.out.println("Please enter room number: ");
        	String booking_room_id = scanner.nextLine();  
        	
        	if (findRoom(booking_room_id) != null) {
        		Room bookingRoom = findRoom(booking_room_id);
        		int saved_x = bookingRoom.getRoomCapacity();
        		int saved_t = 0;
				boolean [] saved_y = bookingRoom.getRoom_number_of_days();
        		valid_booking = true;
        		valid_booking_guest_id = true;
        		valid_booking_room_id = true;
        		
            	valid_booking_room_capacity = false;
            	while (valid_booking_room_capacity == false) {

                	System.out.println("Please enter number of guests:");
                	int booking_room_capacity = scanner.nextInt();
                	saved_t = booking_room_capacity;
                	
                	if (booking_room_capacity <= saved_x){
                		valid_booking = true;
                		valid_booking_guest_id = true;
                		valid_booking_room_id = true;
                		valid_booking_room_capacity = true;
                		break;
                	}
                	else {
                		System.out.println("Guest count exceeds room capacity of: " + saved_x);
                		valid_booking = false;
                		valid_booking_guest_id = true;
                		valid_booking_room_id = true;
                		valid_booking_room_capacity = false;
                	}
                }

            	
            	
            	valid_booking_checkin_month = false;
            	while (valid_booking_checkin_month == false) {

                	System.out.println("Please enter check-in month:");
                	int booking_checkin_month = scanner.nextInt();  
                	
                	if (booking_checkin_month >= 1 && booking_checkin_month <= 12 ){
                		valid_booking = true;
                		valid_booking_guest_id = true;
                		valid_booking_room_id = true;
                		valid_booking_room_capacity = true;
                    	valid_booking_checkin_month = true;
                		
                		
	                    	valid_booking_checkin_day = false;
	                    	while (valid_booking_checkin_day == false) {
	
	                        	System.out.println("Please enter check-in day:");
	                        	int booking_checkin_day = scanner.nextInt();  
	                        	
	                        	if (booking_checkin_day >= 1 && booking_checkin_day <= 31 ){
	                        		valid_booking = true;
	                        		valid_booking_guest_id = true;
	                        		valid_booking_room_id = true;
	                        		valid_booking_room_capacity = true;
	                            	valid_booking_checkin_month = true;
	                            	valid_booking_checkin_day = true;
	                            	
	                            	int day_number_checkin = date_to_day_number(booking_checkin_month, booking_checkin_day);
	
	                            	valid_booking_checkout_month = false;
	                            	while (valid_booking_checkout_month == false) {

	                                	System.out.println("Please enter check-out month:");
	                                	int booking_checkout_month = scanner.nextInt();  
	                                	
	                                	if (booking_checkout_month >= 1 && booking_checkout_month <= 12 ){
	                                		valid_booking = true;
	                                		valid_booking_guest_id = true;
	                                		valid_booking_room_id = true;
	                                		valid_booking_room_capacity = true;
	                                    	valid_booking_checkin_month = true;
	                                    	valid_booking_checkin_day = true;
	                                    	valid_booking_checkout_month = true;
	                                    	
	                                    	
	                	                    	valid_booking_checkout_day = false;
	                	                    	while (valid_booking_checkout_day == false) {
	                	
	                	                        	System.out.println("Please enter check-out day:");
	                	                        	int booking_checkout_day = scanner.nextInt();  
	                	                        	
	                	                        	if (booking_checkout_day >= 1 && booking_checkout_day <= 31 ){
	                	                        		valid_booking = true;
	                	                        		valid_booking_guest_id = true;
	                	                        		valid_booking_room_id = true;
	                	                        		valid_booking_room_capacity = true;
	                	                            	valid_booking_checkin_month = true;
	                	                            	valid_booking_checkin_day = true;
	                	                            	valid_booking_checkout_month = true;
	                	                            	valid_booking_checkout_day = true;
	                	                            	
	                	                            	int day_number_checkout = date_to_day_number(booking_checkout_month, booking_checkout_day);
	                                                    
	                	                        		Room bookingRoom2 = findRoom(booking_room_id);
	                	                				boolean [] saved_z = bookingRoom2.getRoom_number_of_days();
	                	                				
	                	                		    	boolean valid_booking_checked_dates = false;
	                	                		    	
	                	                				boolean booked_room_switch= set_booked(day_number_checkin, day_number_checkout, saved_z);

	                	                		    	if (booked_room_switch == true) {
	                	                		    		//room already booked in the checked dates
	                	                		    		System.out.println("Room is not available during that period.");
		                	                        		valid_booking = false;
		                	                        		valid_booking_guest_id = true;
		                	                        		valid_booking_room_id = true;
		                	                        		valid_booking_room_capacity = true;
		                	                            	valid_booking_checkin_month = true;
		                	                            	valid_booking_checkin_day = true;
		                	                            	valid_booking_checkout_month = true;
		                	                            	valid_booking_checkout_day = true;
		                	                            	valid_booking_checked_dates = false;
		                	                            			break;
	                	                		    	}
	                	                		    	
	                	                		    	else {

	                	                		    		//room vacant in the checked dates, can be booked
		                	                        		valid_booking = true;
		                	                        		valid_booking_guest_id = true;
		                	                        		valid_booking_room_id = true;
		                	                        		valid_booking_room_capacity = true;
		                	                            	valid_booking_checkin_month = true;
		                	                            	valid_booking_checkin_day = true;
		                	                            	valid_booking_checkout_month = true;
		                	                            	valid_booking_checkout_day = true;
		                	                            	valid_booking_checked_dates = true;
		                	                            	
		                	                        		Room localRoom = findRoom(booking_room_id);
		                	                				boolean [] saved_q = localRoom.getRoom_number_of_days();

		                	                            	boolean [] buffer_rooms = new boolean[366];
		                	                            	buffer_rooms = saved_q;
		                	                            	
		                	                                for (int z = day_number_checkin; z < day_number_checkout+1; z++) {
		                	                                    if (buffer_rooms[z] == false) {
		                	                                    	buffer_rooms[z] = true;
		                	                        			}
		                	                        		}
		                	                                
		                	                                Room existingRoomRecord = roomLists.queryRoom(booking_room_id);
		                	                                
		                	                                String newroomId;
		                	                                newroomId = booking_room_id;
		                	                                //saved_x = saved_t;
		                	                                int newroomCapacity = saved_t;

		                	                                boolean [] newroom_number_of_days = new boolean[366]; 
		                	                                newroom_number_of_days = buffer_rooms;

		                	                                Room newRoom = Room.createRoom(newroomId, newroomCapacity, newroom_number_of_days);
//		                	                                Room newRoom = Room.createRoom(newroomId, saved_x, newroom_number_of_days);
		                	                        		
		                	                                if(roomLists.updateRoom(existingRoomRecord, newRoom)) {
		                	                                    System.out.println("Successfully updated record");
		                	                                } else {
		                	                                    System.out.println("Error updating record.");
		                	                                }

		                	                                
		                	                                String bookingId = "";
		                	                                bookingIdNum = bookingIdNum + 1;
		                	                                bookingId = String.valueOf(bookingIdNum);
		                	                                bookingId = bookingGuestId;
		                	                                
		                	                                Guest local_booking_guest = findGuest(bookingGuestId);
		                	                        		String bookingGuestName;
		                	                        		bookingGuestName = local_booking_guest.getGuestName();		                	                                

		                	                                boolean [] booking_room_number_of_days = new boolean[366]; 
		                	                                booking_room_number_of_days = buffer_rooms;
		                	                                
		                	                                int bookingRoomCapacity = saved_x;
		                	                                
		                	                                Booking newBooking = Booking.createBooking(bookingId,  bookingGuestId,  bookingGuestName,  booking_room_id,  bookingRoomCapacity,  booking_checkin_month,  booking_checkin_day,  booking_checkout_month,  booking_checkout_day,  booking_room_number_of_days);
		                	                                if(bookingLists.addNewBooking(newBooking)) {
		                	                                    System.out.println("*** Booking successful! ***");
		                	                                    break;
		                	                                    
		                	                                } else {
		                	                                    System.out.println("Cannot add, the booking id" + bookingId + " already on file");
		                	                                    break;
		                	                                }


	                	                		    	}
	                	            
	                	                        	}
	                	                        	else {
	                	                        		System.out.println("Invalid day.");
	                	                        		valid_booking = false;
	                	                        		valid_booking_guest_id = true;
	                	                        		valid_booking_room_id = true;
	                	                        		valid_booking_room_capacity = true;
	                	                            	valid_booking_checkin_month = true;
	                	                            	valid_booking_checkin_day = true;
	                	                            	valid_booking_checkout_month = true;
	                	                            	valid_booking_checkout_day = false;
	                	                        	}
	                	                        }
	                                	}
	                                	else {
	                                		System.out.println("Invalid month.");
	                                		valid_booking = false;
	                                		valid_booking_guest_id = true;
	                                		valid_booking_room_id = true;
	                                		valid_booking_room_capacity = true;
	                                    	valid_booking_checkin_month = true;
	                                    	valid_booking_checkin_day = true;
	                                    	valid_booking_checkout_month = false;
	                                	}
	                                }
	                        	}
	                        	else {
	                        		System.out.println("Invalid day.");
	                        		valid_booking = false;
	                        		valid_booking_guest_id = true;
	                        		valid_booking_room_id = true;
	                        		valid_booking_room_capacity = true;
	                            	valid_booking_checkin_month = true;
	                            	valid_booking_checkin_day = false;
	
	                        	}
	                        }
                	}
                	else {
                		System.out.println("Invalid month.");
                		valid_booking = false;
                		valid_booking_guest_id = true;
                		valid_booking_room_id = true;
                		valid_booking_room_capacity = true;
                		valid_booking_checkin_month = false;
                	}
                }
        	}
        	else {
        		System.out.println("Room does not exist.");
        		valid_booking = false;
        		valid_booking_guest_id = false;
        		valid_booking_room_id = false;
        	}
        }
     }
    
    
    
    // Checks if the room is booked in the checked-in and checked-out dates
    private static boolean set_booked (int start_day_number, int end_day_number, boolean[] saved_z) {

    	boolean set_booked_status = false; 
        boolean[] temp_rooms;
        temp_rooms = saved_z;

        for (int y = start_day_number; y < end_day_number+1; y++) {
            if (temp_rooms[y] == true) {
            	set_booked_status = true;
            }
		}
        return set_booked_status;
    }
        		

    private static int date_to_day_number(int month, int day) {
    	
        switch (month) {
	    	case 1:
	            return day;
	
	    	case 2:
	            return 31  + day;
	            
	    	case 3:
	            return 59  + day;
	
	    	case 4:
	            return 90  + day;
	            
	    	case 5:
	            return 120 + day;
	            
	    	case 6:
	            return 151 + day;
	        
	    	case 7:
	            return 181 + day;
	        
	    	case 8:
	            return 212 + day;
	            
	    	case 9:
	            return 243 + day;
	            
	    	case 10:
	            return 273 + day;
	            
	    	case 11:
	            return 304 + day;
	            
	        default:
	            return 334 + day;
        }
	            
    }
    
    
    
    private static void addMoreBooking() {

        boolean valid_booking_choice = false; 
        
        while (valid_booking_choice == false) {
        	System.out.println("Would you like to [A]dd a new booking or [R]eturn to the previous menu?");
    	
			char more_booking_choice;
			String s = scanner.next().toLowerCase();
			more_booking_choice = s.charAt(0);
			
			//***********************************************************************************
			//*** Code fix for bug of skipping the next user input ("Enter new guest name: ") ***
			//***********************************************************************************
			scanner.nextLine();

            switch (more_booking_choice) {
	        	case 'a':
		            //This is essentially True, but after adding one more guest,
	        		//we will ask again if user wants to add one more room, so this is set to False
	        		addNewBooking();
	        		valid_booking_choice = false; 
	        		break;
	        	
	        	case 'r':
	        		valid_booking_choice = true;
		            break;

	        	default:
	        		valid_booking_choice = false;
		        	System.out.println("Unknown option-please try again.");
		        	break;
            }
        }
    }

    
    private static void findBooking() {
        System.out.println("Enter existing booking id: ");
        String bookingId = scanner.nextLine();
        Booking existingBookingRecord = bookingLists.queryBooking(bookingId);
        if(existingBookingRecord == null) {
            System.out.println("Booking id not found.");
        }
        else {
            System.out.println("Booking id found.");
        }
            return;
    }

    private static void queryBooking() {
        System.out.println("Enter existing booking id: ");
        String bookingId = scanner.nextLine();
        Booking existingBookingRecord = bookingLists.queryBooking(bookingId);
        if (existingBookingRecord == null) {
            System.out.println("Booking not found.");
            return;
        }

    }


    private static void addNewRoom() {
        System.out.println("Enter new room number: ");
        String roomId  = scanner.nextLine();
        System.out.println("Enter new room capacity: ");
        int roomCapacity  = scanner.nextInt();
        boolean[] room_number_of_days = new boolean[366];
        Arrays.fill(room_number_of_days, false);
        Room newRoom = Room.createRoom(roomId, roomCapacity, room_number_of_days);
        if(roomLists.addNewRoom(newRoom)) {
            System.out.println("New room added: id = " + roomId + ", roomCapacity = "+ roomCapacity);
        } else {
            System.out.println("Cannot add, the room id " + roomId + " already on file");
        }
    }

    
    private static void addMoreRoom() {

        boolean valid_room_choice = false; 
        
        while (valid_room_choice == false) {
        	System.out.println("Would you like to [A]dd a new room or [R]eturn to the previous menu?");
    	
			char more_room_choice;
			String s = scanner.next().toLowerCase();
			more_room_choice = s.charAt(0);
			
			//***********************************************************************************
			//*** Code fix for bug of skipping the next user input ("Enter new guest name: ") ***
			//***********************************************************************************
			scanner.nextLine();

            switch (more_room_choice) {
	        	case 'a':
		            //This is essentially True, but after adding one more guest,
	        		//we will ask again if user wants to add one more room, so this is set to False
	        		addNewRoom();
	        		valid_room_choice = false; 
	        		break;
	        	
	        	case 'r':
	        		valid_room_choice = true;
		            break;

	        	default:
	        		valid_room_choice = false;
		        	System.out.println("Unknown option-please try again.");
		        	break;
            }
        }
    }

    
    private static Room findRoom(String roomId) {
        Room existingRoomRecord = roomLists.queryRoom(roomId);
        if(existingRoomRecord == null) {
            return existingRoomRecord;
        }
            return existingRoomRecord;
    }

    private static void queryRoom() {
        System.out.println("Enter existing room id: ");
        String roomId = scanner.nextLine();
        Room existingRoomRecord = roomLists.queryRoom(roomId);
        if (existingRoomRecord == null) {
            System.out.println("Room not found.");
            return;
        }

        System.out.println("Room Id: " + existingRoomRecord.getRoomId() + " Room capacity is " + existingRoomRecord.getRoomCapacity());
    }

    
    private static void addNewGuest() {
        System.out.println("Enter new guest name: ");
        String guestName = scanner.nextLine();
        String guestId = "";
        guestIdNum = guestIdNum + 1;
        guestId = String.valueOf(guestIdNum);
        Guest newGuest = Guest.createGuest(guestId, guestName);
        if(guestLists.addNewGuest(newGuest)) {
            System.out.println("New guest added: id = " + guestId + ", name = "+ guestName);
        } else {
            System.out.println("Cannot add, the guest id " + guestId + " already on file");
        }
    }

    private static void addMoreGuest() {

        boolean valid_guest_choice = false; 
        
        while (valid_guest_choice == false) {
        	System.out.println("Would you like to [A]dd a new guest or [R]eturn to the previous menu?");
    	
			char more_guest_choice;
			String s = scanner.next().toLowerCase();
			more_guest_choice = s.charAt(0);
			
			//***********************************************************************************
			//*** Code fix for bug of skipping the next user input ("Enter new guest name: ") ***
			//***********************************************************************************
			scanner.nextLine();

            switch (more_guest_choice) {
	        	case 'a':
		            //This is essentially True, but after adding one more guest,
	        		//we will ask again if user wants to add one more guest, so this is set to False
	        		addNewGuest();
	        		valid_guest_choice = false; 
	        		break;
	        	
	        	case 'r':
		            valid_guest_choice = true;
		            break;

	        	default:
		        	valid_guest_choice = false;
		        	System.out.println("Unknown option-please try again.");
		        	break;
            }
        }
    }
	        	


    private static Guest findGuest(String guestId) {
        Guest existingGuestRecord = guestLists.queryGuest(guestId);
        if(existingGuestRecord == null) {
        	return null;
        }
        else {
        	return existingGuestRecord;
        }
    }

    private static void queryGuest() {
        System.out.println("Enter existing guest id: ");
        String guestId = scanner.nextLine();
        Guest existingGuestRecord = guestLists.queryGuest(guestId);
        if (existingGuestRecord == null) {
            System.out.println("Guest not found.");
            return;
        }

        System.out.println("Guest Id: " + existingGuestRecord.getGuestId() + " Guest name is " + existingGuestRecord.getGuestName());
    }
    
    
    
    
    // View bookings 
    private static void viewBookings() {

        boolean valid_view_choice = false;
        while (valid_view_choice == false  ) {

        	System.out.println("Would you like view [G]uest bookings, [R]oom booking, or e[X]it?");
            System.out.println("Enter choice (G, R or X): ");
            
			char view_choice;
			String s = scanner.next().toLowerCase();
			view_choice = s.charAt(0);
			
			//***********************************************************************************
			//*** Code fix for bug of skipping the next user input ("Enter new guest name: ") ***
			//***********************************************************************************
			scanner.nextLine();

            switch (view_choice) {
	        	case 'g':
	                // This is essentially True, but after viewing the bookings, 
	        		// we will ask again if he wants to add view another booking, so this is set to False
	                guest_bookings();
	                valid_view_choice = false;
	                break;
	                
	        	case 'r':
	                // This is essentially True, but after viewing the bookings, 
	        		// we will ask again if he wants to add view another booking, so this is set to False
	                room_bookings();
	                valid_view_choice = false;
	                break;
	                
	        	case 'x' :
	                valid_view_choice = true;
	                break;

	            default:
	            	valid_view_choice = false;
	                System.out.println("Unknown option-please try again");
            }
        }
    }        

        
    private static void guest_bookings() {
        
    	String guest_booking_id;
        boolean valid_guest_bookings = false;
        

        while (valid_guest_bookings == false) {
        	
        	System.out.println("Please enter guest ID:");
        	guest_booking_id = scanner.nextLine();
        	
            Booking localBooking = bookingLists.queryBooking(guest_booking_id);
            if (localBooking == null) {
                System.out.println("Guest does not exist.");
                valid_guest_bookings = false;
            }
            else {
	            System.out.println("Guest " + guest_booking_id + ": " + localBooking.getBookingGuestName());
	            String line1 = "Booking : Room " + localBooking.getBookingRoomId();
	            String line2 = ", " + localBooking.getBookingRoomCapacity();
	            String line3 = " guest(s) from " + localBooking.getBooking_checkin_month()  + "/" + localBooking.getBooking_checkin_day();
	            String line4 = " to " + localBooking.getBooking_checkout_month()  + "/" + localBooking.getBooking_checkout_day();
	            System.out.println(line1 + line2 + line3 + line4);
	            valid_guest_bookings = true;
	            break;
            }
        }
	            
    }
    

    private static void room_bookings() {
        
    	String room_booking_id;
        boolean valid_room_bookings = false;
        

        while (valid_room_bookings == false) {
        	
        	System.out.println("Please enter room number:");
        	room_booking_id = scanner.nextLine();

            String localBookingId = bookingLists.findBookingsByRoomId(room_booking_id);
            
            if (localBookingId == null) {
                System.out.println("Room does not exist.");
                valid_room_bookings = false;
            }
            else {
                Booking localBooking = bookingLists.queryBooking(localBookingId);
	            String line1 = "Room " + room_booking_id + " bookings: ";
	            String line2 = "Guest " + localBooking.getBookingGuestId();
	            String line3 = ", " + localBooking.getBookingGuestName();
	            String line4 = ", " + localBooking.getBookingRoomCapacity();
	            String line5 = " guest(s) from " + localBooking.getBooking_checkin_month()  + "/" + localBooking.getBooking_checkin_day();
	            String line6 = " to " + localBooking.getBooking_checkout_month()  + "/" + localBooking.getBooking_checkout_day();
	            System.out.println(line1 + line2 + line3 + line4 + line5 + line6);
	            valid_room_bookings = true;
	            break;
            }
        }
	            
    }


    private static void startHotelBooking() {
        System.out.println("Starting the FedUni Hotel Bookings...");
    }

	private static void printActions() {
		System.out.println("\n-----------------------------------------------");
		System.out.println("------ Welcome to FedUni Hotel Bookings -------");
		System.out.println("-----------------------------------------------");
		System.out.println("1.)	Add guest                  \n" +
							"2.)	Add room                \n" + 
							"3.)	Add booking             \n" +  
							"4.)	View bookings           \n" +  
							"5.)	Quit                    \n");
	}

}
