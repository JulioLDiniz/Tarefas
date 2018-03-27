package br.com.tarefas.teste.cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.tarefas.model.Cliente;
import br.com.tarefas.util.JPAUtil;

public class TestaSelecaoCliente {
	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEnityManager();
		em.getTransaction().begin();
		
		String jpql = "select distinct c from Cliente c join fetch c.movimentacao ";
		
		Query query = em.createQuery(jpql);
		
	List<Cliente> todosOsClientes = query.getResultList();
		
	System.out.println(todosOsClientes.size());
	
	for (Cliente cliente : todosOsClientes) {
		System.out.println(cliente.getMovimentacao());
	}
		
		em.getTransaction().commit();
		em.close();
		
		
	}
}
