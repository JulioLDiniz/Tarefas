package br.com.tarefas.teste.cliente;

import br.com.tarefas.dao.ClienteDAO;
import br.com.tarefas.model.Cliente;

public class TestaRemocaoCliente {
	public static void main(String[] args) {
		
		Cliente c = new Cliente();
		c.setId(3);
		
		ClienteDAO cDAO = new ClienteDAO();
		cDAO.excluir(c);
		
	}
}
