package banco.app;

import banco.modelo.Titular;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main2 {

    public static void main(String[] args) {

        Titular pessoa1 = new Titular("João da Silva", "23423132");
        Titular pessoa2 = new Titular("Alberto Vieira", "1232145511");

        Set<Titular> pessoas = new HashSet()<>();

        pessoas.add(pessoa1);
        pessoas.add(pessoa2);

        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println(pessoas.get(i).getNome());
        }


    }
    
}
