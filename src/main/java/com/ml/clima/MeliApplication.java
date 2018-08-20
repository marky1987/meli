package com.ml.clima;

import com.ml.clima.service.ICalculadorDeClima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class MeliApplication implements ApplicationListener<ApplicationReadyEvent>{

	@Autowired
	private ICalculadorDeClima calculador;

	public static void main(String[] args) {
		SpringApplication.run(MeliApplication.class, args);
	}

	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		this.getCalculador().predecirClimaEnProximosDiezAnios();
		System.out.println("Termino de persistir. Check la base");
		return;
	}

	public ICalculadorDeClima getCalculador() {
		return calculador;
	}

	public void setCalculador(ICalculadorDeClima calculador) {
		this.calculador = calculador;
	}
}
