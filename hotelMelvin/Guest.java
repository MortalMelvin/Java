package hotelMelvin;

public class Guest {
    private String guestId;
    private String guestName;

    public Guest(String guestId, String guestName) {
        this.guestId = guestId;
        this.guestName = guestName;
    }

    public String getGuestId() {
        return guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public static Guest createGuest(String guestId, String guestName) {
        return new Guest(guestId, guestName);
    }
}
