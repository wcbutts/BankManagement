package BankEncapsulation;

class AccountRecord {
    private Customer customer;
    private Account account;
    //private BigDecimal balance;

    AccountRecord(Customer customer, Account account) {
        this.customer = customer;
        this.account = account;
        //this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountRecord{" +
                customer +
                " " + account +
                '}' + "\n";
    }
}
