package br.com.tarefas.teste.movimentacao;

import java.math.BigDecimal;

import br.com.tarefas.dao.MovimentacaoDAO;
import br.com.tarefas.model.Movimentacao;

public class TestaAlteracaoMovimentacao {
	public static void main(String[] args) {
		Movimentacao m = (Movimentacao) new MovimentacaoDAO().listar(5);
		m.setValor(new BigDecimal("1000.0"));
		
		MovimentacaoDAO dao = new MovimentacaoDAO();
		dao.alterar(m);
	}
}
