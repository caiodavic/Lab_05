	package lab5;

import util.Validacao;

/**
 * Classe que representa um cliente do sistema SAGA, com Nome, CPF, email e localização. O CPF é seu indetificador único.
 * @author Caio Davi Pereira da Silva - 119110875
 *
 */
public class Cliente {
		
		/**
		 * CPF do cliente.
		 */
		private String cpf;
		/**
		 * Nome do cliente.
		 */
		private String nome;
		/**
		 * Email do cliente.
		 */
		private String email;
		/**
		 *Nome do bloco ou localização onde o cliente trabalha.
		 */
		private String loc;
		
		/**
		 * Objeto da classe validação que verifica se entradas são vazias ou nulas.
		 */
		private Validacao validador;
		
		
		/**
		 * Construtor da classe Cliente, recebendo parâmetros que não podem ser vazios ou nulos. Caso algum seja, lançará uma exceção.
		 * @param cpf CPF do Cliente a ser construido.
		 * @param nome Nome do Cliente a ser construído.
		 * @param email Email do cliente a ser construído.
		 * @param loc Localização do cliente a ser construído.
		 */
		public Cliente(String cpf, String nome, String email, String loc) {
			validador = new Validacao();
				 
			validador.validaNulleVazio(cpf, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo."  );
			validador.validaNulleVazio(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
			validador.validaNulleVazio(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo." );
			validador.validaNulleVazio(loc, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula." );
			validador.validaTamanhoCpf(cpf, "Erro no cadastro do cliente: cpf invalido");
			this.cpf = cpf;
			this.nome = nome;
			this.email = email;
			this.loc = loc;
			
		}
		
		/**
		 * Método de acesso para o CPF do cliente.
		 * @return O CPF do Cliente
		 */
		public String getCpf() {
			return cpf;
		}

		/**
		 * Método de alteração do Nome do Cliente.
		 * @param nome Nome que vai substituir o antigo.
		 */
		public void setNome(String nome) {
			this.nome = nome;
		}


		/**
		 * Método de alteração do Email do Cliente.
		 * @param email Email que vai substituir o antigo.
		 */
		public void setEmail(String email) {
			this.email = email;
		}


		/**
		 * Método de alteração da Localização do Cliente.
		 * @param loc Localização que vai substituir a antiga.
		 */
		public void setLoc(String loc) {
			this.loc = loc;
		}


		/**
		 * Representação textual de  um cliente. Retorna uma String com o Nome, Localização e Email.
		 */
		@Override
		public String toString() {
			return nome + " - " + loc + " - " + email;
		}
		
		/**
		 * HashCode da Classe Cliente. Faz a comparação entre dois objetos do tipo Cliente, e se ambos tiverem o mesmo CPF, retornará  um número inteiro igual
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
			return result;
		}

		
		/**
		 * Método que compara dois objetos do tipo Cliente e retorna true, caso tenham CPF iguais, ou false caso contrário.
		 */
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
