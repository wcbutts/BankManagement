package BankEncapsulation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public abstract class Account {

     enum  AccountType {CheckingAccount, SavingsAccount, CreditAccount, DefaultAccount}

    private final Customer customer;
    private final int accountID;
    private final AccountType accountType;
    private BigDecimal balance;

     Account(Customer customer, AccountType accountType, int accountID) {
        this.customer = customer;
        this.accountType = accountType;
        this.accountID = accountID;

        balance = BigDecimal.valueOf(0);
    }

     Customer getCustomer() {
        return customer;
    }

     AccountType getAccountType() {
        return accountType;
    }

    public void withdraw(double withdrawalAmount) {
         BigDecimal withdrawalPreciseAmount = BigDecimal.valueOf(withdrawalAmount).setScale(2, RoundingMode.HALF_UP);
        if (withdrawalPreciseAmount.compareTo(balance) > 0) {
            System.out.println(customer.getFirstName() + ", there are insufficient funds in your account. Your withdrawal was unsuccessful. Your current balance is still " + "$" + balance);
        } else {
            balance = balance.subtract(withdrawalPreciseAmount);
            System.out.println("Hello " + customer.getFirstName() + ", $" + withdrawalPreciseAmount + " was successfully withdrawn from your account! " +
                    "Your remaining balance is now: $" + balance);
        }
    }

    public void deposit(double depositAmount) {
         BigDecimal depositPreciseAmount = BigDecimal.valueOf(depositAmount).setScale(2,RoundingMode.HALF_UP);
        balance = balance.add(depositPreciseAmount);
        System.out.println("Hello " + customer.getFirstName() + ", $" + depositPreciseAmount + " was successfully deposited into your account! " +
                "Your new balance is now: $" + balance);
    }

    public void getBalance() {
        System.out.println(customer.getFirstName() + ", your balance is: $" + balance);
    }

    public void getAccountRecord() {
        System.out.println("Customer name:(" + customer.getFullName() + ") CustomerID:(" +customer.getCustomerID() + ") Account Type:("
                                        + accountType.toString() + ") AccountID:(" + accountID + ") Account Balance:($" + balance +")");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(customer, account.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(customer);
    }

    @Override
    public String toString() {
        return
                "{AccountType: " + accountType +
                ", AccountID: " + accountID +
                ", Balance: " + balance +
                '}';
    }
}
