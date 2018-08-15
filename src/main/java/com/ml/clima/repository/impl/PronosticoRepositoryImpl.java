package com.ml.clima.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ml.clima.entities.Pronostico;
import com.ml.clima.repository.custom.PronosticoRepositoryCustom;

@Repository
public class PronosticoRepositoryImpl implements PronosticoRepositoryCustom {

	 @PersistenceContext
	 private EntityManager em;
	
	@Override
	public Pronostico findByDia(Integer dia) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Pronostico> cq = builder.createQuery(Pronostico.class);
		Root<Pronostico> pro = cq.from(Pronostico.class);
		cq.select(pro);
		List<Predicate> predicates = new ArrayList<Predicate>();
		predicates.add(builder.equal(pro.get("dia"),dia));
		cq.select(pro).where(predicates.toArray(new Predicate[]{}));
		TypedQuery<Pronostico> query = em.createQuery(cq);
		return query.getSingleResult();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
