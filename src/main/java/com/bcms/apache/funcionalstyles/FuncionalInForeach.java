package com.bcms.apache.funcionalstyles;

import java.util.List;

public class FuncionalInForeach {
    public static void main(String[] args) {
        //EXEMPLO 1: Foreach simples
        //Imperativo
        List<String> names = List.of("Jack", "Paula", "Kate", "Peter");
        for(String name: names) {
            System.out.println(name);
        }
        //Funcional
        names.forEach(name -> System.out.println(name));
        //OU: os Filters estao disponiveis so em Stream<T>
        names.stream().forEach(name -> System.out.println(name));

        //EXEMPLO 1: Foreach com if
        //Imperativo
        for(String name: names) {
            if(name.length() == 4) {
                System.out.println(name);
            }
        }
        //Declarativo
        names.stream()
                .filter(name -> name.length() == 4) //so passa os elementos que derem true, para forEach
                .forEach(name -> System.out.print(name));

    }

}
