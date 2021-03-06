package utils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logica.Sistema;

public class SigninWindow extends Window {
	
	Sistema sistema;
	WindowManager windowManager;
	
	public SigninWindow(Sistema sistema, WindowManager windowManager) {
		super("Registro", 500, 420);
		
		this.sistema = sistema;
		this.windowManager = windowManager;
	}
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	protected void placeComponents(JPanel panel) {
		panel.setLayout(null);
		
		JTextField usernameText = CreateInput("Nombre de usuario", panel, 70, 10);
		JTextField nameText = CreateInput("Nombre completo", panel, 240, 10);
		JTextField emailText = CreateInput("Correo", panel, 70, 60);
		JTextField contactText = CreateInput("Contacto", panel, 240, 60);
		JTextField firstPasswordText = CreateInput("Contraseņa", panel, 70, 110);
		JTextField secondPasswordText = CreateInput("Confirmar contraseņa", panel, 240, 110);
					
		// texto: Registrarse
		JButton signinButton = new JButton("Registrarse");
		signinButton.setBounds(155, 180, 130, 25);
		panel.add(signinButton);
						
		signinButton.addActionListener(new ActionListener(){
		       @Override
		       public void actionPerformed(ActionEvent e) {
		    	   // Si las contraseņas coinciden
		    	   if(  firstPasswordText.getText().equals( secondPasswordText.getText() )  ) {
		    		   String username = usernameText.getText();
			    	   String name = nameText.getText();
			    	   String email = emailText.getText();
			    	   String contact = contactText.getText();
			    	   String password = firstPasswordText.getText();
			    	   
			    	   try {
						if(sistema.sigin(username, name, email, contact, password)) {
							   frame.dispose();
							   windowManager.changeWindow("login");
						   }
			    	   } catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
			    	   }
			    	   
					   /*@SuppressWarnings("unused")
					   LoginWindow loginWindow = new LoginWindow(sistema);*/
			    	   
			    	  
		    	   }
		    	           	
		       }
		});
	}
	
	
}
