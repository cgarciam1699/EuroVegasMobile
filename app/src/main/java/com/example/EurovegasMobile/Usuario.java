package com.example.EurovegasMobile;

import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Usuario {
    private ArrayList<Carta> cartas;
    private ImageView[] imagenes;
    private int carta_actual;

    Usuario(ImageView[] i){
        cartas = new ArrayList<Carta>();
        imagenes = i;
        carta_actual=0;
    }

    public void añadirCarta(Carta c) {
        cartas.add(c);
    }

    public int tamaño() {
        return cartas.size();
    }

    public ArrayList<Carta> cartas() {
        return cartas;
    }

    public int sumarCartas(){
        int suma = 0;
        for(Carta carta : cartas)
            suma += carta.getValor();

        int contador = 0;

        while (suma > 21 && contador < cartas.size()){
            if (cartas.get(contador).getPalos() == 1)
                cartas.get(contador).setValor_as_distinto(true);
            contador ++;
            suma = 0;
            for (Carta carta : cartas)
                suma += carta.getValor();
        }
        return suma;
    }

    public ImageView proxima_carta_Vista(){
        carta_actual++;
        return imagenes[carta_actual - 1];
    }

    //Si esto es verdadero, el jugador se ha pasado de 21
    public boolean pasar_21(){
        return sumarCartas() > 21;
    }

    public void desaparecer_cartas_Vistas(){
        for (ImageView i: imagenes)
            i.setVisibility(View.GONE);
    }


}

