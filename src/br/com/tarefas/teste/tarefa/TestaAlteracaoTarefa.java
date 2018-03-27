package br.com.tarefas.teste.tarefa;

import br.com.tarefas.dao.TarefaDAO;
import br.com.tarefas.model.Status;
import br.com.tarefas.model.Tarefa;

public class TestaAlteracaoTarefa {
	public static void main(String[] args) {
		Tarefa t = (Tarefa) new TarefaDAO().listar(5);
		
		t.setStatus(Status.EMANDAMENTO);
		
		TarefaDAO tDAO = new TarefaDAO();
		tDAO.alterar(t);
	}
}
