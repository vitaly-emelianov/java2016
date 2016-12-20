package ru.sbt.homework_mutlithreading;

import ru.sbt.homework_mutlithreading.ThreadPool.ThreadPoolManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by vitaly on 20.12.16.
 */
public class ExecutionManagerImpl implements ExecutionManager {

    @Override
    public Context execute(Runnable callback, Runnable... runnables) {
        List<Runnable> runnableList = new ArrayList<>();
        for (Runnable runnable : runnables) {
            runnableList.add(runnable);
        }

        ThreadPoolManager threadPoolManager = new ThreadPoolManager(10, callback, runnableList);
        return threadPoolManager.getContext();
    }
}
