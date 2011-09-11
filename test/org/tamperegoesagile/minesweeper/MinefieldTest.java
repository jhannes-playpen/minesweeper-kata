package org.tamperegoesagile.minesweeper;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MinefieldTest {

    @Test
    public void acceptance_test() throws Exception {
        assertMinefieldHints(new String[] { "*...", "....", ".*...", "...." },
                new String[] { "*100", "2210", "1*10", "1110" });
        assertMinefieldHints(new String[] { "**...", ".....", ".*..." },
                new String[] { "**100", "33200", "1*100" });
    }

    @Test
    public void should_indicate_empty_field() throws Exception {
        assertMinefieldHints(new String[] { "...", "...", "..." }, new String[] { "000", "000", "000" });
    }

    @Test
    public void should_indicate_shape_of_minefield() throws Exception {
        assertMinefieldHints(new String[] { "....", "...." }, new String[] { "0000", "0000" });
    }

    @Test
    public void should_indicate_mines() throws Exception {
        assertMinefieldHints(new String[] { "**", "**" }, new String[] { "**", "**" });
    }

    @Test
    public void should_indicate_neighbours() throws Exception {
        assertMinefieldHints(new String[] { "...", ".*.", "..." }, new String[] { "111", "1*1", "111" });
    }

    @Test
    public void should_count_mines() throws Exception {
        assertMinefieldHints(new String[] { "*.*" }, new String[] { "*2*" });
    }

    private void assertMinefieldHints(String[] mines, String[] hints) {
        Minefield minefield = new Minefield(mines);
        assertArrayEquals(hints, minefield.getHints());
    }

}
