package br.com.tarefas.teste.tarefa;

import java.util.List;

import br.com.tarefas.dao.TarefaDAO;
import br.com.tarefas.model.Tarefa;

public class TestaSelecaoTarefas {
	public static void main(String[] args) {
		List<Object> listaDeTarefas = new TarefaDAO().listar();
		Tarefa t = new Tarefa();
		
		for (Object object : listaDeTarefas) {
			t = (Tarefa) object;
			System.out.println(t.getTarefa());
		}
	}
}
