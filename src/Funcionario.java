// Classe abstrata que representa um funcionário de forma geral.
// Não é possível criar um objeto diretamente dessa classe.
public abstract class Funcionario {

    // Atributos privados para proteger os dados.
    // Isso representa o encapsulamento.
    private String nome;
    private String cpf;
    private double salario;

    // Construtor da classe.
    // Recebe os dados necessários para criar um funcionário.
    public Funcionario(String nome, String cpf, double salario) {
        setNome(nome);
        setCpf(cpf);
        setSalario(salario);
    }

    // Retorna o nome do funcionário.
    public String getNome() {
        return nome;
    }

    // Retorna o CPF do funcionário.
    public String getCpf() {
        return cpf;
    }

    // Retorna o salário do funcionário.
    public double getSalario() {
        return salario;
    }

    // Altera o nome do funcionário.
    // O nome não pode ser vazio.
    public void setNome(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        this.nome = nome;
    }

    // Altera o CPF.
    // Não existe mais validação para o CPF.
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Altera o salário.
    // O salário precisa ser maior que zero.
    public void setSalario(double salario) {

        if (salario <= 0) {
            throw new IllegalArgumentException("O salário deve ser maior que zero.");
        }

        this.salario = salario;
    }

    // Método abstrato.
    // Cada tipo de funcionário deverá criar sua própria
    // maneira de calcular a bonificação.
    public abstract double calcularBonificacao();

    // Calcula a remuneração total do funcionário.
    //
    // Remuneração total =
    // salário + bonificação
    public double calcularRemuneracaoTotal() {
        return salario + calcularBonificacao();
    }

    // Exibe as informações básicas do holerite.
    public void exibirHolerite() {

        System.out.println("------------------------------------------");
        System.out.println("Funcionário: " + nome);
        System.out.println("CPF: " + cpf);

        // getClass().getSimpleName() pega o nome da classe.
        // Por exemplo: Gerente, Desenvolvedor ou Vendedor.
        System.out.println("Cargo: " + getClass().getSimpleName());
        System.out.printf("Salário: R$ %.2f%n", salario);
        System.out.printf("Bonificação: R$ %.2f%n", calcularBonificacao());
        System.out.printf("Remuneração total: R$ %.2f%n", calcularRemuneracaoTotal());
        System.out.println("------------------------------------------");
    }
}