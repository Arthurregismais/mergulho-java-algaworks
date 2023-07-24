package banco.app;

import java.math.BigDecimal;
import java.util.Optional;

import banco.modelo.Banco;
import banco.modelo.Conta;


public class Main5 {
    
    public static void main(String[] args) {
        Banco banco = new Banco();


        BigDecimal saldo = banco.buscar(123, 222)
            .map(Conta::getSaldo)
            .orElse(BigDecimal.ZERO);

        System.out.println(saldo);


        /*
        Conta contaEncontrada = banco.buscar(123, 222)
            .orElseThrow(() -> new RuntimeException("Conta não encontrada "));
        
        System.out.println(contaEncontrada.getSaldo());
        */
        /*
        if (contaOptional.isPresent()) {
            Conta contaEncontrada = contaOptional.get();
            System.out.println(contaEncontrada.getSaldo());
        }
        */
        
    }
}
