package com.ml.clima;

import com.ml.clima.service.ICalculadorDeClima;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeliApplicationTests {

	@Autowired
	private ICalculadorDeClima calculadorDeClima;

	@Test
	public void contextLoads() {
	}

	public ICalculadorDeClima getCalculadorDeClima() {
		return calculadorDeClima;
	}

	public void setCalculadorDeClima(ICalculadorDeClima calculadorDeClima) {
		this.calculadorDeClima = calculadorDeClima;
	}
}
