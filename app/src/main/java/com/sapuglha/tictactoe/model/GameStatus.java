package com.sapuglha.tictactoe.model;

import android.support.annotation.VisibleForTesting;

public class GameStatus {
    public static final short MATRIX_SIZE = 3;
    private PlayerType[][] status;
    private PlayerType currentPlayer;

    public GameStatus() {
        reset();
    }

    public PlayerType getCurrentPlayer() {
        return currentPlayer;
    }

    public PlayerType getStatus(int x, int y) {
        return status[x][y];
    }

    public boolean setStatus(int x, int y) {
        // Check that the given location is not already played, or played by the same user
        if (status[x][y] != null
                || status[x][y] == currentPlayer) {
            return false;
        }

        // assign the player to that position
        status[x][y] = currentPlayer;

        // Set the next player
        if (currentPlayer == PlayerType.X) {
            currentPlayer = PlayerType.O;
        } else {
            currentPlayer = PlayerType.X;
        }

        return true;
    }

    public void reset() {
        status = new PlayerType[MATRIX_SIZE][MATRIX_SIZE];

        currentPlayer = PlayerType.X;
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public String getMatrix() {
        StringBuilder matrix = new StringBuilder();
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                if (null != status[i][j]) {
                    matrix.append(status[i][j].toString());
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
