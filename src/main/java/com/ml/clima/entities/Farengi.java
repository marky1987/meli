package com.ml.clima.entities;

public class Farengi extends Planeta  {

    private final static int radio = 500;

    public Double[] getPosicion(Integer dia) {
        double x = radio * Math.sin(Double.valueOf(dia));
        double y = radio * Math.cos(Double.valueOf(dia));
        Double [] coordenada = new Double[2];
        coordenada[0] = x;
        coordenada[1] = y;
        return coordenada;
    }
}
