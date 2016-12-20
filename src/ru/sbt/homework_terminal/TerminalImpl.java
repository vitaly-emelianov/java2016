package ru.sbt.homework_terminal;

/**
 * Created by vitaly on 04.12.16.
 */
public class TerminalImpl implements Terminal {

    private final Session session;
    private int numberOfAuthorizationAttempts = 3;
    private long time = 0;


    private class Session {
        private String accountId;
        private TerminalServer terminalServer = new TerminalServerImpl();
        private Status sessionStatus = Status.UNAUTHORIZED;

        public TerminalServer makeRequest() throws Exception {
            if (sessionStatus == Status.UNAUTHORIZED) {
                throw new Exception();
            } else {
                return terminalServer;
            }
        }

        public Session(String accountId, int pinCode, int cardKey) {
            if (TerminalImpl.this.numberOfAuthorizationAttempts == 0) {
                if (System.currentTimeMillis() - time > 5000) {
                    TerminalImpl.this.time = System.currentTimeMillis();
                    TerminalImpl.this.numberOfAuthorizationAttempts = 3;
                }
            }
            if (authorize(pinCode, cardKey)) {
                this.accountId = accountId;
                this.terminalServer = new TerminalServerImpl();
                this.sessionStatus = Status.AUTHORIZED;
            } else {
                TerminalImpl.this.numberOfAuthorizationAttempts -= 1;
                if (TerminalImpl.this.numberOfAuthorizationAttempts == 0) {
                    time = System.currentTimeMillis();
                }
            }
        }

        public boolean authorize(int pinCode, int cardKey) {
            return pinCode + 1 == cardKey;
        }
    }

    public TerminalImpl(String accountId, int pinCode, int cardKey) throws Exception {
        session = new Session(accountId, pinCode, cardKey);
    }

    @Override
    public String accountReport(String accountId) {
        try {
            return session.makeRequest().getAccountReport(accountId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void addMoney(String accountId, long money) {
        try {
            session.makeRequest().addMoney(accountId, money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getMoney(String accountId, long money) {
        try {
            session.makeRequest().getMoney(accountId, money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Terminal terminal = new TerminalImpl("vitaly", 123, 124);
            terminal.accountReport("vitaly");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
