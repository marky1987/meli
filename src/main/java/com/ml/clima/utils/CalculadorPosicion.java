package com.ml.clima.utils;

import com.ml.clima.enums.PlanetaEnum;
import com.ml.clima.factory.CalculadorFactory;

import java.util.HashMap;

public final class CalculadorPosicion {

    public static HashMap<String, Float[]> calcularPosicion(Integer dia){
        //TODO implementar logica
        HashMap<String,Float[]> map = new HashMap<String, Float[]>();
        map.put(PlanetaEnum.FARENGI.name(),CalculadorFactory.getPosicion(PlanetaEnum.FARENGI.name(),dia));
        map.put(PlanetaEnum.VULCANO.name(),CalculadorFactory.getPosicion(PlanetaEnum.VULCANO.name(),dia));
        map.put(PlanetaEnum.BETASOIDE.name(),CalculadorFactory.getPosicion(PlanetaEnum.BETASOIDE.name(),dia));
        return map;
    }
}
