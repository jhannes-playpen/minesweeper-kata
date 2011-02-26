package no.steria.kata.minefield;

import org.junit.Assert;
import org.junit.Test;

public class MinesweeperTest {

    @Test
    public void should_indicate_empty_field() throws Exception {
        assertMinefieldHasClues(new String[] { "...", "...", "..." }, new String[] { "000", "000", "000" });
    }

    @Test
    public void should_support_other_field_sizes() throws Exception {
        assertMinefieldHasClues(new String[] { ".....", "....." }, new String[] { "00000", "00000" });
    }

    @Test
    public void should_indicate_filled_field() throws Exception {
        assertMinefieldHasClues(new String[] { "**", "**" }, new String[] { "**", "**" });
    }

    @Test
    public void should_find_mine_in_front_of_row() throws Exception {
        assertMinefieldHasClues(new String[] { "*.." }, new String[] { "*10" });
    }

    @Test
    public void should_find_mine_at_end_of_row() throws Exception {
        assertMinefieldHasClues(new String[] { "..*" }, new String[] { "01*" });
    }

    @Test
    public void should_add_number_of_mines() throws Exception {
        assertMinefieldHasClues(new String[] { "*.*" }, new String[] { "*2*" });
    }

    @Test
    public void should_find_mine_at_end_of_column() throws Exception {
        assertMinefieldHasClues(new String[] { ".", ".", "*" }, new String[] { "0", "1", "*" });
    }

    @Test
    public void should_find_all_neighbouring_mines() throws Exception {
        assertMinefieldHasClues(new String[] { "...", ".*.", "..." }, new String[] { "111", "1*1", "111" });
    }

    @Test
    public void acceptance_tests() throws Exception {
        assertMinefieldHasClues(new String[] { "*...", "....", ".*..", "...." },
            new String[] { "*100", "2210", "1*10", "1110" });
        assertMinefieldHasClues(new String[] { "**...", ".....", ".*..." },
            new String[] { "**100", "33200", "1*100" });
    }

    private void assertMinefieldHasClues(String[] mines, String[] expectedClues) {
        Minefield minefield = new Minefield(mines);
        Assert.assertArrayEquals(expectedClues, minefield.getClues());
    }

}
