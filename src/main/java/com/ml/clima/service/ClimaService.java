package com.ml.clima.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ml.clima.dto.ResponseDTO;
import com.ml.clima.entities.Pronostico;
import com.ml.clima.repository.PronosticoRepository;
import com.ml.clima.repository.custom.PronosticoRepositoryCustom;

@Service
@Transactional
public class ClimaService {

	
	@Autowired
	private PronosticoRepository repositorty;
	
	public ResponseDTO calcularClima(Integer anio) {
		
//		int diaLimite = anio*365;
//		int dia = 0;
//		int contadorPeriodoLluvia = 0;
//		int contadorPeriodoSequia = 0;
//		int diaPicoMaximoLluvia = 0;
//		int condicionesOptimas = 0;
		
		ResponseDTO rsp = new ResponseDTO();
		rsp.setCantidadPeriodoLluvia(2);
		rsp.setCantidadPeriodoSequia(1);
		rsp.setDiaPicoMaxLluvia(521);
		rsp.setPeriodoCondicionesOptimaYPresion(0);
		
		List<Pronostico> findAll = this.getRepositorty().findAll();
		rsp.setPeriodoCondicionesOptimaYPresion(findAll.get(0).getDia());
		return rsp;
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
