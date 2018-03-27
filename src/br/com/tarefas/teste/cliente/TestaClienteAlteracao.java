package br.com.tarefas.teste.cliente;

import br.com.tarefas.dao.ClienteDAO;
import br.com.tarefas.model.Cliente;

public class TestaClienteAlteracao {
	public static void main(String[] args) {
		Cliente c = (Cliente) new ClienteDAO().listar(2);
		
		c.setNome("esse é o julin");
		
		ClienteDAO cDAO = new ClienteDAO();
		cDAO.alterar(c);
		
		
	}
}
