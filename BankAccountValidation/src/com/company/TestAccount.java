package com.company;

public class TestAccount {
    String bankAccount;
    String accountNumber;
    String routingNumber;
    TestAccount(String bankAccount){
        this.bankAccount = bankAccount;
        this.routingNumber = bankAccount.substring(0, 9);
        this.accountNumber = bankAccount.substring(9);
    }

    public boolean isValid() {
        if (isRoutingNumberValid() && isUserAccountValid()) {
            return true;
        }
        return false;
    }

    public boolean isRoutingNumberValid() {
        try {
            routingNumber = routingNumber.replaceAll("\\s", "").replace("-", "");

            if (routingNumber.length() != 9){
                return false;
            }

            return true;
        } catch (Exception exc) {
            System.out.println("There was a failure with the exception: " + exc.getMessage());
            return false;
        }
    }

    public boolean isUserAccountValid() {
        if (accountNumber.length() >= 5){
            return true;
        }
        return false;
    }

    public String sanitized() {
        return routingNumber + "..." + bankAccount.substring(bankAccount.length() - 3);
    }
}
