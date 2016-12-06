package giftit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mc {
	@RequestMapping("/toLogin")
	public ModelAndView loginpage(){
		return new ModelAndView("loginform");
	}
	@RequestMapping("/signup")
	public ModelAndView signup(){
		return new ModelAndView("signup");
	}
	@RequestMapping("/gfh")
	public ModelAndView gfh(){
		return new ModelAndView("gfh");
	}
	@RequestMapping("/gfhim")
	public ModelAndView gfhim(){
		return new ModelAndView("gfhim");
	}
	@RequestMapping("/hm")
	public ModelAndView hm(){
		return new ModelAndView("hm");
	}
}
