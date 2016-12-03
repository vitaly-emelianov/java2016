package ru.sbt.classwork_21_11;

/**
 * Created by vitaly on 21.11.16.
 */
interface Context {
    int getTotalFinishedTaskCount();

    int getFailedTaskCount() throws InterruptedException;

    int getSuccessFinishedTaskCount();

    void stop();
}