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

		@Override
		public String toString() {
			return nome + " - " + email + " - " + telefone;
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
