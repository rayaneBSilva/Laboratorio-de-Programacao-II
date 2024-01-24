package agenda;

import java.util.*;

/**
 * Classe que cria uma agenda com varios contatos e realiza metodos apartir
 * deles, como cadastrar um contato, exibir, listar, adicionar favoritos, listar
 * eles e exibir.
 * 
 * @author Rayane bezerra
 */
public class Agenda {
	/**
	 * nome do contato.
	 */
	private String nome;
	/**
	 * sobrenome do contato.
	 */
	private String sobreNome;
	/**
	 * posicao que o contato deve ser adicionado no array de contatos.
	 */
	private int posicao;
	/**
	 * telefone do contato.
	 */
	private String telefone;
	/**
	 * array onde sera adicionado os contatos, que pertece a classe Contato.
	 */
	private Contato[] contatos;
	/**
	 * array de 10 posicoes, onde sera armazenado os contatos favoritos.
	 */
	private Contato[] favoritos = new Contato[10];

	/**
	 * Constroi um array contatos com 100 posices apartir de contatos.
	 * 
	 * @param contatos recebe array de contatos.
	 */
	public Agenda() {
		this.contatos = new Contato[100];
	}

	/**
	 * O metodo ira verificar se uma posicao e valida para cadastro ou nao. Para ser
	 * valida precisa estar entre 1 e 100, inclusive esses.
	 * 
	 * @param posicao recebe a posicao no formato int..
	 * @return Caso a posicao esteja no intervalo entre 1 e 100, com ambos estendo
	 *         incluidos retornara true, caso contrario retornara false.
	 */
	public boolean verificaPosicao(int posicao) {
		return posicao > 0 && posicao < 101;
	}

	/**
	 * metodo que verifica se nome e sobrenome de um contato ja cadastrado, e igual
	 * a um novo contato que se deseja cadastrar. Mesmo que o contato esteja em
	 * posicao diferente, se o nome e sobrenome for o mesmo, ele e considerado
	 * igual.
	 * 
	 * @param nome      recebe o nome do contato no formato String.
	 * @param sobreNome recebe nome do sobrenome no formato String.
	 * @return true caso os contatos tenham nome e sobrenome iguais, caso o
	 *         contrario retornara false.
	 */
	public boolean verificaNomeIguais(String nome, String sobreNome) {
		String nomeAux = nome;
		String sobrenomeAux = sobreNome;

		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				if (contatos[i].getNome().equals(nomeaux) && contatos[i].getsobreNome().equals((sobrenomeaux))) {
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * O metodo cadastra um contato na agenda. Ele ira pegar a posicao que deseja
	 * ser cadastra e alocara o nome, sobrenome e telefone nessa posicao. Vale
	 * lembrar que so sera possivel cadastrar um contato caso a posicao seja valida.
	 * 
	 * @param posicao   recebe a posicao no formato int.
	 * @param nome      recebe o nome do contato no formato String.
	 * @param sobreNome recebe o sobrenome do contato no formato String.
	 * @param telefone  recebe o telefone do contato no formato String.
	 * @return "CADASTRO REALIZADO" caso o cadastro ocorra. "CONTATO JA CADASTRADO"
	 *         caso o contato que se deseja cadastrar, ja esteja cadastrado.
	 *         "POSICAO INVALIDA" caso a posicao que se deseja cadastrar seja
	 *         invalida.
	 */
	public String cadastraContato(int posicao, String nome, String sobreNome, String telefone) {
		String status = "POSICAO INVALIDA" + System.lineSeparator(); ;
		if (verificaPosicao(posicao) && (verificaNomeIguais(nome, sobreNome) == false) {
				Contato contato = new Contato(nome, sobreNome, telefone);
				contatos[posicao - 1] = contato;
				status = "CADASTRO REALIZADO" + System.lineSeparator();
		} else {
				status = "CONTATO JA CADASTRADO" + System.lineSeparator();
			}
		}
		return status;
	}

	/**
	 * Método que exibi um contato, apartir da sua posicao na lista de contatos.
	 * 
	 * @param posicao recebe a posicao no formato int.
	 * @return retorna o contato na formatacao " nome + sobrenome + telefone" caso a
	 *         posicao inserida seja valida, no caso da posicao nao ser valida
	 *         retorna a seguinte mensagem "POSICAO INVALIDA".
	 */

	public String exibeContato(int posicao) {
		if (verificaPosicao(posicao) && contatos[posicao - 1] != null) {
			if (favoritos[posicao - 1] != null
					&& favoritos[posicao - 1].getNomeCompleto().equals(contatos[posicao - 1].getNomeCompleto())) {
				return "<3" + " " + favoritos[posicao - 1].getNomeCompleto() + System.lineSeparator() + contatos[posicao - 1].getTelefone();
			} else {
				return contatos[posicao - 1].toString();
			}
		}
		return "POSICAO INVALIDA!" + System.lineSeparator();
	}

	/**
	 * Metodo que lista todos os contatos existente na lista de contatos.
	 * 
	 * @return todos os contatos da lista na seguinte formatacao " posicao + nome +
	 *         sobrenome.
	 */

	public String listaContatos() {
		String listaDosContatos = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				listaDosContatos += i + 1 + " - " + contatos[i].getNomeCompleto() + System.lineSeparator();
			}
		}
		return listaDosContatos;
	}

	/**
	 * metodo que adiciona contato em uma lista de favoritos.
	 * 
	 * @param contato recebe contato
	 * @param posicao recebe a posicao que o contato deve ser favoritado na lista
	 *                posicao
	 * @return uma string dizendo "CONTATO FAVORITO NA POSICAO" + posicao, caso o
	 *         contato seja favoritado com sucesso.
	 */

	public String adicionaFavoritos(int contato, int posicao) {
		favoritos[posicao - 1] = contatos[contato - 1];
		return "CONTATO FAVORITADO NA POSIÇÃO " + posicao + "!";

	}

	/**
	 * Metodo que verifica se um contato ja esta na lista de favoritos.
	 * 
	 * @return o metodo retornara true caso o contato ja esteja na lista de
	 *         favoritos, e false caso nao esteja.
	 */

	public boolean verificaFavoritos() {
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null && favoritos[i].getNomeCompleto().equals(contatos[i].getNomeCompleto())) {
				return true;
			}
		}
		return false;

	}

	/**
	 * Metodo que lista um favorito.
	 * 
	 * @return contato favorito no formato " posicao + nome + sobrenome .
	 */

	public String favoritos() {
		String listaFavoritos = "";
		for (int i = 0; i < favoritos.length; i++) {
			if (contatos[i] != null && favoritos[i] != null) {
				listaFavoritos += i + 1 + " - " + favoritos[i].getNomeCompleto() + System.lineSeparator();
			}
		}

		return listaFavoritos;
	}

	/**
	 * Metodo que remove um contato do array de contatos.
	 * 
	 * @param posicao recebe a posicao no formato int.
	 * @return metodo que retornara "POSICAO INVALIDA" caso a posicao que o contato
	 *         seja removido nao exista. caso isso nao ocorra, retornara apenas um
	 *         System.lineSeparator().
	 */

	public String removeContato(int posicao) {
		if (contatos[posicao - 1] == null) {
			return "POSICAO INVALIDA" + System.lineSeparator();
		}
		contatos[posicao - 1] = null;
		return System.lineSeparator();
	}

}
