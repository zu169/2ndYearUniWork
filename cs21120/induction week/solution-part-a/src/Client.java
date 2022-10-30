import java.math.BigDecimal;

import uk.ac.aber.dcs.induction.accounts.Account;
import uk.ac.aber.dcs.induction.accounts.CurrentAccount;
import uk.ac.aber.dcs.induction.accounts.InsufficientFundsException;
import uk.ac.aber.dcs.induction.accounts.SavingsAccount;

public class Client
{
   // This is an example of how you create constants in Java. The static
   // reserved word means that these are class attributes not instance
   // variables, i.e. the values are stored in the class and not in an object
   // instance. The final reserved word means that they cannot be changed.
   // By convention constants use upper-case identifiers
   private static final int CURRENT = 0;
   private static final int SAVINGS = 1;

   private Account account;
   private int accountType = CURRENT;

   private Client(int type, BigDecimal initialBalance)
   {
      switch (type)
      {
         case CURRENT:
            account = new CurrentAccount(initialBalance);
            break;
         case SAVINGS:
            account = new SavingsAccount(initialBalance);
            break;
         default:
            System.out.println("Illegal account type specified");
      }
      accountType = type;
   }

   // Notice that the only place we explicitly use the CurrentAccount and
   // SavingsAccount classes is in the Client constructor. Elsewhere
   // we use the account variable which is of type Account (the interface).
   // In big programs this can make maintenance much easier. I.e. if we want to
   // add a new type of account e.g. PremiumSavingsAccount, we simply need to
   // change one location in our code; where an object of the class is created.
   // Elsewhere, we only refer to the interface type. This works because we know
   // that any class that implements the interface will have the same set of methods.
   // We can do even better than this using something called factories (software design patterns)

   private void increment(BigDecimal amount){
      account.deposit(amount);
   }

   private void decrement(BigDecimal amount){
      try{
         account.withdraw(amount);
      }
      catch(InsufficientFundsException ife){
         System.out.println("Insufficient funds to withdraw: " + amount);
      }
   }

   private BigDecimal currentBalance(){
      return account.getBalance();
   }

   private void requestOverdraft(BigDecimal amount){
      account.setOverdraft(amount);
   }

   private String getTypeAsString(){
      if (CURRENT == accountType){
         return "CURRENT";
      }
      else{
         return "SAVINGS";
      }
   }

   public static void main(String args[]){
      // Creates a CurrentAccount, SavingsAccount and then uses them
      Client clients[] = {new Client(Client.CURRENT, new BigDecimal("100.00")),
                          new Client(Client.SAVINGS, new BigDecimal("100.00"))};
              
      // To show the difference between the two types of account wrt overdrafts
      // the same set of operations are performed on both types of account
      for (int i = 0; i<clients.length; i++){
         System.out.println("Client account type is " + clients[i].getTypeAsString());
         System.out.println("Client" + i + " balance = " + clients[i].currentBalance());
         System.out.println("About to deposit " + 30.0);
         clients[i].increment(new BigDecimal("30.00"));
         System.out.println("Client" + i + " balance = " + clients[i].currentBalance());
         System.out.println("About to withdraw " + 140.0);
         clients[i].decrement(new BigDecimal("140.00"));
         System.out.println("Client" + i + " balance = " + clients[i].currentBalance());
         System.out.println("About to request overdraft of " + 100.0);
         clients[i].requestOverdraft(new BigDecimal("100.00"));
         System.out.println("About to withdraw " + 140.0);
         clients[i].decrement(new BigDecimal("140.00"));
         System.out.println("Client" + i + " balance = " + clients[i].currentBalance());
      }
   }
}