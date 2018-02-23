package com.sapuglha.tictactoe.controller;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.sapuglha.tictactoe.BR;
import com.sapuglha.tictactoe.R;
import com.sapuglha.tictactoe.model.Board;
import com.sapuglha.tictactoe.model.PlayerType;

import javax.inject.Inject;

import static com.sapuglha.tictactoe.model.Board.MATRIX_SIZE;

public class GameStatusHandler extends BaseObservable {
    private final Board game;

    private PlayerType winner;
    private PlayerType currentPlayer;

    @Inject
    public GameStatusHandler(Board game) {
        this.game = game;
        this.winner = null;
        this.currentPlayer = PlayerType.X;
    }

    @BindingAdapter("image")
    public static void imageBinding(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }

    public void reset() {
        game.reset();
        winner = null;
        currentPlayer = PlayerType.X;

        notifyPropertyChanged(com.sapuglha.tictactoe.BR.winner);
        notifyPropertyChanged(BR._all);
    }

    @Bindable
    public String getWinner() {
        if (null != winner) return winner.toString();
        return "";
    }

    public int getPlayerResource(int x, int y) {
        PlayerType position = game.getPosition(x, y);
        if (null == position) return 0;
        switch (position) {
            case X:
                return R.drawable.player_x;
            case O:
                return R.drawable.player_o;
            default:
                return 0;
        }
    }

    private void setNextPlayer() {
        if (currentPlayer == PlayerType.X) {
            currentPlayer = PlayerType.O;
        } else {
            currentPlayer = PlayerType.X;
        }
    }

    public boolean play(int x, int y) {
        boolean result = (game.setPosition(x, y, currentPlayer) && checkForWinner(x, y, currentPlayer));
        setNextPlayer();
        if (result) {
            notifyPropertyChanged(com.sapuglha.tictactoe.BR.winner);
        }
        notifyPropertyChanged(BR._all);
        return result;
    }

    private boolean checkForWinner(int x, int y, PlayerType player) {
        int winnerCount = 0;

        // Validate row, iterate columns:
        for (int j = 0; j < MATRIX_SIZE; j++) {
            if (game.getPosition(x, j) == player) {
                winnerCount++;
            } else {
                break;
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            winner = player;
            return true;
        }

        // Validate column, iterate rows:
        winnerCount = 0;
        for (int i = 0; i < MATRIX_SIZE; i++) {
            if (game.getPosition(i, y) == player) {
                winnerCount++;
            } else {
                break;
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            winner = player;
            return true;
        }

        // Validate one diagonal, but only if the played position has the same X and Y
        winnerCount = 0;
        if (x == y) {
            for (int i = 0; i < MATRIX_SIZE; i++) {
                if (game.getPosition(i, i) == player) {
                    winnerCount++;
                } else {
                    break;
                }
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            winner = player;
            return true;
        }

        // Finally, check the other diagonal
        winnerCount = 0;
        int j = 0;
        for (int i = MATRIX_SIZE - 1; i >= 0; i--) {
            if (game.getPosition(i, j) == player) {
                winnerCount++;
                j++;
            } else {
                break;
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            winner = player;
            return true;
        } else {
            return false;
        }
    }
}
