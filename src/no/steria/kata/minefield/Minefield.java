package no.steria.kata.minefield;

public class Minefield {

    private final String[] mines;
    private final int columns;
    private final int rows;

    public Minefield(String[] mines) {
        this.mines = mines;
        this.rows = mines.length;
        this.columns = mines[0].length();
    }

    public String[] getClues() {
        int[][] clues = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                if (mines[i].charAt(j) == '*') {
                    clues[i][j] = -100;
                    indicateNeighbouringMine(clues, i, j - 1);
                    indicateNeighbouringMine(clues, i, j + 1);
                    indicateNeighbouringMine(clues, i - 1, j);
                    indicateNeighbouringMine(clues, i + 1, j);
                    indicateNeighbouringMine(clues, i + 1, j + 1);
                    indicateNeighbouringMine(clues, i + 1, j - 1);
                    indicateNeighbouringMine(clues, i - 1, j + 1);
                    indicateNeighbouringMine(clues, i - 1, j - 1);
                }
        }
        return cluesAsString(clues);
    }

    private void indicateNeighbouringMine(int[][] clues, int i, int j) {
        if (isInsideMinefield(i, j)) clues[i][j]++;
    }

    private boolean isInsideMinefield(int i, int j) {
        return 0 <= i && i < rows && 0 <= j && j < columns;
    }

    private String[] cluesAsString(int[][] clues) {
        String[] result = new String[rows];
        for (int i = 0; i < rows; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < columns; j++) {
                if (clues[i][j] < 0)
                    builder.append("*");
                else
                    builder.append(Integer.toString(clues[i][j]));
            }
            result[i] = builder.toString();
        }
        return result;
    }

}
