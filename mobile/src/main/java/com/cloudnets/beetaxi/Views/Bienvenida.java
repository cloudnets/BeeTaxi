package com.cloudnets.beetaxi.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.cloudnets.beetaxi.R;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

/**
 * Creado por Deimer Villa on 28/10/2015.
 */
public class Bienvenida extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bienvenida);
        iniciarAnimacion();
        iniciarAnimacion2();
        cambiarActivity();
    }

    public void animarLogo(){
        YoYo.with(Techniques.Swing)
                .duration(700)
                .playOn(findViewById(R.id.img_logo_bee));
    }

    public void iniciarAnimacion(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animarLogo();
            }
        }, 2000);
    }

    public void iniciarAnimacion2(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animarLogo();
            }
        }, 3200);
    }

    public void cambiarActivity(){
        Thread timer = new Thread() {
            // El nuevo Thread exige el metodo run
            public void run() {
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    avanzar();
                }
            }
        };
        timer.start();
    }

    public void avanzar(){
        Intent principal = new Intent(Bienvenida.this,Menu.class);
        startActivity(principal);
        finish();
    }

}
