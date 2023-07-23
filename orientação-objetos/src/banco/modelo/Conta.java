package banco.modelo;

import java.math.BigDecimal;
import java.util.Objects;

import banco.modelo.excecao.SaldoInsuficienteException;

public abstract class Conta {
    
    private Titular pessoa;
    private int agencia;
    private int numero;
    private BigDecimal saldo = BigDecimal.ZERO;

    public Titular getPessoa() {
        return pessoa;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }


    public BigDecimal getSaldo() {
        return saldo;
    }

    public Conta(Titular pessoa, int agencia, int numero) {
        Objects.requireNonNull(pessoa);
        this.pessoa = pessoa;
        this.agencia = agencia;
        this.numero = numero;
    }

    public abstract void debitarTarifaMensal();

    public void depositar(BigDecimal deposito) {
        if (deposito.compareTo(BigDecimal.ZERO) <= 0 ) {
            throw new IllegalArgumentException("Valore de depósito inválido");
        }
        saldo = saldo.add(deposito); 
    }

    public void sacar (BigDecimal saque) {
        if (saque.compareTo(BigDecimal.ZERO) <= 0 ) {
            throw new IllegalArgumentException("Valor de saque inválido");
        }

        else if (getSaldoDisponivel().subtract(saque).compareTo(BigDecimal.ZERO) < 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque");
        }   
        saldo = saldo.subtract(saque);
    }
    
    public void sacar (BigDecimal saque, BigDecimal taxaDeSaque) {
        sacar(saque.add(taxaDeSaque));
    }

    public BigDecimal getSaldoDisponivel() {
        return getSaldo();
    }

}