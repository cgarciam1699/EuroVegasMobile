package com.example.EurovegasMobile;

//Esta clase va a crear una memoria artificial con una subclase de usuario, que va a poder elegir si
//plantarse o seguir pidiendo en funcion de las reglas del juego del blackjack, es decir
//si tiene 16 o mas se planta y en caso de ser menor va a pedir carta

import android.widget.ImageView;

public class Maquina extends Usuario{
    Maquina(ImageView[] i){
        super(i);
    }

    // si devuelve un valor verdadero, pedirá carta, si retorna un valor falso se plantará
    public boolean hit(){
        int valor = sumarCartas();

        if(valor<=16)
            return true;
        else
            return false;
    }
}


