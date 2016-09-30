package com.example.tictactoe.controller;

import com.example.tictactoe.model.GameStatus;
import com.example.tictactoe.model.PlayerType;

import static com.example.tictactoe.model.GameStatus.MATRIX_SIZE;

/**
 * Created by tiago on 2016-09-29.
 */

public class GameStatusHandler {
    private final GameStatus game;

    public GameStatusHandler(GameStatus game) {
        this.game = game;
    }

    public GameStatus getGame(){
        return game;
    }

    public boolean play(int x, int y) {
        PlayerType currentPlayer = game.getCurrentPlayer();

        // This is probably at the wrong place
        if (game.status[x][y] != PlayerType.NONE
                || game.status[x][y] == currentPlayer) {
            return false;
        }

        game.status[x][y] = currentPlayer;

        boolean response = checkForWinner(x, y);

        if (currentPlayer == PlayerType.X) {
            game.setCurrentPlayer(PlayerType.O);
        } else {
            game.setCurrentPlayer(PlayerType.X);
        }

        return response;
    }

    private boolean checkForWinner(int x, int y) {
        int winnerCount = 0;
        PlayerType currentPlayer = game.getCurrentPlayer();

        // Validate row, iterate columns:
        for (int j = 0; j < MATRIX_SIZE; j++) {
            if (game.status[x][j] == currentPlayer) {
                winnerCount++;
            } else {
                break;
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            game.setWinner(currentPlayer);
            return true;
        }

        // Validate column, iterate rows:
        winnerCount = 0;
        for (int i = 0; i < MATRIX_SIZE; i++) {
            if (game.status[i][y] == currentPlayer) {
                winnerCount++;
            } else {
                break;
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            game.setWinner(currentPlayer);
            return true;
        }

        // Validate one diagonal, but only if the played position has the same X and Y
        winnerCount = 0;
        if (x == y) {
            for (int i = 0; i < MATRIX_SIZE; i++) {
                if (game.status[i][i] == currentPlayer) {
                    winnerCount++;
                } else {
                    break;
                }
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            game.setWinner(currentPlayer);
            return true;
        }

        // Finally, check the other diagonal
        winnerCount = 0;
        int j = 0;
        for (int i = MATRIX_SIZE - 1; i >= 0; i--) {
            if (game.status[i][j] == currentPlayer) {
                winnerCount++;
                j++;
            } else {
                break;
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            game.setWinner(currentPlayer);
            return true;
        } else {
            return false;
        }
    }
}
