package br.com.tarefas.teste.cliente;

import br.com.tarefas.dao.ClienteDAO;
import br.com.tarefas.model.Cliente;

public class TestaInsercaoCliente {
	public static void main(String[] args) {
		Cliente c = new Cliente();
		c.setNome("para apagar");
		c.setTelefone("(61) 9 9111-4780");
		c.setEndereco("Colonia");
		
		ClienteDAO cDAO = new ClienteDAO();
		cDAO.inserir(c);
	}
}
