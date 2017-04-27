package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="user")
public class User {
	
//Fields (total: 3  	FK: 1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name="user_name")
	private String userName;
	private String password;
	private Boolean status;
	
	@JsonManagedReference
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Wish> wishes;
	
	
//	ctor
	public User() {
		
	}
	public User(String name, String userName, String password, Boolean status, List<Wish> wishes) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.wishes = wishes;
	}
	
//	Getters and Setters (DNI setter for id)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public List<Wish> getWishes() {
		return wishes;
	}
	public void setWishes(List<Wish> wishes) {
		this.wishes = wishes;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [name=");
		builder.append(name);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", status=");
		builder.append(status);
//		builder.append(", wishes=");
//		builder.append(wishes);
		builder.append("]");
		return builder.toString();
	}
	
}
