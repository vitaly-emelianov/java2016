//package ru.sbt.homework_mutlithreading;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by vitaly on 03.12.16.
// */
//public class ContextImpl implements Context {
//
//    private final List<Thread> threads;
//    private final int completedTaskNumber;
//
//    public ContextImpl() {
//        this.threads = new ArrayList<>();
//
//        Runnable[] tasks;
//        for (Runnable task : tasks) {
//            threads.add(new Thread(wrapRunnable(task)));
//        }
//        threads.forEach(Thread::start);
//        Runnable callback;
//        new Thread(callback).start();
//        completedTaskNumber = 0;
//    }
//
//    private Runnable wrapRunnable(Runnable runnable) {
//        Runnable wrappedRunnable = new Runnable() {
//            @Override
//            public void run() {
//                runnable.run();
//            }
//        };
//        return wrappedRunnable;
//    }
//
//    @Override
//    public int getCompletedTaskCount() {
//        return 0;
//    }
//
//    @Override
//    public int getFailedTaskCount() {
//        return 0;
//    }
//
//    @Override
//    public int getInterruptedTaskCount() {
//        return 0;
//    }
//
//    @Override
//    public void interrupt() {
//
//    }
//
//    @Override
//    public boolean isFinished() {
//        return false;
//    }
//}
