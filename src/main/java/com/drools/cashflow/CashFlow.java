package com.drools.cashflow;

import java.util.Date;

public class CashFlow {
    public static enum Type {
        CREDIT, DEBIT
    }

    private Date date;
    private double amount;
    private Type type;
    private long accountNum;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(long accountNum) {
        this.accountNum = accountNum;
    }

}
