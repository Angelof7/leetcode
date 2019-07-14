package com.andy.leetcode.concurrency;

/**
 * Created by andy on 2019/7/14.
 */
public class PrintInOrder {
    class Foo {

        private volatile int order;

        public Foo() {
            order = 0;
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            synchronized (this) {
                order++;
                notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (this) {
                while (order != 1) {
                    wait();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                order++;
                notify();
            }

        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (this) {
                while (order != 2) {
                    wait();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
            }
        }
    }

    class Foo2 {

        private volatile boolean firstPrinted;
        private volatile boolean secondPrinted;

        public Foo2() {
            firstPrinted = false;
            secondPrinted = false;
        }

        public synchronized void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstPrinted = true;
            notifyAll();
        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {
            while (!firstPrinted) {
                wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondPrinted = true;
            notify();

        }

        public synchronized void third(Runnable printThird) throws InterruptedException {
            while (!secondPrinted) {
                wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
