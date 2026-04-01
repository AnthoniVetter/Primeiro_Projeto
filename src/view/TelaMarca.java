package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JDialog;
import model.Marca;
import controller.MarcaController;
import javax.swing.table.DefaultTableModel;

public class TelaMarca extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPais;
	private JTable table;
	private MarcaController controller = new MarcaController();
	private DefaultTableModel modeloTabela;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaMarca frame = new TelaMarca();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}


	public TelaMarca(JFrame parent) {
		super(parent,true);
		configurarJanela();
		criarComponentes();
		atualizarTable();

	}
	
	private void configurarJanela() {
		setTitle("Cadastro de Marca");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setLocationRelativeTo(null);   // DEIXA A TELA NO MEIO
		contentPane.setBackground(Color.GRAY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10,10,10,10));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
	}
	
	private void criarComponentes() {
		JLabel jblNome = new JLabel("Nome: ");
		jblNome.setBounds(23, 36, 80, 20);
		contentPane.add(jblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(103,36,200,25);
		contentPane.add(txtNome);
		
		JLabel jblPais = new JLabel("País: ");
		jblPais.setBounds(23, 76, 80, 20);
		contentPane.add(jblPais);
		
		txtPais = new JTextField();
		txtPais.setBounds(103,76,200,25);
		contentPane.add(txtPais);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(345, 23, 89, 23);
		contentPane.add(btnSalvar);
		btnSalvar.addActionListener(e -> salvarMarca());
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(345, 57, 89, 23);
		contentPane.add(btnEditar);
		btnSalvar.addActionListener(e -> editarMarca());
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(345, 91, 89, 23);
		contentPane.add(btnExcluir);
		btnSalvar.addActionListener(e -> excluirMarca());
		
		modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("Nome");
		modeloTabela.addColumn("País");
		
		table = new JTable(modeloTabela);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(20, 150, 440, 180);
		contentPane.add(scroll);
	}

	private void salvarMarca() {
		String nome = txtNome.getText();
		String pais = txtPais.getText();
		
		if (nome.isEmpty() || pais.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
			return;
		}
		controller.salvarMarca(nome, pais);
		JOptionPane.showMessageDialog(this, "Marca salva!");
		
		limparCampos();
		atualizarTable();
	}
	
	private void editarMarca() {
		int linha = table.getSelectedRow();
		
		if (linha == -1) {
		JOptionPane.showMessageDialog(this,"Selecione uma marca!");
		return;
		}
		Marca marca = controller.buscarMarca(linha);
		
		txtNome.setText(marca.getNome());
		txtPais.setText(marca.getPais());
		
		controller.excluirMarca(linha);
		atualizarTable();
	}
	
	private void excluirMarca() {
		int linha = table.getSelectedRow();
		if (linha == -1) {
			JOptionPane.showMessageDialog(this, "Selecione uma marca!");
			return;
		}
		controller.excluirMarca(linha);
		JOptionPane.showMessageDialog(this, "Marca Excluida!");
		atualizarTable();
		
		
	}
	private void atualizarTable() {
		modeloTabela.setRowCount(0);
		for (Marca m : controller.listarMarcas()) {
			modeloTabela.addRow(new Object[] {
					m.getNome(),
					m.getPais()
			});
		}
		
	}
	
	private void limparCampos() {
		txtNome.setText("");
		txtPais.setText("");
	}
	
	
//	public TelaMarca() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1178, 773);
//		contentPane = new JPanel();
//		contentPane.setBackground(Color.GRAY);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JButton btnSalvar = new JButton("Salvar");
//		btnSalvar.setBounds(345, 23, 89, 23);
//		contentPane.add(btnSalvar);
//		
//		JButton btnEditar = new JButton("Editar");
//		btnEditar.setBounds(345, 57, 89, 23);
//		contentPane.add(btnEditar);
//		
//		JButton btnExcluir = new JButton("Excluir");
//		btnExcluir.setBounds(345, 91, 89, 23);
//		contentPane.add(btnExcluir);
//		
//		txtNome = new JTextField();
//		txtNome.setHorizontalAlignment(SwingConstants.LEFT);
//		txtNome.setForeground(Color.LIGHT_GRAY);
//		txtNome.setText("Ex: Nome123");
//		txtNome.setBounds(101, 38, 215, 20);
//		contentPane.add(txtNome);
//		txtNome.setColumns(10);
//		
//		txtPais = new JTextField();
//		txtPais.setForeground(Color.LIGHT_GRAY);
//		txtPais.setText("Ex: Brasil");
//		txtPais.setColumns(10);
//		txtPais.setBounds(101, 72, 215, 20);
//		contentPane.add(txtPais);
//		
//		JLabel textoNome = new JLabel("Nome:");
//		textoNome.setBounds(45, 41, 46, 14);
//		contentPane.add(textoNome);
//		
//		JLabel textoPais = new JLabel("País: ");
//		textoPais.setBounds(45, 75, 46, 14);
//		contentPane.add(textoPais);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(44, 134, 390, 194);
//		contentPane.add(scrollPane);
//		
//		table = new JTable();
//		scrollPane.setViewportView(table);
//
//	}
}
