package br.com.tarefas.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.tarefas.dao.ClienteDAO;
import br.com.tarefas.model.Cliente;

import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class Janela1 {

	private JFrame frame;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldEndereco;
	private JTable table;
	DefaultTableModel modelo = new DefaultTableModel() {
		public boolean isCellEditable(int rowIndex, int mColIndex){ 
	         return false; 
	    } 
	};
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela1 window = new Janela1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 
	/**
	 * Create the application.
	 */
	public Janela1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 896, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteDAO cDAO = new ClienteDAO();
				Cliente c = new Cliente();
				c.setNome(textFieldNome.getText());
				c.setTelefone(textFieldTelefone.getText());
				c.setEndereco(textFieldEndereco.getText());
				
				cDAO.inserir(c);
				
				textFieldNome.setText("");
				textFieldEndereco.setText("");
				textFieldTelefone.setText("");
				
				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
				//limpar tabela
				modelo.setNumRows(0);
				carregaTabela();
				
			}
		});
		btnSalvar.setBounds(461, 76, 117, 25);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				c.setId(Integer.parseInt(textFieldId.getText()));
				c.setNome(textFieldNome.getText());
				c.setTelefone(textFieldTelefone.getText());
				c.setEndereco(textFieldEndereco.getText());
				
				ClienteDAO cDAO = new ClienteDAO();
				cDAO.alterar(c);
				
				textFieldId.setText("");
				textFieldNome.setText("");
				textFieldEndereco.setText("");
				textFieldTelefone.setText("");
				
				JOptionPane.showMessageDialog(null, "Cliente Alterado com sucesso!");
				modelo.setNumRows(0);
				
				carregaTabela();
			}
		});
		btnAlterar.setBounds(604, 76, 117, 25);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(744, 76, 117, 25);
		
		JPanel panelCadastroCliente = new JPanel();
		panelCadastroCliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setForeground(Color.GRAY);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
				.addComponent(panelCadastroCliente, GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCadastroCliente, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Clientes");
		lblNewLabel_1.setBounds(12, 12, 207, 48);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 32));
		panel.add(lblNewLabel_1);
		
		table = new JTable(modelo);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnAlterar.setEnabled(true);
				btnExcluir.setEnabled(true);
				btnSalvar.setEnabled(false);
				
				textFieldId.setText(String.valueOf(modelo.getValueAt(table.getSelectedRow(), 0)));
				textFieldNome.setText(String.valueOf(modelo.getValueAt(table.getSelectedRow(), 1)));
				textFieldTelefone.setText(String.valueOf(modelo.getValueAt(table.getSelectedRow(), 2)));
				textFieldEndereco.setText(String.valueOf(modelo.getValueAt(table.getSelectedRow(), 3)));
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"Id", "Nome", "Telefone", "Endere\u00E7o"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				Object.class, String.class, String.class, String.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
		scrollPane.setViewportView(table);
		modelo.addColumn("ID");
		modelo.addColumn("NOME");
		modelo.addColumn("TELEFONE");
		modelo.addColumn("ENDEREÇO");
		
		
		
		
		panelCadastroCliente.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(12, 28, 50, 27);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panelCadastroCliente.add(lblNewLabel);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(90, 32, 214, 19);
		panelCadastroCliente.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(12, 67, 70, 15);
		panelCadastroCliente.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		javax.swing.text.MaskFormatter telefone = null;
		try {
			telefone = new javax.swing.text.MaskFormatter("(##) # ####-####");
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null,  "Erro na formatação do campo Telefone.", null, JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}

		 textFieldTelefone = new javax.swing.JFormattedTextField(telefone);
		
		textFieldTelefone.setBounds(90, 65, 130, 19);
		panelCadastroCliente.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setBounds(12, 98, 70, 15);
		panelCadastroCliente.add(lblEndereo);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(89, 96, 205, 19);
		panelCadastroCliente.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);
		
		
		panelCadastroCliente.add(btnSalvar);
		
		
		panelCadastroCliente.add(btnExcluir);
		
		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		textFieldId.setBounds(90, 4, 41, 16);
		panelCadastroCliente.add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(12, 5, 70, 15);
		panelCadastroCliente.add(lblId);
		
		
		panelCadastroCliente.add(btnAlterar);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JButton btnCliente = new JButton("Cliente");
		menuBar.add(btnCliente);
		
		JButton btnMovimentacao = new JButton("Movimentação");
		btnMovimentacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(btnMovimentacao);
		
		JButton btnTarefa = new JButton("Tarefa");
		menuBar.add(btnTarefa);
		carregaTabela();
		
		btnSalvar.setEnabled(false);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldId.setText("");
				textFieldNome.setText("");
				textFieldEndereco.setText("");
				textFieldTelefone.setText("");
				
				btnSalvar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnExcluir.setEnabled(false);
			}
		});
		btnNovo.setBounds(332, 76, 117, 25);
		panelCadastroCliente.add(btnNovo);
	}
	
	//Carregar Tabela
	public void carregaTabela() {
		ClienteDAO cliDAO = new ClienteDAO();
		Cliente cli = new Cliente();
			List<Object> clientes = cliDAO.listar();
			
			for (Object object : clientes) {
			cli = (Cliente) object;
			modelo.addRow(new Object[] {
					cli.getId(), cli.getNome(), cli.getTelefone(), cli.getEndereco()
			});
		}
	}
}
