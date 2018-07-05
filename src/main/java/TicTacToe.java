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

        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        }
        if (currentPlayer.equals("O")) {
            currentPlayer = "X";
        }

        if (grid[row][column] != null) {
            throw new PositionAlreadyFilledException();
        }
        grid[row][column] = mark;

        return mark;
    }
}
