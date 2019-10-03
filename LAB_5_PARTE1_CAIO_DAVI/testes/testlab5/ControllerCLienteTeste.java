package testlab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.ControllerCliente;

class ControllerCLienteTeste {
	
	ControllerCliente teste;
	
	@BeforeEach
	void testConstrutor(){
		 teste = new ControllerCliente();
		 
	}
	
	
	@Test
	void testCadastraClientesCorreto() {
		assertEquals("12345678900",teste.cadastraClientes("12345678900","Caio Davi" , "caioodavi@gmail.com", "CAA"));
	}
	
	@Test
	void testCadastraClientesCpfNulleVazio() {
		assertThrows(IllegalArgumentException.class, ()->teste.cadastraClientes("", "Caio Davi", "caioodavi@gmail.com", "CAA"));
		assertThrows(NullPointerException.class, ()->teste.cadastraClientes(null, "Caio Davi", "caioodavi@gmail.com", "CAA"));
	}
	
	@Test
	void testCadastraClientesCpfInvalido() {
		assertThrows(IllegalArgumentException.class, ()->teste.cadastraClientes("123", "Caio Davi", "caioodavi@gmail.com", "CAA"));
		assertThrows(IllegalArgumentException.class, ()->teste.cadastraClientes("123455678909887654", "Caio Davi", "caioodavi@gmail.com", "CAA"));
	}
	
	@Test
	void testCadastraClientesNomeNulleVazio() {
		assertThrows(IllegalArgumentException.class, ()->teste.cadastraClientes("12345678900", "", "caioodavi@gmail.com", "CAA"));
		assertThrows(NullPointerException.class, ()->teste.cadastraClientes("12345678900", null, "caioodavi@gmail.com", "CAA"));
	}
	
	@Test
	void testCadastraClientesEmailNulleVazio() {
		assertThrows(IllegalArgumentException.class, ()->teste.cadastraClientes("12345678900", "Caio Davi", "", "CAA"));
		assertThrows(NullPointerException.class, ()->teste.cadastraClientes("12345678900", "Caio Davi" , null, "CAA"));
	}
	
	@Test
	void testCadastraClientesLocNulleVazio() {
		assertThrows(IllegalArgumentException.class, ()->teste.cadastraClientes("12345678900", "Caio Davi", "caioodavi@gmail.com", ""));
		assertThrows(NullPointerException.class, ()->teste.cadastraClientes("12345678900", "Caio Davi" , "caioodavi@gmail.com", null));
	}
	
	@Test
	void testCadastraClientesJaExistente() {
		teste.cadastraClientes("12345678900", "Caio Davi" , "caio.silva@ccc.ufcg.edu.br", "CN");
				
		assertThrows(IllegalArgumentException.class, ()->teste.cadastraClientes("12345678900", "Caio Davi", "caioodavi@gmail.com", "CAA"));
		
	}
	
	@Test
	void testExibeClienteCorreto() {
		teste.cadastraClientes("12345678900","Caio Davi" , "caio.silva@ccc.ufcg.edu.br", "CAA");
		teste.cadastraClientes("00000000011","Jose Joao" , "jose.joao@ccc.ufcg.edu.br", "CN");
		String msg1 = "Caio Davi - CAA - caio.silva@ccc.ufcg.edu.br";
		String msg2 = "Jose Joao - CN - jose.joao@ccc.ufcg.edu.br";
		assertEquals("Caio Davi - CAA - caio.silva@ccc.ufcg.edu.br", teste.exibeCliente("12345678900"));
		assertEquals("Jose Joao - CN - jose.joao@ccc.ufcg.edu.br", teste.exibeCliente("00000000011"));
		
	}
	
	@Test
	void testExibeClienteCpfNulleVazio() {
		teste.cadastraClientes("12345678900","Caio Davi" , "caio.silva@ccc.ufcg.edu.br", "CAA");
		teste.cadastraClientes("00000000011","Jose Joao" , "jose.joao@ccc.ufcg.edu.br", "CN");
		
		assertThrows(IllegalArgumentException.class,()-> teste.exibeCliente(""));
		assertThrows(NullPointerException.class,()-> teste.exibeCliente(null));
		
	}
	
	@Test
	void testExibeClienteCpfNaoExiste() {
				
		assertThrows(IllegalArgumentException.class,()-> teste.exibeCliente("12345678900"));
		assertThrows(IllegalArgumentException.class,()-> teste.exibeCliente("00000000011"));
		
	}
	
	@Test
	void testExibeTodosClientes() {
		teste.cadastraClientes("12345678900","Caio Davi" , "caio.silva@ccc.ufcg.edu.br", "CAA");
		String msg1 = "Caio Davi - CAA - caio.silva@ccc.ufcg.edu.br";
		assertTrue(teste.exibeTodosClientes().contains(msg1));
		
		teste.cadastraClientes("00000000011","Jose Joao" , "jose.joao@ccc.ufcg.edu.br", "CN");
		
		teste.cadastraClientes("00000000012","Arthur" , "arthur@ccc.ufcg.edu.br", "LCC3");
		
		
		String msg2 = "Jose Joao - CN - jose.joao@ccc.ufcg.edu.br";
		String msg3 = "Arthur - LCC3 - arthur@ccc.ufcg.edu.br";
		
		assertTrue(teste.exibeTodosClientes().contains(msg2));
		assertTrue(teste.exibeTodosClientes().contains(msg3));
				
	}
	
	
	@Test
	void testEditaCadastroClienteCorretoNome() {
		teste.cadastraClientes("12345678900", "Caio Davi", "caio.silva@ccc.ufcg.edu.br", "CAA");
		teste.editaCadastroCliente("12345678900", "nome", "Caio Silva");
		assertEquals("Caio Silva - CAA - caio.silva@ccc.ufcg.edu.br", teste.exibeCliente("12345678900"));
	}
	
