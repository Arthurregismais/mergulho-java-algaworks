package banco.modelo;

public class CaixaEletronico {

    public void imprimirSaldo (Conta conta) {
        System.out.println("Conta: " + conta.getAgencia() + "/" + conta.getNumero());
        System.out.println("Titular: " + conta.getPessoa().getNome());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Saldo Disponível: " + conta.getSaldoDisponivel());

    }
}

