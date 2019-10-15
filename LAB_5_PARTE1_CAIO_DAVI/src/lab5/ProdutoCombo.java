package lab5;

import utilcaio.Validacao;

/**
 * Clase que representa um Combo de Produdutos do sistema SAGA, com Nome,
 * descrição, fator de desconto e preço. Seu nome e sua descrição são seus
 * identificadores únicos.
 * 
 * @author Caio Davi Pereira da Silva - 119110875
 *
 */
public class ProdutoCombo extends ProdutoAbstract implements Produto {
	
	/**
	 * Preço do Combo de produtos
	 */
	private double preco;
	
	/**
	 * Fator de desconto que determina o preço do Combo a partir do preço dos dois produtos que o geram.
	 */
	private double fator;
	
	/**
	 * Produto 1 que faz parte do combo.
	 */
	Produto p1;
	
	/**
	 * Prdotuo 2 que faz parte do combo.
	 */
	Produto p2;
	
	/**
	 * Objeto da classe validação que verifica se entradas são vazias ou nulas.
	 */
	private Validacao validador;
	
	/**
	 * Construtor da Classe ProdutoCombo, recebendo parâmetros que não podem ser vazios
	 * ou nulos. Caso algum seja, lançará uma exceção.
	 * @param nome nome do Combo de Produtos
	 * @param descricao descricao do Combo de Produtos
	 * @param fator Fator de desconto no preço dos produtos que formam o combo
	 * @param p1 Produto 1 que faz parte do combo.
	 * @param p2 Produto 2 que faz parte do combo.
	 */
	public ProdutoCombo(String nome, String descricao, double fator, Produto p1, Produto p2) {
		super(nome, descricao);
		
		validador = new Validacao();
		
		validador.validaNulleVazio(nome, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		validador.validaFator(fator, "Erro no cadastro de combo: fator invalido.");

		this.fator = fator;
		this.p1 = p1;
		this.p2 = p2;

		this.preco = definePrecoCombo(fator, p1.getPreco(), p2.getPreco());
	}

	/**
	 * Método responsável por definir o preço do Combo a partir dos preços dos produtos que fazem parte do combo
	 * @param fator Fator de desconto
	 * @param preco1 Preço do produto 1
	 * @param preco2 Preço do produto 2
	 * @return Valor do combo
	 */
	private double definePrecoCombo(double fator, double preco1, double preco2) {
		return (preco1 + preco2) * (1 - fator);

	}
	
	/**
	 * Método responsável por alterar o fator de desconto
	 */
	public void setPrecoOuFator(double valor) {
		preco = definePrecoCombo(valor, p1.getPreco(), p2.getPreco());
	}

	/**
	 * Método de acesso para o preço do Produto.
	 * 
	 * @return O preço do Produto.
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Método que retorna uma representação textual de um Produto, com nome,
	 * descrição e preço.
	 */
	@Override
	public String toString() {
		return nome + " - " + descricao + " - " + "R$" + String.format("%.2f", preco);
	}

}
