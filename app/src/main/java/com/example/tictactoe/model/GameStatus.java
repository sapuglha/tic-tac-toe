package com.example.tictactoe.model;

public class GameStatus {
    public static final short MATRIX_SIZE = 3;
    private PlayerType[][] status;
    private PlayerType currentPlayer;
    private PlayerType winner;

    public GameStatus() {
        reset();
    }

    public PlayerType getCurrentPlayer() {
        return currentPlayer;
    }

    public PlayerType getWinner() {
        return winner;
    }

    public void setWinner(PlayerType winner) {
        this.winner = winner;
    }

    public PlayerType getStatus(int x, int y) {
        return status[x][y];
    }

    public boolean setStatus(int x, int y) {
        // Check that the given location is not already played, or played by the same user
        if (status[x][y] != PlayerType.NONE
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

        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                status[i][j] = PlayerType.NONE;
            }
        }

        currentPlayer = PlayerType.X;
        winner = PlayerType.NONE;
    }

    public String toString() {
        StringBuilder matrix = new StringBuilder();
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                matrix.append(status[i][j]);
                matrix.append(", ");
            }
            matrix.append('\n');
        }
        return matrix.toString();
    }
}
