package giftit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import giftit.model.Product;
import giftit.model.User;
import giftit.service.ProductServDao;

@Controller
public class ProductController {
@Autowired
ProductServDao pdi;
@RequestMapping("/insertprod")
public ModelAndView insertMap(){
	Product p=new Product();
	pdi.addProduct(p);
	ModelAndView mv=new ModelAndView();
	
	
	mv.addObject("hello");
	return mv;
}
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listProducts", pdi.listProducts());
		return "product";
	}
	@RequestMapping(value="/product/add",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product p){
		if(p.getId()==0){
			pdi.addProduct(p);
		}
		
		return "redirect:/products";
		
	}
	@RequestMapping("/productform")
	public ModelAndView showform(){
		return new ModelAndView("productform","command",new Product());
		
		
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("product") Product product){  
        pdi.addProduct(product);  
        return new ModelAndView("redirect:/viewprod");//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewprod")  
    public ModelAndView viewemp(){  
        List<Product> list=pdi.listProducts();  
        return new ModelAndView("viewprod","list",list);  
    }  
}

