package ru.sbt.homework_terminal;

/**
 * Created by vitaly on 04.12.16.
 */
public interface TerminalServer {
    String getAccountReport(String id);

    void addMoney(String accountId, long money) throws Exception;

    void getMoney(String accountId, long money) throws Exception;
}