	@Test
	void testEditaCadastroClienteCorretoEmail() {
		teste.cadastraClientes("12345678900", "Caio Davi", "caio.silva@ccc.ufcg.edu.br", "CAA");
		teste.editaCadastroCliente("12345678900", "email", "caio.davi@ccc.ufcg.edu.br");
		assertEquals("Caio Davi - CAA - caio.davi@ccc.ufcg.edu.br", teste.exibeCliente("12345678900"));
	}
	
	@Test
	void testEditaCadastroClienteCorretoLoc() {
		teste.cadastraClientes("12345678900", "Caio Davi", "caio.silva@ccc.ufcg.edu.br", "CAA");
		teste.editaCadastroCliente("12345678900", "LOCALIZACAO", "CN");
		assertEquals("Caio Davi - CN - caio.silva@ccc.ufcg.edu.br", teste.exibeCliente("12345678900"));
	}
	
	@Test
	void testEditaCadastroClienteCpfVazioENulo() {
		teste.cadastraClientes("12345678900", "Caio Davi", "caio.silva@ccc.ufcg.edu.br", "CAA");
		assertThrows(IllegalArgumentException.class, ()-> teste.editaCadastroCliente("", "nome","Caio Silva"));
		assertThrows(NullPointerException.class, ()-> teste.editaCadastroCliente(null, "nome","Caio Silva"));
	}
	
	@Test
	void testEditaCadastroClienteAtributoVazioENulo() {
		teste.cadastraClientes("12345678900", "Caio Davi", "caio.silva@ccc.ufcg.edu.br", "CAA");
		assertThrows(IllegalArgumentException.class, ()-> teste.editaCadastroCliente("12345678900", "","Caio Silva"));
		assertThrows(NullPointerException.class, ()-> teste.editaCadastroCliente("12345678900", null ,"Caio Silva"));
	}
	
	@Test
	void testEditaCadastroClienteNovoValorVazioENulo() {
		teste.cadastraClientes("12345678900", "Caio Davi", "caio.silva@ccc.ufcg.edu.br", "CAA");
		assertThrows(IllegalArgumentException.class, ()-> teste.editaCadastroCliente("12345678900", "nome",""));
		assertThrows(NullPointerException.class, ()-> teste.editaCadastroCliente("12345678900", "nome" ,null));
	}
	
	@Test
	void testEditaCadastroClienteTentativaCPF() {
		teste.cadastraClientes("12345678900", "Caio Davi", "caio.silva@ccc.ufcg.edu.br", "CAA");
		assertThrows(IllegalArgumentException.class, ()-> teste.editaCadastroCliente("12345678900", "CPF","Caio Silva"));
		
	}
	
	@Test
	void testEditaCadastroClienteAtributoNaoExiste() {
		teste.cadastraClientes("12345678900", "Caio Davi", "caio.silva@ccc.ufcg.edu.br", "CAA");
		assertThrows(IllegalArgumentException.class, ()-> teste.editaCadastroCliente("12345678900", "endereco","Caio Silva"));
		
	}
	
	@Test
	void testEditaCadastroClienteNaoExiste() {
		teste.cadastraClientes("12345678900", "Caio Davi", "caio.silva@ccc.ufcg.edu.br", "CAA");
		assertThrows(IllegalArgumentException.class, ()-> teste.editaCadastroCliente("12345678911", "nome","Caio Silva"));
		
	}	
	
	@Test
	void testRemoveClienteCorreto() {
		teste.cadastraClientes("12345678900", "Caio Davi", "caio.silva@ccc.ufcg.edu.br", "CAA");
		teste.cadastraClientes("12345678911", "Davi", "davi@ccc.ufcg.edu.br", "CB");
		
		teste.removeCliente("12345678911");
		
		assertFalse(teste.exibeTodosClientes().contains("Davi - CB - davi@ccc.ufcg.edu.br"));
		
		teste.removeCliente("12345678900");
		
		assertFalse(teste.exibeTodosClientes().contains("Caio Davi - CAA - caio.silva@ccc.ufcg.edu.br"));
	}
	
	@Test
	void testRemoveClienteCpfErrado() {
		teste.cadastraClientes("12345678900", "Caio Davi", "caio.silva@ccc.ufcg.edu.br", "CAA");
		assertThrows(IllegalArgumentException.class, ()-> teste.removeCliente("12345678911"));
	}
	
	@Test
	void testRemoveClienteCpfVazioOuNulo() {
		teste.cadastraClientes("12345678900", "Caio Davi", "caio.silva@ccc.ufcg.edu.br", "CAA");
		assertThrows(NullPointerException.class, ()-> teste.removeCliente(null));
		assertThrows(IllegalArgumentException.class, ()-> teste.removeCliente("12345678911"));
	}
}
