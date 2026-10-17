# Sistema de Processamento de Contratos

Este projeto é um exercício prático de lógica e orientação a objetos desenvolvido em Java. O sistema tem como objetivo ler os dados de um contrato, calcular as parcelas mensais com base em uma quantidade de meses informada e aplicar as taxas de juros e pagamento de um serviço financeiro (simulando o PayPal).

## 🚀 Funcionalidades

* **Encapsulamento e Validação:** Entidades com atributos privados e validações do tipo *Fail-Fast* para impedir dados inconsistentes (valores negativos, datas nulas ou números de contrato inválidos).
* **Precisão Financeira:** Uso integral da classe `BigDecimal` para evitar perda de centavos por arredondamento de ponto flutuante.
* **Gerenciamento de Datas:** Uso da API `java.time.LocalDate` para calcular os vencimentos mensais de forma inteligente, lidando corretamente com anos bissextos e meses curtos.
* **Injeção de Dependência:** Arquitetura desacoplada utilizando interfaces, permitindo a troca fácil do serviço de pagamento (ex: PayPal) sem alterar as regras de negócio do contrato.

## 🛠️ Arquitetura do Projeto

O projeto segue uma estrutura de camadas bem definida no padrão Java:

```text
src/
└── model/
    ├── Entities/
    │   ├── Contract.java
    │   └── Installments.java
    └── services/
        ├── OnlinePaymentService.java
        ├── PaypalService.java
        └── ContractService.java
└── application/
    └── PaymentInInstallment.java
```

## 📊 Regras de Negócio (PayPal)

O cálculo das parcelas aplica as seguintes regras da interface de serviços:
1. **Cota Básica:** O valor total do contrato é dividido igualmente pelo número de meses.
2. **Juros Mensais Simples:** Acréscimo de 1% ao mês sobre a cota básica (calculado de acordo com o número da parcela).
3. **Taxa de Pagamento:** Acréscimo de 2% sobre o valor da cota básica já atualizado com os juros.

## 💻 Exemplo de Execução

Ao rodar a classe principal `PaymentInInstallment`, o comportamento do sistema no terminal segue o modelo abaixo:

```text
Enter contract data
Number: 1234
Date (dd/MM/yyyy): 25/06/2026
Contract value: 200.00
Enter number of installments: 3

INSTALLMENTS:
25/07/2026 - R$ 68.68
25/08/2026 - R$ 69.36
25/09/2026 - R$ 70.04
```

## 🔧 Como Executar o Projeto

1. Certifique-se de ter o **JDK 8** ou superior instalado em sua máquina.
2. Abra o projeto em sua IDE de preferência (NetBeans, IntelliJ, Eclipse ou VS Code).
3. Execute o arquivo `PaymentInInstallment.java`.
4. Digite os dados solicitados no console utilizando o padrão de ponto para decimais (ex: `200.00`).
