package ru.sbt.homework_terminal;

/**
 * Created by vitaly on 04.12.16.
 */
public interface Terminal {

    String accountReport(String accountId) throws Exception;

    void addMoney(String accountId, long money) throws Exception;

    void getMoney(String accountId, long count) throws Exception;
}
