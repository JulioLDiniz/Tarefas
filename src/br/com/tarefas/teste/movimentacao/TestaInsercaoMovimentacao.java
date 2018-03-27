package br.com.tarefas.teste.movimentacao;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.tarefas.dao.MovimentacaoDAO;
import br.com.tarefas.model.Cliente;
import br.com.tarefas.model.Movimentacao;

public class TestaInsercaoMovimentacao {
	public static void main(String[] args) {
		Movimentacao m = new Movimentacao();
		m.setDataMovimentacao(Calendar.getInstance());
		m.setManutencao(true);
		m.setValor(new BigDecimal("525.0"));
		
		Cliente c = new Cliente();
		c.setId(2);
		
		m.setCliente(c);
		
		MovimentacaoDAO dao = new MovimentacaoDAO();
		dao.inserir(m);
	}
}
