package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldLogin;
    private JPasswordField passwordField;
    private List<LoginListener> loginListeners = new ArrayList<>();

	// Metodo de Login
	 public void addLoginListener(LoginListener listener) {
        loginListeners.add(listener);
    }
	// Metodo de notificação de login bem sucedido
	private void notifyLoginSuccess() {
        for (LoginListener listener : loginListeners) {
            listener.onLoginSuccess();
        }
    }

	// Construtor da interface gráfica de login
	public LoginGUI() {
		setTitle("Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Campos de texto para login e senha
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(104, 25, 95, 23);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblLogin);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(104, 55, 179, 20);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(104, 86, 109, 14);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 111, 179, 20);
		contentPane.add(passwordField);
		
		// Botão para limpar os campos de login e senha
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.setBounds(82, 166, 109, 23);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldLogin.setText("");
				passwordField.setText("");
			}
		});
		contentPane.add(btnLimpar);
		
		// Botão para realizar o login
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = textFieldLogin.getText();
				String senha = passwordField.getText();
				// Verifica as credenciais e abre a tela da instituição se o login for bem sucedido
				if (login.equals("user") && senha.equals("12345")) {
					InstituicaoGUI telainstituicao = new InstituicaoGUI();
					telainstituicao.setVisible(true);
					dispose();
				}
				else{
					// Exibe uma mensagem de erro se o login falhar
					JOptionPane.showMessageDialog(LoginGUI.this, "Login e/ou senha incorretos.", "Erro!", JOptionPane.INFORMATION_MESSAGE);
					passwordField.setText("");
				}
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEntrar.setBounds(201, 166, 109, 23);
		contentPane.add(btnEntrar);
	}
}
