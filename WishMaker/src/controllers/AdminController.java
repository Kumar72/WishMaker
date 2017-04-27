package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.UserDAO;
import entities.User;
import entities.Wish;

@RestController
public class AdminController {

	@Autowired
	private UserDAO uDao;
	
	@RequestMapping(value="ping", method=RequestMethod.GET)
	public String ping() {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$ IN PING METHOD OF CONTROLLER $$$$$$$$$$$$$$$$$$$$$$$$$");
		return "pong";
	}
	
	//DONE -- GET
	@RequestMapping(value="users", method=RequestMethod.GET)
	List<User> index(){
		List<User> users = uDao.index();
		return users;
	}
	
	//DONE -- GET by ID
	@RequestMapping(value="users/{userId}", method=RequestMethod.GET)
	public User show(@PathVariable int userId) {
		return uDao.show(userId);
	}
	
	//DONE -- CREATE
	@RequestMapping(value="users", method=RequestMethod.POST)
	public User create(@RequestBody String jsonUser, HttpServletResponse res) {
		res.setStatus(201);
		ObjectMapper om = new ObjectMapper();
		
		try {
			User mappedUser = om.readValue(jsonUser, User.class);
			return uDao.create(mappedUser);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//DONE -- UPDATE
	@RequestMapping(value="users/{userId}", method=RequestMethod.PUT)
	public User update(@PathVariable int userId,@RequestBody String jsonUser, HttpServletResponse res) {
		res.setStatus(202);
		ObjectMapper om = new ObjectMapper();
		try {
			User mappedUser = om.readValue(jsonUser, User.class);
			return uDao.update(userId, mappedUser);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//DONE -- DELETE
	@RequestMapping(value="users/{id}", method=RequestMethod.DELETE)
	public boolean destroy(@PathVariable int id){
		return uDao.destroy(id);
	}
	
	//------------------User Wishes----------------------------//
	
	//DONE -- WISH by User Id
	@RequestMapping(value="users/{id}/wishes", method=RequestMethod.GET)
	public List<Wish> showQuestions(@PathVariable int id){
		return uDao.showWish(id);
	}
	
	//DONE -- CREATE WISH
	@RequestMapping(value="users/{id}/wishes", method=RequestMethod.POST)
	public Wish createDetail(@PathVariable int id, @RequestBody String jsonWish, HttpServletResponse res) {
		res.setStatus(201);
		ObjectMapper om = new ObjectMapper();
		Wish mappedWish;
		try {
			System.out.println(id);
			mappedWish = om.readValue(jsonWish, Wish.class);
			return uDao.createWish(id, mappedWish);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//DONE -- UPDATE WISH
	@RequestMapping(value="users/{id}/wishes/{wId}", method=RequestMethod.PUT)
	public Wish updateDetail(@PathVariable int id, @PathVariable int wId, @RequestBody String jsonWish, HttpServletResponse res) {
		res.setStatus(202);
		ObjectMapper om = new ObjectMapper();
		Wish mappedWish;
		try {
			mappedWish = om.readValue(jsonWish, Wish.class);
			return uDao.updateWish(id, wId, mappedWish);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	//DONE
	@RequestMapping(value="users/{id}/wishes/{wId}", method=RequestMethod.DELETE)
	public boolean destroyWish(@PathVariable int id, @PathVariable int wId) {
		System.out.println(wId);
		return uDao.destroyWish(id, wId);
	}
	
}
