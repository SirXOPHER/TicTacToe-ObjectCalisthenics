/**
 * Created by xopher on 05/07/2018.
 */
public class TicTacToe {

    private String currentPlayer;
    private String[][] grid;

    public TicTacToe() {
        this.currentPlayer = "X";
        this.grid = new String[3][3];
    }

    public String makeMark(int row, int column) throws PositionAlreadyFilledException {
        String mark = currentPlayer;
        toggleCurrentPlayer();
        checkPosition(row, column);
        grid[row][column] = mark;
        return mark;
    }

    private void toggleCurrentPlayer() {
        if (currentPlayer.equals("X")) currentPlayer = "O";
        if (currentPlayer.equals("O")) currentPlayer = "X";
    }

    private void checkPosition(int row, int column) throws PositionAlreadyFilledException {
        if (grid[row][column] != null) {
            throw new PositionAlreadyFilledException();
        }
    }

    public boolean checkTriplet(String first, String second, String third) {
        return ((first != null) && (first == second) && (second == third));
    }

    public boolean checkRow() {
        for (int row = 0; row < 3; row++) {
            if (checkTriplet(grid[row][0], grid[row][1], grid[row][2])) return true;
        }
        return false;
    }

    public boolean checkColumn() {
        for (int column = 0; column < 3; column++) {
            if (checkTriplet(grid[0][column], grid[1][column], grid[2][column])) return true;
        }
        return false;
    }

    public boolean checkDiagonal() {
        return ((checkTriplet(grid[0][0], grid[1][1], grid[2][2])) ||
                (checkTriplet(grid[0][2], grid[1][1], grid[2][0])));
    }

    public boolean isGridFull() {
        boolean full = true;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (grid[row][column] == null) {
                    full = false;
                }
            }
        }
        return full;
    }

    // TODO: Remove console printer before shipping production code
    public void printGridToConsole() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int column = 0; column < 3; column++) {
                System.out.print(grid[row][column] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}
