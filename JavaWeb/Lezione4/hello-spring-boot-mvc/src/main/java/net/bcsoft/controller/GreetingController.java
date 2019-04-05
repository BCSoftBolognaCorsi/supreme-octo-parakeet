package net.bcsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.bcsoft.service.MyFirstService;

@Controller
public class GreetingController {
	
	@Autowired
	MyFirstService service;

    @GetMapping({"/greeting"})
    public String greeting(@RequestParam(name="name", required=false) String name, Model model) {
        if(name == null)
        	name = service.getDefaultName();
    	model.addAttribute("name", name);
        return "greeting";
    }

}
