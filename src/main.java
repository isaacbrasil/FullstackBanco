import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class main {
    public static void main(String[] args) {

        Calendar idades = Calendar.getInstance();
        idades.set(2000, 11, 29);

        PessoaFisica Isaac = new PessoaFisica(1, "Isaac", "Goiânia", 1000, idades, "Masculino");

        Calendar idades2 = Calendar.getInstance();
        idades.set(2018, 11, 27);
        PessoaFisica Perola = new PessoaFisica(2, "Perola", "Goiânia", 999, idades2, "Feminino");

        System.out.println("Isaac: " + Isaac.getIdade());
        System.out.println("Perola: " + Perola.getIdade());

        PessoaJuridica Lojeta = new PessoaJuridica(3, "Lojeta", "Goiânia", 001, "vendas");
        PessoaJuridica PagBank = new PessoaJuridica(4, "PagBank", "Goiânia", 003, "vendas");

        ContaEspecial IsaacE = new ContaEspecial(Isaac, 1, 1300.0, 500.0);
        ContaPoupanca PerolaP = new ContaPoupanca(Perola, 2, 9000.0, 1000.0);
        ContaEspecial LojetaE = new ContaEspecial(Lojeta, 3, 10000.0, 1000.0);
        ContaPoupanca PagBankP = new ContaPoupanca(PagBank, 4, 5000.0, 500.0);

        System.out.println("------------------------------");
        System.out.println(IsaacE.getSaldo());
        IsaacE.sacar(100.0);
        System.out.println("------------------------------");

        System.out.println(IsaacE.getSaldo());
        PerolaP.depositar(200.0);

        System.out.println("------------------------------");
        System.out.println(LojetaE.getSaldo());
        LojetaE.transferir(100.0, PerolaP);
        System.out.println("------------------------------");
        System.out.println("Lojeta: " + LojetaE.getSaldo());
        System.out.println("Perola: " + PerolaP.getSaldo());

        List<Conta> listConta = new ArrayList<Conta>();
        listConta.add(IsaacE);
        listConta.add(PerolaP);
        listConta.add(LojetaE);
        listConta.add(PagBankP);

        Double total = 0.0;
        for (Conta conta : listConta) {
            System.out.println("Nome: " + conta.getCliente().getNome() + ", saldo: R$" + conta.getSaldo());
            total += conta.getSaldo();
        }
        System.out.println("------------------------------");
        System.out.println("Total: R$ " + total);
    }

}
