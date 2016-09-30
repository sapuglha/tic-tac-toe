package com.example.tictactoe.model;

/**
 * Created by tiago on 2016-09-29.
 */

public class GameStatus {
    public static final short MATRIX_SIZE = 3;
    public PlayerType[][] status;
    private PlayerType currentPlayer;
    private PlayerType winner;

    public GameStatus() {
        reset();
    }

    public PlayerType getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(PlayerType next) {
        currentPlayer = next;
    }

    public String getWinner() {
        switch (winner) {
            case X:
                return "X";
            case O:
                return "O";
            case NONE:
            default:
                return "";
        }
    }

    public void setWinner(PlayerType winner) {
        this.winner = winner;
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
            matrix.append("\n");
        }
        return matrix.toString();
    }
}
