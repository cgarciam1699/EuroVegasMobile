package com.example.EurovegasMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class principal_blackjack extends AppCompatActivity {

    public static Usuario jugador;
    public static Maquina banca;
    private static Baraja baraja;
    private static Button boton_plantarse;
    private static Button boton_pedir;
    private static int veces_pedir_carta;
    public static boolean blackjack;

    public static Usuario ganador;
    public static String resultado_jugador;
    public static String resultado_banca;
    ImageButton volver_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_blackjack);
        volver_menu = findViewById(R.id.bt_regresar_menu_principal);
    }

    public void regresar_menu(View v){
        Intent intent = new Intent(this, pantalla_inicio.class);
        startActivity(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();
        setValores();
        iniciarReparto();

        if(blackjack)
            resultadoFinal();


        //Si hacemos blackjack pasamos turno
    }


    private void setValores() {
        Carta.cartaAnterior = R.drawable.card_back; // Configuramos la imagen que va a aparecer cuando las cartas estén boca abajo
        //Configuramos los arrays tanto para la maquina como para el usuario
        //Tendremos 9 ImageViews porq ue es el maximo de cartas que se puede tener sin pasarse
        //Ya que solo tenemos una baraja

        ImageView[] pImgs = { findViewById(R.id.carta_jugador1),  findViewById(R.id.carta_jugador2),
                 findViewById(R.id.carta_jugador3),  findViewById(R.id.carta_jugador4),
                 findViewById(R.id.carta_jugador5),  findViewById(R.id.carta_jugador6),
                 findViewById(R.id.carta_jugador7),  findViewById(R.id.carta_jugador8),
                 findViewById(R.id.carta_jugador9)};

        ImageView[] cImgs = { findViewById(R.id.carta_maquina1),  findViewById(R.id.carta_maquina2),
                 findViewById(R.id.carta_maquina3),  findViewById(R.id.carta_maquina4),
                 findViewById(R.id.carta_maquina5),  findViewById(R.id.carta_maquina6),
                 findViewById(R.id.carta_maquina7),  findViewById(R.id.carta_maquina8),
                 findViewById(R.id.carta_maquina9)};

        //Inicializamos todos los objetos
        jugador = new Usuario(pImgs);
        banca = new Maquina(cImgs);
        baraja = new Baraja();
        boton_plantarse = findViewById(R.id.bt_plantarse);
        boton_pedir =  findViewById(R.id.bt_pedircarta);
        veces_pedir_carta = 0;
        resultado_jugador = null;
        resultado_banca = null;
        blackjack = true; //Dirá si se ha hecho blakjack al repartir la primera mano

        //Hacer los botones aparecer y desaparecer
        boton_plantarse.setVisibility(View.GONE);
        boton_pedir.setVisibility(View.GONE);
        jugador.desaparecer_cartas_Vistas();
        banca.desaparecer_cartas_Vistas();

        //Barajamos las cartas
        baraja.barajar();
    }

    public void iniciarReparto() {

        jugador.añadirCarta(baraja.dealer());
        setCard (jugador.proxima_carta_Vista(), jugador.cartas().get(0));

        banca.añadirCarta(baraja.dealer());
        setImage(banca.proxima_carta_Vista(), Carta.cartaAnterior);

        jugador.añadirCarta(baraja.dealer());
        setCard(jugador.proxima_carta_Vista(), jugador.cartas().get(1));

        banca.añadirCarta(baraja.dealer());
        setCard(banca.proxima_carta_Vista(), banca.cartas().get(1));

        ((TextView) findViewById(R.id.tv_sumacartas)).setText("Tu suma es: " + jugador.sumarCartas());

        blackjack();
    }

    public void setImage(ImageView view, int id) {
        view.setVisibility(View.VISIBLE);
        view.setImageResource(id);
    }

    public void setCard(ImageView view, Carta c) {
        int id = CartasImagenes.getImage(c);
        setImage(view, id);
    }

    public void pedirOnClick(View view) {
        jugador.añadirCarta(baraja.dealer());
        setCard(jugador.proxima_carta_Vista(), jugador.cartas().get(veces_pedir_carta + 2));
        ((TextView) findViewById(R.id.tv_sumacartas)).setText("Tu suma es: " + jugador.sumarCartas());
        veces_pedir_carta++;

        if (jugador.pasar_21()) {
            resultado_jugador = "pase";
            ganador = banca;
            resultadoFinal();

        }
    }

    public void plantarseOnClikc(View view){
        resultado_jugador = "pantarse";

        boton_plantarse.setVisibility(View.GONE);
        boton_pedir.setVisibility(View.GONE);

        veces_pedir_carta = 0;
        while(banca.hit()) {
            banca.añadirCarta(baraja.dealer());
            setCard(banca.proxima_carta_Vista(), banca.cartas().get(veces_pedir_carta + 2));
            veces_pedir_carta++;
        }

        if (banca.pasar_21()) {
            resultado_banca = "pase";
            ganador = jugador;
        }
        else {
            resultado_banca = "plantarse";
            if(banca.sumarCartas() == jugador.sumarCartas())
                ganador = null;
            else if (banca.sumarCartas() > jugador.sumarCartas())
                ganador = banca;
            else
                ganador = jugador;
        }
        resultadoFinal();

    }

    public void blackjack() {
        int jugadorTotal = jugador.sumarCartas();
        int bancaTotal = banca.sumarCartas();

        if(jugadorTotal == 21 && bancaTotal == 21) {
            ganador = null;
            resultado_banca = "blackjack";
            resultado_jugador = "blackjack";
        }
        else if(bancaTotal == 21) {
            ganador = banca;
            resultado_banca = "blackjack";
        }
        else if(jugadorTotal == 21) {
            ganador = jugador;
            resultado_jugador = "blackjack";
        }
        else {
            blackjack = false;
            boton_plantarse.setVisibility(View.VISIBLE);
            boton_pedir.setVisibility(View.VISIBLE);
        }
    }

    public void resultadoFinal(){
        Intent ir_pantalla_final = new Intent(this, resultado_final_blackjack.class);
        startActivity(ir_pantalla_final);
    }

}
