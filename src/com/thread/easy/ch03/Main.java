package com.thread.easy.ch03;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2020-05-09 09:44
 */

/**
 * NEW：当一个线程被创建之初，那么此时线程就是新生状态，此状态下线程已经分配完毕内存空间。
 * RUNNABLE：当调用Thread.start()方法后，线程进入就绪状态，此时线程并不会马上开始执行。需要等待JVM选中并分配CPU时间才能开始执行。
 * RUNNING：线程被分配CPU时间后，进入执行状态，在此状态下会运行run()方法中定义的代码。
 * BLOCKED：当处于运行状态的线程，调用一个被阻塞的方法；试图获取一个正在被其他线程占用的锁，都会进入阻塞状态。
 * WAITING：等待状态。当调用了Object.wait()；Thread.join()；LockSupport.park()；方法后线程会进入等待状态。调用Object.wait()的线程会等待Object.notify()方法的调用而重新进入就绪状态。调用Thread.join()方法的线程会等待调用方法线程执行结束而进入结束状态。
 * TIMED_WAITING：固定时间等待状态。此状态下的线程都有一个固定的等待时间，通过调用Object.wait(Long)，Thread.sleep(Long)，Thread.join(Long)，都会让线程进入此状态。处于此状态的线程会等待指定的时间，然后恢复执行。
 * TERMINATED：线程执行结束。
 */

class Main {

    public static final Object OBJECT = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new WaitRunnable());
        Thread thread2 = new Thread(new NotifyRunnable());

        System.out.printf("Main: %s:%s , %s:%s\n", thread1.getName(), thread1.getState(), thread2.getName(), thread2.getState());

        thread1.start();
        thread2.start();

        while (thread1.getState() != Thread.State.TERMINATED
                || thread2.getState() != Thread.State.TERMINATED) {
            System.out.printf("Main: %s:%s , %s:%s\n", thread1.getName(), thread1.getState(), thread2.getName(), thread2.getState());
            Thread.sleep(1000);
        }
    }
}

/**
 * Main: Thread-0:NEW , Thread-1:NEW
 * Thread-0：开始执行，准备锁定object。
 * Thread-0：成功锁定object，执行同步模块。
 * Main: Thread-0:RUNNABLE , Thread-1:RUNNABLE
 * Thread-1：开始执行，准备锁定object。
 * Main: Thread-0:TIMED_WAITING , Thread-1:BLOCKED
 * Main: Thread-0:TIMED_WAITING , Thread-1:BLOCKED
 * Thread-0：被挂起，等待其他线程唤醒自己。
 * Thread-1：成功锁定object，执行同步模块。
 * Main: Thread-0:WAITING , Thread-1:TIMED_WAITING
 * Main: Thread-0:WAITING , Thread-1:TIMED_WAITING
 * Main: Thread-0:WAITING , Thread-1:TIMED_WAITING
 * Thread-1: 唤醒其他线程。
 * Main: Thread-0:BLOCKED , Thread-1:TIMED_WAITING
 * Main: Thread-0:BLOCKED , Thread-1:TIMED_WAITING
 * Main: Thread-0:BLOCKED , Thread-1:TIMED_WAITING
 * Thread-1: 执行结束。
 * Thread-0: 被唤起，继续开始执行。
 * Thread-0: 执行结束。
 */

/**
 * 执行过程分析：
 *
 * 1. Thread-0与Thread-1创建之初。
 * Thread-0：NEW
 * Thread-1：NEW
 *
 * 2. Thread-0先启动，获取锁后进入同步方法快并调用sleep方法等待3秒。Thread-1接着启动，也尝试获取锁，但是锁已经被Thread-0获取，Thread-1等待锁释放。
 * Thread-0：NEW->RUNNABLE->TIME_WAITING
 * Thread-1：NEW->RUNNABLE->BLOCKED
 *
 * 3. Thread-0等待3秒后继续执行然后调用wait方法挂起，并释放锁。Thread-1获取到锁后开始执行同步快并等待三秒。
 * Thread-0：TIME_WAITING->RUNNABLE->WAITING
 * Thread-1：BLOCKED->RUNNABLE->TIMED_WAITING
 *
 * 4. Thread-1休眠3秒后唤醒Thread-0，但这个时候锁依然被Thread-1所拥有，然后Thread-1继续休眠3秒。Thread-0等待Thread-1释放锁。
 * Thread-0：WAITING->BLOCKED
 * Thread-1：TIMED_WAITING->RUNNABLE->TIMED_WAITING
 *
 * 5. Thread-1休眠结束后恢复，并执行完毕同步方法快后结束。Thread-0获取锁后恢复，执行完同步方法快后结束。
 * Thread-0：BLOCKED->RUNNABLE->TERMINATED
 * Thread-1：TIMED_WAITING->RUNNABLE->TERNINATED
 *
 */
