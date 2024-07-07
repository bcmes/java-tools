package com.bcms.apache.strings;

//Conclusao: NUNCA deveriamos usar String pra nada.
// O padrao deveria ser StringBuilder, se nao precisar ser thread safe.
// Se precisar StringBuffer.
public class ManipulationPerformance {
    public static void main(String[] args) {
        int qtd = Integer.parseInt("90000");//1-1000: $
        System.out.println("\nCom " + qtd + " concatenações.");

        long inicio = System.currentTimeMillis();
        if (qtd < 90000) {
            concatenaString(qtd);
        }
        long fim = System.currentTimeMillis();
        System.out.print("Classe String <=====> ");
        System.out.println("Tempo total de processamento: " + (fim-inicio) + "ms");

        inicio = System.currentTimeMillis();
        concatenaStringBuffer(qtd);
        fim = System.currentTimeMillis();
        System.out.print("Classe StringBuffer <=====> ");
        System.out.println("Tempo total de processamento: " + (fim-inicio) + "ms");

        inicio = System.currentTimeMillis();
        concatenaStringBuilder(qtd);
        fim = System.currentTimeMillis();
        System.out.print("Classe StringBuilder <=====> ");
        System.out.println("Tempo total de processamento: " + (fim-inicio) + "ms");
    }

    private static void concatenaStringBuilder(int qtd) {
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < qtd; i++) {
            s.append(i);
        }
    }

    private static void concatenaStringBuffer(int qtd) {
        StringBuffer s = new StringBuffer("");
        for (int i = 0; i < qtd; i++) {
            s.append(i);
        }
    }

    private static void concatenaString(int qtd) {
        String s = "";
        for (int i = 0; i < qtd; i++) {
            s = s + i; //muito lixo gerado para jvm
        }
    }
}
