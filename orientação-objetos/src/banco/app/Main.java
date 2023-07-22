package banco.app;

import banco.modelo.CaixaEletronico;
import banco.modelo.Conta;
import banco.modelo.ContaEspecial;
import banco.modelo.ContaInvestimento;
import banco.modelo.Titular;


public class Main {
    
    public static void main(String[] args) {

        Titular titular1 = new Titular();
        titular1.setNome("Arthur Régis Mais");
        titular1.setDocumento("12209944221");

        Titular titular2 = new Titular();
        titular2.setNome("Fernando Gomes");
        titular2.setDocumento("9882331432547");

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 1, 369);
        minhaConta.depositar(45_000);

        ContaEspecial suaConta = new ContaEspecial(titular2, 2, 246, 1_000);
        suaConta.depositar(30_000);

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        suaConta.sacar(15_000, 30);

        System.out.println("Saldo da sua conta: " + suaConta.getSaldo());
        System.out.println("Saldo da minha conta: " + minhaConta.getSaldo());

        minhaConta.creditarRendimentos(0.8);

        System.out.println("Saldo da minha conta: " + minhaConta.getSaldo());

        minhaConta.debitarTarifaMensal();
        suaConta.debitarTarifaMensal();
        
        caixaEletronico.imprimirSaldo(suaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(minhaConta);

        Conta conta = suaConta;
        conta.debitarTarifaMensal();

    }

}
