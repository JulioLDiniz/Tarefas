package br.com.tarefas.teste.tarefa;

import br.com.tarefas.dao.TarefaDAO;
import br.com.tarefas.model.Tarefa;

public class TestaRemocaoTarefa {
	public static void main(String[] args) {
		Tarefa t = new Tarefa();
		t.setId(4);
		
		TarefaDAO tDAO = new TarefaDAO();
		tDAO.excluir(t);
	}
}
