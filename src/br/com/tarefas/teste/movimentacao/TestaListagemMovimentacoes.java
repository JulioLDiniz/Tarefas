package br.com.tarefas.teste.movimentacao;

import java.util.List;

import br.com.tarefas.dao.MovimentacaoDAO;
import br.com.tarefas.model.Movimentacao;

public class TestaListagemMovimentacoes {
	public static void main(String[] args) {
		Movimentacao m = new Movimentacao();
		
		List<Object> listaMovimentacoes = new MovimentacaoDAO().listar();
		
		for (Object object : listaMovimentacoes) {
			m = (Movimentacao) object;
			System.out.println(m.getId());
		}
	}
}
