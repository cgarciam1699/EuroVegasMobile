package com.example.EurovegasMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class tercer_jugador_carrera_caballos extends AppCompatActivity {

    Button siguiente3, caba31, caba32, caba33, cinco3, diez3, veinte3;
    TextView apuesta3;
    ImageView caballos3;
    int cantidad3;
    Random r;
    Intent intentP3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer_jugador_carrera_caballos);

        siguiente3 = findViewById(R.id.btSiguienteP3);
        caba31 = findViewById(R.id.bt3Caballo1);
        caba32 = findViewById(R.id.bt3Caballo2);
        caba33 = findViewById(R.id.bt3Caballo3);
        cinco3 = findViewById(R.id.btDeCinco3);
        diez3 = findViewById(R.id.btDeDiez3);
        veinte3 = findViewById(R.id.btDeVeinte3);
        apuesta3 = findViewById(R.id.cantidadApostada3);
        caballos3 = findViewById(R.id.imagenCaballosP3);

        intentP3 = new Intent (this, carrera_caballos_a_correr.class);
        r = new Random();

        Bundle extras = getIntent().getExtras();
        int apuestaJ1 = extras.getInt("apuestaJ1");
        int apuestaJ2 = extras.getInt("apuesta2");
        String seleccion1 = extras.getString("seleccion1");
        String seleccion2 = extras.getString("seleccion2");

        intentP3.putExtra("apuestaJuga1", apuestaJ1);
        intentP3.putExtra("apuestaJuga2", apuestaJ2);

        intentP3.putExtra("seleccion1", seleccion1);
        intentP3.putExtra("seleccion2", seleccion2);

        caba31.setEnabled(false);
        caba32.setEnabled(false);

    }

    public void avance3(View v) {


        startActivity(intentP3);

    }

    public void eleccionCaballo3 (View view){

        int aleatorio3 = r.nextInt(2);

        if (caba33.isPressed()){

            if (aleatorio3 == 0){

                caballos3.setImageResource(R.drawable.caballo5);
                intentP3.putExtra("seleccion3","caballo35");

            }
            if (aleatorio3 == 1){

                caballos3.setImageResource(R.drawable.caballo6);
                intentP3.putExtra("seleccion3","caballo36");

            }

        }

    }

    public void apuestaJugador3 (View view){

        if (cinco3.isPressed()){

            cantidad3 = cantidad3 + 10;
            apuesta3.setText(String.valueOf(cantidad3));

        }
        if (diez3.isPressed()){

            cantidad3 = cantidad3 + 100;
            apuesta3.setText(String.valueOf(cantidad3));

        }
        if (veinte3.isPressed()){

            cantidad3 = cantidad3 + 1000;
            apuesta3.setText(String.valueOf(cantidad3));

        }

        intentP3.putExtra("apuesta3",cantidad3);

    }

}
