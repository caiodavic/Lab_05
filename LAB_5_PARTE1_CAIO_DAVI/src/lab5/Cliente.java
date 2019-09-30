package lab5;

import util.Validacao;

public class Cliente {

		private String cpf;
		private String nome;
		private String email;
		private String loc;
		
		private Validacao validador;
		
		public Cliente(String cpf, String nome, String email, String loc) {
			validador = new Validacao();
				 
			validador.validaNulleVazio(cpf);
			validador.validaNulleVazio(nome);
			validador.validaNulleVazio(email);
			validador.validaNulleVazio(loc);
			
			this.cpf = cpf;
			this.nome = nome;
			this.email = email;
			this.loc = loc;
			
		}
		

		public String getCpf() {
			return cpf;
		}

		
		public void setNome(String nome) {
			this.nome = nome;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public void setLoc(String loc) {
			this.loc = loc;
		}



		@Override
		public String toString() {
			return nome + "-" + loc + "-" + email;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
			Cliente other = (Cliente) obj;
			if (cpf == null) {
				if (other.cpf != null)
					return false;
			} else if (!cpf.equals(other.cpf))
				return false;
			return true;
		}



		
		
		
}
