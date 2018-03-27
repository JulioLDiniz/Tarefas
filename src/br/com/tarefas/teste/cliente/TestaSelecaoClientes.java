package br.com.tarefas.teste.cliente;

import java.util.List;

import br.com.tarefas.dao.ClienteDAO;
import br.com.tarefas.model.Cliente;

public class TestaSelecaoClientes {
	public static void main(String[] args) {
		ClienteDAO cDAO = new ClienteDAO();
		
		Cliente c = new Cliente();
		
		List<Object> listaDeClientes =  cDAO.listar();
		
		for (Object object : listaDeClientes) {
			 c =(Cliente) object;
			System.out.println(c.getNome());
		}
		
		
	}
}
