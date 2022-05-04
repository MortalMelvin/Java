#              Author : Melvin M. Flores
#          Student ID : 30352985
#        Date Created : 04 October 2019
#        Program Name : HotelRoomBooking.py
# Program Description : A text-based program for storing data on Hotel Room Bookings
#          Input File : none
#         Output File : none
# Program Features    : 1. This application allows user to add guest.
#                     : 2. This application allows user to add a room.
#                     : 3. This application allows user to add a booking.
#                     : 4. This application allows user to view  bookings.
#                     : 5. This application allows user to quit the program.
# Program Limitation  : Once the user chooses the quit option, all the saved data in the array lists will not exist anymore.

#imported for Counter object
from collections import Counter

#imported for file processing functions
import os

#imported for the set of alphabet and punctuation
import string

# Imported for determining execution time
import time

# Determine start of execution time
start_time = time.time()


# Initialize counter values
global guest_id
global room_id
global room_capacity
global booking_id
global user_input
guest_id = 0

# Array lists
guests = []
rooms = []
bookings = []
#number_of_days = []


# View bookings 
def view_bookings():

    valid_view_choice = False
    while (valid_view_choice == False  ):

        view_booking_options()
        view_choice = (input("Enter choice (G, R or X): ")).lower()

        if (view_choice == 'g'):
            # This is essentially True, but after viewing the bookings,
            # we will ask again if he wants to add view another booking, so this is set to False
            valid_view_choice = False
            guest_bookings()
            
        elif (view_choice == 'r') :
            # This is essentially True, but after viewing the bookings,
            # we will ask again if he wants to add view another booking, so this is set to False
            valid_view_choice = False
            room_booking()
            
        elif (view_choice == 'x') :
            valid_view_choice = True
            break

        else:
            invalid_view_choice = False
            print('Unknown option-please try again.\n')



# View booking options 
def view_booking_options():
    print("Would you like view [G]uest bookings, [R]oom booking, or e[X]it?")


# Guest bookings 
def guest_bookings():

    global guest_booking_id
    valid_guest_bookings = False
    

    while (valid_guest_bookings == False  ):
        guest_booking_id = input("Please enter guest ID: ")

        find_by = 'booking_guest_number'
        looking_for = guest_booking_id
        guest_booking_found = find_guest_booking(looking_for, lambda x: x[find_by])

        if (len (guest_booking_found) == 0):
            print("Guest does not exist.")
            valid_guest_bookings = False
        else:
            valid_guest_bookings = True
            print("Guest " + booking_guest_id + ": " + guest_booking_found[0].get('booking_guest_name'))
            line1 = "Booking : Room " + guest_booking_found[0].get('booking_room_number')
            line2 = ", " + guest_booking_found[0].get('booking_room_capacity')
            line3 = " guest(s) from " + guest_booking_found[0].get('booking_checkin_month')  + "/" + guest_booking_found[0].get('booking_checkin_day')
            line4 = " to " + guest_booking_found[0].get('booking_checkout_month') + "/" + guest_booking_found[0].get('booking_checkout_day')
            print (line1 + line2 + line3 + line4)
            break

# Find guest booking function 
def find_guest_booking(expected, finder):
    found_guest_booking = []
    for guest_booking in bookings:
        if finder(guest_booking) == expected:
            found_guest_booking.append(guest_booking)
    return found_guest_booking


# Room booking 
def room_booking():

    global room_booking_id
    valid_room_booking = False
    

    while (valid_room_booking == False  ):
        room_booking_id = input("Please enter room number: ")

        find_by = 'booking_room_number'
        looking_for = room_booking_id
        room_booking_found = find_room_booking(looking_for, lambda x: x[find_by])

        if (len (room_booking_found) == 0):
            print("Room does not exist.")
            valid_room_booking = False
        else:
            valid_room_booking = True
            print("Room " + room_booking_id + " bookings: ")
            line1 = "Guest " + room_booking_found[0].get('booking_guest_number') + " : " + room_booking_found[0].get('booking_guest_name')
            line2 = ", " + room_booking_found[0].get('booking_room_capacity')
            line3 = " guest(s) from " + room_booking_found[0].get('booking_checkin_month')  + "/" + room_booking_found[0].get('booking_checkin_day')
            line4 = " to " + room_booking_found[0].get('booking_checkout_month') + "/" + room_booking_found[0].get('booking_checkout_day')
            print (line1 + line2 + line3 + line4)
            break

# Find room booking function 
def find_room_booking(expected, finder):
    found_room_booking = []
    for room_booking in bookings:
        if finder(room_booking) == expected:
            found_room_booking.append(room_booking)
    return found_room_booking

# Add more guest options 
def add_more_guest_options():
    print("Would you like to [A]dd a new guest or [R]eturn to the previous menu?")


# Add more guest function
def add_more_guest():
    global more_guest_choice
    valid_guest_choice = False
    

    while (valid_guest_choice == False  ):
        add_more_guest_options()
        more_guest_choice = (input("Enter choice (A or R): ")).lower()

        if (more_guest_choice == 'a'):
            #This is essentially True, but after adding one more guest, we will ask again if he wants to add one more guest, so this is set to False
            valid_guest_choice = False 
            add_guest()
            
        elif (more_guest_choice == 'r') :
            valid_guest_choice = True
            break
            
        else:
            valid_guest_choice = False
            print('Unknown option-please try again.\n')

            


