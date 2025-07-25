import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record Moeda(String base_code, Map<String, Double> conversion_rates) {

    public Map<String, Double> getTaxasFiltradas(List<String> codigosMoedasDeInteresse) {

        Map<String, Double> taxasFiltradas = new HashMap<>();

        for (String codigo : codigosMoedasDeInteresse) {
            // Verifica se o mapa original (conversion_rates) contém aquela chave
            if (this.conversion_rates.containsKey(codigo)) {
                // Se contém, pega o valor (a taxa) e coloca no novo mapa
                taxasFiltradas.put(codigo, this.conversion_rates.get(codigo));
            }
        }

        return taxasFiltradas;
    }
}