package com.ml.clima.entities;

public class Betasoide extends Planeta  {

    private final static int radio = 2000;
    private final static double velocidadAngular = 3.0;

    public Double[] getPosicion(Integer dia){
        double x = Math.round(Math.cos(velocidadAngular * dia)*radio);
        double y = Math.round(Math.sin(velocidadAngular * dia)*radio);
        Double [] coordenada = new Double[2];
        coordenada[0] = x;
        coordenada[1] = y;
        return coordenada;
    }
}
