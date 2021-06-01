package hotelMelvin;

import java.util.ArrayList;

public class GuestLists {
    private String myHotel;
    private ArrayList<Guest> myGuests;

    public GuestLists(String myHotel) {
        this.myHotel = myHotel;
        this.myGuests = new ArrayList<Guest>();
    }

    public boolean addNewGuest(Guest guest) {
        if(findGuest(guest.getGuestId()) >=0) {
            System.out.println("Guest is already on file");
            return false;
        }

        myGuests.add(guest);
        return true;

    }


    private int findGuest(Guest guest) {
        return this.myGuests.indexOf(guest);
    }

    private int findGuest(String guestId) {
        for(int i=0; i<this.myGuests.size(); i++) {
            Guest guest = this.myGuests.get(i);
            if(guest.getGuestId().equals(guestId)) {
                return i;
            }
        }
        return -1;
    }

    public String queryGuest(Guest guest) {
        if(findGuest(guest) >=0) {
            return guest.getGuestId();
        }
        return null;
    }

    public Guest queryGuest(String guestId) {
        int position = findGuest(guestId);
        if(position >=0) {
            return this.myGuests.get(position);
        }

        return null;
    }

    public void printGuests() {
        System.out.println("Guest List");
        for(int i=0; i<this.myGuests.size(); i++) {
            System.out.println((i+1) + "." +
                        this.myGuests.get(i).getGuestId() + " -> " +
                        this.myGuests.get(i).getGuestName());
        }

    }
}
