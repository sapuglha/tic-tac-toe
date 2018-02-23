package com.example.tictactoe.controller;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.tictactoe.BR;
import com.example.tictactoe.R;
import com.example.tictactoe.model.GameStatus;
import com.example.tictactoe.model.PlayerType;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import static com.example.tictactoe.model.GameStatus.MATRIX_SIZE;

/**
 * Created by tiago on 2016-09-29.
 */

public class GameStatusHandler extends BaseObservable {
    private final GameStatus game;

    @Inject
    public GameStatusHandler(GameStatus game) {
        this.game = game;
    }

    @BindingAdapter("android:src")
    public static void setImageUrl(ImageView view, PlayerType player) {
        if (PlayerType.O.equals(player)) {
            Picasso.with(view.getContext()).load(R.drawable.player_o).into(view);
        } else if (PlayerType.X.equals(player)) {
            Picasso.with(view.getContext()).load(R.drawable.player_x).into(view);
        }
    }

    @BindingAdapter("image")
    public static void imageBinding(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }

    public void reset() {
        game.reset();
        notifyPropertyChanged(com.example.tictactoe.BR.winner);
        notifyPropertyChanged(BR._all);
    }

    @Bindable
    public String getWinner() {
        return game.getWinner().toString();
    }

    public PlayerType getPlayer(int x, int y) {
        return game.getStatus(x, y);
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
            notifyPropertyChanged(com.example.tictactoe.BR.winner);
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
