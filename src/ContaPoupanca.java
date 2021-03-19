package Banco.bancofullstack.src;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Pessoa aux, int numeroC, double saldo, double taxa, String cat) {
        super(aux, numeroC, saldo);
        this.txCorrecao = txCorrecao;

    }

    private double txCorrecao;

    public double getTxCorrecao() {

        return this.txCorrecao;
    }

    public void setTxCorrecao(double txCorrecao) {
        this.txCorrecao = txCorrecao;
    }

    public void atualizaSaldoRendimento() {
        this.setSaldo(this.getSaldo() * txCorrecao);
    }

}