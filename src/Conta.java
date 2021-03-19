package Banco.bancofullstack.src;

public class Conta {
    private Pessoa cliente;
    private int nrConta;
    private double saldo;
    private String categoria;

    public Conta(Pessoa cliente, int nrConta, double saldo) {
        super();
        this.cliente = cliente;
        this.nrConta = nrConta;
        this.saldo = saldo;
    }

    public Pessoa getCliente() {
        return this.cliente;
    }

    public void setCliente(Pessoa newcliente) {
        this.cliente = newcliente;
    }

    public int getNrConta() {
        return this.nrConta;
    }

    public void setNrConta(int newnrConta) {
        this.nrConta = newnrConta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double newsaldo) {
        this.saldo = newsaldo;
    }

    protected Boolean temSaldo(double valor) {
        if (this.getSaldo() >= valor) {
            return true;
        } else {
            return false;
        }
    }

    public void sacar(double valor) {
        if (this.temSaldo(valor) == true) {
            debitar(valor);
        } else {
            System.out.println("-----------SEM SALDO DISPONÍVEL--------------");
        }
    }

    private void debitar(double valor) {
        this.saldo -= valor;

    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void transferir(double valor, Conta c) {
        if (temSaldo(valor) == true) {
            this.debitar(valor);
            c.setSaldo(c.getSaldo() + valor);
        } else
            System.out.println("--------SEM SALDO----------");
    }
}