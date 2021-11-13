package com.example.demo.controller;

import java.util.List;

import org.springframework.ui.Model;

import com.example.demo.modelo.Encriptar;

public class Controller {
	
	@GethMapping("/encrypt")
	public String Encrip(Model model){
		List<encriptacion>Encriptar=service.Encrip();
		model.addAttribute("encriptar",Encriptar);
		return "index";
		
	}
	
	@GethMapping("//decrypt")
	public String Encrip(Model model){
		List<encriptacion>Encriptar=service.Encrip();
		model.addAttribute("encriptar",Encriptar);
		return "index";
		
	}

}

