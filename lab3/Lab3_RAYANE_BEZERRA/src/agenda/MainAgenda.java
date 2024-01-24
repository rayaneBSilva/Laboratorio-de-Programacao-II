package agenda;

import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 */

public class MainAgenda {
	/**
	 * Importando Scanner para pedir informaçoes do usuario.
	 */
	public static Scanner sc = new Scanner(System.in);

	public static Agenda agenda = new Agenda();

	/**
	 * Criando metodo menu que exibira opcoes para usuario. Como cadastrar contato,
	 * Listar contato, Exibir contato, favoritos, adicionar favoritos, remover e
	 * sair do programa.
	 */

	private static void menu() {
		System.out.println("(C)adastrar Contato");
		System.out.println("(L)istar Contatos");
		System.out.println("(E)xibir Contato");
		System.out.println("(F)avoritos");
		System.out.println("(A)dicionar Favorito");
		System.out.println("(R)emover Contato");
		System.out.println("(S)air" + System.lineSeparator());
		System.out.print("Opcao> ");
	}

	/**
	 * Metodo que cadastra contato, pedindo a posicao que se deseja cadastrar no
	 * array de contatos, o nome, sobrenome e telefone.
	 */

	public static void cadastraContato() {
		System.out.print(System.lineSeparator() + "Posicao> ");
		int posicao = Integer.parseInt(sc.nextLine());
		System.out.print("Nome> ");
		String nome = sc.nextLine();
		System.out.print("Sobrenome> ");
		String sobreNome = sc.nextLine();
		System.out.print("Telefone> ");
		String telefone = sc.nextLine();
		System.out.println(agenda.cadastraContato(posicao, nome, sobreNome, telefone));
	}

	/**
	 * Exibe informacoes de um contato apartir da sua posicao.
	 */

	private static void exibeContato() {
		System.out.print("Contato> ");
		int posicaoContato = Integer.parseInt(sc.nextLine());
		System.out.println(System.lineSeparator() + agenda.exibeContato(posicaoContato) + System.lineSeparator());
	}

	/**
	 * Lista os contatos que estao no Array de contatos.
	 */
	private static void listaContato() {
		System.out.println(agenda.listaContatos());

	}

	/**
	 * Adiciona contatos favoritos, pedindo qual contato se deseja favoritar e em
	 * que posicao ele deve ser favoritado.
	 */

	private static void adicionaFavoritos() {
		System.out.print("Contato> ");
		int contato = Integer.parseInt(sc.nextLine());
		System.out.print("Posicao> ");
		int posicao = Integer.parseInt(sc.nextLine());
		if (agenda.verificaFavoritos() == true) {
			System.out.println("CONTATO JA ESTA NA LISTA DE FAVORITOS" + System.lineSeparator());
		} else {
			System.out.println(agenda.adicionaFavoritos(contato, posicao) + System.lineSeparator());
		}
	}

	/**
	 * Exibe contatos favoritos.
	 */

	private static void favoritos() {
		System.out.println(agenda.favoritos());

	}

	/**
	 * Remove contato apartir da sua posicao, do Array de contatos.
	 */

	private static void removeContato() {
		System.out.print("Contato> ");
		int posicao = Integer.parseInt(sc.nextLine());
		System.out.print(agenda.removeContato(posicao) + System.lineSeparator());
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema. E exibe o menu
	 * de informacoes.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		menu();
		while (true) {
			String opcao = sc.nextLine();
			if (opcao.equals("S")) {
				break;
			} else if (opcao.equals("C")) {
				cadastraContato();
				menu();
			} else if (opcao.equals("E")) {
				exibeContato();
				menu();
			} else if (opcao.equals("L")) {
				listaContato();
				menu();
			} else if (opcao.equals("F")) {
				favoritos();
				menu();
			} else if (opcao.equals("A")) {
				adicionaFavoritos();
				menu();
			} else if (opcao.equals("R")) {
				removeContato();
				menu();
			} else {
				System.out.println("OPCAO INVALIDA!" + System.lineSeparator());
				menu();

			}
		}

	}

}
	
