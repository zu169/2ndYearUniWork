package uk.ac.aber.dcs.induction.accounts.tests;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.aber.dcs.induction.accounts.Account;
import uk.ac.aber.dcs.induction.accounts.InsufficientFundsException;
import uk.ac.aber.dcs.induction.accounts.SavingsAccount;


class SavingsAccountTest {

    private static final BigDecimal INITIAL_BALANCE = new BigDecimal("1.00");
    private Account account;

    @BeforeEach
    void createAccountFixture() {
        account = new SavingsAccount(INITIAL_BALANCE);
    }

    // Here are two tests. Others are needed to
    // make sure the program only allows for positive
    // doubles when withdrawing and incrementing and
    // that an exception is thrown if we try and
    // set a withdrawal limit
    @Test
    void testIncrementBalanceByOne() {
        // Exercise program
        account.deposit(new BigDecimal("1.00"));

        // Check that balance is now 2.0
        Assertions.assertEquals(new BigDecimal("2.00"), account.getBalance(), "Wrong balance!");
    }

    @Test
    void testDecrementBalanceJustBelowZero() {
        // Exercise program. Notice the use of the Java 8 lambda
        // as the third parameter. This contains the code to exercise
        // where we expect an exception to be thrown. In this case I have
        // one statement, but you could have any number of statements
        // surrounded by { ... }.
        Assertions.assertThrows(InsufficientFundsException.class,
                () -> account.withdraw(new BigDecimal("1.01")));
    }
}
