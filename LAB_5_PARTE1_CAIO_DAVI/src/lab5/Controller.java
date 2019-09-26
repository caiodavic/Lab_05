package lab5;

import java.util.HashMap;

import util.Validacao;

public class Controller {

		private HashMap<String,Cliente> clientes;
		
		private Validacao validador;
		
		public Controller() {
			this.clientes = new HashMap<>();
			this.validador = new Validacao();
			
			
		}
		
		public String cadastraClientes(String cpf, String nome, String email, String loc) {
			String cpfreturn = ""; 
			
			validador.validaNulleVazio(cpf);
			validador.validaNulleVazio(nome);
			validador.validaNulleVazio(email);
			validador.validaNulleVazio(loc);
			
			if( !clientes.containsKey(cpf)) {
				Cliente clienteaux = new Cliente(cpf,nome,email,loc);
				 clientes.put(cpf, clienteaux);
				 cpfreturn = cpf;
			 } else {
				 
				 cpfreturn = "CPF JÁ CADASTRADO!";
			 }
			
			return cpfreturn;
			
		}
		
		public String exibeCliente(String cpf) {
			String msg = "";
			validador.validaNulleVazio(cpf);
			
			if(clientes.containsKey(cpf)) {
				msg = clientes.get(cpf).toString();
			} else {
				msg = "CPF NÃO CADASTRADO!";
			}
			
			return msg;
		}
		
		public String exibeTodosClientes() {
			String msg = "";
			
			if(!clientes.isEmpty()) {
					for(Cliente clienteaux: this.clientes.values()) {
						msg = clienteaux.toString() + "|";
						
					}
				}
			
			return msg;
			}	
		
		
		
		
}

