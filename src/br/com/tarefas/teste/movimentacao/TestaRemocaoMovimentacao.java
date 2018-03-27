package br.com.tarefas.teste.movimentacao;

import br.com.tarefas.dao.MovimentacaoDAO;
import br.com.tarefas.model.Movimentacao;

public class TestaRemocaoMovimentacao {
	public static void main(String[] args) {
		Movimentacao m = new Movimentacao();
		m.setId(4);
		
		MovimentacaoDAO dao = new MovimentacaoDAO();
		dao.excluir(m);
	}
}
