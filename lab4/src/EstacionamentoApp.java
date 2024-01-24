import java.util.ArrayList;
import java.util.List;

public class EstacionamentoApp {
    private static final int CAPACIDADE_ESTACIONAMENTO = 100;
    private static List<Vaga> vagas = new ArrayList<>();

    public static void main(String[] args) {


        adicionarVaga("Rua A, Bairro X", 1, "https://maps.google.com/123", 20.0);
        adicionarVaga("Rua B, Bairro Y", 2, null, 25.5);


        exibirInformacoesVagas();


        simularPrecoVaga(0, 3);


        exibirInformacoesVagas();


        mudarStatusVaga(1, true);


        informarVagasAtivas();


        informarQuantidadeVagasCadastradas();

      
        int idProximaVagaLivre = encontrarProximaVagaLivre("Rua B, Bairro Y", 25.5);
        System.out.println("Próxima vaga livre com mesmo endereço e área: " + idProximaVagaLivre);


        gerarRelatorioUsoVagas();
    }

    private static void adicionarVaga(String endereco, int numeracao, String linkGoogleMaps, double area) {
        if (vagas.size() < CAPACIDADE_ESTACIONAMENTO) {
            Vaga novaVaga = new Vaga(endereco, numeracao, linkGoogleMaps, area);
            vagas.add(novaVaga);
        } else {
            System.out.println("Estacionamento atingiu a capacidade máxima de vagas.");
        }
    }

    private static void mudarStatusVaga(int idVaga, boolean ocupada) {
        if (idVaga >= 0 && idVaga < vagas.size()) {
            Vaga vaga = vagas.get(idVaga);
            if (ocupada) {
                vaga.ocupar();
            } else {
                vaga.desocupar();
            }
        } else {
            System.out.println("ID de vaga inválido.");
        }
    }

    private static void simularPrecoVaga(int idVaga, int horas) {
        if (idVaga >= 0 && idVaga < vagas.size()) {
            Vaga vaga = vagas.get(idVaga);
            double preco = vaga.getValorPorHora() * horas + 0.1 * vaga.getArea();
            System.out.println("Simulação de preço para a vaga " + idVaga + ": R$" + preco);
        } else {
            System.out.println("ID de vaga inválido.");
        }
    }

    private static void exibirInformacoesVagas() {
        System.out.println("Informações sobre as vagas:");
        for (Vaga vaga : vagas) {
            System.out.println(vaga.toString());
        }
        System.out.println();
    }

    private static void informarVagasAtivas() {
        System.out.println("Vagas ativas:");
        for (Vaga vaga : vagas) {
            if (vaga.isOcupada()) {
                System.out.println(vaga.toString());
            }
        }
        System.out.println();
    }

    private static void informarQuantidadeVagasCadastradas() {
        System.out.println("Quantidade de vagas cadastradas: " + vagas.size() + "\n");
    }

    private static int encontrarProximaVagaLivre(String endereco, double area) {
        for (Vaga vaga : vagas) {
            if (!vaga.isOcupada() && vaga.getEndereco().equals(endereco) && vaga.getArea() == area) {
                return vaga.getId();
            }
        }
        return -1;
    }

    private static void gerarRelatorioUsoVagas() {
        System.out.println("Relatório de uso de vagas:");
        for (Vaga vaga : vagas) {
            System.out.println("Vaga " + vaga.getId() + ": Ocupada " + contarOcupacoesVaga(vaga.getId()) + " vezes");
        }
    }

    private static int contarOcupacoesVaga(int idVaga) {
        int contador = 0;
        for (Vaga vaga : vagas) {
            if (vaga.getId() == idVaga && vaga.isOcupada()) {
                contador++;
            }
        }
        return contador;
    }
}
