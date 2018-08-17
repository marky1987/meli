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
	//TODO hacer count a la base por cada caso con limit de cantidad de dias por anio
		return null;
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
