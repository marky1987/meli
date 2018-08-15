package com.ml.clima.repository;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ml.clima.entities.Pronostico;
import com.ml.clima.repository.custom.PronosticoRepositoryCustom;

@Transactional
@Primary
public interface PronosticoRepository extends JpaRepository<Pronostico, Long> , PronosticoRepositoryCustom {

}
