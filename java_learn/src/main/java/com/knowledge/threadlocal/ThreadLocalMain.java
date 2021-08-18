package com.knowledge.threadlocal;

public class ThreadLocalMain {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        for(int i = 0;i<100;i++){
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadLocal.set(finalI +"");
                    printHello(finalI+"");
                }
            }).start();
        }
    }

    static void printHello(String master){
        System.out.println(master + " say hello to " + threadLocal.get());
        //threadLocal.remove();
    }

}
