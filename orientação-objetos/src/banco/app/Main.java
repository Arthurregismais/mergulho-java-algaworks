package banco.app;

//import banco.modelo.Conta;
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

        //// System.out.println("Titular: " + minhaConta.getPessoa().getNome());
        /// System.out.println("Saldo: " + minhaConta.getSaldo());

        /// System.out.println("Titular: " + suaConta.getPessoa().getNome());
        /// System.out.println("Saldo: " + suaConta.getSaldo());

        suaConta.sacar(15_000, 30);

        System.out.println("Saldo da sua conta: " + suaConta.getSaldo());

        minhaConta.creditarRendimentos(0.8);
        System.out.println("Titular: " + minhaConta.getPessoa().getNome());
        System.out.println("Saldo da minha conta: " + minhaConta.getSaldo());

        suaConta.sacar(15000);
        System.out.println("Titular: " + suaConta.getPessoa().getNome());
        System.out.println("Saldo da sua conta: " + suaConta.getSaldo());

    }

}
