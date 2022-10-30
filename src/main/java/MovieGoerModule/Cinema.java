package MovieGoerModule;

public class Cinema {
    final int ROW = 10;
    final int COL = 12;
    private Seat[][] seats;

    // set a default layout
    public Cinema() {
        seats = new Seat[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                seats[i][j] = new Seat();
            }
        }
    }

    // if different cinemas have different layouts?
    public Cinema(int rows, int columns) {
        seats = new Seat[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = new Seat();
            }
        }
    }

    public void printSeats() { // maybe a separate class?
        char alpha = 'A';
        for (int i = 0; i < seats.length; i++) {
            System.out.print(alpha + " ");
            for (int j = 0; j < seats[0].length; j++) {
                if (seats[i][j].isTaken()) {
                    System.out.print("[X]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println(" " + alpha);
            alpha++;
        }
    }

    public void book(int row, int col) {
        seats[row][col].bookSeat();
    }

    public static void main(String[] args) { // test
        Cinema c = new Cinema(10, 16);
        c.book(5, 10);
        c.printSeats();
    }
}
