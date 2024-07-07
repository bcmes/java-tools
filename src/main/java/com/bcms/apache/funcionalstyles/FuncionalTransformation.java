package com.bcms.apache.funcionalstyles;

import java.util.List;

public class FuncionalTransformation {
    public static void main(String[] args) {
        //EXEMPLO 1: tranformacao
        //Imperativo
        List<String> names = List.of("Jack", "Paula", "Kate", "Peter");
        for(String name: names) {
            String nameInUpperCase = name.toUpperCase();
            System.out.println(nameInUpperCase);
        }
        //Funcional
        names.stream()
                .map(name -> name.toUpperCase())
                .forEach(nameInUpperCase -> System.out.println(nameInUpperCase));
        //OU.: style CLASSE::METODO
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
