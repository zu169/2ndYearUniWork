package uk.ac.aber.dcs.induction.accounts;
/**
 * Purpose to define a simple interface that defines methods that all kinds
 * of accounts should support. Clients of this interface just use the methods
 * defined by the interface, without needing to know what the implementation
 * class is.
 *
 */

import java.math.BigDecimal;

public interface Account {
    /**
     ** Gets the current balance
     ** @return The balance as a BigDecimal value
     */
    public BigDecimal getBalance();

    /**
     ** Set the balance.
     ** @param amount The new balance
     */
    public void setBalance(BigDecimal amount);

    /**
     ** Increment the account by amount
     ** @param amount The amount to increment by. Must be positive.
     */
    public void deposit(BigDecimal amount);

    /**
     ** Decrement the account by amount
     ** @param amount The amount to decrement by. Must be positive.
     ** @exception InsufficientFundsException is thrown if
     **            resulting balance exceeds allowed limit
     */
    public void withdraw(BigDecimal amount) throws InsufficientFundsException;

    /**
     ** Sets the overdraft limit as a positive value
     ** @param amount The allowed overdraft as a positive value.
     */
    public default void setOverdraft(BigDecimal amount) {
        // By default we provide an unsupported implementation
        throw new UnsupportedOperationException
                ("Cannot set an overdraft for savings accounts");
    }

    /**
     ** Gets the current overdraft level for the account
     ** @return The current overdraft amount allowed as a BigDecimal.
     */
    public default BigDecimal getOverdraft() {
        // By default just return ZERO
        return BigDecimal.ZERO;
    }

}
