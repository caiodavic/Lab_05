package utilcaio;

import java.lang.reflect.Array;

/**
 * Classe que contém os métodos que padronizam entradas para serem utilziadas
 * como chave nos mapas.
 * 
 * @author Caio Davi Pereira da Silva - 119110875
 *
 */

public class Padronizacao {

	public Padronizacao() {

	}

	/**
	 * Método publico que concatena as palavras do Nome de um Fornecedor para
	 * coloca-las como chave do objeto Fornecedor no Map de fornecedores. Tambem
	 * será usado para pegar um Fornecedor no mesmo mapa
	 * 
	 * @param nome
	 * @return o nome do fornecedor com todas as letras maiusculas e sem espaço.
	 */
	public String concatenaChaveFornecedor(String nome) {
		return nome.trim().replace(" ", "").toUpperCase();

	}

	/**
	 * Método público que concatena o Nome e a Descrição de um Produto para
	 * coloca-los como chave do Produto no Map de produtos. Tambem será utilizado
	 * para pegar um Produto no mesmo mapa.
	 * 
	 * @param nome      Nome do produto.
	 * @param descricao Descricao do Produto.
	 * @return uma String com Nome e Descriçaão concatenados e todos os caracteres
	 *         em maiúsculo.
	 */
	public String concatenaChaveProduto(String nome, String descricao) {
		return (nome + descricao).trim().replace(" ", "").toUpperCase();
	}

	public String concatenaChaveProdutoCombo(String nomeEdescricao) {
		String[] chave = nomeEdescricao.split(" - ");
		return (chave[0] + chave[1]).trim().replace(" ", "").toUpperCase();

	}

	/**
	 * Método responsável por separar em duas strings diferentes a String de entrada
	 * para cadastro do combo com nome e descrição de dois produtos separados por
	 * vírgula
	 * 
	 * @param produto1e2 Produtos que vão formar o combo
	 * @return um Array com dois elementos, cada produto em um
	 */
	public String[] separaProdutosParaCombo(String produto1e2) {

		String[] divide = produto1e2.split(",");
		divide[0] = divide[0].trim();
		divide[1] = divide[1].trim();

		return divide;
	}
	
	/**
	 * Método que formata a data, trocando as "/" por "-"
	 * @param data a data para ser formatada.
	 * @return a data formatada
	 */
	public String formataData(String data) {
		return data.replace("/", "-");
	}
	
	/**
	 * Método que padroniza a entrada de critério de ordenação a fim de não ter problema se inserir caracteres maiusculos, minusculos ou até espaço a mais
	 * @param criterio string a ser padronizada
	 * @return a string que foi parâmetro da função toda em maiúsculo e sem espaços a mais.
	 */
	public String padronizaCriterio(String criterio) {
		return criterio.trim().toUpperCase();
	}
}
