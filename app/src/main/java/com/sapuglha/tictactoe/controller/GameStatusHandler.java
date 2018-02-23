package com.sapuglha.tictactoe.controller;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.sapuglha.tictactoe.BR;
import com.sapuglha.tictactoe.R;
import com.sapuglha.tictactoe.model.GameStatus;
import com.sapuglha.tictactoe.model.PlayerType;

import javax.inject.Inject;

import static com.sapuglha.tictactoe.model.GameStatus.MATRIX_SIZE;

public class GameStatusHandler extends BaseObservable {
    private final GameStatus game;

    private PlayerType winner;

    @Inject
    public GameStatusHandler(GameStatus game) {
        this.game = game;
        this.winner = PlayerType.NONE;
    }

    @BindingAdapter("image")
    public static void imageBinding(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }

    public void reset() {
        game.reset();
        winner = PlayerType.NONE;
        notifyPropertyChanged(com.sapuglha.tictactoe.BR.winner);
        notifyPropertyChanged(BR._all);
    }

    @Bindable
    public String getWinner() {
        return winner.getName();
    }

    public int getPlayerResource(int x, int y) {
        switch (game.getStatus(x, y)) {
            case X:
                return R.drawable.player_x;
            case O:
                return R.drawable.player_o;
            case NONE:
            default:
                return 0;
        }
    }

    public boolean play(int x, int y) {
        PlayerType player = game.getCurrentPlayer();

        boolean result = (game.setStatus(x, y) && checkForWinner(x, y, player));
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
            if (game.getStatus(x, j) == player) {
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
            if (game.getStatus(i, y) == player) {
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
                if (game.getStatus(i, i) == player) {
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
            if (game.getStatus(i, j) == player) {
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
