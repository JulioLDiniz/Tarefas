package br.com.tarefas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.tarefas.model.Movimentacao;
import br.com.tarefas.util.JPAUtil;

public class TestaSelecaoMovimentacao {

	public static void main(String[] args) {
		
		String jpql = "select m from Movimentacao m where m.id = :pId";
		
		EntityManager em = new JPAUtil().getEnityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery(jpql);
		query.setParameter("pId", 2);
		Movimentacao m =(Movimentacao) query.getSingleResult();
		
		
		em.getTransaction().commit();
		em.close();
		
		System.out.println("O valor da movimentação é: "+m.getCliente().getNome());
	}
}
