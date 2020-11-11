package org.produce.model;

public class Account {

    private static long nextAccountNumber = 10L;

    private int pin;
    private long accountNumber;
    public Account() {
        this.pin = 1234;
        this.accountNumber = Account.nextAccountNumber++;
    }
    public int getPin() {
        return pin;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
}
