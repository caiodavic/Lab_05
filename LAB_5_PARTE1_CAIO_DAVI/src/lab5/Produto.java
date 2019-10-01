package lab5;

import util.Validacao;

public class Produto {
	
	private String nome;
	private String descricao;
	private float preco;
	
	private Validacao validador;
	
	public Produto(String nome, String descricao, float preco) {
		validador = new Validacao();
		
		validador.validaNulleVazio(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro no cadastro de produto: descricao nao pode ser vazio ou nulo.");
		validador.validaInteiro(preco, "Erro no cadastro de produto: preco invalido.");
		
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		
	}
	
	
	@Override
	public String toString() {
		return nome +" - " + descricao + " - " + "R$"+ preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
