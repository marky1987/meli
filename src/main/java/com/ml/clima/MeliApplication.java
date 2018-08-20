package com.ml.clima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import com.ml.clima.service.CalculadorDeClima;

@SpringBootApplication
public class MeliApplication implements ApplicationListener<ApplicationReadyEvent>{

	@Autowired
	private CalculadorDeClima calculador;

	public static void main(String[] args) {
		SpringApplication.run(MeliApplication.class, args);
	}

	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		this.getCalculador().run();
		System.out.println("+++ Fin Deploy");
		return;
	}

	public CalculadorDeClima getCalculador() {
		return calculador;
	}

	public void setCalculador(CalculadorDeClima calculador) {
		this.calculador = calculador;
	}
}
