package banco.modelo;

public class ContaInvestimento extends Conta {

    public ContaInvestimento(Titular pessoa, int agencia, int numero) {
        super(pessoa, agencia, numero);
    }
    
    public void creditarRendimentos(double percentualJuros){
        double valorRendimentos = (getSaldo() * percentualJuros) / 100;
        depositar(valorRendimentos);
    }

}


