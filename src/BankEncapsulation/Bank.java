package BankEncapsulation;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Bank {

    private final String bankName;
    private Customer customer;
    private Account account;
    static int accountID;
    static int customerID;
    static AccountRecord accountRecord;
    static ArrayList<Customer> customersList = new ArrayList<>();
    static ArrayList<Account> accountsList = new ArrayList<>();
    static ArrayList<Integer> accountIDList = new ArrayList<>();
    static ArrayList<Integer> customerIDList = new ArrayList<>();
    static ArrayList<AccountRecord> accountRecordsList = new ArrayList<>();
    final private Customer defaultCustomer = new Customer("null", null, 0);
    final private Account defaultAccount = new Account(defaultCustomer, Account.AccountType.DefaultAccount, 0) {
    };

    public Bank(String bankName) {
        this.bankName = bankName;
        System.out.println(bankName + " was successfully created.");
    }

    private Customer createCustomer(String firstName, String lastName) {
        this.customer = new Customer(firstName, lastName, createCustomerID());
        customersList.add(customer);
        System.out.print(customer.getFullName() + " was successfully added with the customerID:" + customerID + " by " + bankName + ". ");
        return customer;
    }

    private int createCustomerID() {
        while (true) {
            customerID++;
            int createdID = customerID;

            if (!customerIDList.contains(createdID)) {
                customerIDList.add(createdID);
                break;
            }
        }
        return customerID;
    }

    public void createNewAccountExistingCustomer(String firstName, String lastName, int customerID, String accountType) {
        Customer attemptedCustomer = new Customer(firstName, lastName, customerID);
        for (Customer locatedCustomer : customersList) {
            if (locatedCustomer.equals(attemptedCustomer)) {
                System.out.print(attemptedCustomer.getFullName() + " with customer ID: " + attemptedCustomer.getCustomerID() + " was successfully located. ");
                createAccount(attemptedCustomer, accountType);
                break;
            }
        }
        if (!customersList.contains(attemptedCustomer)) {
            System.out.println("Attempt to add additional account was unsuccessful. Invalid entry.");
            getDefaultAccount();
        }
    }

    public void createNewAccountNewCustomer(String firstName, String lastName, String accountType) {
        this.customer = createCustomer(firstName, lastName);
        createAccount(this.customer, accountType);
    }

    private void createAccount(Customer customer, String accountType) {
        if (!(accountType.equals("CheckingAccount") || accountType.equals("SavingsAccount") || accountType.equals("CreditAccount"))) {
            System.out.println("Attempt to add additional account was unsuccessful. Invalid entry.");
        } else {
            switch (accountType) {

                case "CheckingAccount" -> {
                    this.account = new CheckingAccount(customer, Account.AccountType.CheckingAccount, createAccountID());
                    System.out.println("A Checking account with the account ID: " + accountID + " was also created.");
                    accountsList.add(this.account);
                    accountRecordsList.add(new AccountRecord(customer, this.account));
                }

                case "SavingsAccount" -> {
                    this.account = new SavingsAccount(customer, Account.AccountType.SavingsAccount, createAccountID());
                    System.out.println("A Savings account with the account ID: " + accountID + " was also created.");
                    accountsList.add(this.account);
                    accountRecordsList.add(new AccountRecord(customer, this.account));
                }

                case "CreditAccount" -> {
                    this.account = new SavingsAccount(customer, Account.AccountType.CreditAccount, createAccountID());
                    System.out.println("A Credit account with the account ID: " + accountID + " was also created.");
                    accountsList.add(this.account);
                    accountRecordsList.add(new AccountRecord(customer, this.account));
                }
                default -> getDefaultAccount();
            }
            //customer.addAccountToCustomerAccountList(account);
        }
        accountsList.add(account);
    }

    private int createAccountID() {
        int randomNum;

        while (true) {
            randomNum = ThreadLocalRandom.current().nextInt(10000000, 99999999);

            if (!accountIDList.contains(randomNum)) {
                accountID = randomNum;
                accountIDList.add(accountID);
                break;
            }
        }
        return accountID;
    }

    private void getDefaultAccount() {
        this.account = defaultAccount;
    }

    public Account retrieveAccountCustomer(String firstName, String lastName, int customerID) {
        return retrieveAccount(firstName, lastName, customerID);
    }

    public Account retrieveAccountBank(String firstName, String lastName, int customerID, int bankPasscode) {
        if (bankPasscode == 12345) {
            return retrieveAccount(firstName, lastName, customerID);
        } else {
            System.out.println("Not Authorized.");
            return defaultAccount;
        }
    }

    private Account retrieveAccount(String firstName, String lastName, int customerID) {
        Customer customerAttempt = new Customer(firstName, lastName, customerID);

        for (Account accountLookup : accountsList) {
            if (accountLookup.getCustomer().equals(customerAttempt)) {
                this.account = accountLookup;
                this.customer = customerAttempt;
                return account;
            }
        }
        if (!customersList.contains(customerAttempt)) {
            System.out.println("Invalid Customer Lookup. " + customerAttempt + "not found in system.");
        }
        return defaultAccount;
    }

    public Customer getCustomer(String firstName, String lastName, int customerID) {
        Customer tempCustomer = new Customer(firstName, lastName, customerID);
        for (Customer currentCustomer : customersList) {
            if (currentCustomer.equals(tempCustomer)) {
                tempCustomer = currentCustomer;
                System.out.println("Customer lookup successful: ");
                break;
            }
        }
        if (!customersList.contains(tempCustomer)) {
            System.out.println("Customer not found; ");
            return defaultCustomer;
        }
        return tempCustomer;
    }


    public void getCustomersList() {
        System.out.println(customersList);
    }

    public void getAccountIDList() {
        System.out.println(accountIDList); ;
    }

    public void getCustomerIDList() {
        System.out.println(customerIDList);;
    }

    public void getAccountsList() {
        System.out.println(accountsList); ;
    }

    public void getAccountRecordsList() {
        System.out.println(accountRecordsList);
    }
    public void getRecords () {
        System.out.println(accountRecordsList);
    }

    public void customerIDLookUp (int accountID) {

        for (Customer tempCustomer : customersList) {
            if (tempCustomer.getCustomerID() == accountID) {
                customer = tempCustomer;
                break;
            }
        }
        System.out.println(customer);
    }
}
