package br.com.tarefas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tarefas.model.Tarefa;

public class TestaInsercao {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tarefa");
		EntityManager em = emf.createEntityManager();
		
		Tarefa t = new Tarefa();
		t.setTarefa("Primeiro cadastro");
		
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}
}
