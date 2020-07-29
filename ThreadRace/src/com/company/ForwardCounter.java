package com.company;

public class ForwardCounter extends ThreadCounter implements Runnable {

    Thread cThread = new Thread(this, "Forward Counter Thread");
    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            count++;
            System.out.println("Temp count (" + cThread.getName() + "): " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(cThread.getName() + " is interrupted. ");
            }
        }
        finish();
    }

    public synchronized void finish() {
        ThreadCounter.isFirst = !ThreadCounter.isFirst;
        if (ThreadCounter.isFirst) {
            System.out.println(cThread.getName() + ": I'm first. :)");
        } else {
            System.out.println(cThread.getName() + ": I'm second. :(");
        }
    }
}