import BankEncapsulation.Bank;

public class Main {
    public static void main(String[] args) {

        Bank branchMain = new Bank("Main Branch");
        //creating a bank

        branchMain.createNewAccountNewCustomer("George", "Wallace","SavingsAccount");
        //creating a checking account with new customer
        //unique customer ID and account ID automatically generated


        //George Wallace's ID number is 1
        branchMain.retrieveAccountBank("George","Wallace",1,12345).deposit(1000.33);
        //bank retrieving account needing a password (12345)
        //bank making a deposit upon customer's request
        branchMain.retrieveAccountBank("George","Wallace",1,12345).withdraw(34.36);
        //bank making a withdrawal upon customer's request
        branchMain.retrieveAccountBank("George","Wallace",1,12345).withdraw(5000);
        //bank making a withdrawal larger than the amount in account
        //request is denied: no action taken
        branchMain.retrieveAccountBank("George","Wallace",1,12345).getBalance();
        //bank checking customers balance
        branchMain.retrieveAccountBank("George","Wallace",1,12345).getAccountRecord();
        //bank requesting full record of customer full name, customer ID, account type, account ID, and balance in the account
        System.out.println();
        branchMain.getCustomersList();


        System.out.println();
        System.out.println();

        Bank branchDT = new Bank("Downtown Branch");


        //customers and accounts are accessible across any created bank: branch
        //customer ids remain unique, and account ids remain attached to the specified account

        branchDT.createNewAccountNewCustomer("Evelyn", "Mary","CheckingAccount");
        // account created with new customer Evelyn Mary ID 2 (a unique account number is automatically generated as well of 6 digits

        branchDT.retrieveAccountBank("Evelyn","Mary",2,12345).deposit(1000);
        //branchDT.getMyAccount("Evelyn", "Mary",2);
        branchMain.retrieveAccountBank("Evelyn","Mary",2,12345).withdraw(234.33);
        //Evenly making withdraw at different branch
        branchMain.getCustomersList();


        System.out.println();
        System.out.println();
        Bank Chase = new Bank("Chase Bank");
        Chase.createNewAccountNewCustomer("Michael","Star","CheckingAccount");
        branchDT.createNewAccountNewCustomer("Sarah","Lee","SavingAccount");
        branchDT.createNewAccountNewCustomer("Sam", "Adam","CheckingAccount");

        branchMain.createNewAccountNewCustomer("Doug","Bug","CheckingAccount");

        branchMain.createNewAccountNewCustomer("George", "Wallace","CreditAccount");


        //retrieving account with customer credentials
        branchMain.retrieveAccountCustomer("George","Wallace",7).deposit(2300);
        branchMain.retrieveAccountBank("George","Wallace",7,12345).getBalance();
        branchMain.retrieveAccountBank("George","Wallace",7,44444).getBalance();

        System.out.println();
        branchDT.getCustomersList();
        System.out.println();
        System.out.println();
        branchMain.createNewAccountNewCustomer("Willie","Berry","CheckingAccount");
        branchMain.createNewAccountExistingCustomer("George","Wallace",7,"CreditAccount");
        //branchMain.getAccountRecordsList();

       branchDT.createNewAccountExistingCustomer("Evelyn","Mary",2,"SavingsAccount");
        //branchDT.getCustomer("Evelyn","Mary",2).accountListTest();
       branchDT.getAccountIDList();
       branchDT.getCustomerIDList();
       branchDT.getCustomersList();
        System.out.println();
        System.out.println();
       branchDT.getAccountRecordsList();
       branchMain.customerIDLookUp(4);

    }

}
 