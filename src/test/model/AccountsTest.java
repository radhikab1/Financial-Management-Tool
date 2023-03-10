package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// Represents tests for Accounts
public class AccountsTest {
    private AccountsList accounts;
    private Account account1;
    private Account account2;

    @BeforeEach
    public void runBefore() {
        accounts = new AccountsList("Radhika's AccountsList");
        account1 = new Account(1, "John Smith", 200.00);
        account2 = new Account(2, "Emily Wood", 0.00);
    }

    @Test
    public void testConstructor() {
        assertNotNull(accounts.getAccounts());
        assertEquals("Radhika's AccountsList", accounts.getName());
        assertEquals(0, accounts.getAccounts().size());
    }

    @Test
    public void testAddAccountOnce() {
        accounts.addAccount(account1);
        assertEquals(1, accounts.getAccounts().size());
        assertEquals(account1, accounts.getAccounts().get(0));
    }

    @Test
    public void testAddAccountMultipleTimes() {
        accounts.addAccount(account1);
        accounts.addAccount(account2);
        assertEquals(2, accounts.getAccounts().size());
        assertEquals(account1, accounts.getAccounts().get(0));
        assertEquals(account2, accounts.getAccounts().get(1));
    }

    @Test
    public void testRemoveAccountOnce() {
        accounts.getAccounts().add(account1);
        accounts.getAccounts().add(account2);
        accounts.removeAccount(account1);
        assertEquals(1, accounts.getAccounts().size());
        assertEquals(account2, accounts.getAccounts().get(0));
    }

    @Test
    public void testRemoveAccountMultipleTimes(){
        accounts.getAccounts().add(account1);
        accounts.getAccounts().add(account2);
        accounts.removeAccount(account2);
        assertEquals(1, accounts.getAccounts().size());
        assertEquals(account1, accounts.getAccounts().get(0));
        accounts.removeAccount(account1);
        assertEquals(0, accounts.getAccounts().size());
    }

    @Test
    public void testGetAccountIdsForOneAccount() {
        accounts.getAccounts().add(account1);
        assertEquals(1, accounts.getAccountIds().size());
        assertEquals(1, accounts.getAccountIds().get(0));
    }

    @Test
    public void testGetAccountIdsForMultipleAccounts() {
        accounts.getAccounts().add(account1);
        accounts.getAccounts().add(account2);
        assertEquals(2, accounts.getAccountIds().size());
        assertEquals(1, accounts.getAccountIds().get(0));
        assertEquals(2, accounts.getAccountIds().get(1));
    }
}

