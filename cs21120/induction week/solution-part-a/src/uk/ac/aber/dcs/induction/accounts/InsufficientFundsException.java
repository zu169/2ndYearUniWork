package uk.ac.aber.dcs.induction.accounts;


public class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) {
        super(message);
    }
}
