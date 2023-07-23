package banco.modelo;

import java.math.BigDecimal;

public class ContaEspecial extends Conta{

    private BigDecimal valorLimite;

    public ContaEspecial(Titular pessoa, int agencia, int numero, BigDecimal valorLimite) {
        super(pessoa, agencia, numero);
        this.valorLimite = valorLimite;
    }

    

    public BigDecimal getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(BigDecimal valorLimite) {
        this.valorLimite = valorLimite;
    }

    @Override
    public BigDecimal getSaldoDisponivel() {
        return getSaldo().add(getValorLimite());
    }

    public void sacar(){

    }



    @Override
    public void debitarTarifaMensal() {
        sacar(new BigDecimal("20"));
    }
}
