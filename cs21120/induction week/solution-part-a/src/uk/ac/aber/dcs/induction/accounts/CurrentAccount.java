package uk.ac.aber.dcs.induction.accounts;
/**
 * Purpose to define a simple class that implements methods defined by the
 * Account interface. Checking accounts allow for overdrafts.
 *
 */

import java.math.BigDecimal;


public class CurrentAccount implements Account {

    // The scale of a BigDecimal is the number of digits after
    // the decimal point. When using the constructor that takes
    // a String, the scale is worked out based on the number
    // of digits provided in the String argument, in this case 2
    private BigDecimal balance = new BigDecimal("0.00");
    private BigDecimal overdraft = new BigDecimal("0.00");

    public CurrentAccount() {
    }

    /**
     ** Constructor sets the balance.
     ** @param initialBalance The initial balance
     ** @exception IllegalArgumentException is thrown if initialBalance is < -overdraft
     */
    public CurrentAccount(BigDecimal initialBalance) {
        setBalance(initialBalance);
    }

    /**
     ** Gets the current balance
     ** @return The balance as a double value
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     ** Set the balance.
     ** @param amount The new balance
     ** @exception IllegalArgumentException is thrown if initialBalance is < -overdraft
     */
    public void setBalance(BigDecimal amount) {
        // REPLACE BigDecimal.ZERO by negative of overdraft (Google BigDecimal.negate method)
        // Also see BigDecimal.compareTo if you can't remember how compareTo methods work
        if (amount.compareTo(overdraft.negate()) >= 0) {
            this.balance = amount;
        } else {
            throw new IllegalArgumentException("The amount must be >= " + overdraft.negate());
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
     **            resulting balance would be < -getOverdraft()
     ** @exception IllegalArgumentException thrown if the amount is not positive
     */
    public void withdraw(BigDecimal amount)
            throws InsufficientFundsException {

        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            // CHANGE THIS LINE TO USE overdraft rather than BigDecimal.ZERO
            // You will need to negate the overdraft to a negative
            if (balance.subtract(amount).compareTo(overdraft.negate()) >= 0) {
                balance = balance.subtract(amount);
            } else {
                throw new InsufficientFundsException("Oops not enough funds");
            }
        } else {
            throw new IllegalArgumentException("The amount must be > 0");
        }
    }

    // ADD MISSING CODE TO DEAL WITH OVERDRAFTS

    /**
     ** Sets the overdraft limit
     ** @param amount The allowed overdraft. Must be a natural number.
     ** @exception IllegalArgumentException thrown if the amount is not >= 0
     */
    public void setOverdraft(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) >= 0) {
            this.overdraft = amount;
        } else {
            throw new IllegalArgumentException("The amount must be >= 0");
        }
    }

    /**
     ** Gets the current overdraft level for the account
     ** @return The current overdraft amount allowed as a BigDecimal.
     */
    public BigDecimal getOverdraft() {
        return this.overdraft;
    }

}
