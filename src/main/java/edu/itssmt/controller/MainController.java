package edu.itssmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.itssmt.model.credenciales.UserAccountInfo;
import edu.itssmt.service.IMainService;




@Controller
public class MainController {
	
	@Autowired
	UserAccountInfo userContext;
	
	@Autowired 
	IMainService mainService;
	
	

	@GetMapping("/")
	public String home1(Model model) {
		

		String page="home";
		if(userContext.isAuthenticated()){
			model.addAttribute("user",userContext.getUserCredentials());
			model.addAttribute("content","dommenu");
			page="menu";
		}
		
		model.addAttribute(page, true);
		
		return page;
	}

	@GetMapping("/home")
	public String home(Model model) {
		
		String page="home";
		if(userContext.isAuthenticated()){
			model.addAttribute("user", userContext.getUserCredentials());
			model.addAttribute("content","dommenu");
			page="menu";
		}
		model.addAttribute(page, true);
		
		return page;
	}
	

	
	
	
	
	@GetMapping("/menu")
	public String menu(Model model,@RequestParam(value="content",required=false)String content) {
		
		model.addAttribute("user", userContext.getUserCredentials());
		if(!userContext.isAuthenticated()){
			model.addAttribute("home", true);
			return "home";
		}
		
		String page="menu";
		
		
		if(content==null){
			
			model.addAttribute("content","dommenu");
			model.addAttribute("home", true);
			return page;
		}
		
		model = mainService.execute(model, content);
		
		
		return page;
	}

	

	

	
	
	


}
