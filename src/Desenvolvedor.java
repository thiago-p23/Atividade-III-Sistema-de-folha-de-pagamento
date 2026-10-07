// Classe Desenvolvedor.
// Também herda da classe Funcionario.
public class Desenvolvedor extends Funcionario {

    // Construtor do desenvolvedor.
    public Desenvolvedor(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }

    // Implementação da regra de bonificação
    // específica do desenvolvedor.
    @Override
    public double calcularBonificacao() {

        // O desenvolvedor recebe 10% do salário.
        return getSalario() * 0.10;
    }
}