package teardownMethods;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


public class BankAppTest {
	private BankAccountApp account;
	
	@Before
    public void setUp() {
        // Setup
        account = new BankAccountApp(1000);
        System.out.println("Before Test: New account created with 1000 balance");
    }

    @After
    public void tearDown() {
        // Teardown
        System.out.println("After Test: Test finished\n");
    }

    @Test
    public void testDeposit() {
        // Arrange
        int depositAmount = 500;

        // Act
        account.deposit(depositAmount);

        // Assert
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        // Arrange
        int withdrawAmount = 400;

        // Act
        account.withdraw(withdrawAmount);

        // Assert
        assertEquals(600, account.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawInsufficientBalance() {
        // Arrange
        int withdrawAmount = 2000;

        // Act
        account.withdraw(withdrawAmount);  // should throw exception

        // Assert is handled by the expected exception
    }

}
