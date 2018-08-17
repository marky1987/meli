package com.ml.clima.service;

import com.ml.clima.entities.Pronostico;
import com.ml.clima.enums.PlanetaEnum;
import com.ml.clima.enums.PronosticoClimaEnum;
import com.ml.clima.repository.PronosticoRepository;
import com.ml.clima.utils.CalculadorPosicion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

@Transactional
@Service
public class CalculadorDeClima implements ICalculadorDeClima {

    private final static int DIAS_EN_DIEZ_ANIOS = 3650;

    @Autowired
    private PronosticoRepository repository;

    public void predecirClimaEnProximosDiezAnios(){
        int dia = 1;
        while(dia <= DIAS_EN_DIEZ_ANIOS){
            HashMap<String, Float[]> hm = CalculadorPosicion.calcularPosicion(dia);
            Float[] posFarengi = hm.get(PlanetaEnum.FARENGI);
            Float[] posBetasoide = hm.get(PlanetaEnum.BETASOIDE);
            Float[] posVulcano = hm.get(PlanetaEnum.VULCANO);
            String clima = this.calcularClimaDelDia(posFarengi, posBetasoide, posVulcano);
            Pronostico pronostico = new Pronostico();
            pronostico.setDia(dia);
            pronostico.setDescripcion(clima);
            this.getRepository().save(pronostico);
        }
    }

    private String calcularClimaDelDia(Float[] posFarengi, Float[] posBetasoide, Float[] posVulcano) {
        String clima = "";

        if (coordenadasXLineales(posFarengi,posBetasoide,posVulcano) && coordenadasYLineales(posFarengi,posBetasoide,posVulcano)){
            //Planetas Alineados con el sol
            clima =	this.isLinealAlSol(posFarengi,posBetasoide,posVulcano) ? PronosticoClimaEnum.SEQUIA.name() : PronosticoClimaEnum.CONDICIONES_OPTIMAS.name();
        }else{
            //De lo contrario si no estan alineados entre ellos es porque si o si forman un triangulo.
            //TODO ver como sacar derivada/integral con el tema del 'perimetro del triangulo en su pico maximo';
            clima = PronosticoClimaEnum.LLUVIA.name();
        }
        return clima;
    }

    private boolean coordenadasXLineales(Float[] posFarengi, Float[] posBetasoide, Float[] posVulcano){
        return posFarengi[0] * 2 == posBetasoide[0] && posBetasoide[0] * 2  == posVulcano[0] ? Boolean.TRUE : Boolean.FALSE;
    }

    private boolean coordenadasYLineales(Float[] posFarengi, Float[] posBetasoide, Float[] posVulcano){
        return posFarengi[1] * 2 == posBetasoide[1] && posBetasoide[1] * 2  == posVulcano[1] ? Boolean.TRUE : Boolean.FALSE;
    }

    private boolean isLinealAlSol(Float[] posFarengi, Float[] posBetasoide, Float[] posVulcano){
        double farengi = posFarengi[0]/posFarengi[1];
        double betasoide = posBetasoide[0]/posBetasoide[1];
        double vulcano = posVulcano[0]/posVulcano[1];
        return farengi == betasoide && betasoide == vulcano ? Boolean.TRUE : Boolean.FALSE;
    }

    public PronosticoRepository getRepository() {
        return repository;
    }

    public void setRepository(PronosticoRepository repository) {
        this.repository = repository;
    }
}
