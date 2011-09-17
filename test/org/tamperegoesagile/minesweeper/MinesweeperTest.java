package org.tamperegoesagile.minesweeper;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Ignore;
import org.junit.Test;

public class MinesweeperTest {

    @Test
    @Ignore
    public void acceptance_test() throws Exception {
        assertMinefieldHints(new String[] {"*...", "....", ".*..", "...."},
                new String[] {"*100", "2210", "1*10", "1110"});
    }

    private void assertMinefieldHints(String[] mines, String[] hints) {
        Minefield minefield = new Minefield(mines);
        assertArrayEquals(hints, minefield.getHints());
    }


    @Test
    public void should_return_all_zeroes_for_zero_mines() throws Exception {
        assertMinefieldHints(new String[]{"...."} , new String[] { "0000"} );
    }

    @Test
    public void should_indicate_field_dimensions() throws Exception {
        assertMinefieldHints(new String[] { "...", "...", "..."},
                new String[] { "000", "000", "000"});
    }

    @Test
    public void should_indicate_mines() throws Exception {
        assertMinefieldHints(new String[] { "***", "***" },
                             new String[] { "***", "***" });
    }

    @Test
    public void should_indicate_neighbouring_mines() throws Exception {
        assertMinefieldHints(new String[]{"*.."}, new String[] {"*10"});
    }
}
