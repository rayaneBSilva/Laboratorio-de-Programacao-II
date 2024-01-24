package lab2;

/** criando classe atividades complementares, que cria um historico de 
 * atividades feita pelo aluno, podendo ser essas estagios, projetos e 
 * cursos.
 * 
 * @author Rayane Bezerra
 *
 */

public class AtividadesComplementares {
	/**
	 * Recebe horas realizada de estagio.
	 */
	private int estagioHoras;
	
	/**
	 * Recebe meses que participou de um projeto.
	 */
	private int mesesProjeto;
	
	/**
	 * recebe horas de um curso.
	 */
	private double horasCurso;
	
	/**
	 * soma os creditos das tres atividades complementares e determina o total de creditos.
	 */
	private int  totalCreditos;
	
	/**
	 * Determina a quantidade de creditos recebido por um aluno em um projeto.
	 * Para cada 3 meses cumprindo em um projeto, sao recebidos 2 creditos.
	 */
	private int creditosProjeto;
	
	/**
	 * determina a quantidade de creditos recebido por um aluno em um projeto.
	 * Para cada 300 hrs de estagios, sao recebidos 5 creditos.
	 */
	private int creditosEstagios;
	
	/**
	 * Determina a quantidade de creditos recebido por um aluno em um curso.
	 * Para cada 30 horas de curso, sao recebidos 1 credito.
	 */
	private int creditosCursos;
	
	/**
	 * Conta a quantidade de estagios e projetos que um aluno ja participou.
	 */
	private int contEstagios, contProjetos;
	/**
	 * Array de tamanho ja definido, que adiciona as horas de um estagio.
	 */
	private int[] estagios = new int[9];
	/**
	 * Array de tamanho ja definido, que adiciona as horas de um projeto.
	 */
	private int[] projetos = new int[16];
    
	/**
	 * atividades complementares nao recebe nada como parametro.
	 */
	public AtividadesComplementares() {
      }
	
	/**
	 * controi um adiciona estagio a partir das horas cumpridas em um determinado estagio.
	 * 
	 * @param horas valor que recebe as horas.
	 */

	public void adicionarEstagio(int horas) {
		this.estagioHoras += horas;
		this.estagios[this.contEstagios] = horas;
		this.contEstagios++;
		
	}
	
	/**
	 * controi um adiciona projetos a partir da quantidade de meses em um projeto.
	 * @param meses valor que recebe os meses.
	 */

	public void adicionarProjeto(int meses) {
		this.mesesProjeto += meses;
		this.projetos[this.contProjetos] = meses;
		this.contProjetos++;
	}
    
	/**
	 * controi um adiciona cursos que a partir das horas recebidas,
	 * vai acumulando as horas.
	 * 
	 * @param horas valor que recebe as horas.
	 */
	public void adicionarCurso(double horas) {
		this.horasCurso += horas;
	}
	
	/**
	 * Metodo que nao retorna nada e calcula a quantidade de creditos de um estagio.
	 * 
	 * 
	 */

	private void CreditosEstagios() {
		int resultado = (int)(this.estagioHoras / 300) * 5;
		this.creditosEstagios = resultado;
	}
	
	/**
	 * Metodo que nao retorna nada e calcula a quantidade de creditos de um projeto.
	 */
	
	private void CreditosProjetos() {
		int resultado = (int)(this.mesesProjeto /3) * 2;
		this.creditosProjeto  = resultado;
	}
	
	/**
	 * Metodo que nao retorna nada e calcula a quantidade de creditos de curso.
	 */
	private void CreditosCursos() {
		int resultado = (int)(this.horasCurso / 30);
		this.creditosCursos = resultado;
	}
	
	/**
	 * Metodo que faz a soma entre a quantidade de creditos de estagio, projeto e curso.
	 *
	 * @return o total de creditos.
	 */
	
	public int contaCreditos() {
		this.CreditosEstagios();
		this.CreditosProjetos();
		this.CreditosCursos();
		this.totalCreditos = (int)(this.creditosEstagios+ this.creditosProjeto + this.creditosCursos);
		return this.totalCreditos; 
		
	}
    
	 /**
	  * Retorna a string atividades, que cria um array com as informacoes passadas pelo aluno.
	  * criando um for para pecorrer cado elemento e adicionando dentro desse array atividades.
	  * 
	  * @return um array de String
	  */
	public String[] pegaAtividades() {
		this.CreditosEstagios();
		this.CreditosProjetos();
		this.CreditosCursos();
		int varAuxiliar = 0;
		String[] atividades = new String[4 + this.contEstagios + this.contProjetos];
		
		for (int i = 0; i < contEstagios; i++) {
			atividades[varAuxiliar] = "Estagio " + this.estagios[i];
			varAuxiliar++;
		}
		for (int j = 0; j < contProjetos; j++) {
			atividades[varAuxiliar] = "Projeto " + this.projetos[j];
			varAuxiliar++;
		}
		atividades[atividades.length - 4] = "Cursos " + this.horasCurso ;
		atividades[atividades.length - 3] = "Creditos_Estagio " + this.creditosEstagios ;
		atividades[atividades.length - 2] = "Creditos_Projeto " + this.creditosProjeto ;
		atividades[atividades.length - 1] = "Creditos_Cursos " + this.creditosCursos ;
		
		return atividades; 
	}
}



