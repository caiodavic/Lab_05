package lab5;

import java.util.HashMap;

import util.Validacao;

public class ControllerCliente {

	private HashMap<String, Cliente> clientes;

	private Validacao validador;

	public ControllerCliente() {
		this.clientes = new HashMap<>();
		this.validador = new Validacao();

	}

	public String cadastraClientes(String cpf, String nome, String email, String loc) {
		String cpfreturn = "";
		
		validador.validaNulleVazio(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo." );
		validador.validaNulleVazio(loc, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula." );
		validador.validaNulleVazio(cpf, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo."  );
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

	public String exibeTodosClientes() {
		String msg = "";

		if (!clientes.isEmpty()) {
			for (Cliente clienteaux : this.clientes.values()) {
				msg += clienteaux.toString() + " | ";

			}
			msg = msg.substring(0, msg.length()-3);
		}
		
		return msg;
	}

	public void editaCadastroCliente(String cpf, String oqAltera, String novoDado) {
		validador.validaNulleVazio(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo." );
		validador.validaNulleVazio(oqAltera, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		validador.validaNulleVazio(novoDado, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.") ;
		
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
				validador.lancaExcecao( "Erro na edicao do cliente: cpf nao pode ser editado.");
				break;

			default:
				validador.lancaExcecao("Erro na edicao do cliente: atributo nao existe.");
				break;
			}
		} else {
			validador.lancaExcecao("Erro na edicao do cliente: cliente nao existe.");
			
		}
	}

	public void removeCliente(String cpf) {
		validador.validaNulleVazio(cpf, "Erro na remocao do cliente: cliente nao existe.");	
		
		if(clientes.containsKey(cpf)) {
				clientes.remove(cpf);
			} else {
				validador.lancaExcecao("Erro na remocao do cliente: cliente nao existe.");
			}
		}

}
