package ru.nalemian.threads;

public class Thread2 extends Thread {

    volatile boolean trueOrFalse;

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }

    boolean checkOut;

    public boolean getCheckOut() {
        return checkOut;
    }

    public void setTrueOrFalse(boolean trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }

    @Override
    public void run() {
        int i = 30;
        while (i >= 0) {
            if (this.trueOrFalse) {
                try {
                    System.out.println(i);
                    i--;
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
            if (i == 0) {
                setCheckOut(true);
                return;
            }
        }
    }
}
