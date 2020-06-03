package com.example.EurovegasMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class splash_inicio extends AppCompatActivity {

    // TIEMPO QUE QUIERO QUE DURE EL SPLASH DEL INICIO (MILISEGUNDOS)
    private final int DURACION_SPLASH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_inicio);

        //Aquí vamos a indicar a que activity nos tiene que redireccionar tras pasar los 3 segundos de splash
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash_inicio.this, Pantalla_Inicio_Sesion.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);

    }
}
