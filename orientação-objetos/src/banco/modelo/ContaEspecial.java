package banco.modelo;

public class ContaEspecial extends Conta{

    private double valorLimite;

    public ContaEspecial(Titular pessoa, int agencia, int numero, double valorLimite) {
        super(pessoa, agencia, numero);
        this.valorLimite = valorLimite;
    }

    

    public double getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(double valorLimite) {
        this.valorLimite = valorLimite;
    }

    @Override
    public double getSaldoDisponivel() {
        return getSaldo() + getValorLimite();
    }

    public void sacar(){

    }



    @Override
    public void debitarTarifaMensal() {
        sacar(20);
    }
}
