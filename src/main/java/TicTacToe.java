/**
 * Created by xopher on 05/07/2018.
 */
public class TicTacToe {

    private String currentPlayer;

    public TicTacToe() {
        this.currentPlayer = "X";
    }

    public String makeMark() {
        currentPlayer = "O";
        return "X";
    }
}
