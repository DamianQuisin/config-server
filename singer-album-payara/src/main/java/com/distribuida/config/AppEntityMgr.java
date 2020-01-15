package com.distribuida.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class AppEntityMgr {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("clientPU");
	
	@Produces
	@ApplicationScoped
	public static EntityManager getEntityManager() {
		
		return emf.createEntityManager();
	}
	

}
