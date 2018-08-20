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
import java.util.stream.Stream;

@Service
@Transactional
public class ClimaService {

	@Autowired
	private PronosticoRepository repositorty;
	
	public ResponseDTO calcularClima() {
		List<Pronostico> all = this.repositorty.findAll();
		Stream<Pronostico> lluvia = all.stream().filter(p -> p.getDescripcion().equals(PronosticoClimaEnum.LLUVIA.name()));
		Stream<Pronostico> sequia = all.stream().filter(p -> p.getDescripcion().equals(PronosticoClimaEnum.SEQUIA.name()));
		Stream<Pronostico> optimo = all.stream().filter(p -> p.getDescripcion().equals(PronosticoClimaEnum.CONDICIONES_OPTIMAS.name()));
		ResponseDTO dto = new ResponseDTO();
		dto.setCantidadPeriodoLluvia(lluvia.toArray().length);
		dto.setCantidadPeriodoSequia(sequia.toArray().length);
		dto.setPeriodoCondicionesOptimaYPresion(optimo.toArray().length);
		dto.setDiaPicoMaxLluvia(0);
		return dto;
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
