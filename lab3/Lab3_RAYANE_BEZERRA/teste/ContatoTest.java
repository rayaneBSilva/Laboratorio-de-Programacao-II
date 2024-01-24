import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import agenda.Agenda;
import agenda.Contato;

class ContatoTest {


	@Test
	void test() {
		assertThrows(IllegalArgumentException.class, () ->  new Contato("", "Gaudêncio", "2101-0000"));

	}
	
	@Test
	void test1() {
		assertThrows(NullPointerException.class, () ->  new Contato(null, "Gaudencio", "2101-0000"));

	}
	
	@Test
	void test2() {
		assertThrows(IllegalArgumentException.class, () ->  new Contato("Matheus", "Gaudêncio", ""));

	}
	
	@Test
	void testgetNome() {
		Contato contato1 = new Contato("Fabio", "junior", "998763");
		assertEquals("Fabio", contato1.getNome());
		
	}
	@Test
	void testGetSobreNome() {
		Contato contato2 = new Contato("Fabio", "junior", "998763");
		assertEquals("junior", contato2.getsobreNome());
		
	}
	
	@Test
	void testgetNomeCompleto() {
		Contato contato3 = new Contato ("Fabio", "junior", "9987665");
		assertEquals("Fabio junior", contato3.getNomeCompleto());
	}
	
	@Test
	void testTelefone() {
		Contato contato4 = new Contato ("Fabio", "junior", "9987665");
		assertEquals("9987665", contato4.getTelefone());
	}
	
	
	@Test
	void TestToString() {
		Contato contato5 = new Contato("maria", "carla", "2321323");
		assertEquals("maria carla" +  System.lineSeparator() + "2321323", contato5.toString());

	}
	
	
	}
	
	
	
	

	
	

