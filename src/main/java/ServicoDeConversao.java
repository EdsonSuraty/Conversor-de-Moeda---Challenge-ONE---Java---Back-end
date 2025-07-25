import java.io.IOException;

public class ServicoDeConversao {

    private ConsultaMoedas consulta;

    // Construtor que recebe a ferramenta de consulta
    public ServicoDeConversao(ConsultaMoedas consulta) {
        this.consulta = consulta;
    }

    public double calcularConversao(String moedaOrigem, String moedaDestino, double valor) throws IOException, NullPointerException {

        // 1. Usa o consultor para buscar o objeto Moeda com todas as taxas
        Moeda moeda = this.consulta.buscaMoeda(moedaOrigem);

        // 2. Do objeto Moeda, pega a taxa específica que nos interessa
        double taxaDeCambio = moeda.conversion_rates().get(moedaDestino);

        // 3. Realiza o cálculo e retorna
        return valor * taxaDeCambio;
    }
}