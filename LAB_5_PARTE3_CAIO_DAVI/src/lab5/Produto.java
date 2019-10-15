package lab5;

/**
 * Classe Interface de Produto, contendo declarações de funções usadas nos dois
 * tipos de Produtos que temos.
 * 
 * @author Caio Davi Pereira da Silva - 119110875
 *
 */
public interface Produto {
	/**
	 * Método que acessa o Nome do produto
	 * 
	 * @return o Nome do produto
	 */
	public String getNome();

	/**
	 * Método que acessa a Descrição do produto
	 * 
	 * @return a Descrição do produto
	 */
	public String getDescricao();

	/**
	 * Método que acessa o preço do produto
	 * 
	 * @return o preço do produto
	 */
	public double getPreco();

	/**
	 * Método que altera o preço ou o fator de desconto, no caso do Produto ser um
	 * Combo.
	 * 
	 * @param valor
	 */
	public void setPrecoOuFator(double valor);

	/**
	 * Compara o nome doProduto e de outro Produto do sistema e retorna o
	 * inteiro que significa qual vem primeiro na ordem alfabética.
	  * @param o um Objeto do tipo Produto
	 * @return inteiro que significa qual vem primeiro na ordem alfabética.
	 */
	public int compareTo(Produto o);
	
	/**
	 * Método resposável por gerar uma representação textual  do Produto, com Nome, Descrição e preço
	 * @return uma String com nome, descrição e preço do produto.
	 */
	public String toString();

}
