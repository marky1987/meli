package com.ml.clima.dto;

public class ResponseDTO {

	private Integer cantidadPeriodoSequia;
	
	private Integer cantidadPeriodoLluvia;
	
	private Integer diaPicoMaxLluvia;
	
	private Integer periodoCondicionesOptimaYPresion;

	
	public Integer getCantidadPeriodoSequia() {
		return cantidadPeriodoSequia;
	}

	public void setCantidadPeriodoSequia(Integer cantidadPeriodoSequia) {
		this.cantidadPeriodoSequia = cantidadPeriodoSequia;
	}

	public Integer getCantidadPeriodoLluvia() {
		return cantidadPeriodoLluvia;
	}

	public void setCantidadPeriodoLluvia(Integer cantidadPeriodoLluvia) {
		this.cantidadPeriodoLluvia = cantidadPeriodoLluvia;
	}

	public Integer getDiaPicoMaxLluvia() {
		return diaPicoMaxLluvia;
	}

	public void setDiaPicoMaxLluvia(Integer diaPicoMaxLluvia) {
		this.diaPicoMaxLluvia = diaPicoMaxLluvia;
	}

	public Integer getPeriodoCondicionesOptimaYPresion() {
		return periodoCondicionesOptimaYPresion;
	}

	public void setPeriodoCondicionesOptimaYPresion(Integer periodoCondicionesOptimaYPresion) {
		this.periodoCondicionesOptimaYPresion = periodoCondicionesOptimaYPresion;
	}

		
}
