package br.com.tarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.tarefas.model.Cliente;
import br.com.tarefas.util.JPAUtil;

public class ClienteDAO implements CRUD {

	private EntityManager em;

	public ClienteDAO() {
		em = new JPAUtil().getEnityManager();
	}

	@Override
	public void inserir(Object o) {
		Cliente c = (Cliente) o;

		em.getTransaction().begin();

		em.persist(c);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void alterar(Object o) {
		Cliente c = (Cliente) o;
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void excluir(Object o) {
		Cliente c =(Cliente) o;
		em.getTransaction().begin();
		
		c = em.find(Cliente.class, c.getId());
		
		em.remove(c);
		
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public List<Object> listar() {
		em.getTransaction().begin();

		String jpql = "select c from Cliente c";

		Query query = em.createQuery(jpql);

		List<Object> listaClientes = query.getResultList();

		em.getTransaction().commit();

		em.close();
		return listaClientes;
	}

	@Override
	public Object listar(int id) {
		em.getTransaction().begin();

		Cliente c = em.find(Cliente.class, id);

		em.getTransaction().commit();
		em.close();

		return c;
	}

}
