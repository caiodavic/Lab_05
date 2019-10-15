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
public class ProdutoSimples extends ProdutoAbstract implements Produto {

	/**
	 * Preço do produto
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
	public ProdutoSimples(String nome, String descricao, double preco) {
		super(nome, descricao);

		validador = new Validacao();
		validador.validaNulleVazio(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		validador.validaInteiro(preco, "Erro no cadastro de produto: preco invalido.");

		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;

	}

	/**
	 * Método de alteração do preço do Produto
	 * 
	 * @param preco Preço que substituirá o antigo.
	 */
	@Override
	public void setPrecoOuFator(double valor) {
		this.preco = valor;
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
	 * Método de acesso para o preço do Produto.
	 * 
	 * @return O preço do Produto.
	 */
	public double getPreco() {
		return preco;
	}

	
}
