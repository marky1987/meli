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
public class ClimaRestController {

	@Autowired
	private ClimaService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDTO hello(@RequestParam("anio") Integer anio) {
		return getService().calcularClima(anio);
	}

	@RequestMapping(value = "/clima", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
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
