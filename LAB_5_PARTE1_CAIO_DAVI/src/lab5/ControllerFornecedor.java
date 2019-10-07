package lab5;

import java.util.HashMap;

import utilcaio.Validacao;

/**
 * Classe controle de Fornecedor e Produto. É nessa classe que temos os métodos
 * que cadastram, alteram e exibem Fornecedores e Produtos.
 *
 */
public class ControllerFornecedor {

	/**
	 * HashMap que tem como chave uma String com o Nome do Fornecedor e armazena
	 * objetos do tipo Fornecedor.
	 */
	private HashMap<String, Fornecedor> fornecedores;

	/**
	 * Objeto da classe validação que verifica se entradas são vazias ou nulas.
	 */
	private Validacao validador;

	/**
	 * Construtor de ControllerFornecedor.
	 */
	public ControllerFornecedor() {
		this.fornecedores = new HashMap<>();
		this.validador = new Validacao();

	}

	/**
	 * Método responsável por cadastrar um Fornecedor, recebendo parâmetros que não
	 * podem ser vazios ou nulos. Caso algum seja, lançará uma exceção.
	 * 
	 * @param nome     Nome do Fornecedor a ser cadastrado.
	 * @param email    Email do cliente a ser cadastrado.
	 * @param telefone Telefone do cliente a ser cadastrado.
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) {
		String nomereturn = "";
		Fornecedor fornecedorAux;
		validador.validaNulleVazio(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");

		String chave = concatenaChave(nome);

		if (!fornecedores.containsKey(chave)) {
			fornecedorAux = new Fornecedor(nome, email, telefone);
			fornecedores.put(chave, fornecedorAux);
			nomereturn = fornecedores.get(chave).getNome();
		} else {
			validador.lancaExcecao("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}

		return nomereturn;

	}

	/**
	 * Método privado que concatena as palavras do Nome de um Fornecedor para
	 * coloca-las como chave do objeto Fornecedor no Map de fornecedores.
	 * 
	 * @param nome
	 * @return
	 */
	private String concatenaChave(String nome) {
		return nome.trim().replace(" ", "").toUpperCase();

	}

	/**
	 * Método que exibe uma representação textual de um Fornecedor, com Nome, Email
	 * e Telefone do mesmo, a partir do seu Nome inserido.
	 * 
	 * @param nome Nome do Fornecedor a ser exibido.
	 * @return Uma string com a reprsentação textual de um Fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		String msg = "";

		validador.validaNulleVazio(nome, "Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");

		String chave = concatenaChave(nome);
		if (fornecedores.containsKey(chave)) {
			msg = fornecedores.get(chave).toString();
		} else {
			validador.lancaExcecao("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}

		return msg;
	}

	/**
	 * Método que exibe uma representação textual de todos os Fornecedores do SAGA.
	 * 
	 * @return Uma String com representação textual de todos os Fornecedores
	 *         cadastrados.
	 */
	public String exibeTodosFornecedores() {
		String msg = "";

		if (!fornecedores.isEmpty()) {
			for (Fornecedor fornecedoraux : this.fornecedores.values()) {
				msg += fornecedoraux.toString() + " | ";

			}
			msg = msg.substring(0, msg.length() - 3);
		}

		return msg;
	}

