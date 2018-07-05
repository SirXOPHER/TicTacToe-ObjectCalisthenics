import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by xopher on 05/07/2018.
 */
public class TicTacToeShould {

    @Test
    public void ensurePlayerXalwaysGoesFirst() {
        assertThat(new TicTacToe().makeMark(), is("X"));
    }
}
