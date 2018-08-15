package com.ml.clima.repository.custom;

import javax.transaction.Transactional;

import com.ml.clima.entities.Pronostico;

@Transactional
public interface PronosticoRepositoryCustom {
	
	public Pronostico findByDia(Integer dia);

}
