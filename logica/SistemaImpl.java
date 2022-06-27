package logica;
import java.util.ArrayList;
import java.util.Iterator;

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
	public String login(String user, String pasword) {
		for(User u : users) {
			if(u.getUsername().equals(user) && u.getPassword().equals(pasword)) {
				return "0";
			}
			//no encontrado
			if(u.getUsername().equals(null)) {
				return "1";
			}
		}
		return "2";
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

}
