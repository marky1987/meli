package com.ml.clima.service;

import com.ml.clima.entities.Pronostico;
import com.ml.clima.enums.PlanetaEnum;
import com.ml.clima.enums.PronosticoClimaEnum;
import com.ml.clima.repository.PronosticoRepository;
import com.ml.clima.utils.CalculadorPosicion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CalculadorDeClima extends Thread {

    private final static int DIAS_EN_DIEZ_ANIOS = 3650;

    @Autowired
    private PronosticoRepository repository;

    @Override
    public void run() {
        int dia = 1;
        while(dia <= DIAS_EN_DIEZ_ANIOS){
            HashMap<String, Double[]> hm = CalculadorPosicion.calcularPosicion(dia);
            Double[] posFarengi = hm.get(PlanetaEnum.FARENGI.name());
            Double[] posBetasoide = hm.get(PlanetaEnum.BETASOIDE.name());
            Double[] posVulcano = hm.get(PlanetaEnum.VULCANO.name());
            String clima = this.calcularClimaDelDia(posFarengi, posBetasoide, posVulcano);
            //Parche por problemas de logica en cuanto a física
            //if (dia%22==0){
              //  clima = PronosticoClimaEnum.SEQUIA.name();
            //} else if (dia%10==0){
              //  clima = PronosticoClimaEnum.CONDICIONES_OPTIMAS.name();
            //} else {
              //  clima = PronosticoClimaEnum.LLUVIA.name();
            //}
            //PARCHE POR PROBLEMAS DE LOGICA en cuanto a fisica;
            Pronostico pronostico = new Pronostico();
            pronostico.setDia(dia);
            pronostico.setDescripcion(clima);
            this.getRepository().save(pronostico);
            dia++;
        }
    }


    private String calcularClimaDelDia(Double[] posFarengi, Double[] posBetasoide, Double[] posVulcano) {
        String clima = "";
        if (estanAlineados(posFarengi, posBetasoide, posVulcano)) {
            //Planetas Alineados con el sol
            clima = this.isLinealAlSol(posFarengi, posBetasoide, posVulcano) ? PronosticoClimaEnum.SEQUIA.name() : PronosticoClimaEnum.CONDICIONES_OPTIMAS.name();
        } else {
            //De lo contrario si no estan alineados entre ellos es porque si o si forman un triangulo.
            //TODO ver como sacar derivada/integral con el tema del 'perimetro del triangulo en su pico maximo';
            clima = PronosticoClimaEnum.LLUVIA.name();
        }
        return clima;
    }

    private boolean estanAlineados(Double[] posFarengi, Double[] posBetasoide, Double[] posVulcano){
        double p1 = (posVulcano[1] - posFarengi[1]) / (posVulcano[0] - posFarengi[0]);
        double p2 = (posBetasoide[1] - posVulcano[1]) / (posBetasoide[0] - posVulcano[0]);
        return p1 == p2 ? Boolean.TRUE : Boolean.FALSE;
    }

    private boolean isLinealAlSol(Double[] posFarengi, Double[] posBetasoide, Double[] posVulcano){
        double pendiente = (posVulcano[1] - posFarengi[1]) / (posVulcano[0] - posFarengi[0]);
        //Significa entonces que la ordenada es 0.
        //Se calcula sobre uno solo porque se entiende que si ya estan alineados entre ellos con que uno ya esta con el sol, todos lo estan
        return posFarengi[1] - (pendiente * posFarengi[0]) == 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    public PronosticoRepository getRepository() {
        return repository;
    }

    public void setRepository(PronosticoRepository repository) {
        this.repository = repository;
    }
}
