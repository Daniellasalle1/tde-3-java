package View;

import java.util.Scanner;
import Controller.VeiculoController;
import model.*;

public class Principal {
    private static VeiculoController controller = new VeiculoController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Digite sua opção: ");
            try {
                processarOpcao(opcao);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 5);
    }

    private static void exibirMenu() {
        System.out.println("\n=== Sistema de Cadastro de Veículos ===");
        System.out.println("1. Cadastrar Veículo");
        System.out.println("2. Listar Veículos");
        System.out.println("3. Atualizar Veículo");
        System.out.println("4. Remover Veículo");
        System.out.println("5. Sair");
    }

    private static void processarOpcao(int opcao) throws Exception {
        switch (opcao) {
            case 1:
                cadastrarVeiculo();
                break;
            case 2:
                listarVeiculos();
                break;
            case 3:
                atualizarVeiculo();
                break;
            case 4:
                removerVeiculo();
                break;
            case 5:
                System.out.println("Saindo do sistema...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void cadastrarVeiculo() throws Exception {
        System.out.println("\n--- Cadastro de Veículo ---");
        System.out.println("1. Carro");
        System.out.println("2. Moto");
        System.out.println("3. Caminhão");
        int tipo = lerInteiro("Escolha o tipo: ");

        String placa = lerString("Placa: ");
        String marca = lerString("Marca: ");
        String modelo = lerString("Modelo: ");

        switch (tipo) {
            case 1:
                int portas = lerInteiro("Número de portas: ");
                controller.cadastrarVeiculo(new Carro(placa, marca, modelo, portas));
                break;
            case 2:
                int cilindradas = lerInteiro("Cilindradas: ");
                controller.cadastrarVeiculo(new Moto(placa, marca, modelo, cilindradas));
                break;
            case 3:
                int eixos = lerInteiro("Número de eixos: ");
                controller.cadastrarVeiculo(new Caminhao(placa, marca, modelo, eixos));
                break;
            default:
                throw new Exception("Tipo de veículo inválido");
        }
        System.out.println("Veículo cadastrado com sucesso!");
    }

    private static void listarVeiculos() {
        System.out.println("\n--- Lista de Veículos ---");
        if (controller.listarVeiculos().isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        for (Veiculo v : controller.listarVeiculos()) {
            v.exibirDetalhes();
            System.out.println("-------------------");
        }
    }

    private static void atualizarVeiculo() throws Exception {
        System.out.println("\n--- Atualizar Veículo ---");
        String placa = lerString("Digite a placa do veículo: ");

        System.out.println("Novos dados:");
        String marca = lerString("Marca: ");
        String modelo = lerString("Modelo: ");

        Veiculo veiculo = controller.buscarVeiculo(placa);

        if (veiculo instanceof Carro) {
            int portas = lerInteiro("Número de portas: ");
            controller.atualizarVeiculo(placa, new Carro(placa, marca, modelo, portas));
        } else if (veiculo instanceof Moto) {
            int cilindradas = lerInteiro("Cilindradas: ");
            controller.atualizarVeiculo(placa, new Moto(placa, marca, modelo, cilindradas));
        } else if (veiculo instanceof Caminhao) {
            int eixos = lerInteiro("Número de eixos: ");
            controller.atualizarVeiculo(placa, new Caminhao(placa, marca, modelo, eixos));
        }
        System.out.println("Veículo atualizado com sucesso!");
    }

    private static void removerVeiculo() throws Exception {
        System.out.println("\n--- Remover Veículo ---");
        String placa = lerString("Digite a placa do veículo: ");
        controller.removerVeiculo(placa);
        System.out.println("Veículo removido com sucesso!");
    }
    
    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        }
    }
}