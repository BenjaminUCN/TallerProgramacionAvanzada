package dominio;
import java.util.ArrayList;

public class User{
    private String username;
    private String name;
    private String email;
    private String contact;
    private String password;
    
    //lista de productos publicados
    //lista de productos comprados
    
	public User(String username, String name, String email, String contact, String password) {
		super();
		this.username = username;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
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

    

    

}