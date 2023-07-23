package banco.modelo.pagamento;

import java.math.BigDecimal;

import banco.modelo.Titular;

public class Holerite implements DocumentoPagavel {

    private Titular funcionario;
    private BigDecimal valorHora;
    private int quantidadeHoras;
    private boolean pago;

    public Holerite(Titular funcionario, BigDecimal valorHora, int quantidadeHoras) {
        this.funcionario = funcionario;
        this.valorHora = valorHora;
        this.quantidadeHoras = quantidadeHoras;
    }

    @Override
    public BigDecimal getValorTotal() {
        return valorHora.multiply(new BigDecimal(quantidadeHoras));
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public void quitarPagamento() {
       pago = true;
    }
    
}
