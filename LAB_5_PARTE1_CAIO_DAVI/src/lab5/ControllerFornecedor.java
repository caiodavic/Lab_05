package lab5;

import java.util.HashMap;

import util.Validacao;

public class ControllerFornecedor {

	private HashMap<String, Fornecedor> fornecedores;

	private Validacao validador;

	public ControllerFornecedor() {
		this.fornecedores = new HashMap<>();
		this.validador = new Validacao();

	}

	public String cadastraFornecedor(String nome, String email, String telefone) {
		String nomereturn = "";

		validador.validaNulleVazio(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");

		String chave = concatenaChave(nome);

		if (!fornecedores.containsKey(chave)) {
			Fornecedor fornecedoraux = new Fornecedor(nome, email, telefone);
			fornecedores.put(chave, fornecedoraux);
			nomereturn = fornecedores.get(chave).getNome();
		} else {
			validador.lancaExcecao("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}

		return nomereturn;

	}

	private String concatenaChave(String nome) {
		return nome.trim().replace(" ", "").toUpperCase();

	}

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

	public String exibeTodosFornecedores() {
		String msg = "";

		if (!fornecedores.isEmpty()) {
			for (Fornecedor fornecedoraux : this.fornecedores.values()) {
				msg += fornecedoraux.toString() + "|";

			}
		}

		return msg;
	}

	public void editaCadastroFornecedor(String nome, String oqAltera, String novoDado) {
		validador.validaNulleVazio(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(oqAltera, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(novoDado, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");

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
		}
	}

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

	public void CadastraProduto(String fornecedor, String nome, String descricao, float preco) {
		validador.validaNull(fornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro no cadastro de produto: descricao nao pode ser vazio ou nulo.");
		validador.validaInteiro(preco, "Erro no cadastro de produto: preco invalido.");

		String chave = concatenaChave(fornecedor);

		if (fornecedores.containsKey(chave)) {
			fornecedores.get(chave).cadastraProdutoFornecedor(nome, descricao, preco);
		} else {
			validador.lancaExcecao("Erro no cadastro de produto: fornecedor nao existe.");
		}

	}

	public String exibeProduto(String fornecedor, String nome, String descricao) {
		String msg = "";
		validador.validaNulleVazio(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro na exibicao de produto: descricao nao pode ser vazio ou nulo.");

		String chave = concatenaChave(fornecedor);

		if (fornecedores.containsKey(chave)) {
			msg = fornecedores.get(chave).exibeProdutoFornecedor(nome, descricao);
		} else {
			validador.lancaExcecao("Erro na exibicao de produto: fornecedor nao existe.");
		}

		return msg;
	}

	public String exibeTodosProdutosDeUmFornecedor(String fornecedor) {
		String msg = "";

		validador.validaNulleVazio(fornecedor, "Erro na exibicao de produtos: fornecedor nao pode ser vazio ou nulo.");

		String chave = concatenaChave(fornecedor);

		if (fornecedores.containsKey(chave)) {
			msg = fornecedores.get(chave).exibeTodosProdutosFornecedor();
		}

		return msg;
	}

	public String exibeTodosProdutosExistentes() {
		String msg = "";

		if (!fornecedores.isEmpty()) {
			for (Fornecedor fornecedorAux : fornecedores.values())
				msg += fornecedorAux.exibeTodosProdutosFornecedor() + "|";
		}

		return msg;
	}

	public void editaProduto(String fornecedor, String nome, String descricao, int novoPreco) {

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

		public void removeProduto(String fornecedor, String nome, String descricao){
			
			
			validador.validaNulleVazio(fornecedor,"Erro na remocao do produto: fornecedor nao pode ser vazio ou nulo.");
			validador.validaNulleVazio(nome,"Erro na remocao do produto: nome nao pode ser vazio ou nulo.");
			validador.validaNulleVazio(descricao,"Erro na remocao do produto: descricao nao pode ser vazia ou nula.");
			
			String chave = concatenaChave(fornecedor);
			
			if (fornecedores.containsKey(chave)) {
				fornecedores.get(chave).removeProdutoFornecedor(nome, descricao);
			} else {
				validador.lancaExcecao("Erro na remocao do fornecedor: fornecedor nao existe.");
			}
		}

	}

