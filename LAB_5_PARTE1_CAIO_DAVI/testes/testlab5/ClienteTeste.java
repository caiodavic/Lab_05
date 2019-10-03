package testlab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Cliente;

class ClienteTeste {

	Cliente cliente1;

	@BeforeEach
	void testConstroiCliente() {
		cliente1 = new Cliente("12345678900", "Caio Davi", "caioodavi@gmail.com", "CAA");
	}

	@Test
	void testConstroiClienteNomeVazioeNulo() {

		try {
			Cliente cliente2 = new Cliente("12345678900", "", "caioodavi@gmail.com", "CAA");
			fail("Era esperada uma exceção");
		} catch (IllegalArgumentException iae) {

		}

		try {
			Cliente cliente3 = new Cliente("12345678900", null, "caioodavi@gmail.com", "CAA");
			fail("Era esperada uma exceção");
		} catch (NullPointerException npe) {

		}
	}

	@Test
	void testConstroiClienteCPFVazioeNulo() {

		try {
			Cliente cliente2 = new Cliente("", "Caio", "caioodavi@gmail.com", "CAA");
			fail("Era esperada uma exceção");
		} catch (IllegalArgumentException iae) {

		}

		try {
			Cliente cliente3 = new Cliente(null, "Caio", "caioodavi@gmail.com", "CAA");
			fail("Era esperada uma exceção");
		} catch (NullPointerException npe) {

		}
	}

	@Test
	void testConstroiClienteCPFInvalido() {

		try {
			Cliente cliente2 = new Cliente("123", "Caio", "caioodavi@gmail.com", "CAA");
			fail("Era esperada uma exceção");
		} catch (IllegalArgumentException iea) {

		}
	}

	@Test
	void testConstroiClienteEmailVazioeNulo() {

		try {
			Cliente cliente2 = new Cliente("12345678900", "Caio", "", "CAA");
			fail("Era esperada uma exceção");
		} catch (IllegalArgumentException iae) {

		}

		try {
			Cliente cliente3 = new Cliente("12345678900", "Caio", null, "CAA");
			fail("Era esperada uma exceção");
		} catch (NullPointerException npe) {

		}
	}

	@Test
	void testConstroiClienteLoclVazioeNulo() {
		
		try {
			Cliente cliente2 = new Cliente("12345678900", "Caio", "caioodavi@gmail.com", "");
			fail("Era esperada uma exceção");
		} catch (IllegalArgumentException iae) {

		}
		
		try {
			Cliente cliente3 = new Cliente("12345678900", "Caio", "caioodavi@gmail.com", null);
			fail("Era esperada uma exceção");
		} catch (NullPointerException npe) {

		}
	}

	@Test
	void testGetCpfCorreto() {
		assertEquals("12345678900", cliente1.getCpf());
	}

	
	@Test
	void testToString() {
		assertEquals("Caio Davi - CAA - caioodavi@gmail.com", cliente1.toString());
	}

	@Test
	void testHashCode() {
		Cliente cliente2 = new Cliente("12345678900", "Davi", "davi@gmail.com", "CD");
		assertEquals(cliente1.hashCode(), cliente2.hashCode());
	}

	@Test
	void testEqualsObject() {
		Cliente cliente2 = new Cliente("12345678900", "Davi", "davi@gmail.com", "CD");
		assertTrue(cliente1.equals(cliente2));
	}

}
