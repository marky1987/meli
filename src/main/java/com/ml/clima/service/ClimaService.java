package com.ml.clima.service;

import com.ml.clima.dto.ResponseDTO;
import com.ml.clima.entities.Pronostico;
import com.ml.clima.enums.PlanetaEnum;
import com.ml.clima.enums.PronosticoClimaEnum;
import com.ml.clima.repository.PronosticoRepository;
import com.ml.clima.utils.CalculadorPosicion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class ClimaService {

	
	@Autowired
	private PronosticoRepository repositorty;
	
	public ResponseDTO calcularClima(Integer anio) {
		
	int diaLimite = anio*365;
	int dia = 0;

		while (dia <= diaLimite){
			HashMap<String, Float[]> hm = CalculadorPosicion.calcularPosicion(dia);
			Float[] posFarengi = hm.get(PlanetaEnum.FARENGI);
			Float[] posBetasoide = hm.get(PlanetaEnum.BETASOIDE);
			Float[] posVulcano = hm.get(PlanetaEnum.VULCANO);
			String clima = this.calcularClimaDelDia(posFarengi, posBetasoide, posVulcano);
			dia++;

		}

		ResponseDTO rsp = new ResponseDTO();
		rsp.setCantidadPeriodoLluvia(2);
		rsp.setCantidadPeriodoSequia(1);
		rsp.setDiaPicoMaxLluvia(521);
		rsp.setPeriodoCondicionesOptimaYPresion(0);

		List<Pronostico> findAll = this.getRepositorty().findAll();
		rsp.setPeriodoCondicionesOptimaYPresion(findAll.get(0).getDia());
		return rsp;
	}

	private String calcularClimaDelDia(Float[] posFarengi, Float[] posBetasoide, Float[] posVulcano) {
		String clima = "";
		if (coordenadasXLineales(posFarengi,posBetasoide,posVulcano) && coordenadasYLineales(posFarengi,posBetasoide,posVulcano)){
		//Planetas Alineados con el sol
			clima = PronosticoClimaEnum.SEQUIA.name();
		}else if (true) {
		//Planetas Alineados entre ellos pero no con el sol
			clima = PronosticoClimaEnum.CONDICIONES_OPTIMAS.name();
		}else{
		//De lo contrario si no estan alineados entre ellos es porque si o si forman un triangulo.
			clima = PronosticoClimaEnum.LLUVIA.name();
		}
		return clima;
	}


	private boolean coordenadasXLineales(Float[] posFarengi, Float[] posBetasoide, Float[] posVulcano){
		if (posFarengi[0] * 2 == posBetasoide[0] && posBetasoide[0] * 2  == posVulcano[0]){

		}
		return true;
	}

	private boolean coordenadasYLineales(Float[] posFarengi, Float[] posBetasoide, Float[] posVulcano){
		if (posFarengi[1] * 2 == posBetasoide[1] && posBetasoide[1] * 2  == posVulcano[1]){

		}
		return true;
	}

	public String calcularClimaPorDia(Integer dia) {
		return this.getRepositorty().findByDia(dia).getDescripcion();
	}


	public PronosticoRepository getRepositorty() {
		return repositorty;
	}


	public void setRepositorty(PronosticoRepository repositorty) {
		this.repositorty = repositorty;
	}
	
}
