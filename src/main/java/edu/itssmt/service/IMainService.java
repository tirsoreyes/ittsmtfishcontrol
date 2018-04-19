package edu.itssmt.service;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;


@Component
public interface IMainService {

	public Model execute(Model model, String content);

	

	
	
}
