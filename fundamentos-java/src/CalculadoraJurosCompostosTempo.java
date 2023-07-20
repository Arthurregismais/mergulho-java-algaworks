public class CalculadoraJurosCompostosTempo {
    public static void main(String[] args) {
        double valorAcumulado = 10_000;
        double juros = 0.8;
        int periodoMeses = 12;
        
        for (int mes = 1; mes <= periodoMeses; mes++) {
            valorAcumulado += (valorAcumulado * juros / 100);
            System.out.println("Mês: " + mes + " = " + valorAcumulado);
        }
    }
}
