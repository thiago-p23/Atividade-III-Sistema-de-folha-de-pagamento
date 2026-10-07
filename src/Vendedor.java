// Classe Vendedor.
// Herda as características da classe Funcionario.
public class Vendedor extends Funcionario {

    // Informação específica do vendedor:
    // quanto ele vendeu durante o mês.
    private double totalVendido;

    // Construtor do vendedor.
    public Vendedor(
            String nome,
            String cpf,
            double salario,
            double totalVendido) {

        // Inicializa os dados que pertencem à classe Funcionario.
        super(nome, cpf, salario);

        // Inicializa o total vendido.
        setTotalVendido(totalVendido);
    }

    // Retorna o total vendido pelo vendedor.
    public double getTotalVendido() {
        return totalVendido;
    }

    // Altera o total vendido.
    public void setTotalVendido(double totalVendido) {

        // O vendedor não pode possuir um total de vendas negativo.
        if (totalVendido < 0) {
            throw new IllegalArgumentException("O total vendido não pode ser negativo.");
        }

        this.totalVendido = totalVendido;
    }

    // Calcula a comissão do vendedor.
    public double calcularComissao() {

        // A comissão corresponde a 5% das vendas.
        return totalVendido * 0.05;
    }

    // Calcula a bonificação do vendedor.
    @Override
    public double calcularBonificacao() {

        // O vendedor recebe 5% do salário.
        double bonificacaoSalario = getSalario() * 0.05;

        // Além disso, recebe 5% sobre suas vendas.
        double comissao = calcularComissao();

        // Soma as duas partes da bonificação.
        return bonificacaoSalario + comissao;
    }

    // Exibe um holerite específico para o vendedor.
    @Override
    public void exibirHolerite() {

        System.out.println("------------------------------------------");
        System.out.println("Funcionário: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Cargo: Vendedor");
        System.out.printf("Salário: R$ %.2f%n", getSalario());
        System.out.printf("Total vendido: R$ %.2f%n", totalVendido);
        System.out.printf("Comissão: R$ %.2f%n", calcularComissao());
        System.out.printf("Bonificação: R$ %.2f%n", calcularBonificacao());
        System.out.printf("Remuneração total: R$ %.2f%n", calcularRemuneracaoTotal());
        System.out.println("------------------------------------------");
    }
}