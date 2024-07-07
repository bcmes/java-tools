package com.bcms.apache.dates;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MySimpleDateFormat {
    public static void main(String[] args) {
        /** Caracteres especiais para formatacao de datas com SimpleDate|Format:
         * y - ano
         * M - mes [MM - 1 a 12, MMM - Jan a Dez, MMMM - Janeiro a Dezembro]
         * d - dia do mes
         * E - dia da semana [EEE - Seg a Dom, EEEE - Segunda a Domingo]
         * a - marcador am/pm
         * H - hora de 0 a 23
         * h - hora de 1 a 12
         * m - minutos
         * s - segundos
         * S - milisegundos
         */
        String mascara = "'Sao Paulo', EEEE, dd, 'de' MMMM 'de' yyyy";
        java.text.SimpleDateFormat formatador = new java.text.SimpleDateFormat(mascara);
        java.text.SimpleDateFormat formatador2 = new java.text.SimpleDateFormat("HH:mm:ss S'ms'");

        Calendar cal = Calendar.getInstance();
        Date data = cal.getTime();

        System.out.println("data original: " + data);
        String textoFormatado = formatador.format(data);
        System.out.println("texto formatado: " + textoFormatado);

        String textoFormatado2 = formatador2.format(data);
        System.out.println("Outro texto formatado: " + textoFormatado2);

        formatador = new java.text.SimpleDateFormat(mascara, Locale.CANADA);
        textoFormatado = formatador.format(data);
        System.out.println("texto formatado 3: " + textoFormatado);
    }
}
