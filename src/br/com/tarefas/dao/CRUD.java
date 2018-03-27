package br.com.tarefas.dao;

import java.util.List;


public interface CRUD {

	abstract void inserir(Object o);
	abstract void alterar(Object o);
	abstract void excluir(Object o);
	abstract List<Object> listar();
	abstract Object listar(int id);
	
}
