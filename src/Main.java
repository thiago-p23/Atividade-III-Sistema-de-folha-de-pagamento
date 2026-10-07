import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Scanner utilizado para receber informações
    // digitadas pelo usuário.
    static Scanner scanner = new Scanner(System.in);

    // ArrayList que armazena todos os funcionários cadastrados.
    //
    // O tipo Funcionario permite armazenar:
    // Gerente, Desenvolvedor e Vendedor.
    static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;

        // O menu será exibido repetidamente até
        // o usuário escolher a opção 0.
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            // Verifica qual opção o usuário escolheu.
            switch (opcao) {
                case 1:
                    // Cadastra um novo funcionário.
                    cadastrarFuncionario();
                    break;

                case 2:
                    // Exibe todos os funcionários.
                    listarFuncionarios();
                    break;

                case 3:
                    // Calcula o total da folha.
                    calcularFolha();
                    break;

                case 4:
                    // Executa os testes obrigatórios.
                    executarTestes();
                    break;

                case 0:
                    // Encerra o programa.
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    // Caso o usuário escolha uma opção
                    // que não existe no menu.
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        // Fecha o Scanner ao terminar o programa.
        scanner.close();
    }

    // ==========================================
    // EXIBIR MENU
    // ==========================================

    public static void exibirMenu() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("       SISTEMA DE FOLHA DE PAGAMENTO");
        System.out.println("==========================================");
        System.out.println("1 - Cadastrar funcionário");
        System.out.println("2 - Listar funcionários");
        System.out.println("3 - Calcular folha de pagamento");
        System.out.println("4 - Executar testes");
        System.out.println("0 - Sair");
        System.out.println("==========================================");
    }

    // ==========================================
    // CADASTRAR FUNCIONÁRIO
    // ==========================================

    public static void cadastrarFuncionario() {

        System.out.println();
        System.out.println("=== CADASTRO DE FUNCIONÁRIO ===");

        // Solicita o nome ao usuário.
        String nome = lerNome();

        // Solicita o CPF.
        // O CPF não possui validação obrigatória.
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();

        // Solicita o salário.
        // O método já possui validação.
        double salario = lerSalario();

        // Solicita o cargo.
        int cargo = lerCargo();

        try {

            Funcionario funcionario;

            // Cria o objeto de acordo com o cargo escolhido.
            switch (cargo) {

                case 1:
                    funcionario = new Gerente(nome, cpf, salario);
                    break;

                case 2:
                    funcionario = new Desenvolvedor(nome, cpf, salario);
                    break;

                case 3:

                    // Apenas o vendedor precisa
                    // informar o total vendido.
                    double totalVendido = lerTotalVendido();
                    funcionario = new Vendedor(nome, cpf, salario, totalVendido);
                    break;

                default:
                    System.out.println("Cargo inválido.");
                    return;
            }

            // Adiciona o funcionário na lista.
            funcionarios.add(funcionario);

            System.out.println();
            System.out.println("Funcionário cadastrado com sucesso!");

        } catch (IllegalArgumentException e) {

            // Mostra a mensagem caso alguma validação
            // das classes encontre um problema.
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }

    // ==========================================
    // VALIDAÇÃO DO NOME
    // ==========================================

    public static String lerNome() {

        while (true) {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            // Verifica se o usuário deixou o campo vazio.
            if (nome.trim().isEmpty()) {
                System.out.println("Erro: o nome não pode ser vazio.");
            } else {
                // Se estiver correto, retorna o nome.
                return nome;
            }
        }
    }

    // ==========================================
    // VALIDAÇÃO DO SALÁRIO
    // ==========================================

    public static double lerSalario() {

        while (true) {
            System.out.print("Digite o salário: ");
            String entrada = scanner.nextLine();

            try {
                // Converte o texto digitado para double.
                //
                // O replace permite aceitar tanto:
                // 5000.50
                // quanto:
                // 5000,50
                double salario = Double.parseDouble(entrada.replace(",", "."));

                // O salário precisa ser maior que zero.
                if (salario <= 0) {
                    System.out.println("Erro: o salário deve ser maior que zero.");
                } else {
                    return salario;
                }

            } catch (NumberFormatException e) {

                // Executado quando o usuário digita
                // algo que não pode ser convertido para número.
                System.out.println("Erro: digite um valor numérico válido.");
            }
        }
    }

    // ==========================================
    // VALIDAÇÃO DO CARGO
    // ==========================================

    public static int lerCargo() {

        while (true) {

            System.out.println();
            System.out.println("Escolha o cargo:");
            System.out.println("1 - Gerente");
            System.out.println("2 - Desenvolvedor");
            System.out.println("3 - Vendedor");

            int cargo = lerInteiro("Digite a opção: ");

            // Verifica se a opção está entre 1 e 3.
            if (cargo >= 1 && cargo <= 3) {
                return cargo;
            } else {
                System.out.println("Erro: escolha uma opção entre 1 e 3.");
            }
        }
    }

    // ==========================================
    // VALIDAÇÃO DO TOTAL VENDIDO
    // ==========================================

    public static double lerTotalVendido() {

        while (true) {
            System.out.print("Digite o total vendido no mês: ");

            String entrada = scanner.nextLine();

            try {

                double total = Double.parseDouble(entrada.replace(",", "."));

                // O total vendido não pode ser negativo.
                if (total < 0) {
                    System.out.println("Erro: o total vendido não pode ser negativo.");
                } else {
                    return total;
                }

            } catch (NumberFormatException e) {

                // Trata entradas como "abc", por exemplo.
                System.out.println("Erro: digite um valor numérico válido.");
            }
        }
    }

    // ==========================================
    // LER NÚMERO INTEIRO
    // ==========================================

    public static int lerInteiro(String mensagem) {

        while (true) {

            System.out.print(mensagem);
            String entrada = scanner.nextLine();

            try {
                // Tenta transformar o texto em inteiro.
                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {

                // Caso o usuário digite letras ou
                // outro valor que não seja inteiro.
                System.out.println("Erro: digite um número inteiro válido.");
            }
        }
    }

    // ==========================================
    // LISTAR FUNCIONÁRIOS
    // ==========================================

    public static void listarFuncionarios() {

        // Verifica se existem funcionários cadastrados.
        if (funcionarios.isEmpty()) {
            System.out.println();
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println();
        System.out.println("=== FUNCIONÁRIOS CADASTRADOS ===");

        // Percorre todos os funcionários da lista.
        for (Funcionario funcionario : funcionarios) {

            // O polimorfismo permite que cada funcionário
            // utilize sua própria implementação.
            funcionario.exibirHolerite();
        }
    }

    // ==========================================
    // CALCULAR FOLHA
    // ==========================================

    public static void calcularFolha() {

        // Não há folha para calcular se não houver
        // funcionários cadastrados.
        if (funcionarios.isEmpty()) {
            System.out.println();
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        // Começa o total da folha em zero.
        double totalFolha = 0;

        // Percorre todos os funcionários.
        for (Funcionario funcionario : funcionarios) {

            // Soma a remuneração total de cada funcionário.
            totalFolha +=
                    funcionario.calcularRemuneracaoTotal();
        }
        System.out.println();
        System.out.println("=== FOLHA DE PAGAMENTO ===");
        System.out.printf("Total da folha: R$ %.2f%n", totalFolha);
    }

    // ==========================================
    // TESTES
    // ==========================================

    public static void executarTestes() {
        System.out.println();
        System.out.println("=== TESTES OBRIGATÓRIOS ===");

        // Teste de nome vazio.
        testarNomeVazio();

        // Teste de salário igual a zero.
        testarSalarioZero();

        // Criação de funcionários para testar
        // os cálculos de bonificação.
        Gerente gerente = new Gerente("Mariana Souza", "111.111.111-11", 10000);
        Desenvolvedor desenvolvedor = new Desenvolvedor("Carlos Lima", "222.222.222-22", 7000);
        Vendedor vendedor = new Vendedor("João Santos", "333.333.333-33", 5000, 100000);

        // Testa a bonificação de cada categoria.
        testarBonificacaoGerente(gerente);
        testarBonificacaoDesenvolvedor(desenvolvedor);
        testarComissaoVendedor(vendedor);
    }

    // ==========================================
    // TESTE DE NOME VAZIO
    // ==========================================

    public static void testarNomeVazio() {

        try {
            // Tenta criar um funcionário sem nome.
            new Gerente("", "444.444.444-44", 5000);

        } catch (IllegalArgumentException e) {

            // Se a exceção acontecer, significa
            // que a validação funcionou.
            System.out.println("Teste nome vazio: PASSOU");
        }
    }

    // ==========================================
    // TESTE DE SALÁRIO ZERO
    // ==========================================

    public static void testarSalarioZero() {

        try {

            // Tenta criar um funcionário
            // com salário igual a zero.
            new Gerente("Pedro", "555.555.555-55", 0);

        } catch (IllegalArgumentException e) {

            // A exceção indica que a validação funcionou.
            System.out.println("Teste salário zero: PASSOU");
        }
    }

    // ==========================================
    // TESTE DO GERENTE
    // ==========================================

    public static void testarBonificacaoGerente(
            Gerente gerente) {

        double resultado = gerente.calcularBonificacao();
        System.out.printf("Bonificação gerente: R$ %.2f%n", resultado);
    }

    // ==========================================
    // TESTE DO DESENVOLVEDOR
    // ==========================================

    public static void testarBonificacaoDesenvolvedor(
            Desenvolvedor desenvolvedor) {

        double resultado = desenvolvedor.calcularBonificacao();
        System.out.printf("Bonificação desenvolvedor: R$ %.2f%n", resultado);
    }

    // ==========================================
    // TESTE DO VENDEDOR
    // ==========================================

    public static void testarComissaoVendedor(
            Vendedor vendedor) {

        double resultado = vendedor.calcularComissao();
        System.out.printf("Comissão vendedor: R$ %.2f%n", resultado);
    }
}