package lab5;

import java.util.ArrayList;

import utilcaio.Validacao;

/**
 * Classe que representa uma conta de um Cliente com um determinado Fornecedor.
 * 
 * @author Caio Davi Pereira da Silva - 119110875
 *
 */
public class Conta {

	/**
	 * ArrayList que armazena objetos do tipo Compra.
	 */
	private ArrayList<Compra> compras;

	/**
	 * Objeto da classe validação que verifica se entradas são vazias ou nulas.
	 */
	private Validacao validador;

	/**
	 * Construtor da classe Conta, recebendo parâmetros que não podem ser vazios ou
	 * nulos. Caso algum seja, lançará uma exceção. Inicialmente a ser construído o
	 * objeto, ele também cadastrará a primeira compra.
	 * 
	 * @param nomeProduto Nome do produto comprado.
	 * @param data        data da compra.
	 * @param preco       preço do produto comprado
	 */

	public Conta(String nomeProduto, String descricaoProduto, String data, double preco) {
		validador = new Validacao();
		validador.validaNulleVazio(nomeProduto,
				"Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");

		validador.validaNulleVazio(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		validador.validaTamanhoData(data, "Erro ao cadastrar compra: data invalida.");

		Compra primeiraCompra = new Compra(nomeProduto, descricaoProduto, data, preco);
		compras = new ArrayList();
		compras.add(primeiraCompra);

	}

	/**
	 * Método que cadastra compra a partir da segunda compra em diante.
	 * 
	 * @param nomeProduto nome do produto comprado.
	 * @param data        data da compra.
	 * @param preco       preco do procuto comprado.
	 */
	public void adicionaCompra(String nomeProduto, String descricaoProduto, String data, double preco) {
		validador.validaNulleVazio(nomeProduto,
				"Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");

		validador.validaNulleVazio(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		validador.validaTamanhoData(data, "Erro ao cadastrar compra: data invalida.");

		Compra compraAux = new Compra(nomeProduto, descricaoProduto, data, preco);

		compras.add(compraAux);
	}

	/**
	 * Método que soma todos os débitos das compras da conta do Cliente
	 * 
	 * @return
	 */
	public double somaDebitoConta() {
		double debito = 0;

		for (Compra compraAux : compras) {
			debito += compraAux.getPreco();
		}

		return debito;
	}

	/**
	 * Método que exibe todas as compras cadastradas do cliente.
	 * 
	 * @return Representação textual de todas as compras do cliente.
	 */
	public String exibeComprasConta() {
		String msg = "";

		for (Compra compraAux : compras) {
			msg += compraAux.toString() + " | ";
		}

		msg = msg.substring(0, msg.length() - 3);

		return msg;
	}

	/**
	 * Método que faz parte da função de ordenação por critério escolhido pelo
	 * usuário. Nesse método adiciona-se todas as compras de uma Conta em um
	 * arrayList quando o critério de ordenação é pelo nome do Cliente ou do Fornecedor.
	 * 
	 * @return ArrayList com todas as compras da Conta
	 */
	public ArrayList<String> ordenaTudoContaPorNome() {
		ArrayList<String> txtCompras = new ArrayList();

		for (Compra compraAtual : compras) {
			txtCompras.add(compraAtual.organizaPorNome());
		}

		return txtCompras;
	}
	
	/**
	 * Método que faz parte da função de ordenação por critério escolhido pelo
	 * usuário. Nesse método adiciona-se todas as compras de uma Conta em um
	 * arrayList quando o critério de ordenação é pela data
	 * 
	 * @return ArrayList com todas as compras da Conta
	 */
	public ArrayList<String> ordenaTudoContaPorData() {
		ArrayList<String> txtCompras = new ArrayList();

		for (Compra compraAtual : compras) {
			txtCompras.add(compraAtual.organizaPorData());
		}

		return txtCompras;
	}

}
