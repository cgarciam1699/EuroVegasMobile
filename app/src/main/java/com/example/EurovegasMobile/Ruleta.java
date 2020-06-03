package com.example.EurovegasMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;



public class Ruleta extends AppCompatActivity {

    Button botonGirar, bt_volver_tablero_ruleta;
    TextView resultado, numeroElegido;
    ImageView ruleta1;


    // Array Sectores de la ruleta
    private static final String[] sectores = { "32 rojo", "15 negro",
            "19 rojo", "4 negro", "21 rojo", "2 negro", "25 rojo", "17 negro", "34 rojo",
            "6 negro", "27 rojo","13 negro", "36 rojo", "11 negro", "30 rojo", "8 negro",
            "23 rojo", "10 negro", "5 rojo", "24 negro", "16 rojo", "33 negro",
            "1 rojo", "20 negro", "14 rojo", "31 negro", "9 rojo", "22 negro",
            "18 rojo", "29 negro", "7 rojo", "28 negro", "12 rojo", "35 negro",
            "3 rojo", "26 negro", "cero"
    };

    //Creamos una instancia de tipo aleatorio para que la ruleta gire de forma aleatoria
    private static final Random ALEATORIO = new Random();
    private int gradoActual = 0, gradoAntiguo = 0;

    // Hay 37 numeros en la ruleta, dividimos 360º de la ruleta por la cantidad de numeros para
    // saber cual es el angulo que ocupa cada numero dentro de la ruleta y entre 2 para tener la mitad
    // de la ruleta

    private static final float MEDIO_SECTOR = 360f / 37f / 2f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonGirar = findViewById(R.id.btGirar);
        resultado = findViewById(R.id.tvResultado);
        ruleta1 = findViewById(R.id.ivRuleta);
        numeroElegido = findViewById(R.id.tvnumeroAnterior);
        bt_volver_tablero_ruleta = findViewById(R.id.bt_volver_tabla_ruleta);

        //Recogemos los datos del numero elegido anteriormente
        Bundle b = this.getIntent().getExtras();
        int numero = b.getInt("Numero");
        numeroElegido.setText("El numero elegido es" +
                ": "+numero);

    }

    public void volver_tablero(View v){
        Intent intent = new Intent (this, Tabla_Ruleta.class);
        startActivity(intent);
    }
    public void giroRuleta (View v){
        gradoAntiguo = gradoActual % 360;
        // calculo el angulo aleatorio de la rotación de la ruleta
        gradoActual = ALEATORIO.nextInt(360)+1080;
        // 720 que es el doble de la ruleta para que de dos vueltas minimo
        // Añadimos el efecto de rotación a la ruleta
        RotateAnimation animacionRuleta = new RotateAnimation(gradoAntiguo, gradoActual, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animacionRuleta.setDuration(4200);
        animacionRuleta.setFillAfter(true);
        // Para que vaya de mas rapido a mas lento y conseguir el efecto deseado
        animacionRuleta.setInterpolator(new DecelerateInterpolator());
        animacionRuleta.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // El text view va a estar vacio mientras la ruleta gira
                resultado.setText("");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //Mostramos el sector correcto señalado por el triangulo al final del giro
                resultado.setText(getSector(360-(gradoActual%360)));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //Inicializo la animacion
        ruleta1.startAnimation(animacionRuleta);

    }
    private String getSector(int gradoActual){
        int i = 0;
        String text = null;

        do{
           // Inicio y final de cada sector de la ruleta
            float inicio = MEDIO_SECTOR * (i*2+1);
            float finalizacion = MEDIO_SECTOR * (i*2+3);

            if (gradoActual >= inicio && gradoActual < finalizacion){
                // El texto a mostrar será igual que el sector que marque
                text = sectores[i];
            }
            i++;
        }while (text == null && i < sectores.length);
        return  text;

    }

}
