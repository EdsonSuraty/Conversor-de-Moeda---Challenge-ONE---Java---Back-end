import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConsultaMoedas {

    private static String getApiKey() throws IOException {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
        }
        return props.getProperty("api_key");
    }

    public Moeda buscaMoeda(String codigoMoeda) throws IOException{

        //Faz a conexão com a API
        String apiKey = getApiKey();
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + codigoMoeda);

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endereco)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            System.out.println("JSON recebido da API: " + json); //Teste do Json no cosole

            return new Gson().fromJson(json, Moeda.class);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível realizar a consulta. Erro: " + e.getMessage());
        }
    }
}
