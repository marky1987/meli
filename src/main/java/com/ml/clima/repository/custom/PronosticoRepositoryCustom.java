package com.ml.clima.repository.custom;

import com.ml.clima.entities.Pronostico;

public interface PronosticoRepositoryCustom {

	Pronostico findByDia(Integer dia);
}
