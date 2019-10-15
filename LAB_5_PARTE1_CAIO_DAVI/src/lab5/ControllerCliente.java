package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;

import utilcaio.Padronizacao;
import utilcaio.Validacao;

/**
 * Classe controle de Cliente. É nessa classe que temos os métodos que cadastra,
 * alteram e exibem um certo Cliente.
 * 
 * @author Caio Davi Pereira da Silva - 119110875
 *
 */
public class ControllerCliente {

	/**
	 * HashMap que tem como chave uma String com o CPF do cliente e armazena objetos
	 * do tipo Cliente.
	 */
	private HashMap<String, Cliente> clientes;

	/**
	 * Objeto da classe validação que verifica se entradas são vazias ou nulas.
	 */
	private Validacao validador;

	/**
	 * Objeto da classe Controladora de Fornecedor, a fim de termos a possibilidade
	 * de chamar funções desse Controlador.
	 */
	ControllerFornecedor fornecedorController;

	/**
	 * Objeto da classe de padronização que transforma nomes e descrições em chaves
	 * para mapas.
	 */
	Padronizacao padronizador;

	/**
	 * Construtor da classe ControllerCLiente.
	 */
	public ControllerCliente(ControllerFornecedor fornecedorController) {
		this.clientes = new HashMap<>();
		this.validador = new Validacao();
		this.fornecedorController = fornecedorController;
		this.padronizador = new Padronizacao();

	}

