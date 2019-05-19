package marvel.android.game;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import marvel.android.castleattackers.game.try2.castleattackers.CastleInvaders;
import marvel.android.flappygame.FlappyGame;
import marvel.android.raindrops.Drop;

public class AndroidLauncher extends AndroidApplication {
    public static boolean on = false;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        //cfg.useGL20 = true;
        cfg.useAccelerometer = false;
        cfg.useCompass = false;
        cfg.useWakelock = true;

        Intent i = getIntent();
        int type = i.getExtras().getInt("type");
        if (!on) {
            switch (type) {
                case 0: initialize(new CastleInvaders(), cfg); return;
                case 1: setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    initialize(new FlappyGame(), cfg); return;
                case 2: initialize(new Drop(), cfg); return;
                default: setResult(RESULT_CANCELED);
                on = true;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        on = false;
    }
}
