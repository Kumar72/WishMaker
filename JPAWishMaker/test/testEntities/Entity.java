package testEntities;
import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.User;
import entities.Wish;

public class Entity {

	@Test		//Basic test
	public void test() {
		boolean pass = true;
		assertEquals(pass, true);
	}
//--------------------------------------------------------------/

	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private User user;
	private Wish wish;
	
	@Before
	  public void setUp() throws Exception { 
		 emf = Persistence.createEntityManagerFactory("Persist");
		 em = emf.createEntityManager();
		 user = em.find(User.class, 1);
		 wish = em.find(Wish.class, 3);
	 }
	 @After
	  public void tearDown() throws Exception { 
		 em.close();
		 emf.close();	 
	 }
	 
	 @Test
	 public void test_user_mapping() {
		assertEquals("Chandan Thakur", user.getName());
	 }
	 
	 @Test
	 public void test_wish_mapping() {
		 assertEquals("Father", wish.getUser().getName());
	 }	
}
