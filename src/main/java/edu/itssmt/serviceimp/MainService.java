package edu.itssmt.serviceimp;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.itssmt.service.IMainService;

@Service
public class MainService implements IMainService {

	@Override
	public Model execute(Model model, String content) {
		
		model.addAttribute("content",content);
		model.addAttribute("menu", true);
		
		
		return model;
	}

}
