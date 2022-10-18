package com.marcionascimento.projetoback.entidades.enums;

public enum Situacao {

	ATIVA(1),
	SUSPENSA(2),
	CANCELADA(3);
	
	private int code;
	
	private Situacao(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Situacao valueOf(int code) {
		for (Situacao value : Situacao.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Situacao code");
	}
}
