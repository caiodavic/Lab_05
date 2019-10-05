package testlab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Produto;

class ProdutoTeste {
	
	Produto teste;
	
	@BeforeEach
	void ConstroiProduto() {
		teste = new Produto("X-Tudao", "Tudo por 5", 5.5);
		
	}
		

	@Test
	void testToString() {
		Produto teste2 = new Produto("Tapioca", "Frango e bacon", 4.0);
		String msg1 = "X-Tudao - Tudo por 5 - R$5,5";
		String msg2 = "Tapioca - Frango e bacon - R$4";
		assertEquals(msg1,teste.toString());
		assertEquals(msg2, teste2.toString());
		
	}
	
	@Test
	void testHashCode() {
		Produto teste2 = new Produto("Tapioca", "Frango e bacon", 4.0);
		Produto teste3 = new Produto("X-Tudao", "Tudo por 5", 4.0);
		
		assertEquals(teste3.hashCode(), teste.hashCode());
		assertNotEquals(teste2.hashCode(), teste.hashCode());
		
	}

	@Test
	void testEqualsObject() {
		Produto teste2 = new Produto("Tapioca", "Frango e bacon", 4.0);
		Produto teste3 = new Produto("X-Tudao", "Tudo por 5", 4.0);
		
		assertTrue(teste.equals(teste3));
		assertFalse(teste.equals(teste2));
	}

}
