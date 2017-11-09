

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
        try {
            while (true) {
                //think
                think();
                //get hungry
                System.out.println("Philosopher " + this.i + " is hungry");
                //get your forks
                server.takeForks(this.i);
                //eat
                eat();
                //finish eating, put away your forks
                System.out.println("Philosopher " + this.i + " is done eating");
                server.returnForks(this.i);
                //return to thinking
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Philosopher thinking
     *
     * @throws InterruptedException
     */
    private void think() throws InterruptedException {
        try {
            System.out.println("Philosopher " + this.i + " is thinking");
            Thread.sleep(randTime());
            //uncomment to test if 0 and 1 are ever using the forks at the same time
//            if(this.i > 1){
//                System.out.println("Philosopher " + this.i + " is going to sleep for a while");
//                Thread.sleep(120000);
//            }
        } catch (InterruptedException e) {
            throw new InterruptedException("I fell off the chair while I was thinking so I have o forks.");
        }

    }

    /**
     * Philosopher eating
     *
     * @throws InterruptedException
     */
    private void eat() throws InterruptedException {
        try {
            System.out.println("Philosopher " + this.i + " is eating");
            Thread.sleep(randTime());
        } catch (InterruptedException e) {
            throw new InterruptedException("I fell off the chair I was eating. But I'll give the fork back.");
        }
    }

    /**
     * Method generates a random time in milliseconds
     *
     * @return (int) Math.random() a random time in milliseconds. 3000 was arbitray chosen during testing as 10000
     * seemed too long but 3000 kept the eating and thinking time under 3 seconds at all times
     */
    private int randTime() {
        return (int) (Math.random() * 3000);
    }

}
