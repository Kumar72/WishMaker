package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.User;
import entities.Wish;

@Transactional
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;
	
	//DONE
	@Override
	public List<User> index() {
		String query = "SELECT u FROM User u";
		return em.createQuery(query, User.class).getResultList();
	}
	
	//DONE
	@Override
	public User show(int id) {
		return em.find(User.class, id);
	}

	//DONE
	@Override
	public User create(User user) {
		em.persist(user);
		em.flush();
		return user;
	}
	
	//DONE
	@Override
	public User update(int id, User user) {
		User u = em.find(User.class, id);
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		u.setUserName(user.getUserName());
		u.setStatus(user.getStatus());
		return u;
	}
	
	//DONE
	@Override
	public boolean destroy(int id) {
		User user = em.find(User.class, id);
		em.remove(user);
		return !em.contains(user);
	}
	
	//---------------- USER WISHES-------------------//
	

	//DONE
	@Override
	public List<Wish> showWish(int id) {
		String query = "SELECT u FROM User u JOIN FETCH u.wishes WHERE u.id= :id";
		User user = em.createQuery(query, User.class)
				.setParameter("id", id)
				.getSingleResult();
		List<Wish> wishList = user.getWishes();
		return  wishList;
	}
	
	//DONE
	@Override
	public Wish createWish(int id, Wish wish) {
		User user = em.find(User.class, id);
		wish.setUser(user);
		em.persist(wish);
		em.flush();
		return wish;
	}

	//DONE
	@Override
	public Wish updateWish(int id, int wishId, Wish wish) {
		Wish w = em.find(Wish.class, wishId);
		w.setItem(wish.getItem());
		w.setDescription(wish.getDescription());
		w.setPrice(wish.getPrice());
		w.setNote(wish.getNote());
		w.setDone(wish.isDone());
		return w;
	}

	//DONE
	@Override
	public boolean destroyWish(int id, int wishId) {
		String query = "SELECT w FROM Wish w WHERE w.id= :id";
		Wish wish = em.createQuery(query, Wish.class)
				.setParameter("id", wishId).getSingleResult();
//		Wish wish = em.find(Wish.class, wishId);
		em.remove(wish);
		em.flush();
		return !em.contains(wish);
	}

}
