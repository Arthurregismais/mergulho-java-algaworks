package banco.app;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import banco.modelo.ContaEspecial;
import banco.modelo.ContaInvestimento;
import banco.modelo.TipoPessoa;
import banco.modelo.Titular;
import banco.modelo.atm.CaixaEletronico;
import banco.modelo.excecao.SaldoInsuficienteException;
import banco.modelo.pagamento.Boleto;
import banco.modelo.pagamento.Holerite;


public class Main {
    
    public static void main(String[] args) {

        Titular titular1 = new Titular();
        titular1.setNome("Arthur Régis Mais");
        titular1.setDocumento("12209944221");
        titular1.setRendimentoAnual(new BigDecimal(15_000d));
        titular1.setTipo(TipoPessoa.JURIDICA);

        Titular titular2 = new Titular();
        titular2.setNome("Fernando Gomes");
        titular2.setDocumento("9882331432547");
        titular2.setRendimentoAnual(new BigDecimal(12_000d));

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 1, 369);
        minhaConta.depositar(new BigDecimal(45_000));

        ContaEspecial suaConta = new ContaEspecial(titular2, 2, 246, new BigDecimal(1_000));
        suaConta.depositar(new BigDecimal(30_000));

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        try {
            minhaConta.depositar(new BigDecimal(30_000));
            minhaConta.sacar(new BigDecimal(1_000));

            suaConta.depositar(new BigDecimal(15_000));
            suaConta.sacar(new BigDecimal(15_000));
            suaConta.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular2, new BigDecimal(35_000));
            Holerite salarioFuncionario = new Holerite(titular2, new BigDecimal(100), 160);

            caixaEletronico.pagar(boletoEscola, minhaConta);
            caixaEletronico.pagar(salarioFuncionario, minhaConta);

            caixaEletronico.estornarPagamento(boletoEscola, minhaConta);

            boletoEscola.imprimirRecibo();
            salarioFuncionario.imprimirRecibo();
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao executar operação na conta: " + e.getMessage());
        }

        titular1.setDataUltimaAtualizacao(LocalDateTime.parse("2023-05-12T23:15"));
        System.out.println("Esta mensagem foi exibida em: " + titular1.getDataUltimaAtualizacao());
        
        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println("");
        caixaEletronico.imprimirSaldo(suaConta);


    }

}
