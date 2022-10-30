package uk.ac.aber.dcs.induction.accounts;
/**
 * Purpose to define a simple class that implements methods defined by the
 * Account interface. Savings accounts do NOT allow for overdrafts.
 *
 */

import java.math.BigDecimal;

public class SavingsAccount implements Account {

    private BigDecimal balance = new BigDecimal("0.00");

    /**
     ** Constructor sets the balance.
     ** @param initialBalance The initial balance
     ** @exception IllegalArgumentException is thrown if initialBalance is not >= 0.0
     */
    public SavingsAccount(BigDecimal initialBalance) {
        setBalance(initialBalance);
    }

    /**
     ** Gets the current balance
     ** @return The balance as a BigDecimal value
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     ** Set the balance.
     ** @param amount The new balance
     ** @exception IllegalArgumentException is thrown if the amount is not >= 0.0
     */
    public void setBalance(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) >= 0) {
            this.balance = amount;
        } else {
            throw new IllegalArgumentException("The amount must be >= 0.0");
        }
    }

    /**
     ** Increment the account by amount
     ** @param amount the amount to increment by. Must be positive.
     ** @exception IllegalArgumentException is thrown if the amount is not positive
     */
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.add(amount);
        } else {
            throw new IllegalArgumentException("The amount must be > 0");
        }
    }

    /**
     ** Decrement the account by amount
     ** @param amount the amount to decrement by. Must be positive.
     ** @exception InsufficientFundsException is thrown if
     **            resulting balance would be < 0
     ** @exception IllegalArgumentException thrown if the amount is not positive
     */
    public void withdraw(BigDecimal amount)
            throws InsufficientFundsException {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            if (balance.subtract(amount).compareTo(BigDecimal.ZERO) >= 0) {
                balance = balance.subtract(amount);
            } else {
                throw new InsufficientFundsException("Oops not enough funds");
            }
        } else {
            throw new IllegalArgumentException("The amount must be > 0.0");
        }
    }
}
