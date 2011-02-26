package no.steria.kata.minefield;

public class Minefield {

    private int columns;
    private int rows;
    private final String[] field;

    public Minefield(String[] field) {
        this.field = field;
        this.rows = field.length;
        this.columns = field[0].length();
    }

    public String[] getClues() {
        int[][] clues = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (field[i].charAt(j) == '*') {
                    clues[i][j] = -100;
                    indicateCloseMine(clues, i, j - 1);
                    indicateCloseMine(clues, i, j + 1);
                    indicateCloseMine(clues, i - 1, j);
                    indicateCloseMine(clues, i + 1, j);
                    indicateCloseMine(clues, i - 1, j - 1);
                    indicateCloseMine(clues, i - 1, j + 1);
                    indicateCloseMine(clues, i + 1, j - 1);
                    indicateCloseMine(clues, i + 1, j + 1);
                }
            }
        }
        return cluesAsString(clues);
    }

    private void indicateCloseMine(int[][] clues, int i, int j) {
        if (isOnBoard(i, j)) clues[i][j]++;
    }

    private boolean isOnBoard(int i, int j) {
        return 0 <= j && j < columns && 0 <= i && i < rows;
    }

    private static String[] cluesAsString(int[][] clues) {
        String[] cluesStrings = new String[clues.length];
        for (int i = 0; i < clues.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < clues[i].length; j++) {
                if (clues[i][j] < 0) {
                    stringBuilder.append("*");
                } else {
                    stringBuilder.append(Integer.toString(clues[i][j]));
                }
            }
            cluesStrings[i] = stringBuilder.toString();
        }

        return cluesStrings;
    }

}
