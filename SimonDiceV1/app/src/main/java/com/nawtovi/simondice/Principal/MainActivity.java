package com.nawtovi.simondice.Principal;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.nawtovi.simondice.Control.Control;
import com.nawtovi.simondice.Control.Reproductor;
import com.nawtovi.simondice.Modelo.MyButton;
import com.nawtovi.simondice.Modelo.MyColors;
import com.nawtovi.simondice.R;

public class MainActivity extends AppCompatActivity {


    private MyButton[] botones = new MyButton[5];
    private final Context context=this;

    @Override
    protected synchronized void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        fillSounds();

        botones[4].getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones[4].playSound();
                new Control(context,botones);
            }
        });

    }

    private void fillSounds() {
        botones[0] = new MyButton(this, R.raw.sound1, MyColors.RED, (ImageView) findViewById(R.id.imgRed1));
        botones[1] = new MyButton(this, R.raw.sound2, MyColors.BLUE, (ImageView) findViewById(R.id.imgBlue2));
        botones[2] = new MyButton(this, R.raw.sound3, MyColors.GREEN, (ImageView) findViewById(R.id.imgGreen3));
        botones[3] = new MyButton(this, R.raw.sound4, MyColors.YELLOW, (ImageView) findViewById(R.id.imgYellow4));
        botones[4] = new MyButton(this, R.raw.bocina, MyColors.CENTER, (ImageView) findViewById(R.id.imgCenter5));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Reproductor.setHilo(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Reproductor.setHilo(true);
    }

}
