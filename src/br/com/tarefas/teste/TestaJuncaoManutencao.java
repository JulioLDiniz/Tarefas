package br.com.tarefas.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.tarefas.util.JPAUtil;

public class TestaJuncaoManutencao {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEnityManager();
		em.getTransaction().begin();
		
		String jpql = "select sum(m.valor) from Movimentacao m where m.manutencao = false and m.dataMovimentacao = :pData";
		
		Query query = em.createQuery(jpql);
		Calendar c = Calendar.getInstance();
		c.set(2018,02,17);
		query.setParameter("pData", c);
		
		System.out.println(query.getSingleResult());
		
		
		em.getTransaction().commit();
		em.close();
	}
}
