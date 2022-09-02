package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaystationlmplTest {
    paystation ps;
    @Before
    public void setUp(){
        ps = new Paystationlmpl();
    }
    @Test
    public void shouldDisplay2Minfor5cents()
        throws IllegalcoinExcemption{
        ps.addPayment(5);
        assertEquals("should display 2 min for 5 cents", 2, ps.readDisplay());

    }
    @Test(expected = IllegalcoinExcemption.class)
    public void shouldRejectIllegalcoin() throws IllegalcoinExcemption{
        ps.addPayment(17);
    }
    @Test
    public void shouldDisplay14MinFor10and25Cents() throws IllegalcoinExcemption{
        ps.addPayment(10);
        ps.addPayment(25);
        assertEquals("shoult display 14 min for 10 + 25 cents", 14,ps.readDisplay());

    }
    @Test
    public void shouldReturnCorrectReceiptWhenBuy() throws IllegalcoinExcemption{
        ps.addPayment(5);
        ps.addPayment(10);
        ps.addPayment(25);
        Receipt receipt;
        receipt = ps.buy();
        assertNotNull("Receipt reference cannot be null", receipt);
        assertEquals("receipt value must be 16 min.",16, receipt.value());

    }
    @Test
    public void shouldReturnReceiptWhenBuy100c() throws IllegalcoinExcemption {
        ps.addPayment(10);
        ps.addPayment(10);
        ps.addPayment(10);
        ps.addPayment(10);
        ps.addPayment(10);
        ps.addPayment(25);
        ps.addPayment(25);

        Receipt receipt;
        receipt = ps.buy();
        assertEquals(40, receipt.value());


    }
    @Test
    public void shouldClearAfterBuy() throws IllegalcoinExcemption {
        ps.addPayment(25);
        ps.buy();
        assertEquals("Display should have been cleard ", 0, ps.readDisplay());
        ps.addPayment(10);
        ps.addPayment(25);
        assertEquals("Next add payment should display correct time", 14, ps.readDisplay());
        Receipt r = ps.buy();
        assertEquals("Next buy should return valid receipt", 14, r.value());
        assertEquals("Again, display should be cleard", 0,ps.readDisplay());
    }
    @Test
    public void shouldClearAfterCancel() throws IllegalcoinExcemption{
        ps.addPayment(10);
        ps.cancel();
        assertEquals("Cancel should clear display", 0, ps.readDisplay());
        ps.addPayment(25);
        assertEquals("Insert after cancel should wor", 10, ps.readDisplay());
    }
}