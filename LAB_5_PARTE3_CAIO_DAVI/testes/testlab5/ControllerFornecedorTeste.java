package testlab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.ControllerFornecedor;

class ControllerFornecedorTeste {

	ControllerFornecedor teste;

	@BeforeEach
	void constroiController() {
		teste = new ControllerFornecedor();

	}

	@Test
	void testCadastraFornecedorCorreto() {
		assertEquals("Seu Olavo", teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344"));
	}

	@Test
	void testCadastraFornecedorNomeVazioOuNull() {
		assertThrows(IllegalArgumentException.class,
				() -> teste.cadastraFornecedor("", "seuolavo@ufcg.edu.br", "911223344"));
		assertThrows(NullPointerException.class,
				() -> teste.cadastraFornecedor(null, "seuolavo@ufcg.edu.br", "911223344"));
	}

	@Test
	void testCadastraFornecedorEmailVazioOuNull() {
		assertThrows(IllegalArgumentException.class, () -> teste.cadastraFornecedor("Seu Olavo", "", "911223344"));
		assertThrows(NullPointerException.class, () -> teste.cadastraFornecedor("Seu Olavo", null, "911223344"));
	}

	@Test
	void testCadastraFornecedorTelefoneVazioOuNull() {
		assertThrows(IllegalArgumentException.class,
				() -> teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", ""));
		assertThrows(NullPointerException.class,
				() -> teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", null));
	}

	@Test
	void testCadastraFornecedorJaExistente() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		assertThrows(IllegalArgumentException.class,
				() -> teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "913131313"));
		assertThrows(IllegalArgumentException.class,
				() -> teste.cadastraFornecedor("Seu Olavo", "lanchao@ufcg.edu.br", "966887755"));
		assertThrows(IllegalArgumentException.class,
				() -> teste.cadastraFornecedor("Seu Olavo", "hamburguer@ufcg.edu.br", "901011010"));
	}

	@Test
	void testExibeFornecedorCorreta() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraFornecedor("Seu Helio", "seuhelio@ufcg.edu.br", "901010101");
		String msg1 = "Seu Olavo - seuolavo@ufcg.edu.br - 911223344";
		String msg2 = "Seu Helio - seuhelio@ufcg.edu.br - 901010101";

		assertEquals(msg1, teste.exibeFornecedor("Seu Olavo"));
		assertEquals(msg2, teste.exibeFornecedor("Seu Helio"));

	}

	@Test
	void testExibeFornecedorNomeVazioOuNulo() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");

