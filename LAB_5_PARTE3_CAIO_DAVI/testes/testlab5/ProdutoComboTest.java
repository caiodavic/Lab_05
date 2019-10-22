package testlab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.ProdutoCombo;
import lab5.ProdutoSimples;

class ProdutoComboTest {
	
	ProdutoCombo teste1;
	ProdutoSimples p1;
	ProdutoSimples p2;
	
	@BeforeEach
	void constroiProdutoCombo() {
		 p1 = new ProdutoSimples("X-Tudao", "Tudo por 5", 5.5);
		 p2 = new ProdutoSimples("Coca-Cola", "Refrigerante em Lata", 2.5);
		
		teste1 = new ProdutoCombo("Combo 2", "X-Tudao e Coca-Cola nos preço", 0.15, p1, p2);
		
	}

	@Test
	void testSetPrecoOuFator() {
		teste1.setPrecoOuFator(0.20);
		assertEquals(6.4,teste1.getPreco());
	}

	@Test
	void testGetPreco() {
		assertEquals(6.8, teste1.getPreco());
	}

	@Test
	void testToString() {
		ProdutoSimples p3 = new ProdutoSimples("Tapioca", "Frango e bacon", 4.0);
		ProdutoCombo teste2 = new ProdutoCombo("Combo 3", "Tapioca e Coca-Cola", 0.1, p2, p3);
		String msg1 = "Combo 2 - X-Tudao e Coca-Cola nos preço - R$6,80";
		String msg2 = "Combo 3 - Tapioca e Coca-Cola - R$5,85";
		
		assertEquals(msg1, teste1.toString());
		assertEquals(msg2, teste2.toString());
	}
	
	@Test
	void testHashCode() {
		ProdutoSimples p3 = new ProdutoSimples("Tapioca", "Frango e bacon", 4.0);
		ProdutoCombo teste = new ProdutoCombo("Combo 2", "X-Tudao e Coca-Cola nos preço", 0.3, p1,p2);
		ProdutoCombo teste2 = new ProdutoCombo("Combo 3", "Tapioca e Coca-Cola", 0.1, p2, p3);
		
		assertEquals(teste1.hashCode(), teste.hashCode());
		assertNotEquals(teste1.hashCode(), teste2.hashCode());
		
	}

	@Test
	void testEqualsObject() {
		ProdutoSimples p3 = new ProdutoSimples("Tapioca", "Frango e bacon", 4.0);
		ProdutoCombo teste = new ProdutoCombo("Combo 2", "X-Tudao e Coca-Cola nos preço", 0.3, p1,p2);
		ProdutoCombo teste2 = new ProdutoCombo("Combo 3", "Tapioca e Coca-Cola", 0.1, p2, p3);
		
		assertTrue(teste1.equals(teste));
		assertFalse(teste1.equals(teste2));
	}
	

}
