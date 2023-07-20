public class Main {
    
    public static void main(String[] args) {

        Titular titular1 = new Titular();
        titular1.nome = "Arthur Régis Mais";
        titular1.documento = "12209944221";

        Titular titular2 = new Titular();
        titular2.nome =  "Fernando Gomes";
        titular2.documento = "9882331432547";

        Conta minhaConta = new Conta(titular1, 1, 369);
        minhaConta.depositar(45_000);

        Conta suaConta = new Conta(titular2, 2, 246);
        suaConta.depositar(30_000);


        System.out.println("Titular: " + minhaConta.pessoa.nome);
        System.out.println("Saldo: " + minhaConta.saldo);

        System.out.println("Titular: " + suaConta.pessoa.nome);
        System.out.println("Saldo: " + suaConta.saldo);

        suaConta.sacar(15_000, 30);

        System.out.println("Saldo da sua conta: " + suaConta.saldo);
    }

}
