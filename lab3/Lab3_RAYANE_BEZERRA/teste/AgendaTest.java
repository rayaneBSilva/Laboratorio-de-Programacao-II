import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import agenda.Agenda;

class AgendaTest {

	private Agenda agenda1 = new Agenda();
	private Agenda agenda = new Agenda();
	private Agenda agenda2 = new Agenda();
	private Agenda agenda3 = new Agenda();
	


	@Test
	void testCadastraContato1() {
		assertEquals("CADASTRO REALIZADO" + System.lineSeparator(),agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000"));
	}
	
	@Test
	void testCadastraContato2() {
		Agenda agenda1 = new Agenda();
		agenda1.cadastraContato(1,"Matheus", "Gaudencio", "1232323242");
		assertEquals("CADASTRO REALIZADO" + System.lineSeparator(),agenda1.cadastraContato( 1, "Pedro", "Silva", "986846.7515"));
	}
	
	@Test
	void testCadastraContato3() {
		Agenda agenda1 = new Agenda();
		agenda1.cadastraContato(1, "Matheus", "Gaudencio","12123123");
		assertEquals("CONTATO JA CADASTRADO" + System.lineSeparator(),agenda1.cadastraContato(3,"Matheus","Gaudencio","(83) 99999-0000"));
	}
	
	@Test
	void testaCadastraContato4() {
		Agenda agenda1 = new Agenda();
		assertEquals("CADASTRO REALIZADO" + System.lineSeparator(), agenda1.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000"));
	}
	@Test
	void testaCadastraContato5() {
		Agenda agenda1 = new Agenda();
		assertEquals("POSICAO INVALIDA" + System.lineSeparator(), agenda1.cadastraContato(101, "Matheus", "Gaudencio", "(83) 99999-0000"));
	}
	@Test
	void testaCadastraContato6() {
		Agenda agenda1 = new Agenda();
		assertEquals("POSICAO INVALIDA" + System.lineSeparator(), agenda1.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000"));
	}
	@Test
	void testaCadastraContato7() {
		Agenda agenda1 = new Agenda();
		assertThrows(IllegalArgumentException.class, () -> agenda1.cadastraContato(1, "Matheus", "Gaudencio", ""));
	}
	@Test
	void testaCadastraContato8() {
		Agenda agenda2 = new Agenda();
		assertThrows(IllegalArgumentException.class, () -> agenda1.cadastraContato(1, "", "Gaudencio", "(83) 99999-0000"));
	}
	
	@Test
	void testaExibirContato1() {
		Agenda agenda1 = new Agenda();
		agenda1.cadastraContato(1, "Matheus", "Gaudencio", "(87) 99999-0000");
		assertEquals("Matheus Gaudencio" + System.lineSeparator() + "(87) 99999-0000",agenda1.exibeContato(1));
	}
	@Test
	void testaExibirContato2() {
		Agenda agenda1 = new Agenda();
		agenda1.cadastraContato(1, "Matheus", "Gaudencio", " ");
		assertEquals("Matheus Gaudencio" + System.lineSeparator() + " ",agenda1.exibeContato(1));
	}
	
	@Test
	void testaExibirContato3() {
		Agenda agenda1 = new Agenda();
		assertEquals("POSICAO INVALIDA!" + System.lineSeparator(), agenda1.exibeContato(100));
	}
	
	@Test
	void testaExibirContato4() {
		Agenda agenda1 = new Agenda();
		assertEquals("POSICAO INVALIDA!" + System.lineSeparator(), agenda1.exibeContato(0));
	}
	@Test
	void testaExibirContato5() {
		Agenda agenda1 = new Agenda();
		assertEquals("POSICAO INVALIDA!" + System.lineSeparator(), agenda1.exibeContato(101));
	}
	
	@Test
	void testaExibirContato6() {
		Agenda agenda1 = new Agenda();
		agenda1.cadastraContato(1, "Matheus", "Gaudencio", "(87) 99999-0000");
		agenda1.adicionaFavoritos(1, 1);
		assertEquals("<3" + " " + "Matheus Gaudencio" + System.lineSeparator() + "(87) 99999-0000", agenda1.exibeContato(1));
	}
	@Test
	void testaAdicionaFAvorito1() {
		Agenda agenda1 = new Agenda();
		agenda1.cadastraContato(1, "Matheus", "Gaudencio", "(87) 99999-0000");
		agenda1.adicionaFavoritos(1, 1);
		assertEquals("<3" + " " + "Matheus Gaudencio" + System.lineSeparator() + "(87) 99999-0000", agenda1.exibeContato(1));
	}
	
	@Test
	void testRemoveContato() {
		Agenda agenda3 = new Agenda();
		agenda3.cadastraContato(23, "Matheus", "Gaudencio", "(87) 99999-0000");
		assertEquals(System.lineSeparator() ,agenda3.removeContato(23));
	}
	
	@Test
	void testRemoveContato2() {
		assertEquals("POSICAO INVALIDA"+ System.lineSeparator(), agenda.removeContato(3));
	}
	
	
	
	

    
	
}
