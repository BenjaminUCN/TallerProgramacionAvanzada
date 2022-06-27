package logica;

import dominio.User;

public interface Sistema {

	public boolean login(String user, String pasword);
	public boolean sigin(String username, String name, String email, String contact, String password);
	public User getUserByName(String username);
	public void addProductToShop(String name, String category, int price, String description, String imagePath, User sellerUser);
	public Object[][] getProductData(String filter);
}
