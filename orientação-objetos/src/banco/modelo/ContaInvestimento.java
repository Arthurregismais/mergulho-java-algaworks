package banco.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaInvestimento extends Conta {

    public ContaInvestimento(Titular pessoa, int agencia, int numero) {
        super(pessoa, agencia, numero);
    }
    
    public void creditarRendimentos(BigDecimal percentualJuros){
        BigDecimal valorRendimentos = getSaldo().multiply(percentualJuros).divide(new BigDecimal("100"),
        2, RoundingMode.HALF_EVEN);
        depositar(valorRendimentos);
    }

    @Override
    public void debitarTarifaMensal() {
        if (getSaldo().compareTo(new BigDecimal("10_000")) < 0) {
            sacar(new BigDecimal("30"));
        }
    }

}


