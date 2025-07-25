import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Principal {
    public static void main(String[] args){

        ConsultaMoedas consulta = new ConsultaMoedas();

        try {
            Moeda moedaCompleta = consulta.buscaMoeda("USD");

            System.out.println("Busca realizada com sucesso!");

            List<String> moedasDeInteresse = List.of("BRL", "EUR", "GBP", "ARS", "CLP");

            Map<String, Double> taxasRelevantes = moedaCompleta.getTaxasFiltradas(moedasDeInteresse);

            System.out.println("TAXAS DE CÂMBIO DE INTERESSE:");

            taxasRelevantes.forEach((moeda, taxa) -> System.out.println(moeda + ": " + taxa));

        } catch (IOException e) {
            System.out.println("ERRO: Não foi possível obter os dados da cotação.");
            System.out.println("Causas prováveis: falha na conexão com a internet ou o arquivo de API Key não foi encontrado.");
            System.out.println("Detalhe técnico do erro: " + e.getMessage());
        }

        System.out.println("Fim do programa de conversão.");
    }
}
