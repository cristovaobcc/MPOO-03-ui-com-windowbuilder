package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewLogin {

	private JFrame frame;
	private JTextField loginTextField;
	private JPasswordField senhaJPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin window = new ViewLogin();
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
	public ViewLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 587, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(159, 87, 70, 15);
		frame.getContentPane().add(lblLogin);
		
		loginTextField = new JTextField();
		loginTextField.setBounds(159, 113, 290, 27);
		frame.getContentPane().add(loginTextField);
		loginTextField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(159, 149, 70, 15);
		frame.getContentPane().add(lblSenha);
		
		senhaJPasswordField = new JPasswordField();
		senhaJPasswordField.setBounds(159, 176, 290, 27);
		frame.getContentPane().add(senhaJPasswordField);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkLogin(loginTextField.getText(), new String(senhaJPasswordField.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Bem vindo ao sistema!");
				} else {
					JOptionPane.showMessageDialog(null, "Dados inválidos!");
				}
				
			}
		});
		btnNewButton.setBounds(262, 226, 106, 41);
		frame.getContentPane().add(btnNewButton);
	}
	
	public boolean checkLogin(String login, String senha) {
		return login.equalsIgnoreCase("usuario") && senha.equalsIgnoreCase("senha");
	}
}
