package Banco.bancofullstack.src;

public class ContaEspecial extends Conta {
    private double limite;

    public double getLimite() {
        return this.limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    protected Boolean temSaldo(double valor) {
        if (valor > this.getSaldo() + limite) {
            return false;
        } else {
            return true;
        }
    }

    public ContaEspecial(Pessoa aux, int numeroC, double saldo, double limite2, String cat) {
        super(aux, numeroC, saldo);
        this.limite = limite;

    }

}