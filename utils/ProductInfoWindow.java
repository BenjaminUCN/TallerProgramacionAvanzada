package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dominio.Product;
import logica.Sistema;
import javax.swing.SwingConstants;

public class ProductInfoWindow {
	
	Sistema sistema;
	WindowManager windowManager;
	
	Product product;
	
	JFrame frame;
	
	public ProductInfoWindow(Sistema sistema, WindowManager windowManager, Product product) {
		this.sistema = sistema;
		this.windowManager = windowManager;
		
		this.product = product;
		this.product.setSeen(true);
		
		//Setup window
		frame = new JFrame("Ventas Coquimbo - ");
		frame.setSize(557, 357);
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
		
		// texto: Nombre producto
		JLabel productNameLabel = new JLabel(product.getName());
		productNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		productNameLabel.setBounds(211, 26, 296, 25);
		productNameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		panel.add(productNameLabel);
		
		// texto: Precio producto
		JLabel productPriceLabel = new JLabel("$"+String.valueOf(product.getPrice()));
		productPriceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		productPriceLabel.setBounds(211, 62, 239, 25);
		productPriceLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		panel.add(productPriceLabel);
		
		// texto: Descripción producto
		JLabel descriptionLabel = new JLabel(product.getDescription());
		descriptionLabel.setVerticalAlignment(SwingConstants.TOP);
		descriptionLabel.setBounds(211, 107, 320, 118);
		descriptionLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(descriptionLabel);
		
		// texto: Nombre del vendedor
		JLabel sellerNameLabel = new JLabel("Vendedor: "+product.getSellerUser().getUsername());
		sellerNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		sellerNameLabel.setBounds(20, 213, 160, 25);
		sellerNameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(sellerNameLabel);
		
		// texto: email del vendedor
		JLabel emailLabel = new JLabel("Email "+product.getSellerUser().getEmail());
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		emailLabel.setBounds(20, 247, 147, 25);
		emailLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(emailLabel);
		
		// texto: contacto del vendedor
		JLabel contactLabel = new JLabel("Contacto "+product.getSellerUser().getContact());
		contactLabel.setHorizontalAlignment(SwingConstants.LEFT);
		contactLabel.setBounds(177, 247, 160, 25);
		contactLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(contactLabel);
		
		// Label con ImageIcon: Foto				
		JLabel photoLabel = new JLabel();
		photoLabel.setOpaque(true);
		//photoLabel.setBackground(Color.cyan);
		photoLabel.setBounds(20, 11, 190, 190);
		photoLabel.setIcon(sistema.scaleImage(product.getImagePath(), photoLabel.getWidth(), photoLabel.getHeight()));
		photoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(photoLabel);
		
		// Botón: Comprar
		JButton buyBtn = new JButton("Comprar");
		buyBtn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		buyBtn.setBounds(347, 247, 160, 25);
				
		buyBtn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Product p = windowManager.getProduct();
				
				windowManager.getUser().addCompra(p);
				p.getSellerUser().addVenta(p);
			}
		});
				
		panel.add(buyBtn);
		
		// Botón: Volver
		JButton backBtn = new JButton("Volver");
		backBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		backBtn.setBounds(347, 282, 160, 25);
		
		backBtn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
				windowManager.setProduct(null);
				windowManager.changeWindow("back");
			}
		});
		
		panel.add(backBtn);
		
		
	}
}
