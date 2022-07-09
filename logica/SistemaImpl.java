package logica;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import dominio.Product;
import dominio.User;
import utils.Window;


public class SistemaImpl implements Sistema {

    private ArrayList<User> users;
    private ArrayList<Product> products;

    int idCounter;
    
    public SistemaImpl() throws FileNotFoundException{
        users = new ArrayList<>();
        products = new ArrayList<>();
        
        readUserRegistry(users);
        idCounter = 1;
    }
    
	@Override
	public void readUserRegistry(ArrayList<User> users) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("Users.txt"));
		while(scan.hasNextLine()) {
			String [] s = scan.nextLine().split(",");
			if(s.length>4) {
				String userName = s[0];
				String fullName = s[1];
				String mail = s[2];
				String contact = s[3];
				String password = s[4];
				User u = new User(userName,fullName,mail,contact,password);
				users.add(u);
			}
			
		}
	}
	
	@Override
	public boolean login(String user, String pasword) {
		for(User u : users) {
			if(u.getUsername().equals(user) && u.getPassword().equals(pasword)) {
				return true;
			}
		}
		JOptionPane.showMessageDialog(null, "Usuario no encontrado! Por favor, intentelo de nuevo.");
		return false;
	}

	@Override
	public boolean sigin(String username, String name, String email, String contact, String password) throws IOException {
		// si no está registrado
		if(true) {
			User newUser = new User(username, name, email, contact, password);
			users.add(newUser);
			saveChanges(users);
			return true;
		}
		return false;
	}
	
	@Override
	public User getUserByName(String username) {
		for(User u : users) {
			if(u.getUsername().equals(username)) {
				return u;
			}	
		}
		return null;
	}
	
	@Override
	public Product getProductById(int id) {
		for(Product p : products) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	@Override
	public Product getProductByName(String name) {
		for(Product p : products) {
			if(p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}
	
	@Override
	public void addProductToShop(String name, String category, int price, String description, String imagePath,
			User sellerUser) {
		
		Product newProduct = new Product(idCounter, name, category, price, description, imagePath, sellerUser);
		products.add(newProduct);
		sellerUser.addPost(newProduct);
		System.out.println(sellerUser.getPosts().get(0).getName());
		
		idCounter++;
	}

	@Override
	public Object[][] getProductData(String filter) {
		//Lista con productos filtrados
		ArrayList<Object[]> filteredProducts = new ArrayList<>();
		
		for(Product p : products) {
			if(p.getCategory().equals(filter) || filter.equals("Todo")) {
				filteredProducts.add(p.getData(""));
			}
		}
		
		//Array con productos filtrados
		Object[][] data;
		data = new Object[filteredProducts.size()][5];
		
		for(int i=0;i<data.length;i++) {
			data[i] = filteredProducts.get(i);
		}
		
		return data;
	}
	
	public Object[][] getUserPosts(User user) {
		ArrayList<Object[]> post = new ArrayList<>();
		
		for(Product p : products) {
			post.add(p.getData("forUser"));
		}
		
		Object[][] data;
		data = new Object[post.size()][5];
		
		
		for(int i=0;i<data.length;i++) {
			data[i] = post.get(i);
		}
		
		return data;
	}
	
	public Object[][] getUserPurchases(User user) {
		ArrayList<Object[]> post = new ArrayList<>();
		
		for(Product p : products) {
			post.add(p.getData("forUser"));
		}
		
		Object[][] data;
		data = new Object[post.size()][5];
		
		
		for(int i=0;i<data.length;i++) {
			data[i] = post.get(i);
		}
		
		return data;
	}
		
	
	/**
	 * escala la imagen, solo funciona con labels cuadrados por ahora
	 * @param path directorio de la imagen 
	 * @param width ancho del label
	 * @param height alto del label
	 * @return imagen (ImageIcon) escalada para el label
	 */
	@Override
	public ImageIcon scaleImage(String path, int width, int height) {
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

	@Override
	public void saveChanges(ArrayList<User> users) throws IOException {
		FileWriter escribirTxt = new FileWriter("Users.txt");
		int cont = 0;
		for (User user : users) {
			String linea = user.getUsername()+","+user.getName()+","+user.getEmail()+","+user.getContact()+","+user.getPassword();
			
			if(cont!=0) {
				escribirTxt.write("\n");
			}
			escribirTxt.write(linea);
			cont++;
		}
		escribirTxt.close();
	}

	@Override
	public void editProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(Product product) {
		products.remove(product);
	}
}
