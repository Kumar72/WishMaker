package entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="wish")
public class Wish {

//	Fields (total: 3  	FK: 1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String item;
	private String description;
	private double price;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
//	@Column(name="wish_date")
//	private Date date;
	@Column(name="complete")
	private boolean done;
	private String note;

	public Wish() {
		
	}
	public Wish(String item, String description, double price, User user) {
		super();
		this.item = item;
		this.description = description;
		this.price = price;
		this.user = user;
	}
	
//	Getters and Setters (DNI setter for Id)
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}	
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Wish [item=");
		builder.append(item);
		builder.append(", description=");
		builder.append(description);
		builder.append(", price=");
		builder.append(price);
//		builder.append(", user=");
//		builder.append(user);
		builder.append(", done=");
		builder.append(done);
		builder.append(", note=");
		builder.append(note);
		builder.append("]");
		return builder.toString();
	}	
}
