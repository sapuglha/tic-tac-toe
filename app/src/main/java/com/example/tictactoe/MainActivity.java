package com.example.tictactoe;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.tictactoe.databinding.ActivityMainBinding;
import com.example.tictactoe.model.GameStatus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        GameStatus gameStatus = new GameStatus();
        binding.setGameStatus(gameStatus);
//        User user = new User("Test", "User");
//        setContentView(R.layout.activity_main);
    }
}
