package com.ml.clima.entities;

public class Vulcano extends Planeta {

    private final static int radio = 1000;

    public Double[] getPosicion(Integer dia){
        double x = radio * Math.sin(-dia);
        double y = radio * Math.cos(-dia);
        Double [] coordenada = new Double[2];
        coordenada[0] = x;
        coordenada[1] = y;
        return coordenada;
    }
}
