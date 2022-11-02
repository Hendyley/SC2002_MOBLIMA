package MovieGoerModule;

public class Cineplex {
    private String name;
    private Cinema[] room;

    public Cineplex(int numRooms, String name) {
        this.name = name;

        room = new Cinema[numRooms];
        for (int i = 0; i < numRooms; i++) {
            room[i] = new Cinema();
        }
    }

    public Cinema getRoom(int i) {
        return this.room[i];
    }

    public String getName() {
        return this.name;
    }
}
