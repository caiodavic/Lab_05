package lab5;

public class Facade {

	private ControllerCliente controleCliente;
	private ControllerFornecedor controleFornecedor;

	public Facade() {
		controleCliente = new ControllerCliente();
		controleFornecedor = new ControllerFornecedor();
	}

	public String cadastraClientesFacade(String cpf, String nome, String email, String loc) {
		return controleCliente.cadastraClientes(cpf, nome, email, loc);
	}

	public String exibeClienteFacade(String cpf) {
		return controleCliente.exibeCliente(cpf);
	}

	public String exibeTodosClientesFacade() {
		return controleCliente.exibeTodosClientes();
	}

	public void editaCadastroClienteFacade(String cpf, String oqAltera, String novoDado) {
		controleCliente.editaCadastroCliente(cpf, oqAltera, novoDado);
	}

	public void removeClienteFacade(String cpf) {
		controleCliente.removeCliente(cpf);
	}

	public String cadastraFornecedorFacade(String nome, String email, String telefone) {
		return controleFornecedor.cadastraFornecedor(nome, email, telefone);

	}

	public String exibeFornecedorFacade(String nome) {
		return controleFornecedor.exibeFornecedor(nome);
	}

	public String exibeTodosFornecedoresFacade() {
		return controleFornecedor.exibeTodosFornecedores();
	}

	public void editaCadastroFornecedorFacade(String nome, String oqAltera, String novoDado) {
		controleFornecedor.editaCadastroFornecedor(nome, oqAltera, novoDado);
	}

	public void removeFornecedorFacade(String nome) {
		controleFornecedor.removeFornecedor(nome);
	}
	
	public void cadastraProdutoFacade(String fornecedor, String nome, String descricao, double preco) {
		controleFornecedor.cadastraProduto(fornecedor, nome, descricao, preco);
		}
	
	public String exibeProdutoFacade(String fornecedor, String nome, String descricao) {
		return controleFornecedor.exibeProduto(fornecedor, nome, descricao);
	}
	
	public String exibeTodosProdutosDeUmFornecedorFacade(String fornecedor) {
		return controleFornecedor.exibeTodosProdutosDeUmFornecedor(fornecedor);
	}
	
	public String exibeTodosProdutosExistentesFacade() {
		return controleFornecedor.exibeTodosProdutosExistentes();
	}
	
	public void editaProduto(String fornecedor, String nome, String descricao, double novoPreco) {
		controleFornecedor.editaProduto(fornecedor, nome, descricao, novoPreco);
	}
	
	public void removeProduto(String fornecedor, String nome, String descricao){
		controleFornecedor.removeProduto(fornecedor, nome, descricao);
	}
	
	
	
	
	
	
	
	
	
	
	

}
