public class Main {
    
    public static void main(String[] args) {

        Titular titular1 = new Titular();
        titular1.nome = "Arthur Régis Mais";
        titular1.documento = "12209944221";

        Titular titular2 = new Titular();
        titular2.nome =  "Fernando Gomes";
        titular2.documento = "9882331432547";

        Conta minhaConta = new Conta();
        minhaConta.pessoa = titular1;
        minhaConta.agencia = 1;
        minhaConta.numero = 369;
        minhaConta.saldo = 45_000;

        Conta suaConta = new Conta();
        suaConta.pessoa = titular2;
        suaConta.agencia = 2;
        suaConta.numero = 246;
        suaConta.saldo = 30_000;


        System.out.println("Titular: " + minhaConta.pessoa.nome);
        System.out.println("Saldo: " + minhaConta.saldo);

        System.out.println("Titular: " + suaConta.pessoa.nome);
        System.out.println("Saldo: " + suaConta.saldo);
    }

}
