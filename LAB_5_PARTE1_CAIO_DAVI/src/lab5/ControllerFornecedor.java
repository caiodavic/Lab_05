package lab5;

import java.util.HashMap;

import util.Validacao;

public class ControllerFornecedor {

		private HashMap<String,Fornecedor> fornecedores;
		
		private Validacao validador;
		
		public ControllerFornecedor() {
			this.fornecedores = new HashMap<>();
			this.validador = new Validacao();
			
		}
		
		public String cadastraFornecedor(String nome, String email, String telefone) {
			String nomereturn = "";
						
			validador.validaNulleVazio(nome);
			validador.validaNulleVazio(telefone);
			validador.validaNulleVazio(email);
			
			String chave = concatenaChave(nome);
			
			if(!fornecedores.containsKey(chave)) {
				Fornecedor fornecedoraux = new Fornecedor(nome, email, telefone);
				fornecedores.put(chave, fornecedoraux);
				nomereturn = fornecedores.get(chave).getNome();				
			} else {
				nomereturn = "FORNECEDOR JÁ CADASTRADO!";
			}
			
			return nomereturn;
			
			
		}
		
			private String concatenaChave(String nome) {
			return nome.trim().replace(" ", "").toUpperCase();
			
		}
			
			public String exibeFornecedor(String nome) {
				String msg = "";
				
				validador.validaNulleVazio(nome);
				
				String chave = concatenaChave(nome);
				if (fornecedores.containsKey(chave)) {
					msg = fornecedores.get(chave).toString();
				} else {
					msg = "FORNECEDOR NÃO CADASTRADO!";
				}

				return msg;
			}
		
		
}