		assertThrows(IllegalArgumentException.class, () -> teste.exibeFornecedor(""));
		assertThrows(NullPointerException.class, () -> teste.exibeFornecedor(null));

	}

	@Test
	void testExibeFornecedorNaoExiste() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");

		assertThrows(IllegalArgumentException.class, () -> teste.exibeFornecedor("Seu Helio"));
	}
	
	/**
	 * 
	 *
	@Test
	void testExibeTodosFornecedores() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraFornecedor("Seu Helio", "seuhelio@ufcg.edu.br", "901010101");

		String msg1 = "Seu Olavo - seuolavo@ufcg.edu.br - 911223344";
		String msg2 = "Seu Helio - seuhelio@ufcg.edu.br - 901010101";

		assertTrue(teste.exibeTodosFornecedores().contains(msg1));
		assertTrue(teste.exibeTodosFornecedores().contains(msg2));

	}
   */
	
	@Test
	void testEditaCadastroFornecedorEmail() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.editaCadastroFornecedor("Seu Olavo", "email", "melhor.lanche@ufcg.edu.br");

		String msg1 = "Seu Olavo - melhor.lanche@ufcg.edu.br - 911223344";

		assertEquals(msg1, teste.exibeFornecedor("Seu Olavo"));
	}

	@Test
	void testEditaCadastroFornecedorTelefone() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.editaCadastroFornecedor("Seu Olavo", "telefone", "944332211");

		String msg1 = "Seu Olavo - seuolavo@ufcg.edu.br - 944332211";

		assertEquals(msg1, teste.exibeFornecedor("Seu Olavo"));
	}

	@Test
	void testEditaCadastroFornecedorNomeNullOuVazio() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		assertThrows(IllegalArgumentException.class,
				() -> teste.editaCadastroFornecedor("", "email", "melhor.lanche@ufcg.edu.br"));
		assertThrows(NullPointerException.class,
				() -> teste.editaCadastroFornecedor(null, "email", "melhor.lanche@ufcg.edu.br"));
	}

	@Test
	void testEditaCadastroFornecedorAtributoNullOuVazio() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		assertThrows(IllegalArgumentException.class,
				() -> teste.editaCadastroFornecedor("Seu Olavo", "", "melhor.lanche@ufcg.edu.br"));
		assertThrows(NullPointerException.class,
				() -> teste.editaCadastroFornecedor("Seu Olavo", null, "melhor.lanche@ufcg.edu.br"));
	}

	@Test
	void testEditaCadastroFornecedorNovoDadoNullOuVazio() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		assertThrows(IllegalArgumentException.class, () -> teste.editaCadastroFornecedor("Seu Olavo", "email", ""));
		assertThrows(NullPointerException.class, () -> teste.editaCadastroFornecedor("Seu Olavo", "email", null));
	}

	@Test
	void testEditaCadastroFornecedorEditaNome() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		assertThrows(IllegalArgumentException.class, () -> teste.editaCadastroFornecedor("Seu Olavo", "nome", "Olavo"));

	}

	@Test
	void testEditaCadastroFornecedorAtributoNaoExiste() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		assertThrows(IllegalArgumentException.class,
				() -> teste.editaCadastroFornecedor("Seu Olavo", "localizacao", "CAA"));

	}

	@Test
	void testEditaCadastroFornecedorNaoExiste() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		assertThrows(IllegalArgumentException.class,
				() -> teste.editaCadastroFornecedor("Dona Olavia", "nome", "Olavo"));

	}

	/**
	 * 
	 *
	@Test
	void testRemoveFornecedorCorreto() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraFornecedor("Seu Helio", "seuhelio@ufcg.edu.br", "901010101");

		teste.removeFornecedor("Seu Olavo");

		assertFalse(teste.exibeFornecedoresOrdenados().contains("Seu Olavo"));

		teste.removeFornecedor("Seu Helio");

		assertFalse(teste.exibeFornecedoresOrdenados().contains("Seu Helio"));

	}
	*/
	
	
	@Test
	void testCadastraProdutoCorreto() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5);
	}

	@Test
	void testCadastraProdutoFornecedorVaziouOuNulo() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		assertThrows(IllegalArgumentException.class, () -> teste.cadastraProduto("", "X-Tudao", "Tudo por 5", 5));
		assertThrows(NullPointerException.class, () -> teste.cadastraProduto(null, "X-Tudao", "Tudo por 5", 5));
	}

	@Test
	void testCadastraProdutoNomeVazioOuNulo() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		assertThrows(IllegalArgumentException.class, () -> teste.cadastraProduto("Seu Olavo", "", "Tudo por 5", 5));
		assertThrows(NullPointerException.class, () -> teste.cadastraProduto("Seu Olavo", null, "Tudo por 5", 5));
	}

	@Test
	void testCadastraProdutoDescricaoVazioOuNulo() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		assertThrows(IllegalArgumentException.class, () -> teste.cadastraProduto("Seu Olavo", "X-Tudao", "", 5));
		assertThrows(NullPointerException.class, () -> teste.cadastraProduto("Seu Olavo", "X-Tudao", null, 5));
	}

	@Test
	void testCadastraProdutoPrecoVazioOuNulo() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		assertThrows(IllegalArgumentException.class,
				() -> teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 0));
		assertThrows(IllegalArgumentException.class,
				() -> teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", -2));

	}

	@Test
	void testCadastraProdutoFornecedorNaoExiste() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		assertThrows(IllegalArgumentException.class,
				() -> teste.cadastraProduto("Seu Helio", "X-Tudao", "Tudo por 5", 5));

	}

	@Test
	void testExibeProdutoCorreto() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5.50);

		String msg1 = "X-Tudao - Tudo por 5 - R$5,5";
		assertEquals(msg1, teste.exibeProduto("Seu Olavo", "X-Tudao", "Tudo por 5"));
	}

	@Test
	void testExibeProdutoFornecedorNuloOuVazio() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5);

		assertThrows(IllegalArgumentException.class, () -> teste.exibeProduto("", "X-Tudao", "Tudo por 5"));
		assertThrows(NullPointerException.class, () -> teste.exibeProduto(null, "X-Tudao", "Tudo por 5"));

	}

	@Test
	void testExibeProdutoNomeNuloOuVazio() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5);

		assertThrows(IllegalArgumentException.class, () -> teste.exibeProduto("Seu Olavo", "", "Tudo por 5"));
		assertThrows(NullPointerException.class, () -> teste.exibeProduto("Seu Olavo", null, "Tudo por 5"));
	}

	@Test
	void testExibeProdutoDescricaoNuloOuVazio() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5);

		assertThrows(IllegalArgumentException.class, () -> teste.exibeProduto("Seu Olavo", "X-Tudao", ""));
		assertThrows(NullPointerException.class, () -> teste.exibeProduto("Seu Olavo", "X-Tudao", null));
	}

	@Test
	void testExibeProdutoFornecedorNaoExiste() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5);

		assertThrows(IllegalArgumentException.class, () -> teste.exibeProduto("Seu Helio", "X-Tudao", "Tudo por 5"));
	}

	@Test
	void testExibeTodosProdutosDeUmFornecedorCorreto() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5.5);
		teste.cadastraProduto("Seu Olavo", "X-Bacon", "Bem gostoso", 7.5);
		teste.cadastraProduto("Seu Olavo", "Coxinha", "Crocante e Saborosa", 3.25);
		
		String msg1 = "Seu Olavo - X-Tudao - Tudo por 5 - R$5,5";
		String msg2 = "Seu Olavo - X-Bacon - Bem gostoso - R$7,5";
		String msg3 = "Seu Olavo - Coxinha - Crocante e Saborosa - R$3,25";
		
				
		assertTrue(teste.exibeTodosProdutosDeUmFornecedor("Seu Olavo").contains(msg1));
		assertTrue(teste.exibeTodosProdutosDeUmFornecedor("Seu Olavo").contains(msg2));
		assertTrue(teste.exibeTodosProdutosDeUmFornecedor("Seu Olavo").contains(msg3));
		
	}
	
	@Test
	void testExibeTodosProdutosDeUmFornecedorVaziouOuNull() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5.5);
		teste.cadastraProduto("Seu Olavo", "X-Bacon", "Bem gostoso", 7.5);
		teste.cadastraProduto("Seu Olavo", "Coxinha", "Crocante e Saborosa", 3.25);
		
		assertThrows(IllegalArgumentException.class, ()-> teste.exibeTodosProdutosDeUmFornecedor(""));
		assertThrows(NullPointerException.class, ()-> teste.exibeTodosProdutosDeUmFornecedor(null));
	}
	
	@Test
	void testExibeTodosProdutosDeUmFornecedorNaoExiste() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5.5);
		teste.cadastraProduto("Seu Olavo", "X-Bacon", "Bem gostoso", 7.5);
		teste.cadastraProduto("Seu Olavo", "Coxinha", "Crocante e Saborosa", 3.25);
		
		assertThrows(IllegalArgumentException.class, () -> teste.exibeProduto("Seu Helio", "X-Tudao", "Tudo por 5"));
	}

	@Test
	void testExibeTodosProdutosExistentes() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraFornecedor("Seu Helio", "seuhelio@ufcg.edu.br", "901010101");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5.5);
		teste.cadastraProduto("Seu Olavo", "X-Bacon", "Bem gostoso", 7.5);
		teste.cadastraProduto("Seu Olavo", "Coxinha", "Crocante e Saborosa", 3.25);
		teste.cadastraProduto("Seu Helio", "Tapioca", "Frango e Queijo", 3.5);
		teste.cadastraProduto("Seu Helio", "Folhado", "Crocante e Gostoso", 2.5);
		
		String msg1 = "Seu Olavo - X-Tudao - Tudo por 5 - R$5,5";
		String msg2 = "Seu Olavo - X-Bacon - Bem gostoso - R$7,5";
		String msg3 = "Seu Olavo - Coxinha - Crocante e Saborosa - R$3,25";
		String msg4 = "Seu Helio - Tapioca - Frango e Queijo - R$3,5";
		String msg5 = "Seu Helio - Folhado - Crocante e Gostoso - R$2,5";
		
		
		
		assertTrue(teste.exibeTodosProdutosExistentes().contains(msg1));
		assertTrue(teste.exibeTodosProdutosExistentes().contains(msg2));
		assertTrue(teste.exibeTodosProdutosExistentes().contains(msg3));
		assertTrue(teste.exibeTodosProdutosExistentes().contains(msg4));
		assertTrue(teste.exibeTodosProdutosExistentes().contains(msg5));
	}

	@Test
	void testEditaProdutoCorreto() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5.5);
		teste.cadastraProduto("Seu Olavo", "X-Bacon", "Bem gostoso", 7.5);
		
		teste.editaProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 4.5);
		
		String msg1 = "X-Tudao - Tudo por 5 - R$4,5";
		
		assertEquals(msg1, teste.exibeProduto("Seu Olavo", "X-Tudao", "Tudo por 5"));
		
		teste.editaProduto("Seu Olavo", "X-Bacon", "Bem gostoso", 6.5);
		
		String msg2 = "X-Bacon - Bem gostoso - R$6,5";
		
		assertEquals(msg2, teste.exibeProduto("Seu Olavo", "X-Bacon", "Bem gostoso"));
				
	}
	
	@Test
	void testEditaProdutoFornecedorNullOuVazio() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5.5);
		
		assertThrows(IllegalArgumentException.class,()->teste.editaProduto("", "X-Tudao", "Tudo por 5", 4.5));
		assertThrows(NullPointerException.class, ()-> teste.editaProduto(null, "X-Tudao", "Tudo por 5", 4.5));
			
	}
	
	@Test
	void testEditaProdutoNullOuVazio() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5.5);
		
		assertThrows(IllegalArgumentException.class,()->teste.editaProduto("Seu Olavo", "", "Tudo por 5", 4.5));
		assertThrows(NullPointerException.class, ()-> teste.editaProduto("Seu Olavo", null, "Tudo por 5", 4.5));
			
	}
	
	@Test
	void testEditaDescricaoNullOuVazio() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5.5);
		
		assertThrows(IllegalArgumentException.class,()->teste.editaProduto("Seu Olavo", "X-Tudao", "", 4.5));
		assertThrows(NullPointerException.class, ()-> teste.editaProduto("Seu Olavo", "X-Tudao", null, 4.5));
			
	}
	
	@Test
	void testEditaPrecoInvalido() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5.5);
		
		assertThrows(IllegalArgumentException.class,()->teste.editaProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 0));
		assertThrows(IllegalArgumentException.class,()->teste.editaProduto("Seu Olavo", "X-Tudao", "Tudo por 5", -1));
			
	}
	
	@Test
	void testEditaFornecedorNaoExiste() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5.5);
		
		assertThrows(IllegalArgumentException.class,()->teste.editaProduto("Seu Helio", "X-Tudao", "Tudo por 5", 4.5));
			
	}
		

	@Test
	void testRemoveProdutoCorreto() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5.5);
		
		teste.removeProduto("Seu Olavo", "X-Tudao", "Tudo por 5");
		
		String msg1 = "X-Tudao - Tudo por 5 - R$5,5";
		
		assertFalse(teste.exibeTodosProdutosDeUmFornecedor("Seu Olavo").contains(msg1));
	}
	
	@Test
	void testRemoveProdutoFornecedorNuloOuVazio() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5.5);
		
		assertThrows(IllegalArgumentException.class,()->teste.removeProduto("", "X-Tudao", "Tudo por 5"));
		assertThrows(NullPointerException.class,()->teste.removeProduto(null, "X-Tudao", "Tudo por 5"));
		
	}
	
	@Test
	void testRemoveProdutoNomeNuloOuVazio() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5.5);
		
		assertThrows(IllegalArgumentException.class,()->teste.removeProduto("Seu Olavo", "", "Tudo por 5"));
		assertThrows(NullPointerException.class,()->teste.removeProduto("Seu Olavo", null, "Tudo por 5"));
		
	}
	
	@Test
	void testRemoveProdutoDescricaoNuloOuVazio() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5.5);
		
		assertThrows(IllegalArgumentException.class,()->teste.removeProduto("Seu Olavo", "X-Tudao", ""));
		assertThrows(NullPointerException.class,()->teste.removeProduto("Seu Olavo", "X-Tudao", null));
		
	}
	
	@Test
	void testRemoveFornecedorNaoExiste() {
		teste.cadastraFornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "911223344");
		teste.cadastraProduto("Seu Olavo", "X-Tudao", "Tudo por 5", 5.5);
		
		assertThrows(IllegalArgumentException.class,()->teste.removeProduto("Seu Helio", "X-Tudao", ""));
		
		
	}
	

}
