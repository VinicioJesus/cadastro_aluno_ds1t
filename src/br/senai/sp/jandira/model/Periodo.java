package br.senai.sp.jandira.model;

public enum Periodo {
	
	MANHA("Horário da Manhã"),
	TARDE("Horário da Tarde"), 
	NOITE("Horário da Noite"), 
	SABADO("Horário Sábado"),
	ONLINE("Curso EAD");
	
	private String descricao;
	
	private Periodo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	

}
