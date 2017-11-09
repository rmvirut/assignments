/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.locks.*;

/**
 * @author Kojo
 */
public class DiningServerImpl implements DiningServer {

    public static final int NUM_OF_PHILS = 5;

    public static boolean[] forks = new boolean[NUM_OF_PHILS]; //shared set of forks

    private ReentrantLock lock = new ReentrantLock(true);

    Condition[] forkAvail = new Condition[NUM_OF_PHILS];//condition locks for the forks

    public DiningServerImpl() {
        //create the 5 forkAvail and their individual locks
        for (int i = 0; i < NUM_OF_PHILS; i++) {
            forkAvail[i] = lock.newCondition();
            forks[i] = true;
        }
    }

    @Override
    public void takeForks(int pNumber) {
        lock.lock();
        try {

            //get fork on the right
            while (!forks[pNumber]) {
                //otherwise wait
                forkAvail[pNumber].await();
            }
            //take the fork
            forks[pNumber] = false;

            //get fork on the left
            while (!forks[(pNumber + 1) % 5]) {
                //otherwise wait
                forkAvail[(pNumber + 1) % 5].await();
            }
            //take the fork
            forks[(pNumber + 1) % 5] = false;

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void returnForks(int pNumber) {
        lock.lock();
        try {
            //release your right forks
            forks[pNumber] = true;
            //tell whoever's waiting they can take the fork
            forkAvail[pNumber].signal();
            //release your left fork
            forks[(pNumber + 1) % 5] = true;
            //notify whoever's waiting to take the fork
            forkAvail[(pNumber + 1) % 5].signal();
        } finally {
            lock.unlock();
        }
    }
}
