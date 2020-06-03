package com.example.EurovegasMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Principal_carrera_caballos extends AppCompatActivity implements View.OnClickListener{


    Button avanzarIni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_carrera_caballos);

        avanzarIni = findViewById(R.id.botonInicio2);

        avanzarIni.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent1 = new Intent(this, primer_jugador_carrera_caballos.class);
        startActivity(intent1);

    }
}
