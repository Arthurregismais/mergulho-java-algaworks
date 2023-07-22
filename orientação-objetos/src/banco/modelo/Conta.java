package banco.modelo;

import java.util.Objects;

import banco.modelo.excecao.SaldoInsuficienteException;

public abstract class Conta {
    
    private Titular pessoa;
    private int agencia;
    private int numero;
    private double saldo;

    public Titular getPessoa() {
        return pessoa;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }


    public double getSaldo() {
        return saldo;
    }

    public Conta(Titular pessoa, int agencia, int numero) {
        Objects.requireNonNull(pessoa);
        this.pessoa = pessoa;
        this.agencia = agencia;
        this.numero = numero;
    }

    public abstract void debitarTarifaMensal();

    public void depositar(double deposito) {
        if (deposito < 0 ) {
            throw new IllegalArgumentException("Valore de depósito inválido");
        }
        saldo += deposito; 
    }

    public void sacar (double saque) {
        if (saldo < 0 ) {
            throw new IllegalArgumentException("Valor de saque inválido");
        }

        else if (saque <= getSaldoDisponivel()) {
            saldo -= saque;
        }
        else  {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque");
        }
    }
    
    public void sacar (double saque, double taxaDeSaque) {
        sacar(saque + taxaDeSaque);
    }

    public double getSaldoDisponivel() {
        return getSaldo();
    }

}