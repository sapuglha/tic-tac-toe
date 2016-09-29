package com.example.tictactoe.model;

/**
 * Created by tiago on 2016-09-29.
 */

public class GameStatus {
    private static final short MATRIX_SIZE = 3;
    private PlayerType[][] status;

    public GameStatus() {
        reset();
    }

    public void reset(){
        status = new PlayerType[MATRIX_SIZE][MATRIX_SIZE];

        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                status[i][j] = PlayerType.NONE;
            }
        }
    }

    public boolean play(int x, int y, PlayerType type) {
        if (status[x][y] != PlayerType.NONE
                || status[x][y] == type) {
            return false;
        }

        status[x][y] = type;
        return true;
    }

    public boolean checkForWinner(int x, int y, PlayerType type) {
        int winnerCount = 0;

        // Validate row, iterate columns:
        for (int j = 0; j < MATRIX_SIZE; j++) {
            if (status[x][j] == type) {
                winnerCount++;
            } else {
                break;
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            return true;
        }

        // Validate column, iterate rows:
        winnerCount = 0;
        for (int i = 0; i < MATRIX_SIZE; i++) {
            if (status[i][y] == type) {
                winnerCount++;
            } else {
                break;
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            return true;
        }

        // Validate one diagonal, but only if the played position has the same X and Y
        winnerCount = 0;
        if (x == y) {
            for (int i = 0; i < MATRIX_SIZE; i++) {
                if (status[i][i] == type) {
                    winnerCount++;
                } else {
                    break;
                }
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            return true;
        }

        // Finally, check the other diagonal
        winnerCount = 0;
        int j = 0;
        for (int i = MATRIX_SIZE - 1; i >= 0; i--) {
            if (status[i][j] == type) {
                winnerCount++;
                j++;
            } else {
                break;
            }
        }

        return winnerCount == MATRIX_SIZE;
    }

    public String toString() {
        StringBuilder matrix = new StringBuilder();
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                matrix.append(status[i][j]);
                matrix.append(", ");
            }
            matrix.append("\n");
        }
        return matrix.toString();
    }
}
