
public class Luke03 {

    private static final int[][] MOVE_ORDNANCE = new int[][]{
            {-1, -2}, //6
            {1, -2}, //7
            {-2, -1}, //5
            {2, -1}, //8
            {-2, 1}, //4
            {2, 1}, //1
            {-1, 2}, //3
            {1, 2} //2
    };

    /**
     * move er ønsket trekk-nr
     * oo6o7o
     * o5ooo8
     * ooo£oo
     * o4ooo1
     * oo3o2o
     */
    private int findMove(int pos, boolean[][] board) {
        int x = pos % 10;
        int y = pos / 10;

        // Finn rute å flytte til med laves høyest pri.
        for (int c = 0; c < 8; c++) {
            int res = findAllowed(c, x, y, board, false);
            if (res != -1) return res;
        }

        //Hvis ingen av disse rutene har samme farge, flytt til den ruten som har høyest nummer. Drit i farge.
        for (int c = 7; c >= 0; c--) {
            int res = findAllowed(c, x, y, board, true);
            if (res != -1) return res;
        }

        return -1;
    }

    private int findAllowed(int c, int x, int y, boolean[][] board, boolean pickLargest) {
        // Flytt til den av disse rutene som har lavest nummer og som har samme farge som ruten springeren står på.
        int nx = MOVE_ORDNANCE[c][0];
        int ny = MOVE_ORDNANCE[c][1];
        nx = x + nx;
        ny = y + ny;

        //Utenfor brettet?
        if (nx >= 0 && ny >= 0 && nx < 10 && ny < 10) {
            boolean colour = board[nx][ny];
            boolean currentColour = board[x][y];
            if (pickLargest || colour == currentColour) {
                board[x][y] = !board[x][y];
                return nx + (ny * 10);
            }
        }
        return -1;
    }

    public static void main(String[] arg) {
        long start = System.nanoTime();
        Luke03 luke = new Luke03();

        int currPos = 0;
        boolean[][] board = new boolean[10][10];

        for (int move = 0; move < 200; move++) {
            currPos = luke.findMove(currPos, board);
        }

        System.out.println("Done: " + ((System.nanoTime() - start) / 1000) + "µs");
        luke.printBoard(board);
    }

    private void printBoard(boolean[][] board) {
        System.out.println();
        int count = 0;
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (board[x][y]) count++;
                System.out.print((board[x][y] ? 1 : 0));
            }
            System.out.println();
        }
        System.out.println("---------- " + count);
    }
}