package com.company;

public class ThreadRace {

    public volatile Boolean isFirst = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ThreadRace();
    }

    public ThreadRace() {
        ForwardCounter c1 = new ForwardCounter();
        c1.cThread.start();

        ReverseCounter c2 = new ReverseCounter();
        c2.rcThread.start();
    }

}
