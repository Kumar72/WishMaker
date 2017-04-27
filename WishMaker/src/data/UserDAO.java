package data;

import java.util.List;

import entities.User;
import entities.Wish;

public interface UserDAO {
	public List<User> index();
	public User show(int id);
	public User create(User user);
	public User update(int id, User user);
	public boolean destroy(int id);
	
	public List<Wish> showWish(int id);
	public Wish createWish(int id, Wish d);
	public Wish updateWish(int id, int dId, Wish detail);
	public boolean destroyWish(int id, int detailId);

}
