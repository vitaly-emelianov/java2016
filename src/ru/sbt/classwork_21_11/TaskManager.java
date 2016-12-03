package ru.sbt.classwork_21_11;

/**
 * Created by vitaly on 21.11.16.
 */
public class TaskManager {

    Context execute(Runnable... runnables) throws InterruptedException {
        Context context = new ContextImpl();
        for (Runnable runnable : runnables) {
            try {
                runnable.run();
            } catch (Exception e) {
                // increment
            }
        }
        return context;
    }
}