# Add more room options 
def add_more_room_options():
    print("Would you like to [A]dd a new room or [R]eturn to the previous menu?")


# Add more room function
def add_more_room():
    global more_room_choice
    invalid_choice = False
    

    while (invalid_choice == False  ):
        add_more_room_options()
        more_room_choice = (input("Enter choice (A or R): ")).lower()

        if (more_room_choice == 'a'):
            invalid_choice = False
            add_room()
            
        elif (more_room_choice == 'r'):
            valid_choice = False
            break
            
        else:
            valid_choice = True
            print('Unknown option-please try again.\n')


# Add guest function 
def add_guest():
    global guest_id
    guest_id =  guest_id + 1
    guest_name = input("Please enter guest name: ")
    print("Guest " + guest_name + " has been created with guest ID: " + str(guest_id))
    guests.append({
        'guest_id': str(guest_id),
        'guest_name': guest_name
       })


# Add room function 
def add_room():
    global room_id
    global room_capacity
    room_vacant = False
    
    while (room_vacant == False  ):

        room_id = input("Please enter room number: ")
        find_by = 'room_number'
        looking_for = room_id
        room_found, y = find_room(looking_for, lambda x: x[find_by])

        if (len (room_found) != 0):
            print("Room aleady exists.")
            room_vacant = False
        else:
            room_vacant = True
            room_capacity = input("Please enter room capacity: ")
            
            room_number_of_days = {}
            for x in range(1,366):
                room_number_of_days[x] = False

            rooms.append({
                'room_number': room_id,
                'room_capacity': room_capacity,
                'room_number_of_days': room_number_of_days
               })

            break
        

# Find room function 
def find_room(expected, finder):
    found_room = []
    i=0
    for room in rooms:
        i += 1
        if finder(room) == expected:
            found_room.append(room)
    return found_room, i


# Add booking function 
def add_booking():
    global booking_id
    global booking_guest_id
    global booking_guest_name
    global booking_room_id
    global booking_room_capacity
    booking_id = 0
    valid_booking_guest_id = False
    valid_booking_room_id = False
    valid_booking_room_capacity = False
    valid_booking_checkin_month = False
    valid_booking_checkin_day = False
    valid_booking_checkout_month = False
    valid_booking_checkout_day = False
    
    valid_booking = False
    while (valid_booking == False  ):

        #valid_booking_guest_id = False
        while (valid_booking_guest_id == False  ):
        
            booking_guest_id = input("Please enter guest ID: ")

            find_by = 'guest_id'
            looking_for = booking_guest_id
            guest_found = find_guest(looking_for, lambda x: x[find_by])

            if (len (guest_found) == 0):
                print("Guest does not exist.")
                valid_booking_guest_id = False
                valid_booking = False
            else:
                booking_guest_name = guest_found[0].get('guest_name')
                valid_booking_guest_id = True
                valid_booking = True

                #valid_booking_room_id = False
                while (valid_booking_room_id == False  ):
                
                    booking_room_id = input("Please enter room number: ")

                    find_by = 'room_number'
                    looking_for = booking_room_id
                    room_found, z = find_room(looking_for, lambda x: x[find_by])
                    
                    if (len (room_found) == 0):
                        print("Room does not exist.")
                        valid_booking_room_id = False
                        valid_booking = False
                    else:
                        valid_booking_room_id = True
                        valid_booking = True

                        #valid_booking_room_capacity = False
                        while (valid_booking_room_capacity == False  ):
                            booking_room_capacity = input("Please enter number of guests: ")
                            if (booking_room_capacity > (room_found[0].get('room_capacity'))):
                                print("Guest count exceeds room capacity of: " + (room_found[0].get('room_capacity')))

                                valid_booking_room_capacity = False
                                valid_booking = False
                            else:
                                valid_booking_room_capacity = True
                                valid_booking = True

                        #valid_booking_checkin_month = False
                        while (valid_booking_checkin_month == False  ):
                            booking_checkin_month = input("Please enter check-in month: ")
                            if (booking_checkin_month.isalpha() == True or int(booking_checkin_month) < 1 or int(booking_checkin_month) > 12):
                                print ("Invalid month.")
                                valid_booking_checkin_month = False
                                valid_booking = False
                            else:
                                valid_booking_checkin_month = True
                
                        #valid_booking_checkin_day = False
                        while (valid_booking_checkin_day == False  ):
                            booking_checkin_day = input("Please enter check-in day: ")
                            if (booking_checkin_day.isalpha() == True or int(booking_checkin_day) < 1 or int(booking_checkin_day) > 31):
                                print ("Invalid day.")
                                valid_booking_checkin_day = False
                                valid_booking = False
                            else:
                                valid_booking_checkin_day = True

                        #valid_booking_checkout_month = False
                        while (valid_booking_checkout_month == False  ):
                            booking_checkout_month = input("Please enter check-out month: ")
                            if (booking_checkout_month.isalpha() == True or int(booking_checkout_month) < 1 or int(booking_checkout_month) > 12):
                                print ("Invalid month.")
                                valid_booking_checkout_month = False
                                valid_booking = False
                            else:
                                valid_booking_checkout_month = True
                                
                        #valid_booking_checkout_day = False
                        while (valid_booking_checkout_day == False  ):
                            booking_checkout_day = input("Please enter check-out day: ")
                            if (booking_checkout_day.isalpha() == True or int(booking_checkout_day) < 1 or int(booking_checkout_day) > 31):
                                print ("Invalid day.")
                                valid_booking_checkout_day = False
                                valid_booking = False
                            else:
                                valid_booking_checkout_day = True
                                valid_booking = True

                                day_number_checkin = date_to_day_number(int(booking_checkin_month), int(booking_checkin_day))
                                
                                day_number_checkout = date_to_day_number(int(booking_checkout_month), int(booking_checkout_day))

                                #room already booked in the checked dates
                                if set_booked(day_number_checkin, day_number_checkout, z) == True:
                                    print ("Room is not available during that period.")
                                    valid_booking_room_id = False
                                    valid_booking_room_capacity = False
                                    valid_booking_checkin_month = False
                                    valid_booking_checkin_day = False
                                    valid_booking_checkout_month = False
                                    valid_booking_checkout_day = False
                                    valid_booking = False
                                    break
                                    
                                    
                                else:
                                    #room vacant in the checked dates, can be booked
                                    valid_booking = True
                                    temp2_rooms = rooms[z-1].get('room_number_of_days')
                                    for y in range (day_number_checkin, day_number_checkout+1):
                                        temp2_rooms[y] = True
                                    rooms[z-1].update(temp2_rooms)
                                
                                    booking_id += 1

                                    print("*** Booking successful! ***")

                                    bookings.append({
                                    'booking_number': booking_id,
                                    'booking_guest_number': booking_guest_id,
                                    'booking_guest_name': booking_guest_name,
                                    'booking_room_number': booking_room_id,
                                    'booking_room_capacity': booking_room_capacity,
                                    'booking_checkin_month': booking_checkin_month,
                                    'booking_checkin_day': booking_checkin_day,
                                    'booking_checkout_month': booking_checkout_month,
                                    'booking_checkout_day': booking_checkout_day
                                    })
                                    break


