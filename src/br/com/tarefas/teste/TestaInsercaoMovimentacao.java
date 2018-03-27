package br.com.tarefas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.tarefas.model.Cliente;
import br.com.tarefas.model.Movimentacao;
import br.com.tarefas.util.JPAUtil;

public class TestaInsercaoMovimentacao {

	public static void main(String[] args) {
		Cliente c = new Cliente();
		c.setNome("Fulano");
		c.setTelefone("61 99314899");
		c.setEndereco("taguatinga");
		
		Movimentacao m = new Movimentacao(new BigDecimal("250.0"), false, Calendar.getInstance());
		m.setCliente(c);
		
		
		EntityManager em = new JPAUtil().getEnityManager();
		
		em.getTransaction().begin();
		
		em.persist(c);
		em.persist(m);
		
		
		em.getTransaction().commit();
		em.close();
		
	}
}
