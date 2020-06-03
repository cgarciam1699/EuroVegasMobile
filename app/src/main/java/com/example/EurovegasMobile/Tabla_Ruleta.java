package com.example.EurovegasMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Tabla_Ruleta extends AppCompatActivity {
    Button bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16, bt17, bt18, bt19, bt20, bt21, bt22, bt23, bt24, bt25, bt26, bt27, bt28, bt29, bt30, bt31, bt32, bt33, bt34, bt35, bt36;
    ImageButton  bt_regresar_menu;
    int contador = 0, ganancia = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla__ruleta);
        bt_regresar_menu = findViewById(R.id.bt_regresar_menu_principal);
        bt_regresar_menu.setBackgroundResource(0);
        bt0 = findViewById(R.id.bt0);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        bt10 = findViewById(R.id.bt10);
        bt11 = findViewById(R.id.bt11);
        bt12 = findViewById(R.id.bt12);
        bt13 = findViewById(R.id.bt13);
        bt14 = findViewById(R.id.bt14);
        bt15 = findViewById(R.id.bt15);
        bt16 = findViewById(R.id.bt16);
        bt17 = findViewById(R.id.bt17);
        bt18 = findViewById(R.id.bt18);
        bt19 = findViewById(R.id.bt19);
        bt20 = findViewById(R.id.bt20);
        bt21 = findViewById(R.id.bt21);
        bt22 = findViewById(R.id.bt22);
        bt23 = findViewById(R.id.bt23);
        bt24 = findViewById(R.id.bt24);
        bt25 = findViewById(R.id.bt25);
        bt26 = findViewById(R.id.bt26);
        bt27 = findViewById(R.id.bt27);
        bt28 = findViewById(R.id.bt28);
        bt29 = findViewById(R.id.bt29);
        bt30 = findViewById(R.id.bt30);
        bt31 = findViewById(R.id.bt31);
        bt32 = findViewById(R.id.bt32);
        bt33 = findViewById(R.id.bt33);
        bt34 = findViewById(R.id.bt34);
        bt35 = findViewById(R.id.bt35);
        bt36 = findViewById(R.id.bt36);
    }

    public void clickbt_regresar_menu (View v){
        if(bt_regresar_menu.isClickable()){
            Intent intent = new Intent(this, pantalla_inicio.class);
            startActivity(intent);

        }
    }
    public void clickbt0 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador);
            startActivity(intent);
        }
    }

    public void clickbt1 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+1);
            startActivity(intent);
        }
    }

    public void clickbt2 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+2);
            startActivity(intent);

        }
    }

    public void clickbt3 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+3);
            startActivity(intent);

        }
    }

    public void clickbt4 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+4);
            startActivity(intent);

        }
    }

    public void clickbt5 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+5);
            startActivity(intent);

        }
    }

    public void clickbt6 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+6);
            startActivity(intent);

        }
    }

    public void clickbt7 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+7);
            startActivity(intent);

        }
    }

    public void clickbt8 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+8);
            startActivity(intent);

        }
    }

    public void clickbt9 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+9);
            startActivity(intent);

        }
    }

    public void clickbt10 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+10);
            startActivity(intent);

        }
    }

    public void clickbt11 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+11);
            startActivity(intent);

        }
    }

    public void clickbt12 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+12);
            startActivity(intent);

        }
    }

    public void clickbt13 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+13);
            startActivity(intent);

        }
    }

    public void clickbt14 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+14);
            startActivity(intent);

        }
    }

    public void clickbt15 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+15);
            startActivity(intent);

        }
    }

    public void clickbt16 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+16);
            startActivity(intent);

        }
    }

    public void clickbt17 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+17);
            startActivity(intent);

        }
    }

    public void clickbt18 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+18);
            startActivity(intent);

        }
    }

    public void clickbt19 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+19);
            startActivity(intent);

        }
    }

    public void clickbt20 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+20);
            startActivity(intent);

        }
    }

    public void clickbt21 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+21);
            startActivity(intent);

        }
    }

    public void clickbt22 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+22);
            startActivity(intent);

        }
    }

    public void clickbt23 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+23);
            startActivity(intent);

        }
    }

    public void clickbt24 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+24);
            startActivity(intent);

        }
    }

    public void clickbt25 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+25);
            startActivity(intent);

        }
    }

    public void clickbt26 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+26);
            startActivity(intent);

        }
    }

    public void clickbt27 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+27);
            startActivity(intent);

        }
    }

    public void clickbt28 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+28);
            startActivity(intent);

        }
    }

    public void clickbt29 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+29);
            startActivity(intent);

        }
    }

    public void clickbt30 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+30);
            startActivity(intent);

        }
    }

    public void clickbt31 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+31);
            startActivity(intent);

        }
    }

    public void clickbt32 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+32);
            startActivity(intent);

        }
    }

    public void clickbt33 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+33);
            startActivity(intent);

        }
    }

    public void clickbt34 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+34);
            startActivity(intent);

        }
    }

    public void clickbt35 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+35);
            startActivity(intent);

        }
    }

    public void clickbt36 (View v){
        if(bt0.isClickable()){
            Intent intent = new Intent(this, Ruleta.class);
            intent.putExtra("Numero", contador+36);
            startActivity(intent);

        }
    }
}
