package ru.nalemian.threads;

class Thread1 extends Thread {
    static volatile boolean trueOrFalse = false;

    Thread2 thread2;

    public Thread1(Thread2 thread2) {
        this.thread2 = thread2;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (thread2.getCheckOut()) {
                    return;
                }
                Thread.sleep(1000); //пауза
                trueOrFalse = !trueOrFalse;
                thread2.setTrueOrFalse(trueOrFalse);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
