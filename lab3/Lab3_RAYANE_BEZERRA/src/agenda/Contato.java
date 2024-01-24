package agenda;

/**
 * Representacao de um contato, que est� alocado em uma determinada agenda. Um
 * contato tem nome, sobrenome e telefone.
 * @author Rayane Bezerra 
 */

public class Contato {
	/**
	 * Nome de um contato no formato String.
	 */
	private String nome;

	/**
	 * Representacao do sobrenome de um contato.
	 */
	private String sobreNome;

	/**
	 * Representacao do telefone do contato no formato String.
	 */
	private String telefone;

	/**
	 * O metodo ira verificar se o nome do contato eh nulo.
	 * 
	 * @param nome recebe a String nome do contato, podendo ser 'null' ou nao.
	 * @throws Se o nome passado como parametro for nulo, sera lancada a excecao
	 *            'NullPointerException' indicando que o nome eh nulo.
	 */
	public void verificaNomeNulo(String nome) {
		if (nome == null) {
			throw new NullPointerException("String nula!");
		}
	}

	/**
	 * O metodo analisa se o nome do contato eh vazio.
	 * 
	 * @param nome recebe a String nome do contato.
	 * @throws Se o nome for vazio entao o metodo ira lancar a excecao"
	 *            IllegalArgumentException" indicando que o que foi passado no nome
	 *            nao eh aceito pelo programa.
	 */

	public void verificaNomeVazio(String nome) {
		if (nome.equals("")) {
			throw new IllegalArgumentException("CONTATO INVALIDO");
		}
	}
	public void verificaSobrenomeVazio(String sobreNome) {
		if (nome.equals("")) {
			throw new IllegalArgumentException("CONTATO INVALIDO");
		}
	}

	public void verificaTelefoneVazio(String nome) {
		if (nome.equals("")) {
			throw new IllegalArgumentException("CONTATO INVALIDO");
		}
	}

	/**
	 * Constroi um contato apartir do seu nome, sobrenome e telefone.
	 * 
	 * @param nome      recebe o nome do contato.
	 * @param sobreNome recebe o sobrenome do contato.
	 * @param telefone  recebe o telefone do contato.
	 * 
	 */
	
	
	public Contato(String nome, String sobreNome, String telefone) {
		verificaNomeVazio(nome);
		verificaNomeNulo(nome);
		verificaTelefoneVazio(telefone);
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.telefone = telefone;
	}

	/**
	 * O metodo ira verificar qual eh o nome do contato.
	 * 
	 * @return retorna o nome do contato.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * O metodo ira verificiar qual eh o sobrenome do contato.
	 * 
	 * @return o sobrenome do contato.
	 */
	public String getsobreNome() {
		return this.sobreNome;
	}

	/**
	 * O metodo ira verificar qual eh o telefone do contato.
	 * 
	 * @return o telefone do contato.
	 */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * O metodo ira verificar qual eh o nome e o sobrenome do contato
	 * 
	 * @return o nome e o sobrenome do contato, no formato "nome + sobreNome".
	 */
	public String getNomeCompleto() {
		return getNome() + " " + getsobreNome();
	}

	/**
	 * Retorna a String que representa o nome, sobrenome e telefone do contato no
	 * formato " nome + sobreNome + telefone".
	 */
	public String toString() {
		return getNomeCompleto() + System.lineSeparator() + getTelefone();
	}

}
