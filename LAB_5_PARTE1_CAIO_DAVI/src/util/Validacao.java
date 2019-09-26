package util;

/**
 * Classe que faz a verificação de dados, se o dado é válido.
 * @author Caio Davi Pereira da Silva - 119110875
 *
 */
public class Validacao {
			
	public Validacao() {
		
	}
	
	/**
	 * Método que verifica o dado inserido, lançando a exceção se o dado for nulo ou vazio.
	 * @param verifica Parametro a ser verificado.
	 */
	public void validaNulleVazio(String verifica) {
		
		validaNull(verifica);
		validaVazio(verifica);
		
	}
	
	/**
	 * Método que verifica o dado inserido, lançando a exceção se o dado for nulo.
	 * @param verifica Parametro a ser verificado
	 */
	public void validaNull(String verifica) {
		if(verifica == null) {
			throw new NullPointerException();
			
			
		}
		
	}
	
	/**
	 * Método que verifica o dado inserido, lançando a exceção se o dado for vazio.
	 * @param verifica Parametro a ser verificado
	 */
	public void validaVazio(String verifica) {
		if("".equals(verifica)) {
			throw new IllegalArgumentException();
		}
		
	}

}
