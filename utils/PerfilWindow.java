package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import dominio.User;
import logica.Sistema;

import java.awt.Dimension;
import java.awt.Font;

public class PerfilWindow {
	
	Sistema sistema;
	
	User user;
	JFrame frame;
	
	public PerfilWindow(Sistema sistema, User user) {
		this.sistema = sistema;
		this.user = user;
		
		frame = new JFrame("Ventas Coquimbo");
		frame.setSize(557, 420);
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
	
		// texto: Bienvenido
		JLabel userLabel = new JLabel("Bienvenido "+user.getUsername());
		userLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		userLabel.setBounds(26, 10, 130, 25);
		panel.add(userLabel);
		
		// texto: Lista de productos didsponibles
		JLabel productsLabel = new JLabel("Lista de productos disponibles");
		productsLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		productsLabel.setBounds(36, 44, 176, 25);
		panel.add(productsLabel);
		
		// Category dropdown
		String[] categories = {"Todo","Juegos","Hogar","Electrodomestico", "Autos", "SAS"};
		
		JComboBox<Object> category = new JComboBox<Object>(categories);
		category.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		// Tabla
		String[] columnNames = new String[] {"ID", "Nombre", "Categoria", "Fecha", "Visto"};
		/*Object[][] data = new Object[][] {
								{"1","Ñuñuki sport ñ3","Autos","04/04/2222","No"},
								{"2","Amogus 3D Mod 1.7","Juegos","01/03/2222","No"},
								{"3","ps4","Juegos","14/10/2018","Si"},
								{"4","pc gamer","Juegos","12/12/2018","No"},
								{"5","silla","Hogar","05/12/2018","No"},
								{"6","labadora","Electrodomestico","08/11/2018","Si"},
								};
		*/						
		Object[][] data = sistema.getProductData((String) category.getSelectedItem());						
								
		JTable table = new JTable(data, columnNames);
		table.getTableHeader().setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		table.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setPreferredScrollableViewportSize(new Dimension(200,30));
		table.setFillsViewportHeight(true);
								
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		scrollPane.setBounds(25, 80, 493, 200);
		panel.add(scrollPane);
		
		
		//Crear Botones+filtro
		JButton sellBtn = new JButton("vender producto");
		sellBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton infoBtn = new JButton("Info producto");
		infoBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JButton filterBtn = new JButton("Filtrar");
		filterBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		JButton myPostsBtn = new JButton("Mis publicaciones");
		myPostsBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		JButton myShopsBtn = new JButton("Mis compras");
		myShopsBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		//Posicionar Botones
		sellBtn.setBounds(26, 291, 160, 25);
		infoBtn.setBounds(236, 291, 136, 25);
		category.setBounds(438,291,80,25);
		filterBtn.setBounds(438, 327, 80, 25);
		myPostsBtn.setBounds(26, 327, 160, 25);
		myShopsBtn.setBounds(236, 327, 136, 25);
		
		//Añadir acciones a los Botones+filtro
		sellBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				@SuppressWarnings("unused")
				SellWindow sellWindow = new SellWindow(sistema, user);
			}
		});
		
		category.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				category.getSelectedItem();
				System.out.println(category.getSelectedItem());
				Object[][] data = sistema.getProductData((String) category.getSelectedItem());
				
				//Borrar la tabla
				for(int i=0; i<table.getRowCount();i++) {
					for(int j=0;j<5;j++) {
						table.setValueAt("", i, j);
					}
				}
				
				//Escribir los datos
				System.out.println(data.length);
				for(int i=0; i<data.length;i++) {
					for(int j=0;j<5;j++) {
						table.setValueAt(data[i][j], i, j);
					}	
				}
				
			}
		});
		
		//Añadir los elementos al panel
		panel.add(sellBtn);
		panel.add(infoBtn);
		panel.add(category);
		panel.add(filterBtn);
		panel.add(myPostsBtn);
		panel.add(myShopsBtn);
	}
	
}
