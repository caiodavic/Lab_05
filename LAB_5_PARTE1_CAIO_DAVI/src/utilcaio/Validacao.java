package utilcaio;

/**
 * Classe que faz a verificação de dados, se o dado é válido.
 * 
 * @author Caio Davi Pereira da Silva - 119110875
 *
 */
public class Validacao {

	public Validacao() {

	}

	/**
	 * Método que verifica o dado inserido, lançando a exceção se o dado for nulo ou
	 * vazio.
	 * 
	 * @param verifica Parametro a ser verificado.
	 * @param mensagem Mensagem de erro que será lançada junto com o tipo do erro.
	 */
	public void validaNulleVazio(String verifica, String mensagemDeErro) {
		
		validaNull(verifica, mensagemDeErro);
		validaVazio(verifica, mensagemDeErro);

	}

	/**
	 * Método que verifica o dado inserido, lançando a exceção se o dado for nulo.
	 * 
	 * @param verifica Parametro a ser verificado.
	 * @param mensagem Mensagem de erro que será lançada junto com o tipo do erro
	 */
	public void validaNull(String verifica, String mensagemDeErro) {
		
		if (verifica == null) {
			throw new NullPointerException(mensagemDeErro);

		}

	}

	/**
	 * Método que verifica o dado inserido, lançando a exceção se o dado for vazio.
	 * 
	 * @param verifica Parametro a ser verificado.
	 * @param mensagem Mensagem de erro que será lançada junto com o tipo do erro
	 */
	public void validaVazio(String verifica, String mensagemDeErro) {
		
		if ("".equals(verifica)) {
			throw new IllegalArgumentException(mensagemDeErro);
		}

	}
	
	/**
	 * Método que verifica o tamanho do CPF, se for diferente de 11 digitos, lançara exceção.
	 * @param verifica Parametro a ser verificado.
	 * @param mensagem Mensagem de erro que será lançada junto com o tipo do erro
	 */
	public void validaTamanhoCpf(String verifica, String mensagem) {
		if (verifica.length() != 11) {
			throw new IllegalArgumentException(mensagem);
		}

	}
	
	/**
	 * Método que lança um erro se verificado algum erro durante a execução do código do SAGA
	 * @param mensagem
	 */
	public void lancaExcecao(String mensagem) {
		throw new IllegalArgumentException(mensagem);
	}

	public void validaInteiro(double preco, String mensagemDeErro) {
		if (preco <= 0) {
			throw new IllegalArgumentException(mensagemDeErro);

		}

	}
}