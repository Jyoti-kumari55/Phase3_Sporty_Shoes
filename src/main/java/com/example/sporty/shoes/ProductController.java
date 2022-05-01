package com.example.sporty.shoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

		@Autowired
		private ProductServices service; 
		
		@RequestMapping("/")
		public String viewHomePage(Model model) {
			List<Product> listShoes = service.listAll();
			model.addAttribute("listShoes", listShoes);
			
			return "detail";
		}
		
		@RequestMapping("/new")
		public String showNewShoesPage(Model model) {
			Product shoe = new Product();
			model.addAttribute("shoes", shoe);
			
			return "newProduct";
		}
		
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String saveShoe(@ModelAttribute("shoes") Product product) {
			service.save(product);
			
			return "redirect:/";
		}
		
		@RequestMapping("/edit/{id}")
		public ModelAndView showEditShoesPage(@PathVariable(name = "id") int id) {
			ModelAndView mav = new ModelAndView("editProduct");
			Product product = service.get(id);
			mav.addObject("product", product);
			
			return mav;
		}
		
		@RequestMapping("/delete/{id}")
		public String deleteShoe(@PathVariable(name = "id") int id) {
			service.delete(id);
			return "redirect:/";		
		}
	}

