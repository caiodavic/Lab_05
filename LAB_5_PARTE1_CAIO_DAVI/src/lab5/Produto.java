package lab5;

import java.text.NumberFormat;

import utilcaio.Validacao;

/**
 * Clase que representa um Produduto do sistema SAGA, com Nome, descrição e
 * preço. Seu nome e sua descrição são seus identificadores únicos.
 * 
 * @author Caio Davi Pereira da Silva - 119110875
 *
 */
public class Produto {

	/**
	 * Nome do Produto.
	 */
	private String nome;
	/**
	 * Descrição do Produto.
	 */
	private String descricao;
	/**
	 * Preço do Produto.
	 */
	private double preco;

	/**
	 * Objeto da classe validação que verifica se entradas são vazias ou nulas.
	 */
	private Validacao validador;

	/**
	 * Construtor da Classe Produto, recebendo parâmetros que não podem ser vazios
	 * ou nulos. Caso algum seja, lançará uma exceção.
	 * 
	 * @param nome      Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @param preco     Preço do Produto.
	 */
	public Produto(String nome, String descricao, double preco) {
		validador = new Validacao();

		validador.validaNulleVazio(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		validador.validaInteiro(preco, "Erro no cadastro de produto: preco invalido.");

		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;

	}

	/**
	 * Método que retorna uma representação textual de um Produto, com nome,
	 * descrição e preço.
	 */
	@Override
	public String toString() {
		return nome + " - " + descricao + " - " + "R$" + String.format("%.2f", preco);
	}

	/**
	 * Método de alteração do preço do Produto
	 * 
	 * @param preco Preço que substituirá o antigo.
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * HashCode de Produto. Faz a comparação entre dois objetos do tipo Produto, e
	 * se ambos tiverem o mesmo Nome e Descrição, retornará um número inteiro igual.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Método que compara dois objetos do tipo Produto e retorna true, caso tenham
	 * Nomes e Descrição iguais, ou false caso contrário.
	 */
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
