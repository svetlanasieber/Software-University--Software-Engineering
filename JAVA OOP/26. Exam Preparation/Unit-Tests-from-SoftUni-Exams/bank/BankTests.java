package bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTests {
    private Bank bank;
    private Client client;

    @Before
    public void setUp() {
        bank = new Bank("DSK", 2);
        client = new Client("Monika");
        bank.addClient(client);

    }

    @Test
    public void testGetBankName() {

        String expectedName = "DSK";
        String actualName = bank.getName();

        assertEquals(expectedName, actualName);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNullNameShouldThrow() {

        Bank bank1 = new Bank(null, 1);

    }

    @Test
    public void testGetCapacity() {

        int expectedCapacity = 2;
        int actualCapacity = bank.getCapacity();


        assertEquals(expectedCapacity, actualCapacity);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidCapacityShouldThrow() {

        Bank bank1 = new Bank("UniCredit", -1);

    }

    @Test
    public void testGetCorrectCount() {

        int expectedCount = 1;
        int actualCount = bank.getCount();
        assertEquals(expectedCount, actualCount);

    }

    @Test
    public void testAddClientWhitEnoughCapacity() {
        Client client1 = new Client("Borislav");
        bank.addClient(client1);
        int expectedCount = 2;
        int actualCount = bank.getCount();
        assertEquals(expectedCount, actualCount);


    }

    @Test(expected = IllegalArgumentException.class)
    public void testTryAddClientWhitNoCapacityLeft() {
        Client client1 = new Client("Borislav");
        Client client2 = new Client("Liliya");
        bank.addClient(client1);
        bank.addClient(client2);
    }

    @Test
    public void testRemoveClient() {

        bank.removeClient("Monika");

        int expectedCount = 0;
        int actualCount = bank.getCount();
        assertEquals(expectedCount, actualCount);

    }
    @Test(expected = IllegalArgumentException.class)
    public void tryToRemoveNullClientShouldThrow(){
        Client client1 = new Client("null");
        bank.removeClient(client1.getName());

    }

    @Test
    public void testClientLoanWithdrawal(){
     bank.loanWithdrawal("Monika");

        assertFalse(client.isApprovedForLoan());
    }
    @Test
    public void testGetStatistics(){

        String expected = String.format("The client %s is at the %s bank!","Monika","DSK");
        assertEquals(expected,bank.statistics());

    }


}
