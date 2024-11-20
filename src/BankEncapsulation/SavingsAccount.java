package BankEncapsulation;

 class SavingsAccount extends Account{

    SavingsAccount(Customer customer, AccountType accountType, int accountID) {
        super(customer, AccountType.SavingsAccount, accountID);
    }
}
