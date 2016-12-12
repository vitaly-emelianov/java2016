package ru.sbt.homework_terminal;

/**
 * Created by vitaly on 04.12.16.
 */
public class TerminalImpl implements Terminal {

    private final Session session;
    public int numberOfFailedAuthorizations;

    private class Session {
        public String accountId;
        public TerminalServer terminalServer = new TerminalServerImpl();
        public Status status = Status.UNAUTHORIZED;

        public Session(String accountId, int pinCode, int cardKey) {
            this.accountId = accountId;
            this.terminalServer = new TerminalServerImpl();
            if (authorize(pinCode, cardKey)) {
                session.status = Status.AUTHORIZED;
            }
        }

        public boolean authorize(int pinCode, int cardKey) {
            return pinCode + 1 == cardKey;
        }
    }

    public TerminalImpl(String accountId, int pinCode, int cardKey) throws Exception {
        session = new Session(accountId, pinCode, cardKey);
        if (session.status == Status.AUTHORIZED) {
            throw new Exception("Pin code isn't valid.");
        }
    }

    @Override
    public String accountReport(String accountId) {
        return session.terminalServer.getAccountReport(accountId);
    }

    @Override
    public void addMoney(String accountId, long money) throws Exception {
        session.terminalServer.addMoney(accountId, money);
    }

    @Override
    public void getMoney(String accountId, long money) throws Exception {
        session.terminalServer.getMoney(accountId, money);
    }
}
