package br.com.tarefas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("tarefa");

	public  EntityManager getEnityManager() {

		return emf.createEntityManager();

	}

}