# Checks if the room is booked in the checked-in and checked-out dates
def set_booked(start_day_number, end_day_number, i):
    set_booked_status = False 
    temp_rooms = {}
    temp_rooms = rooms[i-1].get('room_number_of_days')
    for y in range (start_day_number, end_day_number+1):
        if temp_rooms[y] == True:
            set_booked_status = True

    return set_booked_status

    
# Converts date to number of days
def date_to_day_number(month, day): 
    if   (month == 1):
        return day
    elif (month == 2):
        return 31  + day
    elif (month == 3):
        return 59  + day
    elif (month == 4):
        return 90  + day
    elif (month == 5):
        return 120 + day
    elif (month == 6):
        return 151 + day
    elif (month == 7 ):
        return 181 + day
    elif (month == 8 ):
        return 212 + day
    elif (month == 9 ):
        return 243 + day
    elif (month == 10):
        return 273 + day
    elif (month == 11):
        return 304 + day
    else:
        return 334 + day

  	    
# Find guest function 
def find_guest(expected, finder):
    found_guest = []
    for guest in guests:
        if finder(guest) == expected:
            found_guest.append(guest)
    return found_guest


# List of menu options 
def menu_options():
    print("\n-----------------------------------------------")
    print("------ Welcome to FedUni Hotel Bookings -------")
    print("-----------------------------------------------")
    print("Main Menu - please select an option:")
    print("1.)	Add guest     ")
    print("2.)	Add room      ")
    print("3.)	Add booking   ")
    print("4.)	View bookings ")
    print("5.)	Quit          ")



# Menu Function
def menu():
   
    global user_input
    quit_switch  = False

    while (quit_switch == False):

        menu_options()
        user_input = input("Enter choice (1, 2, 3, 4 or 5): ")
    
        if user_input == '1':
            add_guest()
            add_more_guest()
            quit_switch  = False

        elif user_input == '2':
            add_room()
            add_more_room()
            quit_switch  = False
            
        elif user_input == '3':
            add_booking()
            quit_switch  = False
            
        elif user_input == '4':
            view_bookings()
            quit_booking()
            quit_switch  = True
            break
            
        elif user_input == '5':
            quit_booking()
            quit_switch = True
            break
        
        else:
            print('Unknown option-please try again.\n')


# Quit function 
def quit_booking():
    print("Thanks for using FedUni Hotel Bookings!")

    
# Calling of the main menu
menu()

# Determine end of execution time
end_time = time.time()

# Calculate execution time
exec_time = end_time-start_time

# Displays the program limitation and execution time
print("\nNote:")
print("Once the user chooses the quit option, all the saved data in the array lists will not exist anymore.")
print("\nExecution time : {:.2f} minutes".format(exec_time/60))


