package view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.instituicao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class InstituicaoGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCodigoMEC;
	private JTextField textFieldNome;
	private JTextField textFieldAnoFundacao;
	private List<instituicao> instituicoes = new ArrayList<>(); 
	/**
	 * Create the frame.
	 */
	public InstituicaoGUI() {
		setTitle("Cadastro de Instituicoes de Ensino");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoMEC = new JLabel("Codigo do MEC");
		lblCodigoMEC.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigoMEC.setBounds(104, 25, 95, 23);
		contentPane.add(lblCodigoMEC);
		
		textFieldCodigoMEC = new JTextField();
		textFieldCodigoMEC.setBounds(104, 52, 165, 20);
		contentPane.add(textFieldCodigoMEC);
		textFieldCodigoMEC.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(104, 83, 95, 23);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(104, 108, 165, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblAnoFundacao = new JLabel("Ano da fundacao");
		lblAnoFundacao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAnoFundacao.setBounds(104, 139, 145, 23);
		contentPane.add(lblAnoFundacao);
		
		textFieldAnoFundacao = new JTextField();
		textFieldAnoFundacao.setBounds(104, 166, 165, 20);
		contentPane.add(textFieldAnoFundacao);
		textFieldAnoFundacao.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipo.setBounds(104, 197, 122, 23);
		contentPane.add(lblTipo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Educacao Infantil", "Ensino Fundamental", "Ensino Medio", "Educacao Infantil e Ensino Fundamental", "Educacao Infantil e Ensino Fundamental e Medio", "Ensino Fundamental e Medio", "Ensino Superior"}));
		comboBox.setBounds(104, 228, 165, 22);
		contentPane.add(comboBox);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.setBounds(82, 276, 109, 23);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Metodo para apagar todos os campos, substituindo o texto por vazio
				textFieldCodigoMEC.setText("");
				textFieldNome.setText("");
				textFieldAnoFundacao.setText("");
			}
		});
		contentPane.add(btnLimpar);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigoMEC = textFieldCodigoMEC.getText();
				String nome = textFieldNome.getText();
				String anoFundacao = textFieldAnoFundacao.getText();

				if (isNumeric(codigoMEC) && isAlphabetic(nome) && isNumeric(anoFundacao)){
					JOptionPane.showMessageDialog(InstituicaoGUI.this, "Cadastro realizado com sucesso!");
					instituicoes.add(new instituicao(Integer.parseInt(codigoMEC), nome, Integer.parseInt(anoFundacao)));
					
				} else {
					// Se alguma validação falhar, apague os campos incorretos e exiba uma mensagem de erro
					textFieldCodigoMEC.setText(isNumeric(codigoMEC) ? codigoMEC : "");
					textFieldNome.setText(isAlphabetic(nome) ? nome : "");
					textFieldAnoFundacao.setText(isNumeric(anoFundacao) ? anoFundacao : "");
		
					JOptionPane.showMessageDialog(InstituicaoGUI.this, "Erro: Verifique os campos e tente novamente.", "Erro!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(201, 276, 109, 23);
		contentPane.add(btnCadastrar);

		JTable table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
            },
            new String[] {
                "CodigoMEC", "Nome", "Tipo"
            }
        ));
        table.setBounds(31, 350, 320, 63);
        contentPane.add(table);

        JLabel lblNewLabel = new JLabel("CodigoMEC");
        lblNewLabel.setBounds(59, 320, 70, 14);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nome");
        lblNewLabel_1.setBounds(170, 320, 70, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Tipo");
        lblNewLabel_2.setBounds(275, 320, 70, 14);
        contentPane.add(lblNewLabel_2);
	}


	// Metodos de validação
	private boolean isNumeric(String str) {
		return str.matches("\\d+"); // Verifica se a string contém apenas números
	}
	
	private boolean isAlphabetic(String str) {
		return str.matches("[a-zA-Z]+"); // Verifica se a string contém apenas letras
	}
}
