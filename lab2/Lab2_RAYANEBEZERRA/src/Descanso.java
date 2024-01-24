package lab2;

/** Representa��o do estado de descanso de um aluno, especificamente de computa��o, matriculado da * UFCG. 
*  feita atraves da rela�ao de horas de descanso e a quantidade de semanas
*  
* @author Rayane bezerra
*/

public class Descanso {
	    
		/** 
		 * Quantidade de horas que o aluno descansou.
		 */
	
		 private int horasDescanso;
		 
		 /**
		  * Quantidade de semanas.
		  */

		 private int semanas;
		
		/** Controi descanso a partir da quantidade de horas Semanais  e semanas.
		 * 
		 * @param horasDescanso o numero de horas de descanso.
		 * @param semanas o numero de semanas.
		 */
		
		public void descanso(int horas, int semanas){
			this.horasDescanso = horas;
			this.semanas = semanas;
		}
		
		/** define as horas de descanso.
		 * 
		 * @param valor define o novo valor;
		 */
		
		public void defineHorasDescanso(int valor) {
			this.horasDescanso = valor;
		}
		
		/** define as horas de semanas.
		 * 
		 * @param valor define o valor de semanas.
		 */
		
		public void defineNumeroSemanas(int valor) {
			this.semanas = valor;
		}

		/** 
		 * Metodo responsavel por mostrar a situacao de descanso 
		 * de um aluno, sendo "descansado" caso as horas que o aluno
		 * descansou seja maior ou igual 26 e "cansado" caso o contrario.
		 * 
		 * @return o estado de descanso de um aluno.
		 * 
		 */
		
		public String getStatusGeral(){
			boolean status = "cansado";
			boolean condition = ((horasDescanso / semanas ) >= 26);

			if ((semanas > 0) && condition) {
				status = "descansado";
			}
			return status;
		}
}

