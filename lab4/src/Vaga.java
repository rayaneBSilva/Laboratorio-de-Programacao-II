public class Vaga {

    private static int contadorIds = 0;
    private int id;
    private String endereco;
    private int numeracao;
    private String linkGoogleMaps;
    private double area;
    private double valorPorHora;
    private boolean ocupada;

    public Vaga(String endereco, int numeracao , String linkGoogleMaps, double area){
        this.endereco = endereco;
        this.numeracao = numeracao;
        this.linkGoogleMaps = linkGoogleMaps;
        this.area = area;
        this.valorPorHora = 3.0;
        this.ocupada = false;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public String getLinkGoogleMaps() {
        return linkGoogleMaps;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setLinkGoogleMaps(String linkGoogleMaps) {
        this.linkGoogleMaps = linkGoogleMaps;
    }

    public int getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(int numeracao) {
        this.numeracao = numeracao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getContadorIds() {
        return contadorIds;
    }

    public static void setContadorIds(int contadorIds) {
        Vaga.contadorIds = contadorIds;
    }
    @Override
    public String toString() {
        String status = ocupada ? "OCUPADA" : "LIVRE";
        return id + " - " + endereco + " - " + (linkGoogleMaps != null ? linkGoogleMaps : "") + " - " + status;
    }
}