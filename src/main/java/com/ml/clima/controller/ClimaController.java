package com.ml.clima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "/")
public class ClimaController {
	
	@GetMapping(value = "/")
	public String index() {
		return "index.html";
		
	}
}
