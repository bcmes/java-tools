package com.bcms.apache.classesanonimas;

public class Test1 {

    public void sayHello() {
        /**
         * Exemplo de implementação anonima da interface
         */
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };
    }
}