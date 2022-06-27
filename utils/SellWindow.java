package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dominio.User;
import logica.Sistema;

//public class SellWindow extends Window{
public class SellWindow{
	
	Sistema sistema;
	
	User sellerUser;
	String imagePath;
	
	JFrame frame;
	
	public SellWindow(Sistema sistema, User sellerUser) {
		//super("publicar producto", 420, 420);
		this.sistema = sistema;
		this.sellerUser = sellerUser;
		imagePath = "no-uimage.png";
		
		frame = new JFrame("Ventas Coquimbo - ");
		frame.setSize(557, 345);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		
		frame.setVisible(true);
		
		
	}
	
	//@Override
	protected void placeComponents(JPanel panel) {
		panel.setLayout(null);
		
		//@SuppressWarnings("unused")
		//JTextField usernameText = CreateInput("Nombre de usuario", panel, 70, 10);
		
		// texto: Nombre producto
		JLabel productNameLabel = new JLabel("Nombre");
		productNameLabel.setBounds(10, 10, 160, 25);
		productNameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(productNameLabel);
								
		// entrada de texto: Nombre producto
		JTextField productNameTextField = new JTextField(20);
		productNameTextField.setBounds(10,35,160,25);
		productNameTextField.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(productNameTextField);
		
		// texto: Precio producto
		JLabel productPriceLabel = new JLabel("Precio");
		productPriceLabel.setBounds(10, 60, 160, 25);
		productPriceLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(productPriceLabel);
										
		// entrada de texto: Precio producto
		JTextField productPriceTextField = new JTextField(20);
		productPriceTextField.setBounds(10,85,160,25);
		productPriceTextField.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(productPriceTextField);
		
		// texto: Descripción producto
		JLabel descriptionLabel = new JLabel("Descripción");
		descriptionLabel.setBounds(10, 110, 160, 25);
		descriptionLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(descriptionLabel);
												
		// entrada de texto: Descripción producto
		JTextField descriptionTextField = new JTextField(20);
		descriptionTextField.setBounds(10,135,320,124);
		descriptionTextField.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(descriptionTextField);
		
		
		// texto: Descripción producto
		JLabel categoryLabel = new JLabel("Categoría");
		categoryLabel.setBounds(180, 10, 160, 25);
		categoryLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(categoryLabel);
		
		// dropdown: categoría
		String[] categories = {"Todo","Juegos","Hogar","Electrodomestico", "Autos", "SAS"};
		JComboBox<Object> category = new JComboBox<Object>(categories);
		category.setBounds(180,35,80,25);
		
		category.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				category.getSelectedItem();
				System.out.println(category.getSelectedIndex());
			}
		});
		
		panel.add(category);
		
		// Botón: Registrar/Editar publicación
		JButton sendPostBtn = new JButton("Registrar/Editar publicación");
		sendPostBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		sendPostBtn.setBounds(30, 270, 210, 25);
		
		sendPostBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = productNameTextField.getText();
				String categoryStr = (String) category.getSelectedItem();
				int price = Integer.parseInt(productPriceTextField.getText());
				String description = descriptionTextField.getText();
				
				
				sistema.addProductToShop(name, categoryStr, price, description, imagePath, sellerUser);
				
				frame.dispose();
	        	@SuppressWarnings("unused")
				PerfilWindow perfilWindow = new PerfilWindow(sistema, sellerUser);
			}
		});
		
		panel.add(sendPostBtn);
		
		
		// Label con ImageIcon: Foto				
		JLabel photoLabel = new JLabel();
		photoLabel.setOpaque(true);
		//photoLabel.setBackground(Color.cyan);
		photoLabel.setBounds(340, 10, 190, 190);
		photoLabel.setIcon(scaleImage(imagePath, photoLabel.getWidth(), photoLabel.getHeight()));
		photoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(photoLabel);
		
		// Botón: Subir Foto
		JButton uploadPhotoBtn = new JButton("Subir Foto");
		uploadPhotoBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		uploadPhotoBtn.setBounds(300, 270, 160, 25);
		
		uploadPhotoBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				int response = fileChooser.showOpenDialog(null);
				
				if(response == JFileChooser.APPROVE_OPTION) {
					imagePath = fileChooser.getSelectedFile().getAbsolutePath();
					photoLabel.setIcon(scaleImage(imagePath, photoLabel.getWidth(), photoLabel.getHeight()));
				}
			}
		});
		
		panel.add(uploadPhotoBtn);
		
		
	}
	
	/**
	 * escala la imagen, solo funciona con labels cuadrados por ahora
	 * @param path directorio de la imagen 
	 * @param width ancho del label
	 * @param height alto del label
	 * @return imagen (ImageIcon) escalada para el label
	 */
	private ImageIcon scaleImage(String path, int width, int height) {
		ImageIcon image = new ImageIcon(path);
		/*Intento de algorithmo para labels no cuadradas
		double originalRatio = image.getIconWidth()/image.getIconHeight();
		double newRatio = width/height;
		
		if(originalRatio > 1 && newRatio >1) {
			
		}*/
		
		int size = width;//width = 190
		
		double scaleFactor = ((double) size)/Math.max(image.getIconWidth(), image.getIconHeight());
		int scaledWidth = (int) Math.round(scaleFactor*image.getIconWidth());
		int scaledHeight = (int) Math.round(scaleFactor*image.getIconHeight());
		ImageIcon scaledImage = new ImageIcon(image.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH));
		
		return scaledImage;
	}
}
