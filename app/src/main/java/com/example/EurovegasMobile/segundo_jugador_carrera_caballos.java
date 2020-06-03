package com.example.EurovegasMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class segundo_jugador_carrera_caballos extends AppCompatActivity {

    Button avance, caba21, caba22, caba23, cinco2, diez2, veinte2;
    TextView apuesta2;
    ImageView caballos2;
    int cantidad2;
    Random r;
    Intent intentP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_jugador_carrera_caballos);

        avance = findViewById(R.id.btSiguiente2);
        caba21 = findViewById(R.id.bt2Caballo1);
        caba22 = findViewById(R.id.bt2Caballo2);
        caba23 = findViewById(R.id.bt2Caballo3);
        apuesta2 = findViewById(R.id.cantidadApostada2);
        caballos2 = findViewById(R.id.imagenCaballosP2);
        cinco2 = findViewById(R.id.btDeCinco2);
        diez2 = findViewById(R.id.btDeDiez2);
        veinte2 = findViewById(R.id.btDeVeinte2);

        intentP2 = new Intent(this, tercer_jugador_carrera_caballos.class);
        r = new Random();

        Bundle extras = getIntent().getExtras();
        int cantJuga1 = extras.getInt("apuesta");
        String seleccion1 = extras.getString("seleccion1");

        intentP2.putExtra("apuestaJ1", cantJuga1);

        intentP2.putExtra("seleccion1", seleccion1);

        caba21.setEnabled(false);

    }

    public void avance1(View v) {


        startActivity(intentP2);

    }

    public void eleccionCaballo2 (View view){

        int aleatorio2 = r.nextInt(2);

        if (caba22.isPressed()){

            if (aleatorio2 == 0){

                caballos2.setImageResource(R.drawable.caballo3);
                intentP2.putExtra("seleccion2","caballo23");

            }
            if (aleatorio2 == 1){

                caballos2.setImageResource(R.drawable.caballo4);
                intentP2.putExtra("seleccion2","caballo24");

            }

        }

        if (caba23.isPressed()){

            Toast.makeText(this, "Este no es tu caballo, SELECCIONE EL CABALLO 2", Toast.LENGTH_LONG).show();

        }

    }

    public void apuestaJugador2 (View view){

        if (cinco2.isPressed()){

            cantidad2 = cantidad2 + 10;
            apuesta2.setText(String.valueOf(cantidad2));

        }
        if (diez2.isPressed()){

            cantidad2 = cantidad2 + 100;
            apuesta2.setText(String.valueOf(cantidad2));

        }
        if (veinte2.isPressed()){

            cantidad2 = cantidad2 + 1000;
            apuesta2.setText(String.valueOf(cantidad2));

        }

        intentP2.putExtra("apuesta2",cantidad2);

    }
}
