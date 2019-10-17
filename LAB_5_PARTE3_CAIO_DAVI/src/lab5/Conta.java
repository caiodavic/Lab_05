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
	 * Nome do fornecedor da conta do Cliente.
	 */
	private String fornecedor;
	
	/**
	 * Cliente comprador da conta.
	 */
	private Cliente comprador;
	
	/**
	 * Construtor da classe Conta, recebendo parâmetros que não podem ser vazios ou
	 * nulos. Caso algum seja, lançará uma exceção. Inicialmente a ser construído o
	 * objeto, ele também cadastrará a primeira compra.
	 * 
	 * @param nomeProduto Nome do produto comprado.
	 * @param data        data da compra.
	 * @param preco       preço do produto comprado
	 */
	
	public Conta(String fornecedor, Cliente comprador) {
		validador = new Validacao();
		validador.validaNulleVazio(fornecedor, "deu erro");
		//validador.validaClienteNull(comprador, "deu erro");
		this.fornecedor = fornecedor;
		this.comprador = comprador;
		compras = new ArrayList();
		
	}
	
	
	/**
	 * Método que cadastra compra a partir da segunda compra em diante.
	 * @param nomeProduto nome do produto comprado.
	 * @param data data da compra.
	 * @param preco preco do procuto comprado.
	 */
	public void adicionaCompra(String nomeProduto, String data, double preco) {
		validador.validaNulleVazio(nomeProduto,
				"Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");

		validador.validaNulleVazio(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		validador.validaTamanhoData(data, "Erro ao cadastrar compra: data invalida.");
		
		
				
		Compra compraAux = new Compra(nomeProduto, data, preco, fornecedor, comprador);

		compras.add(compraAux);
	}
	
	/**
	 * Método que soma todos os débitos das compras da conta do Cliente
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comprador == null) ? 0 : comprador.hashCode());
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (comprador == null) {
			if (other.comprador != null)
				return false;
		} else if (!comprador.equals(other.comprador))
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		return true;
	}


	
	
	


}
