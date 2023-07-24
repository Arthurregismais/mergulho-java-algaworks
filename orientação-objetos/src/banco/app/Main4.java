package banco.app;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import banco.modelo.Banco;
import banco.modelo.Conta;
import banco.modelo.Titular;

public class Main4 {
    public static void main(String[] args) {

        Banco banco = new Banco();

        List<Titular> titulares = banco.getContas().stream()
            .map(Conta::getPessoa)
            .distinct()
            .collect(Collectors.toList());

        System.out.println(titulares);

        BigDecimal saldoTotal = banco.getContas().stream()
            .map(Conta::getSaldo)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(saldoTotal);

        banco.getContas().stream()
            .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0)
            .filter(conta -> conta.getNumero() > 300)
            .map(conta -> conta.getPessoa())
            .distinct()
            .forEach(System.out::println);


        /*stream.forEach(conta -> {
            conta.depositar(new BigDecimal("10"));
            System.out.println(conta.getAgencia() + "/" + conta.getNumero() + " = " +conta.getSaldo());
        });*/
    }
}
