package org.tamperegoesagile.minesweeper;

public class Minefield {

    private static final int MINE = -100;
    private final String[] mines;
    private int[][] hints;

    public Minefield(String[] mines) {
        this.mines = mines;
        this.hints = new int[mines.length][mines[0].length()];
        for(int row = 0; row < mines.length ; row++ ){
            for (int column = 0; column < mines[row].length(); column++) {
                if( isAMine(row, column) ) {
                    hints[row][column] = MINE;
                    if (isPositionOnMinefield(row, column+1)) {
                        hints[row][column+1] = 1;
                    }
                }
            }
        }
    }

    private boolean isPositionOnMinefield(int row, int column) {
        return column < hints[row].length;
    }

    private boolean isAMine(int row, int column) {
        return mines[row].charAt(column) == '*';
    }

    public String[] getHints() {
        String[] hintStrings = new String[mines.length];
        for(int row = 0; row < mines.length ; row++ ){
            StringBuilder hintLine = new StringBuilder();
            for (int column = 0; column < mines[row].length(); column++) {
                if (hints[row][column] == MINE) {
                    hintLine.append("*");
                } else {
                    hintLine.append(hints[row][column]);
                }
            }
            hintStrings[row] = hintLine.toString();
        }
        return hintStrings;
    }

}
