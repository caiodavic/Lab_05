package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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
	 * Construtor da classe ControllerCLiente.
	 */
	public ControllerCliente() {
		this.clientes = new HashMap<>();
		this.validador = new Validacao();

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
	 * Método privado que ordena todos os Clientes do mapa de Clientes em um ArrayList, a partir do seu nome;
	 * @return um ArrayList com todos os Clientes do sistema ordenados pelo seus respectivos nomes;
	 */
	private ArrayList<Cliente> ordenaClientes() {
		ArrayList<Cliente> clientesArray = new ArrayList<>(this.clientes.values());
		
		Collections.sort(clientesArray);
		
		return clientesArray;
	}
	
	/**
	 * Método responsável por exibir os Clientes de forma ordenada usando o nome como referência.
	 * @return	uma String como todos os clientes ordenados por ordem alfabética usando o nome como referência.
	 */
	public String exibeClientesOrdenados() {
		String msg = "";
		
		for(Cliente clienteAux: ordenaClientes()) {
			msg += clienteAux.toString() + " | ";			
		}
		
		msg = msg.substring(0, msg.length() - 3);
		
		return msg;
	}

}
