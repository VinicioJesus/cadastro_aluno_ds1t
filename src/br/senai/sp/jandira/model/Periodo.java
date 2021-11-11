package br.senai.sp.jandira.model;

public enum Periodo {
	
	MANHA("Hor�rio da Manh�"),
	TARDE("Hor�rio da Tarde"), 
	NOITE("Hor�rio da Noite"), 
	SABADO("Hor�rio S�bado"),
	ONLINE("Curso EAD");
	
	private String descricao;
	
	private Periodo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	

}
