package ru.nalemian.lessons.threads;

public class Threads {
    static volatile boolean trueOrFalse = false; //volatile - когда одну переменную используют разные потоки

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000); //пауза
                    trueOrFalse = !trueOrFalse;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.setDaemon(true); //демон-поток - фоновый поток (служебный), выполняющий какую-то работу в фоне

        //процесс продолжается, пока се НЕ демон-потоки (тут - thread2) завершили свою работу (как без ошибок, так и с выбрасыванием исключений)

        Thread thread2 = new Thread(() -> {
            int i = 30;
            while (i >= 0) {
                if (trueOrFalse) {
                    try {
                        System.out.println(i);
                        i--;
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
