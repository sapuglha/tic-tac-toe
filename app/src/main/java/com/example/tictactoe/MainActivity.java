package com.example.tictactoe;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.tictactoe.controller.GameStatusHandler;
import com.example.tictactoe.dagger.DaggerGameComponent;
import com.example.tictactoe.dagger.GameComponent;
import com.example.tictactoe.dagger.GameModule;
import com.example.tictactoe.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private GameStatusHandler handler;

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_game:
                handler.reset();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
