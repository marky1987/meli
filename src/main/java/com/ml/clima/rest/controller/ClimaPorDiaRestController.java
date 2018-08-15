package com.ml.clima.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ml.clima.dto.ResponseDTO;
import com.ml.clima.service.ClimaService;

@RestController
public class ClimaPorDiaRestController {

	@Autowired
	private ClimaService service;
	
	
	public ClimaService getService() {
		return service;
	}

	public void setService(ClimaService service) {
		this.service = service;
	}
}
