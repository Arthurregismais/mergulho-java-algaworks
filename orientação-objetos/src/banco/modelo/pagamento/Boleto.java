package banco.modelo.pagamento;

import java.math.BigDecimal;

import banco.modelo.Titular;

public class Boleto implements DocumentoPagavel, DocumentoEstornavel {

    private Titular beneficiario;
    private BigDecimal valor;
    private boolean pago = false;

    public Boleto(Titular beneficiario, BigDecimal valor) {
        this.beneficiario = beneficiario;
        this.valor = valor;
        
    }

    @Override
    public BigDecimal getValorTotal() {
        return valor;
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public void quitarPagamento() {
        pago = true;
    }

    @Override
    public void estornarPagamento() {
        pago = false;
    }
    
}
