package com.distribuida.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.distribuida.entidades.Singer;

@ApplicationScoped
public class ServicioSingerImpl implements ServicioSinger {

	@Inject
	EntityManager em;
	
	@Override
	public List<Singer> listar() {
		List<Singer> singers = new ArrayList<Singer>();
		singers = em.createQuery("from Singer", Singer.class).getResultList();
		return singers;
	}

	@Override
	public Singer buscar(Integer id) {
		return em.find(Singer.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		em.getTransaction().begin();
		Singer singer = em.find(Singer.class, id);
		em.remove(singer);
		em.getTransaction().commit();
	}

	@Override
	public void crear(Singer singer) {
		em.getTransaction().begin();
		em.persist(singer);
		em.getTransaction().commit();

	}

	@Override
	public void editar(Singer singer) {
		em.getTransaction().begin();
		em.merge(singer);
		em.getTransaction().commit();

	}

}
