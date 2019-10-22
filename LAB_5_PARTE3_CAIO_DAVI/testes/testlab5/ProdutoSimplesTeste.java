package testlab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.ProdutoSimples;

class ProdutoSimplesTeste {
	
	ProdutoSimples teste;
	
	@BeforeEach
	void constroiProdutoSimples() {
		teste = new ProdutoSimples("X-Tudao", "Tudo por 5", 5.5);
		
	}
		

	@Test
	void testToString() {
		ProdutoSimples teste2 = new ProdutoSimples("Tapioca", "Frango e bacon", 4.0);
		String msg1 = "X-Tudao - Tudo por 5 - R$5,50";
		String msg2 = "Tapioca - Frango e bacon - R$4,00";
		assertEquals(msg1,teste.toString());
		assertEquals(msg2, teste2.toString());
		
	}
	
	@Test
	void testSetPrecoOuFator() {
		teste.setPrecoOuFator(6);
		assertEquals(6,teste.getPreco());
	}
	
	@Test
	void testHashCode() {
		ProdutoSimples teste2 = new ProdutoSimples("Tapioca", "Frango e bacon", 4.0);
		ProdutoSimples teste3 = new ProdutoSimples("X-Tudao", "Tudo por 5", 4.0);
		
		assertEquals(teste3.hashCode(), teste.hashCode());
		assertNotEquals(teste2.hashCode(), teste.hashCode());
		
	}

	@Test
	void testEqualsObject() {
		ProdutoSimples teste2 = new ProdutoSimples("Tapioca", "Frango e bacon", 4.0);
		ProdutoSimples teste3 = new ProdutoSimples("X-Tudao", "Tudo por 5", 4.0);
		
		assertTrue(teste.equals(teste3));
		assertFalse(teste.equals(teste2));
	}
	

}
