/**
 * 
 */
package com.boot.test.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author sunil.yadav
 *
 */
@Controller
public class HomeController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value= {"/", "/home"}, method=RequestMethod.GET)
	public ModelAndView getHomePage() {
		User user = new User();
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("name", "application property for home");
		modelAndView.addObject("name2", "sunil");
		modelAndView.addObject("user", user);
		List<User> users = userDao.getusers();
		modelAndView.addObject("users", users);
		return modelAndView;
	}
	
	@RequestMapping(value= {"/action"}, method=RequestMethod.POST)
	public String action(@ModelAttribute(value="user") User user) {
		System.out.println("USER :: " + user);
		String successPage = "home";
		User response = userDao.createUser(user);
		if(response==null)
			successPage = "error";
		return "redirect:"+successPage;
	}
	
	@RequestMapping(value= {"/update"}, method=RequestMethod.POST)
	public String update(@ModelAttribute(value="user") User user) {
		System.out.println("USER :: " + user);
		String successPage = "home";
		User response = userDao.updateUser(user);
		if(response==null)
			successPage = "error";
		return "redirect:"+successPage;
	}
	
	@RequestMapping(value= {"/update-user/{id}"}, method=RequestMethod.GET)
	public ModelAndView updateUser(@PathVariable(value="id") String id) {
		User user = new User();
		ModelAndView modelAndView = new ModelAndView("update");
		System.out.println("USER :: " + id);
		user = userDao.getUser(id);
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping(value= {"/delete-user/{id}"}, method=RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable(value="id") String id) {
		System.out.println("USER :: " + id);
		userDao.deleteUser(id);;
		ModelAndView modelAndView = new ModelAndView("home");
		User user = new User();
		modelAndView .addObject("user", user );
		List<User> users = userDao.getusers();
		modelAndView.addObject("users", users);
		return modelAndView;
	}
}
