package com.bcms.apache.logs;

public class MyLogs {

//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//    Class<com.github.bcmes.java.tools.logs.MyLogs> myClass = MyLogs.class;
    Class<? extends MyLogs> myClass2 = this.getClass();
    void testMethodA() {
        //log.info("Log test info...");
    }

    public static void main(String[] args) {
        MyLogs myLogs = new MyLogs();
//        myLogs.testMethodA();
        System.out.println(MyLogs.class);
//        System.out.println(myLogs.myClass);
        System.out.println(myLogs.myClass2);

    }
}
