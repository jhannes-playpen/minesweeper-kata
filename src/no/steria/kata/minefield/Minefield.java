package no.steria.kata.minefield;

public class Minefield {

    private int rows;
    private int columns;
    private final String[] minefield;

    public Minefield(String[] minefield) {
        this.minefield = minefield;
        this.rows = minefield.length;
        this.columns = minefield[0].length();
    }

    public String[] getClues() {
        int[][] cluefield = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (minefield[i].charAt(j) == '*') {
                    cluefield[i][j] = -100;
                    indicateFieldHasNeighbouringMine(cluefield, i, j - 1);
                    indicateFieldHasNeighbouringMine(cluefield, i, j + 1);
                    indicateFieldHasNeighbouringMine(cluefield, i - 1, j);
                    indicateFieldHasNeighbouringMine(cluefield, i + 1, j);
                    indicateFieldHasNeighbouringMine(cluefield, i + 1, j - 1);
                    indicateFieldHasNeighbouringMine(cluefield, i + 1, j + 1);
                    indicateFieldHasNeighbouringMine(cluefield, i - 1, j - 1);
                    indicateFieldHasNeighbouringMine(cluefield, i - 1, j + 1);
                }
            }
        }
        return cluesToStrings(cluefield);
    }

    private void indicateFieldHasNeighbouringMine(int[][] cluefield, int i, int j) {
        if (isInsideField(i, j)) cluefield[i][j]++;
    }

    private boolean isInsideField(int i, int j) {
        return 0 <= j && j < columns && 0 <= i && i < rows;
    }

    private String[] cluesToStrings(int[][] cluefield) {
        String[] result = new String[rows];
        for (int i = 0; i < rows; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < columns; j++) {
                if (cluefield[i][j] < 0)
                    builder.append("*");
                else
                    builder.append(Integer.toString(cluefield[i][j]));
            }
            result[i] = builder.toString();
        }
        return result;
    }

}
