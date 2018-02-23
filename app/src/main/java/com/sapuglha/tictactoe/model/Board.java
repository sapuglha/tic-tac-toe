package com.sapuglha.tictactoe.model;

import android.support.annotation.VisibleForTesting;

public class Board {
    public static final short MATRIX_SIZE = 3;
    private PlayerType[][] board;

    public Board() {
        reset();
    }

    public PlayerType getPosition(int x, int y) {
        return board[x][y];
    }

    public boolean setPosition(int x, int y, PlayerType currentPlayer) {
        // Check that the given location is not already played, or played by the same user
        if (board[x][y] != null || board[x][y] == currentPlayer) {
            return false;
        }

        // assign the player to that position
        board[x][y] = currentPlayer;

        return true;
    }

    public void reset() {
        board = new PlayerType[MATRIX_SIZE][MATRIX_SIZE];
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public String getMatrix() {
        StringBuilder matrix = new StringBuilder();
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                if (null != board[i][j]) {
                    matrix.append(board[i][j].toString());
                } else {
                    matrix.append("-");
                }
                matrix.append(" ");
            }
            matrix.append('\n');
        }
        return matrix.toString();
    }
}
