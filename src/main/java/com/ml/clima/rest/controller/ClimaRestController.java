package com.ml.clima.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.ml.clima.dto.ResponseDTO;
import com.ml.clima.service.ClimaService;

import java.util.HashMap;

@RestController
public class ClimaRestController {

	@Autowired
	private ClimaService service;
	
	@GetMapping(value = "/v1/info", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDTO index() {
		return getService().calcularClima();
	}

	@GetMapping(value = "/v1/clima", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClimaPorDiaDTO getClimaPorDia(@RequestParam("dia") Integer dia) {
		ClimaPorDiaDTO dto = new ClimaPorDiaDTO();
		dto.setDia(dia);
		dto.setClima(getService().calcularClimaPorDia(dia));
		return dto;
	}
	
	public ClimaService getService() {
		return service;
	}

	public void setService(ClimaService service) {
		this.service = service;
	}
	
}
