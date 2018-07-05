import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by xopher on 05/07/2018.
 */
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
}
