package banco.modelo.pagamento;

import banco.modelo.Titular;

public class Holerite implements DocumentoPagavel {

    private Titular funcionario;
    private double valorHora;
    private int quantidadeHoras;
    private boolean pago;

    public Holerite(Titular funcionario, double valorHora, int quantidadeHoras) {
        this.funcionario = funcionario;
        this.valorHora = valorHora;
        this.quantidadeHoras = quantidadeHoras;
    }

    @Override
    public double getValorTotal() {
        return valorHora * quantidadeHoras;
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
