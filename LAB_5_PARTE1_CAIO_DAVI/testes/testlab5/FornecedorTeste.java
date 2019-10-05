package testlab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Fornecedor;

class FornecedorTeste {

	Fornecedor teste;

	@BeforeEach
	void constroiFornecedor() {
		teste = new Fornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", "901010101");
	}

	@Test
	void TestConstroiFornecedorNomeVaziouOuNulo() {
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("", "seuolavo@ufcg.edu.br", "911223344"));
		assertThrows(NullPointerException.class, () -> new Fornecedor(null, "seuolavo@ufcg.edu.br", "911223344"));
	}

	@Test
	void testConstroiFornecedorEmailVazioOuNull() {
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Seu Olavo", "", "911223344"));
		assertThrows(NullPointerException.class, () -> new Fornecedor("Seu Olavo", null, "911223344"));
	}

	@Test
	void testeConstroiTelefoneEmailVazioOuNull() {
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", ""));
		assertThrows(NullPointerException.class, () -> new Fornecedor("Seu Olavo", "seuolavo@ufcg.edu.br", null));
	}

	@Test
	void testToString() {
		String msg1 = "Seu Olavo - seuolavo@ufcg.edu.br - 901010101";
		assertEquals(msg1, teste.toString());
	}

	@Test
	void testCadastraProdutoFornecedorCorreto() {
		teste.cadastraProdutoFornecedor("X-Tudao", "Tudo por 5", 5);
		teste.cadastraProdutoFornecedor("Tapioca", "Frango e Bacon", 3.5);
	}

	@Test
	void testCadastraProdutoFornecedorNomeVazioOuNull() {
		assertThrows(IllegalArgumentException.class, () -> teste.cadastraProdutoFornecedor("", "Tudo por 5", 5));
		assertThrows(NullPointerException.class, () -> teste.cadastraProdutoFornecedor(null, "Tudo por 5", 5));
	}
	
	@Test
	void testCadastraProdutoFornecedorDescricaoVazioOuNull() {
		assertThrows(IllegalArgumentException.class, () -> teste.cadastraProdutoFornecedor("Tapioca", "", 3.5));
		assertThrows(NullPointerException.class, () -> teste.cadastraProdutoFornecedor("Tapioca", null, 3.5));
	}
	
	@Test
	void testCadastraProdutoFornecedorPrecoInvalido() {
		assertThrows(IllegalArgumentException.class, () -> teste.cadastraProdutoFornecedor("Tapioca", "Frango e Bacon", 0));
		assertThrows(IllegalArgumentException.class, () -> teste.cadastraProdutoFornecedor("Tapioca", "Frango e Bacon", -3));
	}
	
	@Test
	void testCadastraProdutoFornecedorJaExiste() {
		teste.cadastraProdutoFornecedor("Tapioca", "Frango e Bacon", 3.5);
		assertThrows(IllegalArgumentException.class, () -> teste.cadastraProdutoFornecedor("Tapioca", "Frango e Bacon", 4.5));
	}
	
	@Test
	void testExibeProdutoFornecedorCorreto() {
		teste.cadastraProdutoFornecedor("X-Tudao", "Tudo por 5", 5.50);

		String msg1 = "X-Tudao - Tudo por 5 - R$5,5";
		assertEquals(msg1, teste.exibeProdutoFornecedor("X-Tudao", "Tudo por 5"));
	}
	
	@Test
	void testExibeProdutoFornecedorNomeVazioOuNulo() {
		teste.cadastraProdutoFornecedor("X-Tudao", "Tudo por 5", 5.50);

		assertThrows(IllegalArgumentException.class, ()-> teste.exibeProdutoFornecedor("", "Tudo por 5"));
		assertThrows(NullPointerException.class, ()-> teste.exibeProdutoFornecedor(null, "Tudo por 5"));
	}
	
	@Test
	void testeExibeProdutoFornecedorDescricaoVazioOuNulo() {
		teste.cadastraProdutoFornecedor("X-Tudao", "Tudo por 5", 5.50);

		assertThrows(IllegalArgumentException.class, ()-> teste.exibeProdutoFornecedor("X-Tudao", ""));
		assertThrows(NullPointerException.class, ()-> teste.exibeProdutoFornecedor("X-Tudao", null));

	}
	
	@Test
	void testeExibeProdutoFornecedorProdutoNaoExiste() {
		teste.cadastraProdutoFornecedor("X-Tudao", "Tudo por 5", 5.50);

		assertThrows(IllegalArgumentException.class, ()-> teste.exibeProdutoFornecedor("X-Burger", "Bacon"));
		

	}

	@Test
	void testExibeTodosProdutosFornecedor() {
		teste.cadastraProdutoFornecedor("X-Tudao", "Tudo por 5", 5.50);
		teste.cadastraProdutoFornecedor("Tapioca", "Frango e Bacon", 3.5);
		
		String msg1 = "X-Tudao - Tudo por 5 - R$5,5";
		String msg2 = "Tapioca - Frango e Bacon - R$3,5";
		
		assertTrue(teste.exibeTodosProdutosFornecedor().contains(msg2));
		assertTrue(teste.exibeTodosProdutosFornecedor().contains(msg1));
	}

	@Test
	void testEditaProdutoCorreto() {
		
		teste.cadastraProdutoFornecedor("X-Tudao", "Tudo por 5", 5.5);
		teste.cadastraProdutoFornecedor("X-Bacon", "Bem gostoso", 7.5);
		
		teste.editaProdutoFornecedor("X-Tudao", "Tudo por 5", 4.5);
		
		String msg1 = "X-Tudao - Tudo por 5 - R$4,5";
		
		assertEquals(msg1, teste.exibeProdutoFornecedor("X-Tudao", "Tudo por 5"));
		
		teste.editaProdutoFornecedor("X-Bacon", "Bem gostoso", 6.5);
		
		String msg2 = "X-Bacon - Bem gostoso - R$6,5";
		
		assertEquals(msg2, teste.exibeProdutoFornecedor("X-Bacon", "Bem gostoso"));
				
	}
	
		
	@Test
	void testEditaProdutoNullOuVazio() {
		
		teste.cadastraProdutoFornecedor("X-Tudao", "Tudo por 5", 5.5);
		
		assertThrows(IllegalArgumentException.class,()->teste.editaProdutoFornecedor("", "Tudo por 5", 4.5));
		assertThrows(NullPointerException.class, ()-> teste.editaProdutoFornecedor(null, "Tudo por 5", 4.5));
			
	}
	
	@Test
	void testEditaDescricaoNullOuVazio() {
		
		teste.cadastraProdutoFornecedor("X-Tudao", "Tudo por 5", 5.5);
		
		assertThrows(IllegalArgumentException.class,()->teste.editaProdutoFornecedor("X-Tudao", "", 4.5));
		assertThrows(NullPointerException.class, ()-> teste.editaProdutoFornecedor("X-Tudao", null, 4.5));
			
	}
	
	@Test
	void testEditaPrecoInvalido() {
		
		teste.cadastraProdutoFornecedor("X-Tudao", "Tudo por 5", 5.5);
		
		assertThrows(IllegalArgumentException.class,()->teste.editaProdutoFornecedor("X-Tudao", "Tudo por 5", 0));
		assertThrows(IllegalArgumentException.class,()->teste.editaProdutoFornecedor("X-Tudao", "Tudo por 5", -1));
			
	}
	
	@Test
	void testEditaProdutoNaoExiste() {
		
		teste.cadastraProdutoFornecedor("X-Tudao", "Tudo por 5", 5.5);
		
		assertThrows(IllegalArgumentException.class,()->teste.editaProdutoFornecedor("X-Bacon", "Tudo por 5", 0));
					
	}
	
	@Test
	void testRemoveProdutoCorretoFornecedor() {
		
		teste.cadastraProdutoFornecedor("X-Tudao", "Tudo por 5", 5.5);
		
		teste.removeProdutoFornecedor("X-Tudao", "Tudo por 5");
		
		String msg1 = "X-Tudao - Tudo por 5 - R$5,5";
		
		assertFalse(teste.exibeTodosProdutosFornecedor().contains(msg1));
	}
	
	
	@Test
	void testRemoveProdutoFornecedorNomeNuloOuVazio() {
		teste.cadastraProdutoFornecedor("X-Tudao", "Tudo por 5", 5.5);
		
		assertThrows(IllegalArgumentException.class,()->teste.removeProdutoFornecedor( "", "Tudo por 5"));
		assertThrows(NullPointerException.class,()->teste.removeProdutoFornecedor(null, "Tudo por 5"));
		
	}
	
	@Test
	void testRemoveProdutoFornecedorDescricaoNuloOuVazio() {
		
		teste.cadastraProdutoFornecedor("X-Tudao", "Tudo por 5", 5.5);
		
		assertThrows(IllegalArgumentException.class,()->teste.removeProdutoFornecedor("X-Tudao", ""));
		assertThrows(NullPointerException.class,()->teste.removeProdutoFornecedor("X-Tudao", null));
		
	}
	
	@Test
	void testRemoveProdutoFornecedorProdutoNaoExiste() {

		teste.cadastraProdutoFornecedor("X-Tudao", "Tudo por 5", 5.5);
		
		assertThrows(IllegalArgumentException.class,()->teste.removeProdutoFornecedor("X-Tudao", ""));
				
	}	
	

	@Test
	void testHashCode() {
		Fornecedor teste2 = new Fornecedor("Seu Olavo", "olavo@ufcg.edu.br", "912121212");
		assertEquals(teste.hashCode(), teste2.hashCode());
	}

	@Test
	void testEqualsObject() {
		Fornecedor teste2 = new Fornecedor("Seu Olavo", "olavo@ufcg.edu.br", "912121212");
		assertTrue(teste.equals(teste2));
	}

}
