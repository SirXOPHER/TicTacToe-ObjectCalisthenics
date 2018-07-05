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
