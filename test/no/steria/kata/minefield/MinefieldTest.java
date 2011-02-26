package no.steria.kata.minefield;

import org.junit.Assert;
import org.junit.Test;

public class MinefieldTest {

    @Test
    public void should_indicate_empty_minefield() throws Exception {
        assertMinefieldHasClues(new String[] { "...", "...", "..." }, new String[] { "000", "000", "000" });
    }

    @Test
    public void should_indicate_minefield_of_correct_shape() throws Exception {
        assertMinefieldHasClues(new String[] { "....", "...." }, new String[] { "0000", "0000" });
    }

    @Test
    public void should_find_minefield_at_start_of_row() throws Exception {
        assertMinefieldHasClues(new String[] { "*.." }, new String[] { "*10" });
    }

    @Test
    public void should_find_minefield_at_end_of_row() throws Exception {
        assertMinefieldHasClues(new String[] { "..*" }, new String[] { "01*" });
    }

    @Test
    public void should_find_two_minefields_in_row() throws Exception {
        assertMinefieldHasClues(new String[] { "*.*" }, new String[] { "*2*" });
    }

    @Test
    public void should_find_minefield_at_end_of_column() throws Exception {
        assertMinefieldHasClues(new String[] { ".", ".", "*" }, new String[] { "0", "1", "*" });
    }

    @Test
    public void should_indicate_all_neighbours() throws Exception {
        assertMinefieldHasClues(new String[] { "...", ".*.", "..." }, new String[] { "111", "1*1", "111" });
    }

    @Test
    public void acceptance_test() throws Exception {
        assertMinefieldHasClues(new String[] { "*...", "....", ".*..", "...." },
            new String[] { "*100", "2210", "1*10", "1110" });
    }

    private void assertMinefieldHasClues(String[] minefield, String[] clues) {
        Minefield field = new Minefield(minefield);
        Assert.assertArrayEquals(clues, field.getClues());
    }
}
