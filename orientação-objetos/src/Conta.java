import java.util.Objects;

public class Conta {
    
    Titular pessoa;
    int agencia;
    int numero;
    double saldo;

    Conta(Titular pessoa, int agencia, int numero) {
        Objects.requireNonNull(pessoa);
        this.pessoa = pessoa;
        this.agencia = agencia;
        this.numero = numero;
    }

    void depositar(double deposito) {
        if (deposito < 0 ) {
            throw new IllegalArgumentException("Valore de depósito inválido");
        }
        saldo += deposito; 
    }

    void sacar (double saque) {
        if (saque < 0 ) {
            throw new IllegalArgumentException("Valor de saque inválido");
        }

        else if (saque <= saldo) {
            saldo -= saque;
        }
        else  {
            throw new IllegalStateException("Saldo insuficiente para realizar o saque");
        }
    }
    
    void sacar (double saque, double taxaDeSaque) {
        sacar(saque + taxaDeSaque);
    }

}