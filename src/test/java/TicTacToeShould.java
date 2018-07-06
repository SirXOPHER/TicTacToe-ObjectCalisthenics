import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by xopher on 05/07/2018.
 */
@RunWith(JUnitParamsRunner.class)
public class TicTacToeShould {

    TicTacToe testGame;

    @Before
    public void setUp() {
        testGame = new TicTacToe();
    }

    @Test
    public void ensurePlayerXalwaysGoesFirst() throws PositionAlreadyFilledException {
        assertThat(testGame.makeMark(2, 2), is("X"));
    }

    @Test
    public void alternateBetweenTwoPlayers() throws PositionAlreadyFilledException {
        testGame.makeMark(1, 2);
        assertThat(testGame.makeMark(0, 2), is("X"));
    }

    @Test(expected = PositionAlreadyFilledException.class)
    public void ensurePlayersCannotPlayOnPlayedPosition() throws PositionAlreadyFilledException {
        testGame.makeMark(0, 0);
        testGame.makeMark(0, 0);
    }
    
    @Test
    public void validateWinningTriplet() {
        assertThat(testGame.checkTriplet("X", "X", "X"), is(true));
        assertThat(testGame.checkTriplet("O", "O", "O"), is(true));
    }
    
    @Test
    public void validateWinningRow() throws PositionAlreadyFilledException {
        testGame.makeMark(0, 0);
        testGame.makeMark(0, 1);
        testGame.makeMark(0, 2);
        assertThat(testGame.checkRow(), is(true));
    }

    @Test
    public void validateWinningColumn() throws PositionAlreadyFilledException {
        testGame.makeMark(0, 0);
        testGame.makeMark(1, 0);
        testGame.makeMark(2, 0);
        assertThat(testGame.checkColumn(), is(true));
    }
    
    @Test
    public void validateWinningDiagonal() throws PositionAlreadyFilledException {
        testGame.makeMark(0, 0);
        testGame.makeMark(1, 1);
        testGame.makeMark(2, 2);
        assertThat(testGame.checkDiagonal(), is(true));
    }
    
    @Test
    @Parameters({"0, 0", "0, 1", "0, 2",
                 "1, 0", "1, 1", "1, 2",
                 "2, 0", "2, 1", "2, 2"})
    public void detectWhenGridIsFull(int row, int column) {
        testGame.makeMark(row, column);
        assertThat(testGame.isGridFull(), is(true));
    }
}
