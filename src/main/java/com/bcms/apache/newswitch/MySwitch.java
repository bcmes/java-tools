package com.bcms.apache.newswitch;

public class MySwitch {
    public static void main(String[] args) {

        mySwitch1();
        mySwitchJava14();

    }

    private static void mySwitch1() {
        int quarter = (int) (3 * Math.random());

        /**
         * Tipos suportados:
         * byte, short, char, and int
         * Byte, Short, Character, and Integer
         * enumerated types
         * String
         */
        String quarterLabel = null;
        switch (quarter) { //sempre avalia um unico valor, se o valor for null da NullPointerException.
            case 0: quarterLabel = "Q1 - Winter";
                break;
            case 1: quarterLabel = "Q2 - Spring";
                break;
            case 2: quarterLabel = "Q3 - Summer";
                break;
            case 3: quarterLabel = "Q3 - Summer";
                break;
            default: quarterLabel = "Unknown quarter";
        }
        ;
        //Se um break nao é encontrado os proximos cases sao executados.
    }

    private static void mySwitchJava14() {
        enum Day {MONDAY, FRIDAY, SUNDAY, TUESDAY, THURSDAY, SATURDAY, WEDNESDAY, XX}
        Day day = Day.THURSDAY;
        int len = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> {
                System.out.println("Some code...");
                yield 8; // usado para retornar o valor, quando é um bloco.
            }
            case WEDNESDAY -> 9;
            default -> 0;

        };
        System.out.println("len = " + len);
        //Este código do case pode ser uma expressão única, um bloco ou uma instrução throw.
        //e nao precisa mais de break, pois agora cada case é um bloco de codigo.
    }
}
