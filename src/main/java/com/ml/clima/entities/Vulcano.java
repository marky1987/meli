package com.ml.clima.entities;

public class Vulcano extends Planeta {

    private final static int radio = 1000;
    private final static double velocidadAngular = 5.0;

    public Double[] getPosicion(Integer dia){
        double x = radio * Math.sin(velocidadAngular * dia);
        x = Math.toRadians(x);
        x = Math.round(x);
        double y = radio * Math.cos(velocidadAngular * dia);
        y = Math.toRadians(y);
        y = Math.round(y);
        Double [] coordenada = new Double[2];
        coordenada[0] = x;
        coordenada[1] = y;
        return coordenada;
    }
}
