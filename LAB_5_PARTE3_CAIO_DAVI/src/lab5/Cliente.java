package lab5;

import java.util.ArrayList;
import java.util.HashMap;

import utilcaio.Validacao;

/**
 * Classe que representa um cliente do sistema SAGA, com Nome, CPF, email e
 * localização. O CPF é seu indetificador único.
 * 
 * @author Caio Davi Pereira da Silva - 119110875
 *
 */
public class Cliente implements Comparable<Cliente> {

	/**
	 * CPF do cliente.
	 */
	private String cpf;
	/**
	 * Nome do cliente.
	 */
	private String nome;
	/**
	 * Email do cliente.
	 */
	private String email;
	/**
	 * Nome do bloco ou localização onde o cliente trabalha.
	 */
	private String loc;

	/**
	 * Objeto da classe validação que verifica se entradas são vazias ou nulas.
	 */
	private Validacao validador;

	/**
	 * HashMap que tem como chave uma String com o Fornecedor da conta do cliente e
	 * armazena objetos do tipo Conta.
	 */
	private HashMap<String, Conta> contas;

	/**
	 * Construtor da classe Cliente, recebendo parâmetros que não podem ser vazios
	 * ou nulos. Caso algum seja, lançará uma exceção.
	 * 
	 * @param cpf   CPF do Cliente a ser construido.
	 * @param nome  Nome do Cliente a ser construído.
	 * @param email Email do cliente a ser construído.
	 * @param loc   Localização do cliente a ser construído.
	 */
	public Cliente(String cpf, String nome, String email, String loc) {
		validador = new Validacao();

		validador.validaNulleVazio(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(loc, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		validador.validaTamanhoCpf(cpf, "Erro no cadastro do cliente: cpf invalido");
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.loc = loc;

		contas = new HashMap<>();

	}

	/**
	 * Método de acesso para o CPF do cliente.
	 * 
	 * @return O CPF do Cliente
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Método de alteração do Nome do Cliente.
	 * 
	 * @param nome Nome que vai substituir o antigo.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método de acesso para o Nome do cliente.
	 * 
	 * @return O Nome do Cliente
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método de alteração do Email do Cliente.
	 * 
	 * @param email Email que vai substituir o antigo.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Método de alteração da Localização do Cliente.
	 * 
	 * @param loc Localização que vai substituir a antiga.
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}

	/**
	 * Método que adiciona uma compra na conta do cliente em específico passado por
	 * parâmetro
	 * 
	 * @param chave       chave do mapa de contas, essa chave contém relação com o
	 *                    nome do fornecedor que vendeu o produto
	 * @param nomeProduto Nome do produto comprado.
	 * @param data        data da compra do produto.
	 * @param preco       preco do produto.
	 */
	public void adicionaCompraCliente(String chave, String nomeProduto, String descricaoProduto, String data,
			double preco) {
		validador.validaNulleVazio(nomeProduto,
				"Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");

		validador.validaNulleVazio(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		validador.validaTamanhoData(data, "Erro ao cadastrar compra: data invalida.");

		if (contas.containsKey(chave)) {
			this.contas.get(chave).adicionaCompra(nomeProduto, descricaoProduto, data, preco);
		} else {

			Conta contaAux = new Conta(nomeProduto, descricaoProduto, data, preco);
			this.contas.put(chave, contaAux);
		}

	}

	/**
	 * Método que exibe a conta de um cliente com um fornecedor em específico.
	 * 
	 * @param fornecedor Fornecedor a quem o cliente esta devendo para ser mostrado
	 *                   em tela.
	 * @param chave      chave do mapa de contas, essa chave contém relação com o
	 *                   nome do fornecedor que o cliente esta com débito.
	 * @return Representação textual da conta do cliente com aquele fornecedor
	 */
	public String exibeContaCliente(String fornecedor, String chave) {
		String msg = "";

		if (contas.containsKey(chave)) {
			msg = fornecedor + " | " + contas.get(chave).exibeComprasConta();
		} else {
			validador.lancaExcecao("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}

		return msg;
	}

	/**
	 * Método que exibe o débito do cliente com determinado fornecedor.
	 * 
	 * @param chave chave do mapa de contas, essa chave contém relação com o nome do
	 *              fornecedor que o cliente esta com débito.
	 * @return débito do cliente com aquele fornecedor
	 */
	public double totalizandoContaFornecedor(String chave) {
		double debito = 0;

		if (contas.containsKey(chave)) {
			debito = contas.get(chave).somaDebitoConta();
		} else {
			validador.lancaExcecao("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}

		return debito;
	}

	/**
	 * Método de acesso ao HashMap de contas.
	 * 
	 * @return o HashMap de todas as contas de determinado cliente
	 */
	public HashMap<String, Conta> getMapContas() {
		if (contas.isEmpty()) {
			validador.lancaExcecao("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		}
		return contas;
	}

	public void pagaContaCliente(String chave) {

		if (!contas.containsKey(chave)) {
			validador.lancaExcecao("Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");
		} else {
			contas.remove(chave);

		}
	}

	/**
	 * Método de acesso ao mapa de Contas do Cliente.
	 * 
	 * @return um HashMap com as contas do Cliente
	 */
	public HashMap<String, Conta> getMapConta() {
		return contas;
	}

	/**
	 * Representação textual de um cliente. Retorna uma String com o Nome,
	 * Localização e Email.
	 */
	@Override
	public String toString() {
		return nome + " - " + loc + " - " + email;
	}

	/**
	 * HashCode da Classe Cliente. Faz a comparação entre dois objetos do tipo
	 * Cliente, e se ambos tiverem o mesmo CPF, retornará um número inteiro igual
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	/**
	 * Método que compara dois objetos do tipo Cliente e retorna true, caso tenham
	 * CPF iguais, ou false caso contrário.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	/**
	 * Compara o nome do Cliente e de outro Cliente do sistema e retorna o inteiro
	 * que significa qual vem primeiro na ordem alfabética.
	 */
	@Override
	public int compareTo(Cliente o) {
		return this.nome.compareTo(o.getNome());
	}

}
