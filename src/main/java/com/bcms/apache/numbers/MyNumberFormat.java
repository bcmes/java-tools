package com.bcms.apache.numbers;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class MyNumberFormat {
    public static void main(String[] args) {
        String idioma = "pt";
        String pais = "BR";
        Locale localidade = new Locale(idioma, pais);

        NumberFormat formatadorNumerico = NumberFormat.getNumberInstance(localidade);
        NumberFormat formatadorMonetario = NumberFormat.getCurrencyInstance(localidade);
        NumberFormat formatadorPercentual = NumberFormat.getPercentInstance();

        formatadorNumerico.setMinimumFractionDigits(2);
        formatadorNumerico.setMaximumFractionDigits(2); //arrendonda
        formatadorNumerico.setRoundingMode(RoundingMode.FLOOR);

        System.out.println("numero: " + formatadorNumerico.format(1000.126));
        System.out.println("moeda: " + formatadorMonetario.format(150.4));
        System.out.println("percentual: " + formatadorPercentual.format(0.53));

        try {
            Number valor = formatadorNumerico.parse("1000");
            System.out.println("> numero lido: " + valor);
            System.out.println("> numero: " + formatadorNumerico.format(valor));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

    }
}
