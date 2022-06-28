package logica;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;

import dominio.Product;
import dominio.User;


public class SistemaImpl implements Sistema {

    private ArrayList<User> users;
    private ArrayList<Product> products;

    int idCounter;
    
    public SistemaImpl(){
        users = new ArrayList<>();
        products = new ArrayList<>();
        
        idCounter = 1;
    }

	@Override
	public boolean login(String user, String pasword) {
		for(User u : users) {
			if(u.getUsername().equals(user) && u.getPassword().equals(pasword)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean sigin(String username, String name, String email, String contact, String password) {
		// si no está registrado
		if(true) {
			User newUser = new User(username, name, email, contact, password);
			users.add(newUser);
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
	public void addProductToShop(String name, String category, int price, String description, String imagePath,
			User sellerUser) {
		
		Product newProduct = new Product(idCounter, name, category, price, description, imagePath, sellerUser);
		products.add(newProduct);
		
		idCounter++;
	}

	@Override
	public Object[][] getProductData(String filter) {
		//Lista con productos filtrados
		ArrayList<Object[]> filteredProducts = new ArrayList<>();
		
		for(Product p : products) {
			if(p.getCategory().equals(filter) || filter.equals("Todo")) {
				filteredProducts.add(p.getData());
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

}
