package com.example.tictactoe.controller;

import com.example.tictactoe.model.GameStatus;
import com.example.tictactoe.model.PlayerType;

import javax.inject.Inject;

import dagger.Module;

import static com.example.tictactoe.model.GameStatus.MATRIX_SIZE;

/**
 * Created by tiago on 2016-09-29.
 */

public class GameStatusHandler {
    private final GameStatus game;

    @Inject
    public GameStatusHandler(GameStatus game) {
        this.game = game;
    }

    public GameStatus getGame() {
        return game;
    }

    public boolean play(int x, int y) {
        PlayerType player = game.getCurrentPlayer();
        return game.setStatus(x, y) && checkForWinner(x, y, player);
    }

    private boolean checkForWinner(int x, int y, PlayerType player) {
        int winnerCount = 0;

        // Validate row, iterate columns:
        for (int j = 0; j < MATRIX_SIZE; j++) {
            if (game.getStatus(x, j) == player) {
                winnerCount++;
            } else {
                break;
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            game.setWinner(player);
            return true;
        }

        // Validate column, iterate rows:
        winnerCount = 0;
        for (int i = 0; i < MATRIX_SIZE; i++) {
            if (game.getStatus(i, y) == player) {
                winnerCount++;
            } else {
                break;
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            game.setWinner(player);
            return true;
        }

        // Validate one diagonal, but only if the played position has the same X and Y
        winnerCount = 0;
        if (x == y) {
            for (int i = 0; i < MATRIX_SIZE; i++) {
                if (game.getStatus(i, i) == player) {
                    winnerCount++;
                } else {
                    break;
                }
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            game.setWinner(player);
            return true;
        }

        // Finally, check the other diagonal
        winnerCount = 0;
        int j = 0;
        for (int i = MATRIX_SIZE - 1; i >= 0; i--) {
            if (game.getStatus(i, j) == player) {
                winnerCount++;
                j++;
            } else {
                break;
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            game.setWinner(player);
            return true;
        } else {
            return false;
        }
    }
}
