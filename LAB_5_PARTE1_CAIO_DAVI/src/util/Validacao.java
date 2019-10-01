package util;

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
	 */
	public void validaNulleVazio(String verifica, String mensagemDeErro) {

		validaNull(verifica, mensagemDeErro);
		validaVazio(verifica, mensagemDeErro);

	}

	/**
	 * Método que verifica o dado inserido, lançando a exceção se o dado for nulo.
	 * 
	 * @param verifica Parametro a ser verificado
	 */
	public void validaNull(String verifica, String mensagemDeErro) {
		if (verifica == null) {
			throw new NullPointerException(mensagemDeErro);

		}

	}

	/**
	 * Método que verifica o dado inserido, lançando a exceção se o dado for vazio.
	 * 
	 * @param verifica Parametro a ser verificado
	 */
	public void validaVazio(String verifica, String mensagemDeErro) {
		if ("".equals(verifica)) {
			throw new IllegalArgumentException(mensagemDeErro);
		}

	}

	public void validaTamanhoCpf(String verifica, String mensagem) {
		if (verifica.length() != 11) {
			throw new IllegalArgumentException(mensagem);
		}

	}

	public void lancaExcecao(String mensagem) {
		throw new IllegalArgumentException(mensagem);
	}

	public void validaInteiro(float preco, String mensagemDeErro) {
		if (preco <= 0) {
			throw new IllegalArgumentException(mensagemDeErro);

		}

	}
}
