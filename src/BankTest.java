import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {
    private Bank bank;
    private TransferThread[] threads;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
        threads = new TransferThread[Bank.numAccounts];

        for (int i = 0; i < Bank.numAccounts; i++) {
            threads[i] = new TransferThread(bank, i, 1000); // Set maxAmount to 1000 for example
            threads[i].start();
        }
    }

    @Test
    public void testBankAudit() throws InterruptedException {
        // Wait for some time to let the transfers happen
        TimeUnit.SECONDS.sleep(5);

        // Stop the threads to prevent infinite looping
        stopThreads();

        // Perform an audit to check the total money in the bank
        int totalMoney = getTotalMoneyInBank(bank);

        // The total money should be 100,000 since no other transfers are happening
        assertEquals(100000, totalMoney);
    }

    @Test
    public void testRandomTransfers() throws InterruptedException {
        // Wait for some time to let the transfers happen
        TimeUnit.SECONDS.sleep(5);

        // Stop the threads to prevent infinite looping
        stopThreads();

        // Perform an audit to check the total money in the bank
        int totalMoney = getTotalMoneyInBank(bank);

        // The total money should be 100,000 since no other transfers are happening
        assertEquals(100000, totalMoney);
    }

    private void stopThreads() {
        for (TransferThread thread : threads) {
            thread.interrupt();
        }
    }

    private int getTotalMoneyInBank(Bank bank) {
        int total = 0;
        for (int balance : bank.getAccounts()) {
            total += balance;
        }
        return total;
    }
}