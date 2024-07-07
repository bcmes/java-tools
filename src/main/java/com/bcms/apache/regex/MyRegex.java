package com.bcms.apache.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegex {
    public static void main(String[] args) {
        //usado para buscas
        Pattern padrao = Pattern.compile("\\d\\d");
        Matcher matches = padrao.matcher("O 2º colocado chegou as 11h26m33s");
        while (matches.find()) {
            System.out.println("Encontrei o valor " + matches.group() + " na posição " + matches.start());
        }

        //usando como validador
        Pattern padraoCpf = Pattern.compile("\\d{3}\\d{3}\\d{3}\\d{2}");
        Matcher matcher = padraoCpf.matcher("11122233344");
        System.out.println(matcher.matches());
    }
}
