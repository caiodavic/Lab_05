package lab5;

import java.util.ArrayList;
import java.util.HashMap;

import util.Validacao;

public class Fornecedor {

	private String nome;
	private String email;
	private String telefone;

	private HashMap<String, Produto> produtos;

	private Validacao validador;

	public Fornecedor(String nome, String email, String telefone) {
		validador = new Validacao();
		
		validador.validaNulleVazio(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		produtos = new HashMap<>();

	}

	public String getNome() {
		return nome;
	}

	public void setEmail(String email) {
		
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return nome + " - " + email + " - " + telefone;
	}

	public void cadastraProdutoFornecedor(String nome, String descricao, double preco) {
		validador.validaNulleVazio(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro no cadastro de produto: descricao nao pode ser vazio ou nulo.");
		validador.validaInteiro(preco, "Erro no cadastro de produto: preco invalido.");

		String chave = concatenaChave(nome, descricao);
		Produto produtoAux = new Produto(nome, descricao, preco);

		if (!produtos.containsKey(chave)) {
			produtos.put(chave, produtoAux);
		} else {
			validador.lancaExcecao("Erro no cadastro de produto: produto ja existe.");
		}

	}

	public String exibeProdutoFornecedor(String nome, String descricao) {
		String msg = "";

		validador.validaNulleVazio(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro na exibicao de produto: descricao nao pode ser vazio ou nulo.");

		String chave = concatenaChave(nome, descricao);

		if (produtos.containsKey(chave)) {
			msg = produtos.get(chave).toString();
		} else {
			validador.lancaExcecao("Erro na exibicao de produto: produto nao existe.");
		}

		return msg;

	}

	public String exibeTodosProdutosFornecedor() {
		String msg = "";
		if (!produtos.isEmpty()) {
			for (Produto produtoAux : this.produtos.values()) {
				msg += nome + " - " + produtoAux.toString() + " | ";
			}
			
			msg = msg.substring(0, msg.length() - 3);
		}

		return msg;
	}

	public void editaProdutoFornecedor(String nome, String descricao, double novoPreco) {
		validador.validaNulleVazio(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		validador.validaInteiro(novoPreco, "Erro na edicao de produto: preco invalido.");
		
		String chave = concatenaChave(nome, descricao);
		
		if(produtos.containsKey(chave)) {
			produtos.get(chave).setPreco(novoPreco);
		}	else {
			validador.lancaExcecao("Erro na edicao de produto: produto nao existe.");
		}
	}
	
	public void removeProdutoFornecedor(String nome, String descricao) {
		validador.validaNulleVazio(nome,"Erro na remocao do produto: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(descricao,"Erro na remocao do produto: descricao nao pode ser vazia ou nula.");
		
		String chave = concatenaChave(nome, descricao);
		
		if(produtos.containsKey(chave)) {
			produtos.remove(chave);
		} else {
			validador.lancaExcecao("Erro na remocao de produto: produto nao existe.");
		}
		
	}

	private String concatenaChave(String nome, String descricao) {
		return (nome + descricao).trim().replace(" ", "").toUpperCase();
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