	/**
	 * Método responsável por cadastrar um cliente, recebendo parâmetros que não
	 * podem ser vazios ou nulos. Caso algum seja, lançará uma exceção.
	 * 
	 * @param cpf   CPF do Cliente a ser cadastrado.
	 * @param nome  Nome do Cliente a ser cadastrado.
	 * @param email Email do cliente a ser cadastrado.
	 * @param loc   Localização do cliente a ser cadastrado.
	 */
	public String cadastraClientes(String cpf, String nome, String email, String loc) {
		String cpfreturn = "";

		validador.validaNulleVazio(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(loc, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		validador.validaNulleVazio(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		validador.validaTamanhoCpf(cpf, "Erro no cadastro do cliente: cpf invalido.");

		if (!clientes.containsKey(cpf)) {
			Cliente clienteaux = new Cliente(cpf, nome, email, loc);
			clientes.put(cpf, clienteaux);
			cpfreturn = clientes.get(cpf).getCpf();
		} else {
			validador.lancaExcecao("Erro no cadastro do cliente: cliente ja existe.");
		}

		return cpfreturn;

	}

	/**
	 * Método que exibe a representação textual de um Cliente, a partir de um CPF
	 * inserido.
	 * 
	 * @param cpf CPF do cliente que se deseja exibir.
	 * @return Uma String com uma representação textual do cliente, com Nome, Email
	 *         e Localização
	 */
	public String exibeCliente(String cpf) {
		String msg = "";

		validador.validaNulleVazio(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");

		if (clientes.containsKey(cpf)) {
			msg = clientes.get(cpf).toString();
		} else {
			validador.lancaExcecao("Erro na exibicao do cliente: cliente nao existe.");
		}

		return msg;
	}

	/**
	 * Método que edita o cadastro de um Cliente a partir do CPF inserido como
	 * parâmetro. Não se pode alterar o CPF
	 * 
	 * @param cpf      CPF do Cliente que se deseja alterar algum dado
	 * @param oqAltera Dado que se deseja alterar.
	 * @param novoDado Dado que substituirá o antigo.
	 */
	public void editaCadastroCliente(String cpf, String oqAltera, String novoDado) {
		validador.validaNulleVazio(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(oqAltera, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(novoDado, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");

		oqAltera = oqAltera.toUpperCase();

		if (clientes.containsKey(cpf)) {
			switch (oqAltera) {
			case "NOME":
				clientes.get(cpf).setNome(novoDado);
				break;

			case "LOCALIZACAO":
				clientes.get(cpf).setLoc(novoDado);
				break;

			case "EMAIL":
				clientes.get(cpf).setEmail(novoDado);
				break;

			case "CPF":
				validador.lancaExcecao("Erro na edicao do cliente: cpf nao pode ser editado.");
				break;

			default:
				validador.lancaExcecao("Erro na edicao do cliente: atributo nao existe.");
				break;
			}
		} else {
			validador.lancaExcecao("Erro na edicao do cliente: cliente nao existe.");

		}
	}

	/**
	 * Método que remove um cliente cadastrado do sistema a partir de seu CPF.
	 * 
	 * @param cpf CPF do Cliente que se deseja remover
	 */
	public void removeCliente(String cpf) {

		validador.validaNulleVazio(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");

		if (clientes.containsKey(cpf)) {
			clientes.remove(cpf);
		} else {
			validador.lancaExcecao("Erro na remocao do cliente: cliente nao existe.");
		}
	}

	/**
	 * Método privado que ordena todos os Clientes do mapa de Clientes em um
	 * ArrayList, a partir do seu nome;
	 * 
	 * @return um ArrayList com todos os Clientes do sistema ordenados pelo seus
	 *         respectivos nomes;
	 */
	private ArrayList<Cliente> ordenaClientes() {
		ArrayList<Cliente> clientesArray = new ArrayList<>(this.clientes.values());

		Collections.sort(clientesArray);

		return clientesArray;
	}

	/**
	 * Método responsável por exibir os Clientes de forma ordenada usando o nome
	 * como referência.
	 * 
	 * @return uma String como todos os clientes ordenados por ordem alfabética
	 *         usando o nome como referência.
	 */
	public String exibeClientesOrdenados() {
		String msg = "";

		for (Cliente clienteAux : ordenaClientes()) {
			msg += clienteAux.toString() + " | ";
		}

		msg = msg.substring(0, msg.length() - 3);

		return msg;
	}

	/**
	 * Método responsável por cadastrar uma compra de um cliente com um determinado
	 * fornecedor.
	 * 
	 * @param cpf              cpf do cliente.
	 * @param fornecedor       nome do fornecedor.
	 * @param nomeProduto      nome do produto.
	 * @param descricaoProduto descrição do produto.
	 * @param data             data da compra.
	 */
	public void adicionaCompra(String cpf, String fornecedor, String nomeProduto, String descricaoProduto,
			String data) {

		validador.validaNulleVazio(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		validador.validaTamanhoCpf(cpf, "Erro ao cadastrar compra: cpf invalido.");
		validador.validaNulleVazio(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(nomeProduto,
				"Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricaoProduto,
				"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		validador.validaNulleVazio(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		validador.validaTamanhoData(data, "Erro ao cadastrar compra: data invalida.");

		if (!clientes.containsKey(cpf)) {
			validador.lancaExcecao("Erro ao cadastrar compra: cliente nao existe.");
		} else if (!fornecedorController.existeFornecedor(fornecedor)) {
			validador.lancaExcecao("Erro ao cadastrar compra: fornecedor nao existe.");
		} else if (!fornecedorController.existeProduto(fornecedor, nomeProduto, descricaoProduto)) {
			validador.lancaExcecao("Erro ao cadastrar compra: produto nao existe.");
		} else {
			String chaveFornecedor = padronizador.concatenaChaveFornecedor(fornecedor);
			String nome = fornecedorController.getNomeProduto(fornecedor, nomeProduto, descricaoProduto);
			double preco = fornecedorController.getPrecoProduto(fornecedor, nomeProduto, descricaoProduto);
			
			
			clientes.get(cpf).adicionaCompraCliente(chaveFornecedor, nome, data, preco);


		}

	}

	/**
	 * Método que exibe a conta de um cliente com um fornecedor em específico.
	 * 
	 * @param cpf        CPF do cliente que deseja que se exiba a conta.
	 * @param fornecedor Fornecedor a quem o cliente esta devendo para ser mostrado
	 *                   em tela.
	 * @return Representação textual da conta do cliente com aquele fornecedor
	 */
	public String exibeConta(String cpf, String fornecedor) {
		String msg = "";
		String nomeCliente = "";
		
		validador.validaNulleVazio(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		validador.validaTamanhoCpf(cpf, "Erro ao exibir conta do cliente: cpf invalido.");
		validador.validaNulleVazio(fornecedor,
				"Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");

		if (clientes.containsKey(cpf)) {
			nomeCliente = clientes.get(cpf).getNome();
		} else {
			validador.lancaExcecao("Erro ao exibir conta do cliente: cliente nao existe.");
		}

		String chave = padronizador.concatenaChaveFornecedor(fornecedor);

		String nomeFornecedor = fornecedorController.getNomeFornecedor(fornecedor);

		String conta = clientes.get(cpf).exibeContaCliente(nomeFornecedor, chave);

		msg = "Cliente: " + nomeCliente + " | " + conta;

		return msg;
	}

	/**
	 * Método que exibe o débito do cliente com determinado fornecedor.
	 * 
	 * @param chave chave do mapa de contas, essa chave contém relação com o nome do
	 *              fornecedor que o cliente esta com débito.
	 * @return débito do cliente com aquele fornecedor
	 */
	public String totalizandoContaFornecedor(String cpf, String fornecedor) {
		double debito = 0;
		
		validador.validaNulleVazio(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		validador.validaTamanhoCpf(cpf, "Erro ao recuperar debito: cpf invalido.");
		validador.validaNulleVazio(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		if (!fornecedorController.existeFornecedor(fornecedor)) {
			validador.lancaExcecao("Erro ao recuperar debito: fornecedor nao existe.");
		}

		String chave = padronizador.concatenaChaveFornecedor(fornecedor);

		if (clientes.containsKey(cpf)) {
			debito = clientes.get(cpf).totalizandoContaFornecedor(chave);
		} else {
			validador.lancaExcecao("Erro ao recuperar debito: cliente nao existe.");
		}
		
		return (String.format(Locale.US,"%.2f", debito));
	}

	/**
	 * Método que exibe todas as contas de um cliente com todos os fornecedores em
	 * que ele esta em débito.
	 * 
	 * @param cpf CPF do cliente que se deseja exibir as contas
	 * @return Uma String com a representação textual de todas as contas do cliente
	 */
	public String exibeTodasAsContasCliente(String cpf) {
		String msg = "";
		
		validador.validaNulleVazio(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		validador.validaTamanhoCpf(cpf, "Erro ao exibir contas do cliente: cpf invalido.");
		
		if (clientes.containsKey(cpf)) {
			msg +="Cliente: " + clientes.get(cpf).getNome() + " | ";
		} else {
			validador.lancaExcecao("Erro ao exibir contas do cliente: cliente nao existe.");
		}
		
		ArrayList<String> chavesArray = new ArrayList<>(clientes.get(cpf).getMapContas().keySet());
		
		Collections.sort(chavesArray);
		
		for (String chaveAux : chavesArray) {

			String nomeFornecedor = fornecedorController.getNomeFornecedor(chaveAux);

			msg += clientes.get(cpf).exibeContaCliente(nomeFornecedor, chaveAux) + " | ";
		}
		
		msg = msg.substring(0, msg.length()-3);
		return msg;
	}

}
