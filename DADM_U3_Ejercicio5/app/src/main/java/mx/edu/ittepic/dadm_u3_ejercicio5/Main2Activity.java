package mx.edu.ittepic.dadm_u3_ejercicio5;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {
MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo (this));


    }
    public void amarillo(){
        mp = MediaPlayer.create(this, R.raw.amarillo);
        mp.start();
    }
    public void negro(){
        mp = MediaPlayer.create(this, R.raw.negro);
        mp.start();
    }
    public void morado(){
        mp = MediaPlayer.create(this, R.raw.morado);
        mp.start();
    }
    public void verde(){
        mp = MediaPlayer.create(this, R.raw.verde);
        mp.start();
    }
    public void azul(){
        mp = MediaPlayer.create(this, R.raw.azul);
        mp.start();
    }
    public void naranja(){
        mp = MediaPlayer.create(this, R.raw.naranja);
        mp.start();
    }
}
