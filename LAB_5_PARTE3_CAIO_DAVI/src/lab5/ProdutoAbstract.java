package lab5;

/**
 * Classe Abstrata da qual Produto e ComboProduto herdam.
 * 
 * @author Caio Davi Pereira da Silva - 119110875
 *
 */
public abstract class ProdutoAbstract implements Produto, Comparable<Produto> {

	/**
	 * Nome do Produto.
	 */
	protected String nome;
	/**
	 * Descrição do Produto.
	 */
	protected String descricao;

	public ProdutoAbstract(String nome, String descricao) {

		this.nome = nome;
		this.descricao = descricao;
	}

	/**
	 * Método de acesso para o nome do Produto.
	 * 
	 * @return O nome do Produto.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método de acesso para a descrição do Produto.
	 * 
	 * @return A descrição do produto.
	 */
	public String getDescricao() {
		return descricao;
	}
	

	/**
	 * Compara o nome doProduto e de outro Produto do sistema e retorna o
	 * inteiro que significa qual vem primeiro na ordem alfabética.
	  * @param o um Objeto do tipo Produto
	 * @return inteiro que significa qual vem primeiro na ordem alfabética.
	 */
	@Override
	public int compareTo(Produto o) {
		return this.nome.compareTo(o.getNome());
	}

	/**
	 * HashCode de Produto. Faz a comparação entre dois objetos do tipo Produto ou
	 * ProdutoCombo, e se ambos tiverem o mesmo Nome e Descrição, retornará um
	 * número inteiro igual.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Método que compara dois objetos do tipo Produto e retorna true, caso tenham
	 * Nomes e Descrição iguais, ou false caso contrário.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoAbstract other = (ProdutoAbstract) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
