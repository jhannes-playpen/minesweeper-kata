package org.tamperegoesagile.minefield;

public class Minefield {

    private final String[] minefield;
    private int[][] hints;

    public Minefield(String[] minefield) {
        this.minefield = minefield;
        hints = new int[minefield.length][minefield[0].length()];
        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[i].length(); j++) {
                if (hasMineInLocation(i, j)) {
                    indicateMine(i, j);
                    indicateNeighbouringMine(i-1, j+1);
                    indicateNeighbouringMine(i, j+1);
                    indicateNeighbouringMine(i+1, j+1);
                    indicateNeighbouringMine(i-1, j);
                    indicateNeighbouringMine(i+1, j);
                    indicateNeighbouringMine(i-1, j-1);
                    indicateNeighbouringMine(i, j-1);
                    indicateNeighbouringMine(i+1, j-1);
                }
            }
        }
    }

    private void indicateMine(int i, int j) {
        hints[i][j] = -99;
    }

    private void indicateNeighbouringMine(int line, int pos) {
        if (0<=line && line <hints.length && 0<=pos && pos<hints[line].length) {
            hints[line][pos]++;
        }
    }

    public String[] getHints() {
        return hintsAsString(hints);
    }

    private String[] hintsAsString(int[][] hints) {
        String[] result = new String[hints.length];
        for (int i = 0; i < hints.length; i++) {
            result[i] = hintLineAsString(hints[i]);
        }
        return result;
    }

    private String hintLineAsString(int[] hints) {
        StringBuilder result = new StringBuilder();
        for (int hint : hints) {
            if (hint < 0) result.append("*");
            else result.append(String.valueOf(hint));
        }
        return result.toString();
    }

    private boolean hasMineInLocation(int i, int j) {
        return 0 <= j && j < minefield[i].length() && minefield[i].charAt(j) == '*';
    }

}
