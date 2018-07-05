/**
 * Created by xopher on 05/07/2018.
 */
public class TicTacToe {

    private String currentPlayer;

    public TicTacToe() {
        this.currentPlayer = "X";
    }

    public String makeMark() {
        String mark = currentPlayer;
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        }
        if (currentPlayer.equals("O")) {
            currentPlayer = "X";
        }
        return mark;
    }
}
