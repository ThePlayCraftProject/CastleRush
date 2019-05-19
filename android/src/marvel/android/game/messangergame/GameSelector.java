package marvel.android.game.messangergame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.badlogic.gdx.Game;

import marvel.android.game.AndroidLauncher;
import marvel.android.game.R;

public class GameSelector extends AppCompatActivity {
    private boolean on = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_selector);
    }

    @Override
    protected void onResume() {
        super.onResume();
        on = false;
    }

    public void onRush(View v) {
        if (!on) {
            Intent i = new Intent(GameSelector.this, AndroidLauncher.class);
            i.putExtra("type", 0);
            startActivity(i);
            on = true;
        }
    }
    public void onFlappy(View v) {
        if (!on) {
            Intent i = new Intent(GameSelector.this, AndroidLauncher.class);
            i.putExtra("type", 1);
            startActivity(i);
            on = true;
        }
    }
    public void onRainy(View v) {
        if (!on) {
            Intent i = new Intent(GameSelector.this, AndroidLauncher.class);
            i.putExtra("type", 2);
            startActivity(i);
            on = true;
        }
    }
}
