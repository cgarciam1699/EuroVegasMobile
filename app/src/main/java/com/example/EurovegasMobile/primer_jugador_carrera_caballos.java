package com.example.EurovegasMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class primer_jugador_carrera_caballos extends AppCompatActivity {

    Button siguiente1, caba1, caba2, caba3, cinco, diez, veinte;
    TextView apuesta;
    ImageView caballos;
    int cantidad1;
    Random r;
    Intent intentP1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primer_jugador_carrera_caballos);

        siguiente1 = findViewById(R.id.btSiguiente1);
        caballos = findViewById(R.id.imagenCaballosP1);
        caba1 = findViewById(R.id.btCaballo1);
        caba2 = findViewById(R.id.btCaballo2);
        caba3 = findViewById(R.id.btCaballo3);
        apuesta = findViewById(R.id.cantidaApostada);
        cinco = findViewById(R.id.btDeCinco1);
        diez = findViewById(R.id.btDeDiez1);
        veinte = findViewById(R.id.btDeVeinte1);

        intentP1 = new Intent(this, segundo_jugador_carrera_caballos.class);
        r = new Random();

    }

    public void avance(View v) {

        startActivity(intentP1);

    }

    public void eleccionCaballo1 (View view){

        int aleatorio1 = r.nextInt(2);

        if(caba1.isPressed()){

            if (aleatorio1 == 0){

                caballos.setImageResource(R.drawable.caballo1);
                intentP1.putExtra("seleccion1","caballo11");

            }
            if (aleatorio1 == 1){

                caballos.setImageResource(R.drawable.caballo2);
                intentP1.putExtra("seleccion1", "caballo12");

            }

        }

        if (caba2.isPressed()){

            Toast.makeText(this, "Este no es tu caballo, SELECCIONE EL CABALLO 1", Toast.LENGTH_LONG).show();

        }

        if (caba3.isPressed()){

            Toast.makeText(this, "Este no es tu caballo, SELECCIONE EL CABALLO 1", Toast.LENGTH_LONG).show();

        }

    }

    public void apuestaJugador1 (View view){

        if (cinco.isPressed()){

            cantidad1 = cantidad1 + 10;
            apuesta.setText(String.valueOf(cantidad1));

        }
        if (diez.isPressed()){

            cantidad1 = cantidad1 + 100;
            apuesta.setText(String.valueOf(cantidad1));

        }
        if (veinte.isPressed()){

            cantidad1 = cantidad1 + 1000;
            apuesta.setText(String.valueOf(cantidad1));

        }

        intentP1.putExtra("apuesta",cantidad1);

    }
}
