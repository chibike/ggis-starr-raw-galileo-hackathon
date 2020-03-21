package com.example.ggis_starr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class SplashScreen extends AppCompatActivity {

    Thread splashTread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        startAnimations();
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    /**
     * Handles the animation, launching the login screen and the finally exiting of the App
     */
    private void startAnimations()
    {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l_layout = (LinearLayout)findViewById(R.id.splash_screen_layout);
        l_layout.clearAnimation();
        l_layout.startAnimation(anim);

        splashTread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    int waited = 0;
                    while (waited < 3500)
                    {
                        sleep(100);
                        waited += 100;
                    }

                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                    startActivity(intent);
                    SplashScreen.this.finish();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    SplashScreen.this.finish();
                }
            }
        };

        splashTread.start();
    }
}
