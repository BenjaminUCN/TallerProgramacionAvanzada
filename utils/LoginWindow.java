package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logica.Sistema;

public class LoginWindow {
	
	Sistema sistema;
	WindowManager windowManager;
	
	JFrame frame;
	
	public LoginWindow(Sistema sistema,WindowManager windowManager) {
		this.sistema = sistema;
		this.windowManager = windowManager;
		
		frame = new JFrame("Ventas Coquimbo - Login");
		frame.setSize(420, 420);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);
		
		
		frame.setVisible(true);
	}
	

	private void placeComponents(JPanel panel) {

	    panel.setLayout(null);
	
		// texto: Usuario
		JLabel userLabel = new JLabel("Usuario");
		userLabel.setBounds(115, 11, 80, 25);
		panel.add(userLabel);
		
		// entradas de texto: Usuario
		JTextField userText = new JTextField(20);
		userText.setBounds(115, 32, 160, 25);
		panel.add(userText);
	
		// texto: Contraseña
		JLabel passwordLabel = new JLabel("Contraseña");
		passwordLabel.setBounds(115, 68, 80, 25);
		panel.add(passwordLabel);
				
		// entrada de texto: Contraseña
		JTextField passwordTextField = new JTextField(20);
		passwordTextField.setBounds(115,93,160,25);
		panel.add(passwordTextField);
				
		// texto: Registrarse
		JButton signinButton = new JButton("Registrarse");
		signinButton.setBounds(125, 165, 130, 25);
		panel.add(signinButton);
				
		signinButton.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	frame.dispose();
		       	/*@SuppressWarnings("unused")
				SigninWindow signinWindow = new SigninWindow(sistema);*/
	        	
	        	windowManager.changeWindow("signin");
	        }
	    });
		
		// boton: Ingresar
		JButton loginButton = new JButton("Ingresar");
		loginButton.setBounds(125,130,130,25);
		panel.add(loginButton);
	
		loginButton.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	String user = userText.getText();
	        	String pasword = passwordTextField.getText();
	        	if(sistema.login(user, pasword)) {
	        		frame.dispose();
		        	/*@SuppressWarnings("unused")
					PerfilWindow perfilWindow = new PerfilWindow(sistema, sistema.getUserByName(user));*/
	        		
	        		windowManager.setUser(sistema.getUserByName(user));
	        		windowManager.changeWindow("perfil");
	        	}

	        }
	    });
		
	}
	
}
