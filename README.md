# Atividade-III-Sistema-de-folha-de-pagamento

**TechSolutions**

## 1. Descrição do Projeto

O Sistema de Folha de Pagamento foi desenvolvido em Java com o objetivo de automatizar o cálculo da remuneração dos funcionários da empresa TechSolutions.

O sistema permite cadastrar funcionários de diferentes categorias, calcular suas bonificações e exibir seus respectivos holerites. Também realiza o cálculo do valor total da folha de pagamento da empresa.

A aplicação utiliza conceitos de Programação Orientada a Objetos (POO), como encapsulamento, herança, abstração e polimorfismo, facilitando a organização do código e a inclusão de novas categorias de funcionários no futuro.

## 2. Objetivos

* Automatizar o cálculo das bonificações dos funcionários.
* Calcular a remuneração total de cada funcionário.
* Permitir o cadastro de diferentes categorias de funcionários.
* Validar informações para evitar dados inválidos.
* Aplicar os principais conceitos de Programação Orientada a Objetos.
* Facilitar a manutenção e a expansão do sistema.

## 3. Funcionalidades

O sistema possui as seguintes funcionalidades:

* Cadastrar funcionários.
* Escolher o cargo do funcionário.
* Informar nome, CPF e salário.
* Informar o total vendido no mês, no caso de vendedores.
* Listar os funcionários cadastrados.
* Exibir o holerite de cada funcionário.
* Calcular a folha de pagamento.
* Executar testes das regras de negócio.
* Validar os dados informados pelo usuário.

## 4. Regras de Negócio

### Funcionário

Todo funcionário possui:

* Nome.
* CPF.
* Salário.

O nome não pode ser vazio e o salário deve ser maior que zero.

O CPF é armazenado pelo sistema, mas não possui validação obrigatória.

### Gerente

O gerente recebe uma bonificação equivalente a 20% do salário.

**Fórmula:**

```text
Bonificação = Salário × 0,20
```

Exemplo:

```text
Salário: R$ 10.000,00
Bonificação: R$ 2.000,00
Remuneração total: R$ 12.000,00
```

### Desenvolvedor

O desenvolvedor recebe uma bonificação equivalente a 10% do salário.

**Fórmula:**

```text
Bonificação = Salário × 0,10
```

Exemplo:

```text
Salário: R$ 7.000,00
Bonificação: R$ 700,00
Remuneração total: R$ 7.700,00
```

### Vendedor

O vendedor recebe uma bonificação de 5% do salário, além de uma comissão de 5% sobre o total vendido no mês.

**Fórmulas:**

```text
Bonificação sobre o salário = Salário × 0,05

Comissão = Total vendido × 0,05

Bonificação total = Bonificação sobre o salário + Comissão

Remuneração total = Salário + Bonificação total
```

Exemplo:

```text
Salário: R$ 5.000,00
Total vendido: R$ 100.000,00

Bonificação sobre o salário: R$ 250,00
Comissão: R$ 5.000,00
Bonificação total: R$ 5.250,00
Remuneração total: R$ 10.250,00
```

### Remuneração Total

A remuneração total de cada funcionário é calculada pela soma do salário com sua bonificação.

```text
Remuneração Total = Salário + Bonificação
```

## 5. Estrutura do Projeto

```text
src/
├── Funcionario.java
├── Gerente.java
├── Desenvolvedor.java
├── Vendedor.java
└── Main.java
```

### Funcionario.java

Classe abstrata que representa um funcionário de forma geral.

Contém os atributos nome, CPF e salário, além dos métodos de consulta, alteração com validação, cálculo da remuneração total e exibição do holerite.

Também define o método abstrato `calcularBonificacao()`, que deve ser implementado pelas classes especializadas.

### Gerente.java

Classe que herda de `Funcionario` e implementa o cálculo da bonificação de 20% sobre o salário.

### Desenvolvedor.java

Classe que herda de `Funcionario` e implementa o cálculo da bonificação de 10% sobre o salário.

### Vendedor.java

Classe que herda de `Funcionario` e adiciona o atributo `totalVendido`.

Possui métodos para consultar o total vendido, validar esse valor e calcular a comissão de 5% sobre as vendas.

### Main.java

Classe responsável pela execução do programa e pela interação com o usuário.

Apresenta o menu principal, realiza o cadastro dos funcionários, lista os registros, calcula a folha de pagamento e executa os testes.

## 6. Conceitos de Programação Orientada a Objetos

### Encapsulamento

O encapsulamento é aplicado por meio dos atributos privados das classes.

Exemplo:

```java
private String nome;
private String cpf;
private double salario;
```

Esses atributos não podem ser acessados diretamente de outras classes.

O acesso é realizado por métodos específicos, como `getNome()`, `getCpf()` e `getSalario()`.

Os métodos responsáveis por alterar os dados possuem validações para impedir valores inválidos, como um salário igual a zero.

### Herança

A herança permite que as classes `Gerente`, `Desenvolvedor` e `Vendedor` reutilizem os atributos e métodos da classe `Funcionario`.

Exemplo:

```java
public class Gerente extends Funcionario
```

Isso evita a repetição de código e permite que cada categoria tenha suas próprias regras.

### Abstração

A classe `Funcionario` é abstrata, pois representa um conceito geral de funcionário.

```java
public abstract class Funcionario
```

Ela também define o método abstrato:

```java
public abstract double calcularBonificacao();
```

Cada classe especializada implementa esse método de acordo com sua própria regra de bonificação.

