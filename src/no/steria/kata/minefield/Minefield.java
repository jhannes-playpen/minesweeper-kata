package no.steria.kata.minefield;

public class Minefield {

    private int columns;
    private int rows;
    private final String[] minefield;

    public Minefield(String[] minefield) {
        this.minefield = minefield;
        this.rows = minefield.length;
        this.columns = minefield[0].length();
    }

    public String[] getClues() {
        int[][] cluefield = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (minefield[row].charAt(column) == '*') {
                    cluefield[row][column] = -100;
                    indicateNeighbouringMine(cluefield, row, column - 1);
                    indicateNeighbouringMine(cluefield, row, column + 1);
                    indicateNeighbouringMine(cluefield, row - 1, column);
                    indicateNeighbouringMine(cluefield, row + 1, column);
                    indicateNeighbouringMine(cluefield, row + 1, column - 1);
                    indicateNeighbouringMine(cluefield, row + 1, column + 1);
                    indicateNeighbouringMine(cluefield, row - 1, column - 1);
                    indicateNeighbouringMine(cluefield, row - 1, column + 1);
                }
            }
        }
        return cluesToStrings(cluefield);
    }

    private void indicateNeighbouringMine(int[][] cluefield, int row, int column) {
        if (isInsideField(row, column)) cluefield[row][column]++;
    }

    private boolean isInsideField(int row, int column) {
        return column >= 0 && column < columns && 0 <= row && row < rows;
    }

    private String[] cluesToStrings(int[][] cluefield) {
        String[] result = new String[rows];
        for (int row = 0; row < rows; row++) {
            StringBuilder builder = new StringBuilder();
            for (int column = 0; column < columns; column++) {
                if (cluefield[row][column] < 0) {
                    builder.append("*");
                } else {
                    builder.append(Integer.toString(cluefield[row][column]));
                }
            }
            result[row] = builder.toString();
        }
        return result;
    }

}
