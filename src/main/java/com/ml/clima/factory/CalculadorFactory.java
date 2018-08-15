package com.ml.clima.factory;

import com.ml.clima.entities.Betasoide;
import com.ml.clima.entities.Farengi;
import com.ml.clima.entities.Vulcano;
import com.ml.clima.enums.PlanetaEnum;

public class CalculadorFactory {

    public static float getPosicion(String tipo, Integer dia){
        float posicion = 0;
        if (tipo.equalsIgnoreCase(PlanetaEnum.BETASOIDE.name())){
            posicion =  new Betasoide().getPosicion(dia);
        }else if(tipo.equalsIgnoreCase(PlanetaEnum.FARENGI.name())){
            posicion = new Farengi().getPosicion(dia);
        }else if(tipo.equalsIgnoreCase(PlanetaEnum.VULCANO.name())){
            posicion = new Vulcano().getPosicion(dia);
        }
        return posicion;
    }

}
