package com.example.EurovegasMobile;

// Aqui creo la clase baraja, en la cual creo una baraja de 52 cartas, ademas de agregar un metodo para barajarlo
// v_a
public class Baraja {
    private Carta[] cartas;
    private int contador;

    Baraja(){
        cartas = new Carta[52];
        rellenar();
    }

    private void rellenar() {
        int pos = 0;

        for (int p = 1; p <=4; p++)
            for (int v_a = 1; v_a < 14; v_a++){
                cartas[pos] = new Carta(p, v_a);
                pos++;
            }
    }

    public void barajar(){
        for (int j = cartas.length -1; j >=0; j--){
            int random = (int) (Math.random()*j);

            cartas = intercambiar(cartas, j, random);
        }
        contador = 0; //El contador vuelve a 0
    }

    //private por que solo se usará en el barajeo
    private Carta[] intercambiar(Carta[] cs, int f, int l){
        Carta temp = cs[l];
        cs[l] = cs[f];
        cs[f] = temp;

        return cs;
    }

    public Carta dealer(){
        contador++;
        return cartas[contador-1];
    }
}
