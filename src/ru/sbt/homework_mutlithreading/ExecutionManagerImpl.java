//package ru.sbt.homework_mutlithreading;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//
///**
// * Created by vitaly on 03.12.16.
// */
//public class ExecutionManagerImpl implements ExecutionManager {
//    private ExecutorService executorService;
//    private volatile List<Runnable> runnables;
//    private volatile Runnable callback;
//
//    @Override
//    public Context execute(Runnable callback, Runnable... tasks) {
//        for (Runnable runnable: tasks) {
//            runnables.add(runnable);
//        }
//        this.callback = callback;
//        Context context = new ContextImpl();
//        return context;
//    }
//
//    public static void main(String[] args) {
//        ExecutionManager executionManager = new ExecutionManagerImpl();
//        Runnable callback = () -> System.out.println("Finished execution of callback function.");
//        Runnable runnable1 = () -> {
//            try {
//                Thread.sleep(100);
//                System.out.println("runnable 1");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//        Runnable runnable2 = () -> {
//            try {
//                Thread.sleep(200);
//                System.out.println("runnable 2");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//        Context context = executionManager.execute(callback, runnable1, runnable2);
//        System.out.println(context.getCompletedTaskCount());
//    }
//}
