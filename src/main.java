package Banco.bancofullstack.src;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class main {

    static List<Conta> contas = new ArrayList<Conta>();
    static List<Pessoa> clientes = new ArrayList<Pessoa>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Calendar idades = Calendar.getInstance();
        idades.set(2000, 11, 29);

        @SuppressWarnings("deprecation")
        PessoaFisica Isaac = new PessoaFisica(1, "Isaac", "Goiania", 999, idades, "Masculino");

        Calendar idades2 = Calendar.getInstance();
        idades2.set(2002, 11, 27);

        @SuppressWarnings("deprecation")
        PessoaFisica Perola = new PessoaFisica(2, "Perola", "Goiania", 888, idades2, "Feminino");

        // System.out.println("Isaac: " + Isaac.getIdade());
        // System.out.println("Perola: " + Perola.getIdade());

        PessoaJuridica Lojeta = new PessoaJuridica(3, "Lojeta", "GOIAS", 111, "Vestuário");
        PessoaJuridica PagBank = new PessoaJuridica(4, "PagBank", "BH", 222, "Pagamentos");

        // ContaEspecial IsaacE = new ContaEspecial(Isaac, 1, 1000.0, 500.0);
        // ContaPoupanca PerolaP = new ContaPoupanca(Perola, 2, 500.0, 0.02);
        // ContaEspecial LojetaE = new ContaEspecial(Lojeta, 3, 100000.0, 10000.0);
        // ContaPoupanca PagBankP = new ContaPoupanca(PagBank, 4, 1500.0, 0.03);

        main.clientes.add(Isaac);
        main.clientes.add(Perola);
        main.clientes.add(Lojeta);
        main.clientes.add(PagBank);

        // main.contas.add(IsaacE);
        // main.contas.add(PerolaP);
        // main.contas.add(LojetaE);
        // main.contas.add(PagBankP);

        Menu menu = new Menu();
        System.out.println("-------------------------");
        System.out.println("---- Seja Bem Vindo!-----");
        System.out.println("-------------------------");
        menu.menuPrincipal(sc);
        System.out.println("-------------------------");
        System.out.println("-- Programa encerrado!---");
        System.out.println("------- Ate Mais!--------");
        System.out.println("-------------------------");

        sc.close();

    }

}