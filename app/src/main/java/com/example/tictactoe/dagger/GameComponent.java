package com.example.tictactoe.dagger;

import com.example.tictactoe.controller.GameStatusHandler;

import dagger.Component;

/**
 * Created by tiago on 2016-09-30.
 */

@Component(modules = {GameModule.class})
public interface GameComponent {
    GameStatusHandler provideGameStatusHandler();
}
