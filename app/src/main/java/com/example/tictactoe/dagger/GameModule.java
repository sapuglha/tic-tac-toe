package com.example.tictactoe.dagger;

import com.example.tictactoe.controller.GameStatusHandler;
import com.example.tictactoe.model.GameStatus;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tiago on 2016-09-30.
 */

@Module
public class GameModule {
    @Provides
    GameStatus provideGameStatus(){
        return new GameStatus();
    }

    @Provides
    GameStatusHandler provideGameStatusHandler() {
        return new GameStatusHandler(new GameStatus());
    }
}
