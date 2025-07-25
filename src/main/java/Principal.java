import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (UnsupportedEncodingException e) {
            System.err.println("Erro ao configurar o encoding: " + e.getMessage());
        }

        // 1. Inicializa as ferramentas que vamos precisar uma única vez
        Scanner scanner = new Scanner(System.in);
        ConsultaMoedas consulta = new ConsultaMoedas();
        ServicoDeConversao servico = new ServicoDeConversao(consulta);

        // 2. Define o texto do menu para reutilização
        String menu = """
                
                ***************************************************
                Seja bem-vindo(a) ao Conversor de Moedas!
                
                1) Dólar Americano (USD) =>> Real Brasileiro (BRL)
                2) Real Brasileiro (BRL) =>> Dólar Americano (USD)
                3) Euro (EUR) =>> Real Brasileiro (BRL)
                4) Real Brasileiro (BRL) =>> Euro (EUR)
                5) Peso Argentino (ARS) =>> Real Brasileiro (BRL)
                6) Real Brasileiro (BRL) =>> Peso Argentino (ARS)
                7) Sair
                ***************************************************
                """;

        // 3. Loop principal que mantém o programa rodando
        while (true) {
            System.out.println(menu);
            System.out.print("Escolha uma opção válida: ");
            String opcao = scanner.nextLine(); // Lê a opção como texto

            // 4. Condição de saída do programa
            if (opcao.equalsIgnoreCase("7")) {
                System.out.println("Obrigado por usar o Conversor de Moedas! Finalizando...");
                break; // Interrompe o loop 'while'
            }

            String moedaOrigem = "";
            String moedaDestino = "";

            // 5. Define as moedas com base na opção do usuário
            switch (opcao) {
                case "1":
                    moedaOrigem = "USD";
                    moedaDestino = "BRL";
                    break;
                case "2":
                    moedaOrigem = "BRL";
                    moedaDestino = "USD";
                    break;
                case "3":
                    moedaOrigem = "EUR";
                    moedaDestino = "BRL";
                    break;
                case "4":
                    moedaOrigem = "BRL";
                    moedaDestino = "EUR";
                    break;
                case "5":
                    moedaOrigem = "ARS";
                    moedaDestino = "BRL";
                    break;
                case "6":
                    moedaOrigem = "BRL";
                    moedaDestino = "ARS";
                    break;
                default:
                    System.out.println("\nOpção inválida! Por favor, escolha um número de 1 a 7.\n");
                    continue; // Pula o resto do código e volta para o início do loop
            }

            // 6. Bloco de execução principal com tratamento de erros
            try {
                System.out.print("Digite o valor que deseja converter: ");
                double valor = scanner.nextDouble();

                // IMPORTANTE: Consumir a quebra de linha que o nextDouble() deixa para trás
                scanner.nextLine();

                // Chama nosso serviço especialista para fazer todo o trabalho
                double valorConvertido = servico.calcularConversao(moedaOrigem, moedaDestino, valor);

                // Exibe o resultado formatado para o usuário
                System.out.println("----------------------------------------");
                System.out.printf("Valor %.2f [%s] corresponde ao valor final de =>> %.2f [%s]%n",
                        valor, moedaOrigem, valorConvertido, moedaDestino);
                System.out.println("----------------------------------------");

            } catch (InputMismatchException e) {
                System.out.println("\nERRO: Valor inválido. Por favor, digite apenas números (use a vírgula ',' para decimais).\n");
                scanner.nextLine(); // Limpa o buffer do scanner para a próxima tentativa
            } catch (IOException | NullPointerException e) {
                System.out.println("\nERRO na consulta: " + e.getMessage() + "\n");
            } catch (Exception e) {
                System.out.println("\nOcorreu um erro inesperado: " + e.getMessage() + "\n");
            }
        }

        scanner.close(); // Fecha o scanner ao final do programa
    }
}