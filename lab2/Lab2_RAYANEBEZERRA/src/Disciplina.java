package lab2;


import java.util.Arrays;


/**
 * /** A classe disciplina cadastra a nota de um aluno
     * e faz a sua soma, calculando sua media. Mostrando
     * se um aluno foi aprovado ou reprovado. Tendo sua aprovacao
     * caso sua media seja maior que ou igual a 7.
     * 
	 * @author Rayane bezerra
	 */

public class Disciplina {
		
		/**
		 * nome da disciplina.
		 */
		private String disciplina;
		/**
		 * Quantidade de horas 
		 */
		private int horas;
		/**
		 * Media de um aluno.
		 */
		private double media;
		/**
		 * Array de tamanho ja definido, que recebera as notas de um aluno.
		 */
		private  double[] arrayNotas = new double[4];
		
	    /**
	     * controi uma disciplina a partir do seu nome.
	     * @param disciplina recebe o nome da disciplina.
	     */
		
		public Disciplina(String disciplina) {
			this.disciplina = disciplina;
		}
		
		/**
		 * Metodo que cadastra as horas que um aluno estudou.
		 * 
		 * @param horas recebe a quantidade de horas estudadas.
		 */

		public void cadastraHoras(int horas) {
			this.horas += horas;
		}
		
	    /**
	     * Metodo que nao retorna nada. Atribui as notas de um aluno e adiciona em
	     * um array de notas.
	     * 
	     * @param nota recebe o valor da nota de um aluno;
	     * @param valorNota recebe a nota tirada por um aluno.
	     */
		
		public void cadastraNota(int nota, double valorNota) {
			
			this.arrayNotas[nota - 1] = valorNota;
		}
		
		/**
		 * Metodo que nao retorna nada, soma as notas do um aluno e calcula sua media.
		 *
		 */
		
		private void calculaMedia(){
			double media = 0;
			int cont = arrayNotas.length;
			
			for (double nota : arrayNotas) {
				media += nota;
			}

			this.media = media/ cont;
			}
		
		/**
		 * representa os status de aprovacao de um aluno, caso sua media
		 * seja maior ou igual a 7 seu status de aprovacao sera "true",
		 * caso contrario seu status de aprovacao sera "false".
		 * 
		 * @return o status de aprovacao.
		 */
		
		public boolean aprovado() {
			
			calculaMedia();
			boolean statusAprovacao;
			if ( media >= 7 ) {
				statusAprovacao = true;
			} else {
				statusAprovacao = false;
			}
			return statusAprovacao;
			}
		
		/**
		 * Retorna  a string que representa a disciplina. A representacao segue 
		 * o formato "disciplina  horas  media  arraysNotas"
		 */

		
		public String toString( ) {
			return disciplina + " " + horas + " " +  media + " " + Arrays.toString(arrayNotas);
			
		}

}

