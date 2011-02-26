package no.steria.kata.minefield;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MinefieldTest {

    @Test
    public void should_indicate_empty_minefield() throws Exception {
        assertEquals("000", cluesForSingleLineMinefield("..."));
    }

    @Test
    public void should_find_mine_at_start_of_row() throws Exception {
        assertEquals("*10", cluesForSingleLineMinefield("*.."));
    }

    @Test
    public void should_find_mine_at_end_of_row() throws Exception {
        assertEquals("01*", cluesForSingleLineMinefield("..*"));
    }

    @Test
    public void should_find_mines_side_by_side() throws Exception {
        assertEquals("1**1", cluesForSingleLineMinefield(".**."));
    }

    @Test
    public void should_find_two_mines() throws Exception {
        assertEquals("*2*", cluesForSingleLineMinefield("*.*"));
    }

    @Test
    public void should_indicate_empty_narrow() throws Exception {
        assertArrayEquals(new String[] { "0", "0", "0" }, cluesForMinefield(new String[] { ".", ".", "." }));
    }

    @Test
    public void should_find_mine_at_end_of_column() throws Exception {
        assertArrayEquals(new String[] { "0", "1", "*" }, cluesForMinefield(new String[] { ".", ".", "*" }));
    }

    @Test
    public void should_find_mine_at_start_of_column() throws Exception {
        assertArrayEquals(new String[] { "*", "1", "0" }, cluesForMinefield(new String[] { "*", ".", "." }));
    }

    @Test
    public void should_find_mine_diagonally() throws Exception {
        assertArrayEquals(new String[] { "111", "1*1", "111" }, cluesForMinefield(new String[] { "...", ".*.", "..." }));
    }

    @Test
    public void acceptance_test() throws Exception {
        assertArrayEquals(new String[] { "*100", "2210", "1*10", "1110" },
            cluesForMinefield(new String[] { "*...", "....", ".*..", "...." }));
    }

    private String[] cluesForMinefield(String[] minefield) {
        Minefield field = new Minefield(minefield);
        return field.getClues();
    }

    private String cluesForSingleLineMinefield(String minefield) {
        return cluesForMinefield(new String[] { minefield })[0];
    }

}
