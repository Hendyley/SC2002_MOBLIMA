package MovieGoerModule;

public class Cineplex {
    private Cinema[] room;

    public Cineplex(int numRooms) {
        room = new Cinema[numRooms];
        for (int i = 0; i < numRooms; i++) {
            room[i] = new Cinema();
        }
    }

    public Cinema getRoom(int i) {
        return this.room[i];
    }

    // public static void main(String[] args) { // test
    // Cineplex c = new Cineplex(2);
    // c.room[0].printSeats();
    // }
}
