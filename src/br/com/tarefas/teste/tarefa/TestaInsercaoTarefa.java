package br.com.tarefas.teste.tarefa;

import java.util.Calendar;

import br.com.tarefas.dao.TarefaDAO;
import br.com.tarefas.model.Status;
import br.com.tarefas.model.Tarefa;

public class TestaInsercaoTarefa {
	public static void main(String[] args) {
		Tarefa t = new Tarefa();
		t.setTarefa("Marcar consulta do pai");
		t.setDate(Calendar.getInstance());
		t.setStatus(Status.EMABERTO);
		
		TarefaDAO tDAO = new TarefaDAO();
		tDAO.inserir(t);
	}
}
