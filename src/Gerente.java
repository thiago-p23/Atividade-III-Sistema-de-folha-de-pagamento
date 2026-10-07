// Classe Gerente.
// Herda os atributos e métodos da classe Funcionario.
public class Gerente extends Funcionario {

    // Construtor do gerente.
    // O super() chama o construtor da classe Funcionario.
    public Gerente(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }

    // @Override indica que estamos sobrescrevendo
    // um método que existe na classe Funcionario.
    @Override
    public double calcularBonificacao() {

        // O gerente recebe 20% do salário como bonificação.
        return getSalario() * 0.20;
    }
}