package com.example.EurovegasMobile;

public class Carta {
    private int palos; // diamantes 1; corazones 2; picas 3; treboles 4
    private int valor_as; // el valor del as es 1
    private boolean valor_as_distinto; // si el valor del as no es uno entonces es 11

    public static int cartaAnterior; //Guardará el valor de la carta anterior

    Carta(int p, int v_a){
        palos = p;
        valor_as = v_a;
    }

    public int getPalos() {
        return palos;
    }

    public int getValor_as(){
        return valor_as;
    }

    //retorno del valor de la carta cuando hay BlackJack
    public int getValor(){
        if (valor_as == 1){
            if(getValor_as_distinto())
                return 1;
            else
                return 11;
        }
        else if (valor_as > 10)
            return 10;
        else
            return valor_as;
    }

    public boolean getValor_as_distinto(){
        return valor_as_distinto;
    }

    public void setValor_as_distinto(boolean one){
        valor_as_distinto = one;
    }

}
