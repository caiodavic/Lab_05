package lab5;

import util.Validacao;

public class Fornecedor {

		private String nome;
		private String email;
		private String telefone;
		
		private Validacao validador;
		
		public Fornecedor(String nome, String email, String telefone) {
			
			validador.validaNulleVazio(nome);
			validador.validaNulleVazio(email);
			validador.validaNulleVazio(telefone);
			this.nome = nome;
			this.email = email;
			this.telefone = telefone;
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
		
		
		
}
