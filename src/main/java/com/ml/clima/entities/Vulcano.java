package com.ml.clima.entities;

public class Vulcano extends Planeta {

    private final static int radio = 1000;
    private final static double velocidadAngular = 5.0;

    public Double[] getPosicion(Integer dia){
        double x = Math.round(360 - Math.cos(velocidadAngular * dia)*radio);
        double y = Math.round(360 - Math.sin(velocidadAngular * dia)*radio);
        Double [] coordenada = new Double[2];
        coordenada[0] = x;
        coordenada[1] = y;
        return coordenada;
    }
}
