package no.steria.kata.minefield;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MinesweeperTest {

    @Test
    public void should_indicate_empty_field() {
        assertMinefieldHasClues(new String[] { "...", "...", "..." }, new String[] { "000", "000", "000" });
    }

    @Test
    public void should_has_clues_for_right_size_of_field() {
        assertMinefieldHasClues(new String[] { "....", "...." }, new String[] { "0000", "0000" });
    }

    @Test
    public void should_indicate_filled_field() {
        assertMinefieldHasClues(new String[] { "***", "***" }, new String[] { "***", "***" });
    }

    @Test
    public void should_find_mine_at_start_of_row() {
        assertMinefieldHasClues(new String[] { "*.." }, new String[] { "*10" });
    }

    @Test
    public void should_find_mine_at_end_of_row() {
        assertMinefieldHasClues(new String[] { "..*" }, new String[] { "01*" });
    }

    @Test
    public void should_add_number_of_mines() {
        assertMinefieldHasClues(new String[] { "*.*" }, new String[] { "*2*" });
    }

    @Test
    public void should_find_mine_at_end_of_column() {
        assertMinefieldHasClues(new String[] { ".", ".", "*" }, new String[] { "0", "1", "*" });
    }

    @Test
    public void should_find_all_neighbouring_mines() {
        assertMinefieldHasClues(new String[] { "...", ".*.", "..." }, new String[] { "111", "1*1", "111" });
    }

    @Test
    public void acceptance_test() {
        assertMinefieldHasClues(new String[] { "*...", "....", ".*...", "...." },
            new String[] { "*100", "2210", "1*10", "1110" });
        assertMinefieldHasClues(new String[] { "**...", ".....", ".*..." },
            new String[] { "**100", "33200", "1*100" });
    }

    private void assertMinefieldHasClues(String[] mines, String[] expectedClues) {
        Minefield minefield = new Minefield(mines);
        assertArrayEquals(expectedClues, minefield.getClues());
    }

}
