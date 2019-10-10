package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import utilcaio.Validacao;

/**
 * Classe que representa um Fornecedor do sistema SAGA, com Nome, email e
 * telefone. Seu nome é seu identificador único. Cada Fornecedor tem uma Map do
 * tipo Produtos.
 * 
 * @author Caio Davi Pereira da Silva - 119110875
 *
 */
public class Fornecedor implements Comparable<Fornecedor> {

	/**
	 * Nome do Fornecedor.
	 */
	private String nome;
	/**
	 * Email do Fornecedor.
	 */
	private String email;
	/**
	 * Telefone do Fornecedor
	 */
	private String telefone;

	/**
	 * Map que tem como chave um String com o Nome e Descrição de um Produto e
	 * armazena um objeto do tipo Produto.
	 */
	private HashMap<String, Produto> produtos;

	/**
	 * Objeto da classe validação que verifica se entradas são vazias ou nulas.
	 */
	private Validacao validador;

	/**
	 * Construtor da classe Fornecedor recebendo parâmetros que não podem ser vazios
	 * ou nulos. Caso algum seja, lançará uma exceção.
	 * 
	 * @param nome     Nome do Fornecedor
	 * @param email    Email do Fornecedor
	 * @param telefone Telefone do Fornecedor
	 */
	public Fornecedor(String nome, String email, String telefone) {
		validador = new Validacao();

		validador.validaNulleVazio(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");

		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		produtos = new HashMap<>();

	}

	/**
	 * Método de acesso para o nome do Fornecedor.
	 * 
	 * @return O nome do Fornecedor.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método de alteração do Email do Fornecedor.
	 * 
	 * @param email Email que vai substituir o antigo.
	 */
	public void setEmail(String email) {

		this.email = email;
	}

	/**
	 * Método de alteração do telefone do Fornecedor.
	 * 
	 * @param telefone Telefone que vai substituir o antigo.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Método que retorna uma representação textual do Fornecedor, com Nome, Email e
	 * Telefone.
	 */
	@Override
	public String toString() {
		return nome + " - " + email + " - " + telefone;
	}

	/**
	 * Método que cadastra um Produto no Fornecedor, inserindo o mesmo no Map de
	 * Produtos.
	 * 
	 * @param nome      Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @param preco     Preço do Produto
	 */
	public void cadastraProdutoFornecedor(String nome, String descricao, double preco) {
		validador.validaNulleVazio(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro no cadastro de produto: descricao nao pode ser vazio ou nulo.");
		validador.validaInteiro(preco, "Erro no cadastro de produto: preco invalido.");

		String chave = concatenaChave(nome, descricao);
		Produto produtoAux = new Produto(nome, descricao, preco);

		if (!produtos.containsKey(chave)) {
			produtos.put(chave, produtoAux);
		} else {
			validador.lancaExcecao("Erro no cadastro de produto: produto ja existe.");
		}

	}

	/**
	 * Método que exibe o Produto de um Fornecedor.
	 * 
	 * @param nome      Nome do produto a ser exibido.
	 * @param descricao Descrição do produto a ser exibido.
	 * @return Uma String com a representação textual do produto, com nome,
	 *         descrição e preço.
	 */
	public String exibeProdutoFornecedor(String nome, String descricao) {
		String msg = "";

		validador.validaNulleVazio(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro na exibicao de produto: descricao nao pode ser vazio ou nulo.");

		String chave = concatenaChave(nome, descricao);

		if (produtos.containsKey(chave)) {
			msg = produtos.get(chave).toString();
		} else {
			validador.lancaExcecao("Erro na exibicao de produto: produto nao existe.");
		}

		return msg;

	}

	/**
	 * Método que exibe todos os Produtos cadastrados de um Fornecedor.
	 * 
	 * @return String com a representação textual de todos os Produtos do Fornecedor
	 *         a quem pertence.
	 */
	public String exibeTodosProdutosFornecedor() {
		String msg = "";
		
		if (!produtos.isEmpty()) {
			for (Produto produtoAux : ordenaProdutos()) {
				msg += nome + " - " + produtoAux.toString() + " | ";
		}

			msg = msg.substring(0, msg.length() - 3);
		} else {
			msg += nome + " -";
		}

		return msg;
	}

	/**
	 * Método que altera o preço de um produto, a partir do Nome e Descrição
	 * inseridos.
	 * 
	 * @param nome      Nome do produto a ser alterado.
	 * @param descricao Descrição do Produto a ser alterado.
	 * @param novoPreco Preço novo que irá subsituir o antigo.
	 */
	public void editaProdutoFornecedor(String nome, String descricao, double novoPreco) {
		validador.validaNulleVazio(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		validador.validaInteiro(novoPreco, "Erro na edicao de produto: preco invalido.");

		String chave = concatenaChave(nome, descricao);

		if (produtos.containsKey(chave)) {
			produtos.get(chave).setPreco(novoPreco);
		} else {
			validador.lancaExcecao("Erro na edicao de produto: produto nao existe.");
		}
	}

	/**
	 * Método que remove um Produto de um fornecedor, a partir do seu Nome e
	 * Descrição.
	 * 
	 * @param nome      Nome do produto a ser removido.
	 * @param descricao Descrição do produto a ser removido.
	 */
	public void removeProdutoFornecedor(String nome, String descricao) {
		validador.validaNulleVazio(nome, "Erro na remocao do produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro na remocao do produto: descricao nao pode ser vazia ou nula.");

		String chave = concatenaChave(nome, descricao);

		if (produtos.containsKey(chave)) {
			produtos.remove(chave);
		} else {
			validador.lancaExcecao("Erro na remocao de produto: produto nao existe.");
		}

	}

	/**
	 * Método privado que concatena o Nome e a Descrição de um Produto para
	 * coloca-los como chave do Produto no Map de produtos.
	 * 
	 * @param nome      Nome do produto.
	 * @param descricao Descricao do Produto.
	 * @return uma String com Nome e Descriçaão concatenados e todos os caracteres
	 *         em maiúsculo.
	 */
	private String concatenaChave(String nome, String descricao) {
		return (nome + descricao).trim().replace(" ", "").toUpperCase();
	}

	/**
	 * HashCode de Fornecedor. Faz a comparação entre dois objetos do tipo
	 * Fornecedor, e se ambos tiverem o mesmo Nome, retornará um número inteiro
	 * igual.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Método que compara dois objetos do tipo Fornecedor e retorna true, caso
	 * tenham Nomes iguais, ou false caso contrário.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	/**
	 * Compara o nome do Fornecedor e de outro Fornecedor do sistema e retorna o inteiro que significa qual vem primeiro na ordem alfabética.
	 */
	@Override
	public int compareTo(Fornecedor o) {
		return this.nome.compareTo(o.getNome());
	}
	
	/**
	 * Método privado que ordena todos os Produtos do mapa de Produtos em um ArrayList, a partir do seu nome;
	 * @return um ArrayList com todos os Produtos do fornecedor ordenados pelo seus respectivos nomes;
	 */
	private ArrayList<Produto> ordenaProdutos(){
		ArrayList produtosArray = new ArrayList<Produto>(this.produtos.values());
		
		Collections.sort(produtosArray);
		
		return produtosArray;
	}

}
