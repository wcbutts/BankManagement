package BankEncapsulation;

import java.util.Objects;

public class Customer {

    private final String firstName;
    private final String lastName;
    static Account account;
    private final int customerID;
    private AccountRecord accountRecord;
    //private ArrayList<Account> customerAccountList;

    Customer(String firstName, String lastName, int customerID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerID = customerID;
        //customerAccountList = new ArrayList<>();
    }

//    public void addAccountToCustomerAccountList(Account account) {
//      customerAccountList.add(account);
//
//    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public AccountRecord getAccountRecord() {
        return accountRecord;
    }

    public Account getAccount() {
        return account;
    }

//    public void accountListTest() {
//        System.out.println(customerAccountList);
//    }

    @Override
    public String toString() {
        return "{Customer: " + getFullName() + ", CustomerID: " + customerID + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return customerID == customer.customerID && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, customerID);
    }
}

