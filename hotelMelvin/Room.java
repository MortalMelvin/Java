package hotelMelvin;

import java.util.ArrayList;
import java.util.Arrays;


public class Room {
    private String roomId;
    private int roomCapacity;
    private boolean[] room_number_of_days = new boolean[366];


	public Room(String roomId, int roomCapacity, boolean room_number_of_days[]) {
        this.roomId = roomId;
        this.roomCapacity = roomCapacity;
        this.room_number_of_days = room_number_of_days;

    }

    
    public String getRoomId() {
        return roomId;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public boolean[] getRoom_number_of_days() {
 		return room_number_of_days;
 	}

    public void setRoom_number_of_days(boolean[] room_number_of_days) {
		this.room_number_of_days = room_number_of_days;
	}


	public static Room createRoom(String roomId, int roomCapacity, boolean room_number_of_days[]) {
        return new Room(roomId, roomCapacity, room_number_of_days);
    }
}
