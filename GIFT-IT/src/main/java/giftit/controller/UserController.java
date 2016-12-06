package giftit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



import giftit.model.User;
import giftit.service.UserServDao;



@Controller
public class UserController {
	@Autowired
	UserServDao udi;
	@RequestMapping("/Insert")
	public ModelAndView InsertMap()
	{
		
		User u = new User();
		u.setFname("Aparna");
		u.setLname("a");
		u.setEmail("aparna@gmail.com");
		u.setPassword("xxx");
		u.setAddress1("6/29 bk street");
		u.setAddress2("sri venkatesh nagar virugambakkam");
		u.setCity("chennai");
		u.setCountry("India");
		u.setState("Tamilnadu");
		u.setZip("600092");
		u.setPhone("8939359631");

		udi.addUser(u);
		
		ModelAndView mv=new ModelAndView();
		
		
		mv.addObject("hello");
		return mv;
	}
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", udi.listUsers());
		return "user";
	}
	@RequestMapping(value="/user/add",method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user")User u){
		if(u.getId()==0){
			udi.addUser(u);
		}
		
		return "redirect:/users";
		
	}
}
