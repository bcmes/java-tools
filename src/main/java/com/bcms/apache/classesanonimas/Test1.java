package com.bcms.apache.classesanonimas;

public class Test1 {

//    interface HelloWorld { //bixo estranho, mas pode ficar aqui.
//        public void greet();
//        public void greetSomeone(String someone);
//    }

    public void sayHello() {
        HelloWorld frenchGreeting = new HelloWorld() { //implementacao anonima no metodo
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