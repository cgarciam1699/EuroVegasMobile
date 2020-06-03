package com.example.EurovegasMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class carrera_caballos_a_correr extends AppCompatActivity {

    int resultadoTotal, velocidad1, velocidad2, velocidad3, apuesta1, apuesta2, apuesta3;
    Button bt_volver_menu;
    Random r;
    ImageView calle1, calle2, calle3;
    String CaballoP1, CaballoP2, CaballoP3;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera_caballos_a_correr);

        calle1 = findViewById(R.id.Calle1);
        calle2 = findViewById(R.id.Calle2);
        calle3 = findViewById(R.id.Calle3);
        bt_volver_menu = findViewById(R.id.bt_volver_al_menu);

        resultado = findViewById(R.id.resultado);

        Bundle extras = getIntent().getExtras();
        apuesta1 = extras.getInt("apuestaJuga1");
        apuesta2 = extras.getInt("apuestaJuga2");
        apuesta3 = extras.getInt("apuesta3");

        CaballoP1 = extras.getString("seleccion1");
        CaballoP2 = extras.getString("seleccion2");
        CaballoP3 = extras.getString("seleccion3");

        r = new Random();

        caballoCalle();

        carrera();

        MiThread hilo = new MiThread();
        hilo.start();

    }

    public void vueltaAJugar(View view){

        Intent intent = new Intent(this, Principal_carrera_caballos.class);
        startActivity(intent);

    }

    public void carrera(){

        velocidad1 = r.nextInt(5000-1000+1)+1000;
        velocidad2 = r.nextInt(5000-1000+1)+1000;
        velocidad3 = r.nextInt(5000-1000+1)+1000;

        TranslateAnimation anim_delante1 = new TranslateAnimation(0.0f, 0.0f, 0.0f, 1200.0f);
        TranslateAnimation anim_delante2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, 1200.0f);
        TranslateAnimation anim_delante3 = new TranslateAnimation(0.0f, 0.0f, 0.0f, 1200);

        anim_delante1.setFillAfter(true);
        anim_delante2.setFillAfter(true);
        anim_delante3.setFillAfter(true);

        anim_delante1.setDuration(velocidad1);
        anim_delante2.setDuration(velocidad2);
        anim_delante3.setDuration(velocidad3);

        calle1.startAnimation(anim_delante1);
        calle2.startAnimation(anim_delante2);
        calle3.startAnimation(anim_delante3);

    }

    public void caballoCalle(){

        if (CaballoP1.equals("caballo11")){

            calle1.setImageResource(R.drawable.caballo1);

        }else {

            calle1.setImageResource(R.drawable.caballo2);

        }

        if (CaballoP2.equals("caballo23")){

            calle2.setImageResource(R.drawable.caballo3);

        }else {

            calle2.setImageResource(R.drawable.caballo4);

        }

        if (CaballoP3.equals("caballo35")){

            calle3.setImageResource(R.drawable.caballo5);

        }else {

            calle3.setImageResource(R.drawable.caballo6);

        }

    }

    class MiThread extends Thread {
        @Override
        public void run() {

            try {

                Thread.sleep(5000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            resultadoTotal = apuesta1 + apuesta2 + apuesta3;

            if (velocidad1 < velocidad2){

                if (velocidad1 < velocidad3){

                    resultado.setText("HA GANADO EL CABALLO NUMERO 1 CON UN PREMIO DE "+resultadoTotal);

                }else {

                    resultado.setText("HA GANADO EL CABALLO 3 CON UN PREMIO DE "+resultadoTotal);

                }

            }else if (velocidad2 < velocidad1){

                if (velocidad2 < velocidad3){

                    resultado.setText("HA GANADO EL CABALLO 2 CON UN PREMIO DE "+resultadoTotal);

                } else {

                    resultado.setText("HA GANADO EL CABALLO 3 CON UN PREMIO DE "+resultadoTotal);

                }

            }else if (velocidad3 < velocidad1){

                if (velocidad3 < velocidad2){

                    resultado.setText("HA GANADO EL CABALLO 3 CON UN PREMIO DE "+resultadoTotal);

                }else {

                    resultado.setText("HA GANADO EL CABALLO 2 CON UN PREMIO DE "+resultadoTotal);

                }

            }else if (velocidad1 < velocidad3){

                if (velocidad1 < velocidad2){

                    resultado.setText("HA GANADO EL CABALLO 1 CON UN PREMIO DE "+resultadoTotal);

                }else {

                    resultado.setText("HA GANADO EL CABALLO 2 CON UN PREMIO DE "+resultadoTotal);

                }

            }else{

                resultado.setText("HA GANADO EL CABALLO 1 CON UN PREMIO DE "+resultadoTotal);

            }

        }


    }
    public void volver_menu(View view){
        Intent intent1 = new Intent(this, pantalla_inicio.class);
        startActivity(intent1);
    }
}
