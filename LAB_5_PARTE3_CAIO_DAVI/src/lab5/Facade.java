package lab5;

import easyaccept.EasyAccept;

public class Facade {

	private ControllerCliente controleCliente;
	private ControllerFornecedor controleFornecedor;

	public Facade() {
		controleFornecedor = new ControllerFornecedor();
		controleCliente = new ControllerCliente(controleFornecedor);
	}

	public String adicionaCliente(String cpf, String nome, String email, String loc) {
		return controleCliente.cadastraClientes(cpf, nome, email, loc);
	}

	public String exibeCliente(String cpf) {
		return controleCliente.exibeCliente(cpf);
	}

	public String exibeClientes() {
		return controleCliente.exibeClientesOrdenados();
	}

	public void editaCliente(String cpf, String oqAltera, String novoDado) {
		controleCliente.editaCadastroCliente(cpf, oqAltera, novoDado);
	}

	public void removeCliente(String cpf) {
		controleCliente.removeCliente(cpf);
	}

	public String adicionaFornecedor(String nome, String email, String telefone) {
		return controleFornecedor.cadastraFornecedor(nome, email, telefone);

	}

	public String exibeFornecedor(String nome) {
		return controleFornecedor.exibeFornecedor(nome);
	}

	public String exibeFornecedores() {
		return controleFornecedor.exibeFornecedoresOrdenados();
	}

	public void editaFornecedor(String nome, String oqAltera, String novoDado) {
		controleFornecedor.editaCadastroFornecedor(nome, oqAltera, novoDado);
	}

	public void removeFornecedor(String nome) {
		controleFornecedor.removeFornecedor(nome);
	}

	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		controleFornecedor.cadastraProduto(fornecedor, nome, descricao, preco);
	}

	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return controleFornecedor.exibeProduto(fornecedor, nome, descricao);
	}

	public String exibeProdutosFornecedor(String fornecedor) {
		return controleFornecedor.exibeTodosProdutosDeUmFornecedor(fornecedor);
	}

	public String exibeProdutos() {
		return controleFornecedor.exibeTodosProdutosOrdenados();
	}

	public void editaProduto(String fornecedor, String nome, String descricao, double novoPreco) {
		controleFornecedor.editaProduto(fornecedor, nome, descricao, novoPreco);
	}

	public void removeProduto(String fornecedor, String nome, String descricao) {
		controleFornecedor.removeProduto(fornecedor, nome, descricao);
	}

	public void adicionaCompra(String cpf, String fornecedor, String data, String nomeProduto,
			String descricaoProduto) {
		controleCliente.adicionaCompra(cpf, fornecedor, nomeProduto, descricaoProduto, data);
	}
	
	public String getDebito(String cpf, String fornecedor) {
		return controleCliente.totalizandoContaFornecedor(cpf, fornecedor);
	}
	
	public String exibeContas(String cpf, String fornecedor) {
		return controleCliente.exibeConta(cpf, fornecedor);
	}
	
	public String exibeContasClientes(String cpf) {
		return controleCliente.exibeTodasAsContasCliente(cpf);
	}

	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produto1e2) {
		controleFornecedor.cadastraCombo(fornecedor, nome, descricao, fator, produto1e2);
	}
	
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		controleFornecedor.editaCombo(nome, descricao, fornecedor, novoFator);
	}
	
	public void realizaPagamento(String cpf, String fornecedor) {
		controleCliente.pagaConta(cpf, fornecedor);
	}

	public static void main(String[] args) {
		args = new String[] { "lab5.Facade", "testesEA/use_case_1.txt", "testesEA/use_case_2.txt",
				"testesEA/use_case_3.txt", "testesEA/use_case_4.txt", "testesEA/use_case_5.txt", "testesEA/use_case_6.txt", "testesEA/use_case_7.txt"};
		EasyAccept.main(args);
	}

}
