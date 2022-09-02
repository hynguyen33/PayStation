package org.example;

public interface PayStation {
    public void addPayment(int coinValue) throws IllegalcoinExcemption;
    public int readDisplay();
    public Receipt buy();
    public void cancel();
}
