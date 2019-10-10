package lab5;

import easyaccept.EasyAccept;

public class Facade {

	private ControllerCliente controleCliente;
	private ControllerFornecedor controleFornecedor;

	public Facade() {
		controleCliente = new ControllerCliente();
		controleFornecedor = new ControllerFornecedor();
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
	
	public void removeProduto(String fornecedor, String nome, String descricao){
		controleFornecedor.removeProduto(fornecedor, nome, descricao);
	}
	
	public static void main(String[] args) {
		args = new String[] {"lab5.Facade", "testesEA/use_case_1.txt", "testesEA/use_case_2.txt", "testesEA/use_case_3.txt" , "testesEA/use_case_4.txt"};
		EasyAccept.main(args);
	}
	
	
	
	
	
	
	
	
	
	

}
