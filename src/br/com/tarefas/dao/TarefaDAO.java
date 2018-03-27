package br.com.tarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.tarefas.model.Tarefa;
import br.com.tarefas.util.JPAUtil;

public class TarefaDAO implements CRUD{
	
	EntityManager em ;
	
	public TarefaDAO() {
		em = new JPAUtil().getEnityManager();
	}

	@Override
	public void inserir(Object o) {
		Tarefa t = (Tarefa) o;
		
		em.getTransaction().begin();
		em.persist(t);		
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void alterar(Object o) {
		Tarefa t = (Tarefa) o;
		em.getTransaction().begin();
		em.merge(t);		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void excluir(Object o) {
		Tarefa t = (Tarefa) o;
		em.getTransaction().begin();
		t = em.find(Tarefa.class, t.getId());
		em.remove(t);		
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<Object> listar() {
		String jpql = "select t from Tarefa t";
		
		Query query = em.createQuery(jpql);
		
		return query.getResultList();
	}

	@Override
	public Object listar(int id) {
		
		String jpql = "select t from Tarefa t where t.id = :pId";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pId", id);
		
		Tarefa t = (Tarefa) query.getSingleResult();
		return t;
	}

}
