package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class InstituicaoGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCodigoMEC;
	private JTextField textFieldNome;
	private JTextField textFieldAnoFundacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstituicaoGUI frame = new InstituicaoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InstituicaoGUI() {
		setTitle("Cadastro de Instituicoes de Ensino");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 400);
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
			}
		});
		contentPane.add(btnLimpar);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(201, 276, 109, 23);
		contentPane.add(btnCadastrar);
	}
}
