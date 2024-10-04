import java.util.Comparator;
import java.util.Scanner;

public class ViewCadVeiculo {
    private static ServiceVeiculo service = new ServiceVeiculo();
    static Scanner input = new Scanner(System.in);

    public static void limparTela() {       
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void aguardarEnter() {
        System.out.print("Pressione Enter para continuar...");
        input.nextLine();
    }

    private static int inputNumerico(String mensagem) {
        int valor = 0;
        boolean entradaValida = false;
        System.out.print(mensagem);
        do {
            String valorStr = input.nextLine();
            try {
                valor = Integer.parseInt(valorStr);
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("ERRO. Valor informado deve ser um número Inteiro");
            }
        } while (!entradaValida);
        return valor;
    }

    private static void adicionar() {
        limparTela();
        Veiculo novoVeiculo = null;
        System.out.println("======== ADICIONANDO NOVO VEICULO ========");
        int tipoVeiculo = 0;
        do {
            tipoVeiculo = inputNumerico("Qual o tipo de veiculo: (1) Carro - (2) Moto");
            if (tipoVeiculo == 1) {
                novoVeiculo = new Carro();
            } else if (tipoVeiculo == 2) {
                novoVeiculo = new Moto();
            } else {
                System.out.println("Opção inválida");
            }
        } while (novoVeiculo == null);
        
        System.out.print("Informe o modelo do veículo: ");
        String modelo = input.nextLine();
        novoVeiculo.setModelo(modelo);

        System.out.print("Informe a marca do veículo: ");
        novoVeiculo.setMarca(input.nextLine());

        int ano = inputNumerico("Informe o ano de Fabricação: ");
        novoVeiculo.setAno(ano);

        System.out.print("Informe a placa do veículo: ");
        String placa = input.nextLine();
        novoVeiculo.setPlaca(placa);

        if (tipoVeiculo == 1) {
            int nPortas = inputNumerico("Informe o nº de portas: ");
            ((Carro) novoVeiculo).setNumeroPortas(nPortas);
        } else if (tipoVeiculo == 2) {
            System.out.print("Informe se o veículo possui partida elétrica (1 para Sim / 0 para Não): ");
            int partidaEletrica = inputNumerico("");
            ((Moto) novoVeiculo).setPartidaEletrica(partidaEletrica == 1);
        }

        try {
            service.adicionar(novoVeiculo);
            System.out.println("Veiculo adicionado com Sucesso!");
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        aguardarEnter();
    }

    private static void listar() {
        limparTela();

       
        var veiculos = service.pesquisarTodos();

        System.out.println("======== LISTA DE VEÍCULOS =========");

     
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
        } else {
           
            for (Veiculo veiculo : veiculos) {
                System.out.println(veiculo.getClass().getSimpleName());
                System.out.println(veiculo); 
                System.out.println("------------------------------------");
            }
        }
        aguardarEnter();
    }

    private static void pesquisarPorPlaca() {
        limparTela();
        System.out.println("====== PESQUISAR VEÍCULOS ======");
        System.out.print("Insira a placa do veículo: ");
        String placa = input.nextLine();
        Veiculo veiculo = service.pesquisarPorPlaca(placa);
        if (veiculo == null) {
            System.out.println("Não foram encontrados veículos com esta placa.");
        } else {
            System.out.println(veiculo);
        }
        aguardarEnter();
    }

    private static void removerPorPlaca() {
        limparTela();
        System.out.println("====== EXCLUIR VEÍCULO ======");
        System.out.print("Insira a placa do veiculo que deseja remover: ");
        String placa = input.nextLine();
        try {
            service.removerPorPlaca(placa);
            System.out.println("Veiculo removido com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        aguardarEnter();
    }

    public static void main(String[] args) {
        String menu = """
                SISTEMA DE GERENCIAMENTO DE FROTAS
                Menu de Opções:
                1 - Cadastrar novo Veículo;
                2 - Listar todos Veículos cadastrados;
                3 - Pesquisar Veículo pela placa;
                4 - Remover Veículo;
                0 - Sair;
                Digite a opção desejada:
                """;
        int opcao;
        do {
            limparTela();
            opcao = inputNumerico(menu);
            switch (opcao) {
                case 0:
                    System.out.println("VOLTE SEMPRE!!!");
                    break;
                case 1:
                    adicionar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    pesquisarPorPlaca();
                    break;
                case 4:
                    removerPorPlaca();  
                    break;
                default:
                    System.out.println("Opção Inválida!!!");
                    aguardarEnter();
                    break;
            }
        } while (opcao != 0);
    }
}
