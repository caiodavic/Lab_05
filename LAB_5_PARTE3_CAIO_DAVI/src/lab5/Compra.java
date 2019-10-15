package lab5;

import utilcaio.Padronizacao;
import utilcaio.Validacao;

/**
 * Classe que representa uma Compra na Conta de um Cliente.
 * @author caio
 *
 */
public class Compra {
	
	/**
	 * Nome do produto que foi comprado
	 */
	private String nomeProduto;
	
	/**
	 * Data da compra do produto.
	 */
	private String data;
	
	/**
	 * Preço do produto comprado
	 */
	private double preco;
	
	/**
	 * Objeto da classe validação que verifica se entradas são vazias ou nulas.
	 */
	private Validacao validador;
	
	/**
	 * Objeto da classe padronização, que torna padrão as entradas.
	 */
	private Padronizacao padronizador;
	
	/**
	 * Construtor da Classe Compra, recebendo parâmetros que não podem ser vazios
	 * ou nulos. Caso algum seja, lançará uma exceção.
	 * @param nomeProduto Nome do produto comprado.
	 * @param data data da compra do produto.
	 * @param preco preço do produto comprado.
	 */
	public Compra(String nomeProduto, String data, double preco) {
		
		validador = new Validacao();
		padronizador = new Padronizacao();
		validador.validaNulleVazio(nomeProduto,
				"Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");

		validador.validaNulleVazio(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		validador.validaTamanhoData(data, "Erro ao cadastrar compra: data invalida.");
				
		this.data = padronizador.formataData(data);
		this.nomeProduto = nomeProduto;
		this.preco = preco;

	}
	
	/**
	 * Método de acesso do nome do Produto comprado.
	 * @return nome do Produto.
	 */
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	/**
	 * Método de acesso do preço do Produto comprado.
	 * @return preço do Produto.
	 */
	public double getPreco() {
		
		return preco;
	}
	
	/**
	 * Método responsável por gerar uma representação textual de uma Compra, com o nome do Produto e a Data;
	 */
	@Override
	public String toString() {
		return nomeProduto + " - " + data;
	}

}
