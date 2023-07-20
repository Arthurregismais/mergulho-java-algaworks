public class CalculadoraJurosCompostosMeta {
    public static void main(String[] args) {
        double valorAcumulado = 10_000;
        double valorMeta = 20_000;
        double juros = 0.8;
        Integer tempoEmMeses = 1;

        while (valorAcumulado < valorMeta) {
            valorAcumulado += (valorAcumulado * juros) / 100;
            tempoEmMeses++;
            System.out.println("Mês: " + tempoEmMeses + " = " + valorAcumulado);
        }

        System.out.println("Eu obtive o meu valor meta de R$" + valorMeta + " em " + tempoEmMeses + " meses");
    }
}
