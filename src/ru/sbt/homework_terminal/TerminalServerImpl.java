package ru.sbt.homework_terminal;

import java.util.*;

/**
 * Created by vitaly on 04.12.16.
 */
public class TerminalServerImpl implements TerminalServer {
    private final Map<String, Account> accounts;

    private class Account {
        private final String firstName;
        private final String lastName;
        private long sum;

        public Account(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sum = 0;
        }

        public String getReport() {
            return firstName + ", " + lastName + ", " + sum;
        }

    }

    public TerminalServerImpl() {
        this.accounts = new HashMap<>();
    }

    @Override
    public String getAccountReport(String id) {
        return (accounts.get(id)).getReport();
    }

    @Override
    public void addMoney(String accountId, long money) throws Exception {
        Account account = accounts.get(accountId);
        if (money % 100 == 0) {
            account.sum += money;
        } else {
            throw new Exception("Money cannot be divided by 100.");
        }
    }

    @Override
    public void getMoney(String accountId, long money) throws Exception {
        Account account = accounts.get(accountId);
        if (money % 100 == 0 || account.sum <= money) {
            account.sum -= money;
        } else {
            throw new Exception("Money cannot be divided by 100.");
        }
    }
}
