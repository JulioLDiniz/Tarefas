package br.com.tarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.tarefas.model.Movimentacao;
import br.com.tarefas.util.JPAUtil;

public class MovimentacaoDAO implements CRUD {

	EntityManager em ;
	
	public MovimentacaoDAO() {
		em = new JPAUtil().getEnityManager();
	}
	
	@Override
	public void inserir(Object o) {
		Movimentacao m = (Movimentacao)o;
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void alterar(Object o) {
		Movimentacao m = (Movimentacao)o;
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void excluir(Object o) {
		Movimentacao m = (Movimentacao)o;
		em.getTransaction().begin();
		m = em.find(Movimentacao.class, m.getId());
		em.remove(m);
		em.getTransaction().commit();
		em.close();		
	}

	@Override
	public List<Object> listar() {
		String jpql = "select m from Movimentacao m left join m.cliente c";
		Query query = em.createQuery(jpql);
		
		return query.getResultList();
	}

	@Override
	public Object listar(int id) {
		em.getTransaction().begin();
		
		Movimentacao m = em.find(Movimentacao.class, id);
		
		em.getTransaction().commit();
		em.close();		
		
		return m;
	}

}
