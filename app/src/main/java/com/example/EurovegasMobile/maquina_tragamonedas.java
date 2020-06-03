package com.example.EurovegasMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class maquina_tragamonedas extends AppCompatActivity {
    ImageView imagen1, imagen2, imagen3, imagen4, imagen5, imagen6, imagen7, imagen8, imagen9;
    Button tirar, bt_volver_inicio;
    Random r1, r2, r3, r4, r5, r6, r7, r8, r9;
    int fruta1, fruta2, fruta3, fruta4, fruta5, fruta6, fruta7, fruta8, fruta9, ganancia=1000;
    TextView tvContador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maquina_tragamonedas);
        imagen1 = findViewById(R.id.ivFruta1);
        imagen2 = findViewById(R.id.ivFruta2);
        imagen3 = findViewById(R.id.ivFruta3);
        imagen4 = findViewById(R.id.ivFruta5);
        imagen5 = findViewById(R.id.ivFruta6);
        imagen6 = findViewById(R.id.ivFruta4);
        imagen7 = findViewById(R.id.ivFruta7);
        imagen8 = findViewById(R.id.ivFruta8);
        imagen9 = findViewById(R.id.ivFruta9);
        bt_volver_inicio = findViewById(R.id.bt_volver_inicio);
        tirar = findViewById(R.id.btTirar);
        tvContador = findViewById(R.id.tvcontador);

        r1 = new Random();
        r2 = new Random();
        r3 = new Random();
        r4 = new Random();
        r5 = new Random();
        r6 = new Random();
        r7 = new Random();
        r8 = new Random();
        r9 = new Random();

    }

    public void volver_Inicio(View v){
        Intent intent = new Intent(this, pantalla_inicio.class);
        startActivity(intent);
    }

    public void tirar(View v) {
        fruta1 = r1.nextInt(4);
        fruta2 = r2.nextInt(4);
        fruta3 = r3.nextInt(4);
        fruta4 = r4.nextInt(4);
        fruta5 = r5.nextInt(4);
        fruta6 = r6.nextInt(4);
        fruta7 = r7.nextInt(4);
        fruta8 = r8.nextInt(4);
        fruta9 = r9.nextInt(4);

        if (fruta1 == 0) {
            imagen1.setImageResource(R.drawable.simbolocereza);
        } else if (fruta1 == 1) {
            imagen1.setImageResource(R.drawable.simbololimon);
        } else if (fruta1 == 2) {
            imagen1.setImageResource(R.drawable.simbolosandia);
        } else if (fruta1 == 3) {
            imagen1.setImageResource(R.drawable.simbolouvas);

        }

        if (fruta2 == 0) {
            imagen2.setImageResource(R.drawable.simbolocereza);
        } else if (fruta2 == 1) {
            imagen2.setImageResource(R.drawable.simbololimon);
        } else if (fruta2 == 2) {
            imagen2.setImageResource(R.drawable.simbolosandia);
        } else if (fruta2 == 3){
            imagen2.setImageResource(R.drawable.simbolouvas);
        }

        if (fruta3 == 0) {
            imagen3.setImageResource(R.drawable.simbolocereza);
        } else if (fruta3 == 1) {
            imagen3.setImageResource(R.drawable.simbololimon);
        } else if (fruta3 == 2) {
            imagen3.setImageResource(R.drawable.simbolosandia);
        } else if (fruta3 == 3) {
            imagen3.setImageResource(R.drawable.simbolouvas);
        }

        if (fruta4 == 0) {
            imagen4.setImageResource(R.drawable.simbolocereza);
        } else if (fruta4 == 1) {
            imagen4.setImageResource(R.drawable.simbololimon);
        } else if (fruta4 == 2) {
            imagen4.setImageResource(R.drawable.simbolosandia);
        } else if (fruta4 == 3){
            imagen4.setImageResource(R.drawable.simbolouvas);
        }

        if (fruta5 == 0) {
            imagen5.setImageResource(R.drawable.simbolocereza);
        } else if (fruta5 == 1) {
            imagen5.setImageResource(R.drawable.simbololimon);
        } else if (fruta5 == 2) {
            imagen5.setImageResource(R.drawable.simbolosandia);
        } else if (fruta5 == 3) {
            imagen5.setImageResource(R.drawable.simbolouvas);
        }

        if (fruta6 == 0) {
            imagen6.setImageResource(R.drawable.simbolocereza);
        } else if (fruta6 == 1) {
            imagen6.setImageResource(R.drawable.simbololimon);
        } else if (fruta6 == 2) {
            imagen6.setImageResource(R.drawable.simbolosandia);
        } else if (fruta6 == 3) {
            imagen6.setImageResource(R.drawable.simbolouvas);
        }

        if (fruta7 == 0) {
            imagen7.setImageResource(R.drawable.simbolocereza);
        } else if (fruta7 == 1) {
            imagen7.setImageResource(R.drawable.simbololimon);
        } else if (fruta7 == 2) {
            imagen7.setImageResource(R.drawable.simbolosandia);
        } else if (fruta7 == 3) {
            imagen7.setImageResource(R.drawable.simbolouvas);
        }

        if (fruta8 == 0) {
            imagen8.setImageResource(R.drawable.simbolocereza);
        } else if (fruta8 == 1) {
            imagen8.setImageResource(R.drawable.simbololimon);
        } else if (fruta8 == 2) {
            imagen8.setImageResource(R.drawable.simbolosandia);
        } else if (fruta8 == 3) {
            imagen8.setImageResource(R.drawable.simbolouvas);
        }

        if (fruta9 == 0) {
            imagen9.setImageResource(R.drawable.simbolocereza);
        } else if (fruta9 == 1) {
            imagen9.setImageResource(R.drawable.simbololimon);
        } else if (fruta9 == 2) {
            imagen9.setImageResource(R.drawable.simbolosandia);
        } else if (fruta9 == 3) {
            imagen9.setImageResource(R.drawable.simbolouvas);
        }

        if(fruta1==0 && fruta2==0 && fruta3==0){
            tvContador.setText(Integer.toString(ganancia+80));
            ganancia = ganancia+80;
            Toast.makeText(this, "Premio: 80€ Linea 1", Toast.LENGTH_SHORT).show();

        }
        if(fruta6==0 && fruta4==0 && fruta5==0){
            tvContador.setText(Integer.toString(ganancia+80));
            ganancia = ganancia+80;
            Toast.makeText(this, "Premio: 80€ Linea 2", Toast.LENGTH_SHORT).show();


        }
        if(fruta7==0 && fruta8==0 && fruta9==0){
            tvContador.setText(Integer.toString(ganancia+80));
            ganancia = ganancia+80;
            Toast.makeText(this, "Premio: 80€ Linea 3", Toast.LENGTH_SHORT).show();
        }
        if(fruta3==0 && fruta4==0 && fruta7==0){
            tvContador.setText(Integer.toString(ganancia+80));
            ganancia = ganancia+80;
            Toast.makeText(this, "Premio: 80€ Linea 4", Toast.LENGTH_SHORT).show();
        }
        if(fruta1==0 && fruta4==0 && fruta9==0){
            tvContador.setText(Integer.toString(ganancia+80));
            ganancia = ganancia+80;
            Toast.makeText(this, "Premio: 80€ Linea 5", Toast.LENGTH_SHORT).show();
        }


        if(fruta1==1 && fruta2==1 && fruta3==1){
            tvContador.setText(Integer.toString(ganancia+160));
            ganancia = ganancia+160;
            Toast.makeText(this, "Premio: 160€ Linea 1", Toast.LENGTH_SHORT).show();
        }
        if(fruta6==1 && fruta4==1 && fruta5==1){
            tvContador.setText(Integer.toString(ganancia+160));
            ganancia = ganancia+160;
            Toast.makeText(this, "Premio: 160€ Linea 2", Toast.LENGTH_SHORT).show();
        }
        if(fruta7==1 && fruta8==1 && fruta9==1){
            tvContador.setText(Integer.toString(ganancia+160));
            ganancia = ganancia+160;
            Toast.makeText(this, "Premio: 160€ Linea 3", Toast.LENGTH_SHORT).show();
        }
        if(fruta3==1 && fruta4==1 && fruta7==1){
            tvContador.setText(Integer.toString(ganancia+160));
            ganancia = ganancia+160;
            Toast.makeText(this, "Premio: 160€ Linea 4", Toast.LENGTH_SHORT).show();
        }
        if(fruta1==1 && fruta4==1 && fruta9==1){
            tvContador.setText(Integer.toString(ganancia+160));
            ganancia = ganancia+160;
            Toast.makeText(this, "Premio: 160€ Linea 5", Toast.LENGTH_SHORT).show();
        }
        //______________________________________________________________------------------------

        if(fruta1==2 && fruta2==2 && fruta3==2){
            tvContador.setText(Integer.toString(ganancia+640));
            ganancia = ganancia+640;
            Toast.makeText(this, "Premio: 640€ Linea 1", Toast.LENGTH_SHORT).show();
        }
        if(fruta6==2 && fruta4==2 && fruta5==2){
            tvContador.setText(Integer.toString(ganancia+640));
            ganancia = ganancia+640;
            Toast.makeText(this, "Premio: 640€ Linea 2", Toast.LENGTH_SHORT).show();
        }
        if(fruta7==2 && fruta8==2 && fruta9==2){
            tvContador.setText(Integer.toString(ganancia+640));
            ganancia = ganancia+640;
            Toast.makeText(this, "Premio: 640€ Linea 3", Toast.LENGTH_SHORT).show();
        }
        if(fruta3==2 && fruta4==2 && fruta7==2){
            tvContador.setText(Integer.toString(ganancia+640));
            ganancia = ganancia+640;
            Toast.makeText(this, "Premio: 640€ Linea 4", Toast.LENGTH_SHORT).show();
        }
        if(fruta1==2 && fruta4==2 && fruta9==2){
            tvContador.setText(Integer.toString(ganancia+640));
            ganancia = ganancia+640;
            Toast.makeText(this, "Premio: 640€ Linea 5", Toast.LENGTH_SHORT).show();
        }


        if(fruta1==3 && fruta2==3 && fruta3==3){
            tvContador.setText(Integer.toString(ganancia+320));
            ganancia = ganancia+320;
            Toast.makeText(this, "Premio: 320€ Linea 1", Toast.LENGTH_SHORT).show();
        }
        if(fruta6==3 && fruta4==3 && fruta5==3){
            tvContador.setText(Integer.toString(ganancia+320));
            ganancia = ganancia+320;
            Toast.makeText(this, "Premio: 320€ Linea 2", Toast.LENGTH_SHORT).show();
        }
        if(fruta7==3 && fruta8==3 && fruta9==3){
            tvContador.setText(Integer.toString(ganancia+320));
            ganancia = ganancia+320;
            Toast.makeText(this, "Premio: 320€ Linea 3", Toast.LENGTH_SHORT).show();
        }
        if(fruta3==3 && fruta4==3 && fruta7==3){
            tvContador.setText(Integer.toString(ganancia+320));
            ganancia = ganancia+320;
            Toast.makeText(this, "Premio: 320€ Linea 4", Toast.LENGTH_SHORT).show();
        }
        if(fruta1==3 && fruta4==3 && fruta9==3){
            tvContador.setText(Integer.toString(ganancia+320));
            ganancia = ganancia+320;
            Toast.makeText(this, "Premio: 320€ Linea 5", Toast.LENGTH_SHORT).show();
        }
        else {
            tvContador.setText(Integer.toString(ganancia-100));
            ganancia = ganancia - 100;
        }


        TranslateAnimation rotar = new TranslateAnimation(0, 0, -400f, 200f);
        TranslateAnimation rotar2 = new TranslateAnimation(0, 0, -400f, 200f);
        TranslateAnimation rotar3 = new TranslateAnimation(0, 0, -400f, 200f);
        TranslateAnimation rotar4 = new TranslateAnimation(0, 0, -400f, 200f);
        TranslateAnimation rotar5 = new TranslateAnimation(0, 0, -400f, 200f);
        TranslateAnimation rotar6 = new TranslateAnimation(0, 0, -400f, 200f);
        TranslateAnimation rotar7 = new TranslateAnimation(0, 0, -400f, 200f);
        TranslateAnimation rotar8 = new TranslateAnimation(0, 0, -400f, 200f);
        TranslateAnimation rotar9 = new TranslateAnimation(0, 0, -400f, 200f);

        RotateAnimation girar = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        /*RotateAnimation rotarG= new RotateAnimation(0,360,120,120);
        rotarG.setDuration(1000);
        rotarG.setRepeatCount(rotarG.INFINITE);
        rotarG.setRepeatMode(rotarG.REVERSE);*/


        rotar.setDuration(1100);
        rotar2.setDuration(1200);
        rotar3.setDuration(1300);
        rotar4.setDuration(900);
        rotar5.setDuration(1000);
        rotar6.setDuration(800);
        rotar7.setDuration(500);
        rotar8.setDuration(600);
        rotar9.setDuration(700);

        girar.setDuration(1000);

        imagen1.startAnimation(rotar);
        imagen2.startAnimation(rotar2);
        imagen3.startAnimation(rotar3);
        imagen4.startAnimation(rotar4);
        imagen5.startAnimation(rotar5);
        imagen6.startAnimation(rotar6);
        imagen7.startAnimation(rotar7);
        imagen8.startAnimation(rotar8);
        imagen9.startAnimation(rotar9);

        tirar.startAnimation(girar);
    }
}
