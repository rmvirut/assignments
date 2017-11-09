

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.lang.Thread.State;

/**
 * @author Kojo
 */
public class Philosopher implements Runnable {

    private DiningServer server;
    private int i;

    /**
     * @param server the dining table with the forks
     * @param i      index value of Philosopher from 0 - DiningServerImpl.NUM_OF_PHILS
     */
    public Philosopher(DiningServer server, int i) {
        this.server = server;
        this.i = i;
    }


    @Override
    public void run() {
        while (true) {
            try {
                //think
                think();
                //get hungry
                System.out.println("Philosopher " + this.i + " is hungry");
                Thread.sleep(randTime());
                //get your forks
                server.takeForks(this.i);
                //eat
                eat();
                //finish eating, put away your forks
                System.out.println("Philosopher " + this.i + " is done eating");
                Thread.sleep(randTime());
                server.returnForks(this.i);
                //return to thinking
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Philosopher thinking
     *
     * @throws InterruptedException
     */
    public void think() throws InterruptedException {
        System.out.println("Philosopher " + this.i + " is thinking");
        Thread.sleep(randTime());
    }

    /**
     * Philosopher eating
     *
     * @throws InterruptedException
     */
    public void eat() throws InterruptedException {
        System.out.println("Philosopher " + this.i + " is eating");
        Thread.sleep(randTime());
    }

    /**
     * Method generates a random time in milliseconds
     *
     * @return (int) Math.random() a random time in milliseconds
     */
    public int randTime() {
        return (int) Math.random() * 1000;
    }

}
