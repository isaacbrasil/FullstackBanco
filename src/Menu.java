package Banco.bancofullstack.src;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public void menuPrincipal(Scanner sc) {
        Integer escolha = 1;

        Conta conta;
        do {
            this.showMenuPrincipal();
            try {
                escolha = sc.nextInt();
                switch (escolha) {
                case 1:
                    Pessoa aux = null;
                    aux = this.buscarPessoa(sc);

                    System.out.println("------------------------------");
                    System.out.println("----Digite o numero da nova Conta----");
                    System.out.println("------------------------------");
                    int numeroC = sc.nextInt();

                    System.out.println("------------------------------");
                    System.out.println("----Digite o saldo----");
                    System.out.println("------------------------------");
                    double saldo = sc.nextDouble();
                    System.out.println("------------------------------");
                    System.out.println(
                            "Digite o numero da categoria: 1(SIMPLES), 2(EXECUTIVA), 3(PREMIUM),  4(PERSONALITE)");
                    System.out.println("------------------------------");
                    int ncat = sc.nextInt();
                    sc.nextLine();
                    String cat = null;
                    if (ncat == 1) {
                        cat = TipoConta.SIMPLES.toString();
                    } else if (ncat == 2) {
                        cat = TipoConta.EXECUTIVA.toString();
                    } else if (ncat == 3) {
                        cat = TipoConta.PREMIUM.toString();
                    } else if (ncat == 4) {
                        cat = TipoConta.PERSONALITE.toString();
                    } else {
                        System.out.println("ENTRADA INVALIDA! DIGITE 1 ou 2 ou 3 ou 4");
                    }
                    // System.out.println(TipoConta.PREMIUM.toString());
                    System.out.println("------------------------------");
                    System.out.println("Conta Especial ou Poupança?(E ou P)");
                    System.out.println("------------------------------");
                    String tipo = sc.nextLine();
                    switch (tipo) {
                    case "E":
                        System.out.println("Digite o limite:");
                        double limite = sc.nextDouble();
                        ContaEspecial auxContaE = new ContaEspecial(aux, numeroC, saldo, limite, cat);
                        main.contas.add(auxContaE);
                        break;
                    case "P":
                        System.out.println("Digite a taxa de correção:");
                        double taxa = sc.nextDouble();
                        ContaPoupanca auxContaP = new ContaPoupanca(aux, numeroC, saldo, taxa, cat);
                        main.contas.add(auxContaP);
                        break;
                    }
                    break;

                case 2:
                    System.out.println("Selecionar Conta");

                    conta = this.buscarConta(sc);
                    this.menuConta(sc, conta);
                    break;

                case 3:
                    this.cadatrarCliente(sc);
                    break;

                case 4:
                    System.out.println("------------------------------");
                    System.out.println("1 - Saldo das Contas");
                    System.out.println("2 - Total das Contas");

                    Integer esc = sc.nextInt();
                    sc.nextLine();

                    switch (esc) {
                    case 1:

                        this.printacontas(sc);
                        break;

                    case 2:

                        this.printasaldototal(sc);
                        break;
                    }

                    break;

                case 5:
                    System.out.println("5 - Sair");
                    break;

                default:
                    System.out.println("Opcao Incorreta");
                }

            } catch (Exception e) {
                System.out.println("Opcao Incorreta.");
                escolha = 5;
            }
        } while (escolha != 5);

    }

    private void cadatrarCliente(Scanner sc) {

        System.out.println("--- Novo Cliente-----");
        System.out.println("Selecione o tipo de Pessoa");
        System.out.println("1 - Pessoa Fisica");
        System.out.println("2 - Pessoa Juridica");

        Integer tipo = sc.nextInt();

        System.out.println("--- Informe o ID -----");
        Integer id = sc.nextInt();

        System.out.println("--- Informe o Nome -----");
        String nome = sc.nextLine();

        System.out.println("--- Informe o Endereco -----");
        String endereco = sc.nextLine();

        if (tipo == 1) {
            System.out.println("--- Informe o CPF -----");
            int cpf = sc.nextInt();

            System.out.println("Informe a Data de Nascimento: ");

            System.out.println("Informe o ano de Nascimento: ");
            Integer ano = sc.nextInt();
            System.out.println("Informe o mês de Nascimento: ");
            Integer mes = sc.nextInt();
            System.out.println("Informe o dia de Nascimento: ");
            Integer dia = sc.nextInt();
            System.out.println("Informe o genero: ");
            String genero = sc.nextLine();

            Calendar idade = Calendar.getInstance();
            idade.set(ano, mes, dia);
            main.clientes.add(new PessoaFisica(id, nome, endereco, cpf, idade, genero));

        } else {
            System.out.println("--- Informe o CNPJ -----");
            String cnpj = sc.nextLine();

            System.out.println("--- Informe a Atividade -----");
            String atividade = sc.nextLine();

            main.clientes.add(new PessoaJuridica(id, nome, endereco, id, atividade));
        }

    }

    private void menuConta(Scanner sc, Conta conta) {

        Integer escolha = 1;
        do {
            this.showMenuConta(conta);
            try {
                escolha = sc.nextInt();
                Double vr;
                switch (escolha) {
                case 1:
                    System.out.println("Alterar conta");

                    break;
                case 2:
                    System.out.println("Informe o Valor do Deposito");
                    vr = sc.nextDouble();
                    conta.depositar(vr);
                    break;
                case 3:
                    System.out.println("Informe o Valor para Saque");
                    vr = sc.nextDouble();
                    conta.sacar(vr);
                    break;
                case 4:
                    Conta dest = this.buscarConta(sc);
                    System.out.println("Informe o Valor para Transferencia");
                    vr = sc.nextDouble();
                    conta.transferir(vr, dest);
                    break;
                case 5:
                    System.out.println("-------------------------");
                    System.out.println("--- SALDO: R$ " + conta.getSaldo());
                    System.out.println("-------------------------");

                    break;
                }

            } catch (Exception e) {
                System.out.println("Opcao Incorreta, sair.");
                escolha = 6;
            }
        } while (escolha != 6);
    }

    private void showMenuPrincipal() {
        System.out.println("-------------------------");
        System.out.println("---Selecione Uma Opcao---");
        System.out.println("-------------------------");
        System.out.println("1 - Abrir Nova Conta");
        System.out.println("2 - Selecionar Conta");
        System.out.println("3 - Cadastrar Cliente");
        System.out.println("4 - Relatorios");
        System.out.println("5 - Sair");
        System.out.println("-------------------------");
    }

    private void showMenuConta(Conta conta) {
        System.out.println("-------------------------");
        System.out.println("Cliente: " + conta.getCliente().getNome());
        System.out.println("Nr Conta: " + conta.getNrConta());
        System.out.println("-------------------------");
        System.out.println("---Selecione Uma Opcaoo---");
        System.out.println("-------------------------");
        System.out.println("1 - Alterar Conta");
        System.out.println("2 - Deposito");
        System.out.println("3 - Saque");
        System.out.println("4 - Transferencia");
        System.out.println("5 - Saldo");
        System.out.println("6 - Sair");
        System.out.println("-------------------------");
    }

    public Conta buscarConta(Scanner sc) {

        Conta conta = null;
        do {
            System.out.println("------------------------------");
            System.out.println("---Digite o numero da Conta---");
            System.out.println("------------------------------");
            Integer escolha = sc.nextInt();
            for (Conta c : main.contas) {

                if (c.getNrConta() == escolha) {
                    conta = c;
                    break;
                }
            }
            if (conta == null) {
                System.out.println("------------------------------");
                System.out.println("-----Conta Nao Encontrada-----");
                System.out.println("------------------------------");
            }

        } while (conta == null);

        return conta;
    }

    public Pessoa buscarPessoa(Scanner sc) {

        Pessoa aux = null;
        do {

            System.out.println("------------------------------");
            System.out.println("----Digite o id do Cliente----");
            System.out.println("------------------------------");

            int id = sc.nextInt();
            for (Pessoa p : main.clientes) {
                if (p.getId() == id)
                    aux = p;

            }
            if (aux == null) {
                System.out.println("------------------------------");
                System.out.println("-----Cliente não Encontrado-----");
                System.out.println("------------------------------");
            }
        } while (aux == null);

        return aux;
    }

    public void printacontas(Scanner sc) {
        System.out.println("------------------------------");
        for (Conta c : main.contas) {
            System.out.println("Numero da conta: " + c.getNrConta() + ", saldo: R$" + c.getSaldo());

        }
        System.out.println("------------------------------");

    }

    public void printasaldototal(Scanner sc) {
        double total = 0;
        for (Conta c : main.contas)
            total += c.getSaldo();
        System.out.println("------------------------------");
        System.out.println("Saldo total das contas: R$" + total);
        System.out.println("------------------------------");
    }
}
