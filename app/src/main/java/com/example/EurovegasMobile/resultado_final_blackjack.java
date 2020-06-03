package com.example.EurovegasMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class resultado_final_blackjack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_final_blackjack);
    }

    @Override
    protected void onStart() {

        super.onStart();
        setValores();
    }
    public void setValores(){
        TextView ganador = findViewById(R.id.tv_ganador);
        TextView puntosJugador = findViewById(R.id.tv_pts_jugador);
        TextView puntosBanca = findViewById(R.id.tv_pts_banca);
        TextView resultadoJugador = findViewById(R.id.resultado_jugador);
        TextView resultadoBanca = findViewById(R.id.resultado_banca);

        if(principal_blackjack.ganador==null)
            ganador.setText("EMPATE");
        else if (principal_blackjack.ganador==principal_blackjack.jugador)
            ganador.setText("Jugador Gana");
        else
            ganador.setText("Jugador Pierde");

        if("plantarse".equals(principal_blackjack.resultado_jugador))
            resultadoJugador.setText("Jugador se planta");
        else if("pase".equals(principal_blackjack.resultado_jugador))
            resultadoJugador.setText("Jugador se pasa");
        else if("blackjack".equals(principal_blackjack.resultado_jugador))
            resultadoJugador.setText("BLACK\nJACK");
        else
            resultadoJugador.setVisibility(View.GONE);

        puntosJugador.setText(""+principal_blackjack.jugador.sumarCartas());
        puntosBanca.setText(""+principal_blackjack.banca.sumarCartas());

        if("plantarse".equals(principal_blackjack.resultado_banca))
            resultadoBanca.setText("Banca se planta");
        else if ("pase".equals(principal_blackjack.resultado_banca))
            resultadoBanca.setText("Banca se pasa");
        else if ("blackjack".equals(principal_blackjack.resultado_banca))
            resultadoBanca.setText("BLACK\nJACK");
        else
            resultadoBanca.setVisibility(View.GONE);
    }

    public void reiniciar(View view){
        //Devuelve de nuevo todos los valores a 0
        Intent reinicar = new Intent(this, principal_blackjack.class);
        startActivity(reinicar);
    }

    public void volver_menu_inicio(View view){
        Intent volver_menu = new Intent(this, pantalla_inicio.class);
        startActivity(volver_menu);
    }
}
