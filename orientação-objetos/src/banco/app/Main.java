package banco.app;

import banco.modelo.Conta;
import banco.modelo.ContaEspecial;
import banco.modelo.ContaInvestimento;
import banco.modelo.Titular;
import banco.modelo.atm.CaixaEletronico;
import banco.modelo.excecao.SaldoInsuficienteException;
import banco.modelo.pagamento.Boleto;
import banco.modelo.pagamento.DocumentoPagavel;
import banco.modelo.pagamento.Holerite;


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

        try {
            minhaConta.depositar(30_000);
            minhaConta.sacar(1_000);

            suaConta.depositar(15_000);
            suaConta.sacar(15_500);
            suaConta.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular2, 35_000);
            Holerite salarioFuncionario = new Holerite(titular2, 100, 160);

            caixaEletronico.pagar(boletoEscola, minhaConta);
            caixaEletronico.pagar(salarioFuncionario, minhaConta);

            caixaEletronico.estornarPagamento(boletoEscola, minhaConta);

            boletoEscola.imprimirRecibo();
            salarioFuncionario.imprimirRecibo();
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao executar operação na conta: " + e.getMessage());
        }

        
        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println("");
        caixaEletronico.imprimirSaldo(suaConta);


    }

}
