package org.example;

public class Paystationlmpl implements PayStation {
    private int insertedsoFar;
    private int timeBought;

    public void addPayment(int coinValue) throws IllegalcoinExcemption {
        switch (coinValue){
            case 5: break;
            case 10: break;
            case 25: break;
            default:
                throw new IllegalcoinExcemption("invalid coin: " + coinValue);
        }
        insertedsoFar += coinValue;
        timeBought = insertedsoFar/5*2;

    }
    public int readDisplay(){
        return insertedsoFar/5*2;
    }

    @Override
    public Receipt buy() {
        Receipt r = new ReceiptImpl(timeBought);
        //timeBought = insertedsoFar = 0;
        reset();
        return  r;
    }

    @Override
    public void cancel() {
        reset();
    }
    public void reset(){
        timeBought = insertedsoFar = 0;
    }
}
