package com.ml.clima.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.ml.clima.dto.ResponseDTO;
import com.ml.clima.service.ClimaService;

@RestController
public class ClimaRestController {

	@Autowired
	private ClimaService service;
	
	@GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDTO index() {
		return getService().calcularClima();
	}

	@GetMapping(value = "/clima", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getClimaPorDia(@RequestParam("dia") Integer dia) {
		return getService().calcularClimaPorDia(dia);
	}
	
	public ClimaService getService() {
		return service;
	}

	public void setService(ClimaService service) {
		this.service = service;
	}
	
}
