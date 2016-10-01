package com.example.tictactoe;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.tictactoe.controller.GameStatusHandler;
import com.example.tictactoe.dagger.DaggerGameComponent;
import com.example.tictactoe.dagger.GameComponent;
import com.example.tictactoe.dagger.GameModule;
import com.example.tictactoe.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    GameStatusHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        GameComponent component = DaggerGameComponent
                .builder()
                .gameModule(new GameModule())
                .build();

        handler = component.provideGameStatusHandler();

        binding.setGameHandler(handler);
        binding.setGameStatus(handler.getGame());
    }
}
