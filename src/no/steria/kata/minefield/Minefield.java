package no.steria.kata.minefield;

public class Minefield {

    private final String[] rowsOfMines;
    private int columns;
    private int rows;

    public Minefield(String[] rowsOfMines) {
        this.rowsOfMines = rowsOfMines;
        this.rows = rowsOfMines.length;
        this.columns = rowsOfMines[0].length();
    }

    public String[] getClues() {
        int[][] cluefield = new int[rows][columns];
        for (int i = 0; i < cluefield.length; i++) {
            String minefieldRow = rowsOfMines[i];
            for (int j = 0; j < minefieldRow.length(); j++) {
                if (minefieldRow.charAt(j) == '*') {
                    cluefield[i][j] = -100;
                    if (j > 0) {
                        cluefield[i][j - 1]++;
                        if (i < cluefield.length - 1)
                            cluefield[i + 1][j - 1]++;
                        if (i > 0)
                            cluefield[i - 1][j - 1]++;
                    }
                    if (j < cluefield[i].length - 1) {
                        cluefield[i][j + 1]++;
                        if (i < cluefield.length - 1)
                            cluefield[i + 1][j + 1]++;
                        if (i > 0)
                            cluefield[i - 1][j + 1]++;
                    }
                    if (i > 0)
                        cluefield[i - 1][j]++;
                    if (i < cluefield.length - 1)
                        cluefield[i + 1][j]++;
                }
            }
        }

        return clueFieldToStrings(cluefield);
    }

    private String[] clueFieldToStrings(int[][] cluefield) {
        String[] result = new String[cluefield.length];
        for (int i = 0; i < result.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < cluefield[i].length; j++) {
                if (cluefield[i][j] < 0)
                    builder.append('*');
                else
                    builder.append(Integer.toString(cluefield[i][j]));
            }
            result[i] = builder.toString();

        }
        return result;
    }

}
