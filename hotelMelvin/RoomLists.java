package hotelMelvin;

import java.util.ArrayList;

public class RoomLists {
    private String myHotel;
    private ArrayList<Room> myRooms;

    public RoomLists(String myHotel) {
        this.myHotel = myHotel;
        this.myRooms = new ArrayList<Room>();
    }

    public boolean addNewRoom(Room room) {
        if(findRoom(room.getRoomId()) >=0) {
            System.out.println("Room is already on file");
            return false;
        }

        myRooms.add(room);
        return true;

    }

    public boolean updateRoom(Room oldRoom, Room newRoom) {
        int foundPosition = findRoom(oldRoom);
        if(foundPosition <0) {
            System.out.println(oldRoom.getRoomId() +", was not found.");
            return false;
        }

        this.myRooms.set(foundPosition, newRoom);

        return true;
    }


    private int findRoom(Room room) {
        return this.myRooms.indexOf(room);
    }

    private int findRoom(String roomId) {
        for(int i=0; i<this.myRooms.size(); i++) {
        	Room room = this.myRooms.get(i);
            if(room.getRoomId().equals(roomId)) {
                return i;
            }
        }
        return -1;
    }

    public String queryRoom(Room room) {
        if(findRoom(room) >=0) {
            return room.getRoomId();
        }
        return null;
    }

    public Room queryRoom(String roomId) {
        int position = findRoom(roomId);
        if(position >=0) {
            return this.myRooms.get(position);
        }

        return null;
    }

    public void printRooms() {
        System.out.println("Room List");
        for(int i=0; i<this.myRooms.size(); i++) {
            System.out.println((i+1) + "." +
                        this.myRooms.get(i).getRoomId() + " -> " +
                        this.myRooms.get(i).getRoomCapacity() + " -> " +
                        this.myRooms.get(i).getRoom_number_of_days());
        }

    }
}

