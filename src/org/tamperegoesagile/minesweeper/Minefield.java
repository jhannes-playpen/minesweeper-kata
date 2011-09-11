package org.tamperegoesagile.minesweeper;

public class Minefield {

    private int[][] hints;

    public Minefield(String[] minefield) {
        hints = new int[minefield.length][minefield[0].length()];
        for (int line = 0; line < minefield.length; line++) {
            for (int pos = 0; pos<minefield[line].length(); pos++) {
                if (minefield[line].charAt(pos) == '*') {
                    indicateMine(line, pos);
                    indicateNeighbouringMine(line-1, pos-1);
                    indicateNeighbouringMine(line-1, pos);
                    indicateNeighbouringMine(line-1, pos+1);
                    indicateNeighbouringMine(line, pos-1);
                    indicateNeighbouringMine(line, pos+1);
                    indicateNeighbouringMine(line+1, pos-1);
                    indicateNeighbouringMine(line+1, pos);
                    indicateNeighbouringMine(line+1, pos+1);
                }
            }
        }
    }

    private void indicateMine(int line, int pos) {
        hints[line][pos] = -100;
    }

    private void indicateNeighbouringMine(int line, int position) {
        if (line < 0 || hints.length <= line) return;
        if (position < 0 || hints[line].length <= position) return;
        hints[line][position] += 1;
    }

    public String[] getHints() {
        return hintsAsString();
    }

    private String[] hintsAsString() {
        String[] result = new String[hints.length];
        for (int i = 0; i < hints.length; i++) {
            result[i] = hintLineAsString(hints[i]);
        }
        return result;
    }

    private String hintLineAsString(int[] hintLine) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < hintLine.length; i++) {
            result.append(hintLine[i] < 0 ? "*" : String.valueOf(hintLine[i]));
        }
        return result.toString();
    }

}
