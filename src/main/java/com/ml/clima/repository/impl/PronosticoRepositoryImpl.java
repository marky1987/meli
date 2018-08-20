package com.ml.clima.repository.impl;

import com.ml.clima.entities.Pronostico;
import com.ml.clima.enums.PronosticoClimaEnum;
import com.ml.clima.repository.custom.PronosticoRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PronosticoRepositoryImpl implements PronosticoRepositoryCustom {

	 @PersistenceContext
	 private EntityManager em;

	@Override
	public Pronostico findByDia(Integer dia) {
		CriteriaBuilder builder = this.getEm().getCriteriaBuilder();
		CriteriaQuery<Pronostico> cq = builder.createQuery(Pronostico.class);
		Root<Pronostico> pro = cq.from(Pronostico.class);
		cq.select(pro);
		List<Predicate> predicates = new ArrayList<Predicate>();
		predicates.add(builder.equal(pro.get("dia"),dia));
		cq.select(pro).where(predicates.toArray(new Predicate[]{}));
		TypedQuery<Pronostico> query = this.getEm().createQuery(cq);
		return query.getSingleResult();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
