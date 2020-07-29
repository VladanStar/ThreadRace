package com.company;
public class ReverseCounter extends ThreadCounter implements Runnable {

    Thread rcThread = new Thread(this, "Reverse Counter Thread");
    private int count = 10;

    @Override
    public void run() {
        while (true) {
            count--;
            System.out.println("Temp count (" + rcThread.getName() + "): " + count);
            if (count == 0) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(rcThread.getName() + " is interrupted. ");
            }
        }
        finish();
    }

    public synchronized void finish() {
        ThreadCounter.isFirst = !ThreadCounter.isFirst;
        if (ThreadCounter.isFirst) {
            System.out.println(rcThread.getName() + ": I'm first. :)");
        } else {
            System.out.println(rcThread.getName() + ": I'm second. :(");
        }
    }
}