	/**
	 * Método que altera um dado do Fornecedor. Não é possível alterar o nome de um
	 * Fornecedor.
	 * 
	 * @param nome     Nome do FOrnecedor que se deseja alterar um dado.
	 * @param oqAltera Dado a ser alterado.
	 * @param novoDado Dado que substituirá o dado antigo.
	 */
	public void editaCadastroFornecedor(String nome, String oqAltera, String novoDado) {
		validador.validaNulleVazio(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(oqAltera, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(novoDado, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");

		String chave = concatenaChave(nome);
		oqAltera = oqAltera.toUpperCase();

		if (fornecedores.containsKey(chave)) {
			switch (oqAltera) {

			case "EMAIL":
				fornecedores.get(chave).setEmail(novoDado);
				break;

			case "TELEFONE":
				fornecedores.get(chave).setTelefone(novoDado);
				break;

			case "NOME":
				validador.lancaExcecao("Erro na edicao do fornecedor: nome nao pode ser editado.");
				break;

			default:
				validador.lancaExcecao("Erro na edicao do fornecedor: atributo nao existe.");
				break;

			}
		} else {
			validador.lancaExcecao("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
	}

	/**
	 * Método que remove um Fornecedor cadastrado do SAGA, a partir do seu Nome.
	 * 
	 * @param nome Nome do fornecedor a ser removido.
	 */
	public void removeFornecedor(String nome) {
		validador.validaNulleVazio(nome,
				"Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		String chave = concatenaChave(nome);
		if (fornecedores.containsKey(chave)) {
			fornecedores.remove(chave);
		} else {
			validador.lancaExcecao("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
	}

	/**
	 * Método que cadastra um Produto no Fornecedor, inserindo o mesmo no Map de
	 * Produtos do Fornecedor passado por parâmetro.
	 * 
	 * @param fornecedor o Produto irá ser cadastrado nesse fornecedor
	 * @param nome       Nome do Produto.
	 * @param descricao  Descrição do Produto.
	 * @param preco      Preço do Produto
	 */
	public void cadastraProduto(String fornecedor, String nome, String descricao, double preco) {
		validador.validaNulleVazio(fornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		validador.validaInteiro(preco, "Erro no cadastro de produto: preco invalido.");

		String chave = concatenaChave(fornecedor);

		if (fornecedores.containsKey(chave)) {
			fornecedores.get(chave).cadastraProdutoFornecedor(nome, descricao, preco);
		} else {
			validador.lancaExcecao("Erro no cadastro de produto: fornecedor nao existe.");
		}

	}

	/**
	 * Método que exibe o Produto de um Fornecedor.
	 * 
	 * @param fornecedor Fornecedor a quem pertence o produto
	 * @param nome       Nome do produto a ser exibido.
	 * @param descricao  Descrição do produto a ser exibido.
	 * @return Uma String com a representação textual do produto, com nome,
	 *         descrição e preço.
	 */
	public String exibeProduto(String fornecedor, String nome, String descricao) {
		String msg = "";
		validador.validaNulleVazio(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");

		String chave = concatenaChave(fornecedor);

		if (fornecedores.containsKey(chave)) {
			msg = fornecedores.get(chave).exibeProdutoFornecedor(nome, descricao);
		} else {
			validador.lancaExcecao("Erro na exibicao de produto: fornecedor nao existe.");
		}

		return msg;
	}

	/**
	 * Método que exibe todos os Produtos cadastrados de um Fornecedor.
	 * 
	 * @param fornecedor Fornecedor que se deseja listar todos os produtos do mesmo.
	 * @return String com a representação textual de todos os Produtos do Fornecedor
	 *         a quem pertence.
	 */
	public String exibeTodosProdutosDeUmFornecedor(String fornecedor) {
		String msg = "";

		validador.validaNulleVazio(fornecedor, "Erro na exibicao de produtos: fornecedor nao pode ser vazio ou nulo.");

		String chave = concatenaChave(fornecedor);

		if (fornecedores.containsKey(chave)) {
			msg = fornecedores.get(chave).exibeTodosProdutosFornecedor();
		} else {
			validador.lancaExcecao("Erro na exibicao de produto: fornecedor nao existe.");
		}

		return msg;
	}

	/**
	 * Método que exibe todos os Produtos cadastrados no SAGA.
	 * 
	 * @return String com a representação textual de todos os produtos cadastrados
	 *         no SAGA.
	 */
	public String exibeTodosProdutosExistentes() {
		String msg = "";

		if (!fornecedores.isEmpty()) {
			for (Fornecedor fornecedorAux : fornecedores.values())
				msg += fornecedorAux.exibeTodosProdutosFornecedor() + " | ";
		}

		return msg;
	}

	/**
	 * Método que altera o preço de um produto, a partir do Nome e Descrição
	 * inseridos.
	 * 
	 * @param fornecedor Fonecedor do produto que se deseja alterar.
	 * @param nome       Nome do produto que se deseja alterar.
	 * @param descricao  Descrição do produto que se deseja alterar.
	 * @param novoPreco  Preço novo que irá subsituir o antigo.
	 */
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {

		validador.validaNulleVazio(fornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		validador.validaInteiro(novoPreco, "Erro na edicao de produto: preco invalido.");

		String chave = concatenaChave(fornecedor);

		if (fornecedores.containsKey(chave)) {

			fornecedores.get(chave).editaProdutoFornecedor(nome, descricao, novoPreco);

		} else {
			validador.lancaExcecao("Erro na edicao de produto: fornecedor nao existe.");
		}
	}

	/**
	 * Método que remove um Produto de um fornecedor, a partir do seu Nome e
	 * Descrição.
	 * 
	 * @param fornecedor Fornecedor do produto a ser removido
	 * @param nome      Nome do produto a ser removido.
	 * @param descricao Descrição do produto a ser removido.
	 */
	public void removeProduto(String nome, String descricao, String fornecedor) {

		validador.validaNulleVazio(fornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(nome, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");

		String chave = concatenaChave(fornecedor);

		if (fornecedores.containsKey(chave)) {
			fornecedores.get(chave).removeProdutoFornecedor(nome, descricao);
		} else {
			validador.lancaExcecao("Erro na remocao de produto: fornecedor nao existe.");
		}
	}

}
