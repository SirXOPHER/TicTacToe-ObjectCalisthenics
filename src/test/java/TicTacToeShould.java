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
    public void ensurePlayerXalwaysGoesFirst() {
        assertThat(testGame.makeMark(), is("X"));
    }

    @Test
    public void alternateBetweenTwoPlayers() {
        testGame.makeMark();
        assertThat(testGame.makeMark(), is("X"));
    }
}