### Polimorfismo

O polimorfismo permite armazenar diferentes categorias de funcionários em uma mesma coleção.

```java
ArrayList<Funcionario> funcionarios = new ArrayList<>();
```

Dessa forma, o sistema pode percorrer a lista e chamar métodos como `calcularBonificacao()` e `exibirHolerite()`, executando a implementação correspondente ao tipo de funcionário.

## 7. Validações

O sistema possui validações para garantir que os dados respeitem as regras de negócio.

| Campo             | Regra                                    |
| ----------------- | ---------------------------------------- |
| Nome              | Não pode ser vazio                       |
| CPF               | Não possui validação obrigatória         |
| Salário           | Deve ser maior que zero                  |
| Cargo             | Deve corresponder a uma opção disponível |
| Total vendido     | Não pode ser negativo                    |
| Valores numéricos | Devem ser informados em formato válido   |

As validações são realizadas tanto na entrada de dados do `Main` quanto nas classes responsáveis pelas regras de negócio.

O programa utiliza estruturas de repetição para solicitar novamente os dados quando o usuário informa um valor inválido.

Também utiliza tratamento de exceções com `try/catch` para lidar com entradas incorretas.

## 8. Menu do Sistema

Ao iniciar o programa, o usuário encontra as seguintes opções:

```text
==========================================
       SISTEMA DE FOLHA DE PAGAMENTO
==========================================
1 - Cadastrar funcionário
2 - Listar funcionários
3 - Calcular folha de pagamento
4 - Executar testes
0 - Sair
==========================================
```

### Cadastrar funcionário

Permite informar os dados do funcionário, escolher seu cargo e, quando necessário, informar o total vendido no mês.

### Listar funcionários

Exibe os funcionários cadastrados e seus respectivos holerites.

### Calcular folha de pagamento

Soma a remuneração total de todos os funcionários cadastrados.

### Executar testes

Executa verificações relacionadas às regras de negócio e aos cálculos de bonificação e comissão.

### Sair

Encerra a execução do programa.

## 9. Cálculo da Folha de Pagamento

O total da folha é calculado percorrendo a coleção de funcionários e somando a remuneração total de cada um.

```java
double totalFolha = 0;

for (Funcionario funcionario : funcionarios) {
    totalFolha += funcionario.calcularRemuneracaoTotal();
}
```

Esse processo utiliza o polimorfismo para calcular corretamente a remuneração de cada categoria.

## 10. Testes

O sistema contempla os seguintes testes:

* Criação de funcionário com dados válidos.
* Tentativa de cadastrar nome vazio.
* Tentativa de cadastrar salário igual a zero.
* Cálculo da bonificação do gerente.
* Cálculo da bonificação do desenvolvedor.
* Cálculo da comissão do vendedor.
* Cálculo da remuneração total.
* Cálculo da folha de pagamento.

Os testes de validação verificam se o sistema impede operações que violem as regras definidas.

## 11. Exemplo de Resultado

Considerando os seguintes funcionários:

| Funcionário   | Cargo         |      Salário | Bonificação | Remuneração total |
| ------------- | ------------- | -----------: | ----------: | ----------------: |
| Mariana Souza | Gerente       | R$ 10.000,00 | R$ 2.000,00 |      R$ 12.000,00 |
| Carlos Lima   | Desenvolvedor |  R$ 7.000,00 |   R$ 700,00 |       R$ 7.700,00 |
| João Santos   | Vendedor      |  R$ 5.000,00 | R$ 5.250,00 |      R$ 10.250,00 |

O resultado da folha de pagamento será:

```text
Total da folha: R$ 29950,00
```

## 12. Tecnologias Utilizadas

* Java
* Java Development Kit (JDK)
* Programação Orientada a Objetos
* ArrayList
* Scanner
* IntelliJ IDEA

## 13. Como Executar o Projeto

### Pré-requisitos

É necessário ter o JDK instalado e configurado no computador.

### Executando pela IntelliJ IDEA

1. Abra o projeto no IntelliJ IDEA.
2. Acesse a pasta `src`.
3. Abra o arquivo `Main.java`.
4. Execute o método `main`.
5. Utilize o menu exibido no console.

### Executando pelo terminal

Acesse a pasta que contém os arquivos `.java` e compile o projeto:

```bash
javac *.java
```

Depois, execute:

```bash
java Main
```

## 14. Possíveis Melhorias Futuras

O sistema pode ser expandido com novas funcionalidades, como:

* Cadastro de novas categorias de funcionários.
* Validação completa do CPF.
* Armazenamento dos funcionários em arquivos ou banco de dados.
* Edição e remoção de funcionários cadastrados.
* Geração de relatórios da folha de pagamento.
* Criação de testes automatizados.

A estrutura baseada em uma classe abstrata e em classes especializadas facilita a implementação dessas melhorias.

## 15. Conclusão

O desenvolvimento do Sistema de Folha de Pagamento permitiu aplicar conceitos fundamentais de Programação Orientada a Objetos em Java.

O projeto demonstra como utilizar encapsulamento para proteger os dados, herança para reutilizar código, abstração para definir comportamentos comuns e polimorfismo para trabalhar com diferentes categorias de funcionários.

Além disso, a implementação de validações e de um menu interativo torna o sistema mais organizado e adequado às regras de negócio propostas.

A estrutura também permite adicionar novas categorias de funcionários futuramente, mantendo a organização e facilitando a manutenção do código.
