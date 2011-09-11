package org.tamperegoesagile.minefield;

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
    public void empty_field_has_no_hints() throws Exception {
        assertMinefieldHints(new String[] { "...", "...", "..."},
                new String[] { "000", "000", "000"});
        assertMinefieldHints(new String[] { "....", "...."},
                new String[] { "0000", "0000"});
    }

    @Test
    public void should_indicate_mines_for_filled_field() throws Exception {
        assertMinefieldHints(new String[] { "*****", "*****" },
                new String[] { "*****", "*****" });
    }

    @Test
    public void should_find_mine_at_start_of_row() throws Exception {
        assertMinefieldHints(new String[] { "*.." }, new String[] { "*10" });
    }

    @Test
    public void should_find_mine_at_end_of_row() throws Exception {
        assertMinefieldHints(new String[] { "..*" }, new String[] { "01*" });
    }

    @Test
    public void should_find_mine_at_end_of_column() throws Exception {
        assertMinefieldHints(new String[] { ".", ".", "*" }, new String[] { "0", "1", "*" });
    }

    @Test
    public void should_find_mine_at_start_of_column() throws Exception {
        assertMinefieldHints(new String[] { "*", ".", "." }, new String[] { "*", "1", "0" });
    }

    @Test
    public void should_indicate_all_neighbours() throws Exception {
        assertMinefieldHints(new String[] { "...", ".*.", "..." }, new String[] { "111", "1*1", "111" });
    }

    @Test
    public void should_count_mines() throws Exception {
        assertMinefieldHints(new String[] { "*.*" }, new String[] { "*2*" });
    }

    private void assertMinefieldHints(String[] minefield, String[] expectedHints) {
        Minefield field = new Minefield(minefield);
        assertArrayEquals(expectedHints, field.getHints());
    }

}
