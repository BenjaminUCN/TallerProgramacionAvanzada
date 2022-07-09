package dominio;
import java.util.ArrayList;
import java.util.List;

public class User{
    private String username;
    private String name;
    private String email;
    private String contact;
    private String password;
    
    private int cantidadVentas;
    
    //lista de productos publicados
    private List<Product> posts;
    //lista de productos comprados
    private List<Product> compras;
    
	public User(String username, String name, String email, String contact, String password) {
		super();
		this.username = username;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.password = password;
		
		this.cantidadVentas = 0;
		posts = new ArrayList<Product>();
		compras = new ArrayList<Product>();
	}
	
	public void addPost(Product p) {
		posts.add(p);
	}
	
	public void addCompra(Product p) {
		compras.add(p);
		
	}
	
	public void addVenta(Product p) {
		p.setSold(true);
		cantidadVentas++;
	}
	
	public int getVentas() {
		return cantidadVentas;
	}
	
	public List<Product> getCompras() {
		return compras;
	}

	public void setCompras(List<Product> compras) {
		this.compras = compras;
	}

	public List<Product> getPosts() {
		return posts;
	}

	public void setPosts(List<Product> posts) {
		this.posts = posts;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		System.out.println(name);
		return name;
		
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		System.out.println("email: "+email);
		return email;
	}

	public void setEmail(String email) {
		System.out.println("email: cambió");
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Object[][] getUserPosts() {
		ArrayList<Object[]> post = new ArrayList<>();
		
		for(Product p : posts) {
			post.add(p.getData("forUser"));
		}
		
		Object[][] data;
		data = new Object[post.size()][5];
		
		
		for(int i=0;i<data.length;i++) {
			data[i] = post.get(i);
		}
		
		return data;
	}
	
	public Object[][] getUserPurchases() {
		ArrayList<Object[]> post = new ArrayList<>();
		
		for(Product p : compras) {
			post.add(p.getData("forConsumer"));
		}
		
		Object[][] data;
		data = new Object[post.size()][5];
		
		
		for(int i=0;i<data.length;i++) {
			data[i] = post.get(i);
		}
		
		return data;
	}
	
	public int getPostCount() {
		return posts.size();
	}
	
    public int getPurchaseCount() {
    	return compras.size();
    }

}