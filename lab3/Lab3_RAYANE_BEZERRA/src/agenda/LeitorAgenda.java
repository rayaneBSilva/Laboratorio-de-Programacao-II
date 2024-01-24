package agenda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeitorAgenda {

	/**
	 * L�gica para ler de arquivos csv os dados necess�rios e povoar uma agenda.
	 * 
	 * @author nazarenoandrade
	 *
	 */

	private static final int COLUNA_POSICAO = 0;
	private static final int COLUNA_NOME = 1;
	private static final int COLUNA_SOBRENOME = 2;
	private static final int COLUNA_TELEFONE = 3;

	/**
	 * L� contatos de um arquivo CSV e os coloca em uma agenda.
	 * 
	 * @param arquivoContatos Caminho para arquivo contendo contatos.
	 * @param agenda          A agenda a manipular.
	 * @return O n�mero de contatos adicionados � agenda.
	 * @throws IOException           Caso n�o tenhamos permiss�o de ler o arquivo.
	 * @throws FileNotFoundException Caso o arquivo n�o exista.
	 */
	public int carregaContatos(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		int carregados = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(arquivoContatos))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				carregados += 1;
				if (carregados == 1) {
					// pulamos a primeira linha, o cabe�alho
					continue;
				}
				String[] campos = linha.split(",");
				processaLinhaCsvContatos(campos, agenda);
			}
		}

		return carregados;
	}

	/**
	 * Coloca na agenda os dados de uma linha do arquivo de agenda inicial.
	 * 
	 * @param campos As informa��es lidas do csv.
	 * @param agenda A agenda a manipular.
	 */
	private void processaLinhaCsvContatos(String[] campos, Agenda agenda) {
		int posicao = Integer.parseInt(campos[COLUNA_POSICAO]);
		String nome = campos[COLUNA_NOME].trim();
		String sobrenome = campos[COLUNA_SOBRENOME].trim();
		String num = campos[COLUNA_TELEFONE].trim();

		agenda.cadastraContato(posicao, sobrenome, num, nome);
	}

}
