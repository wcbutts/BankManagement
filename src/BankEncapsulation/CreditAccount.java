package BankEncapsulation;

public class CreditAccount extends Account{

    CreditAccount(Customer customer, AccountType accountType, int accountID) {
        super(customer, AccountType.CreditAccount, accountID);
    }
}
