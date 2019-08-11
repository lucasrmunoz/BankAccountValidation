package com.company;

public class TestAccount {
    private String bankAccount;
    private String accountNumber;
    private String routingNumber;

    TestAccount(String bankAccount){
        this.bankAccount = bankAccount.replaceAll("\\s", "").replace("-", "");
        this.routingNumber = this.bankAccount.substring(0, 9);
        this.accountNumber = this.bankAccount.substring(9);
    }

    // To check and make sure the routing and account numbers have been validated
    public boolean isValid() {
        return (isRoutingNumberValid() && isUserAccountValid());
    }

    // Runs a check on the routing number to make sure we will have no remainder from the calculated sum
    public boolean isRoutingNumberValid() {
            int checkSumTotal = 0;

            if (routingNumber.length() != 9){
                return false;
            }

            for (int i = 0; i < routingNumber.length(); i += 3) {
                checkSumTotal += Character.getNumericValue(routingNumber.charAt(i)) * 3;
                checkSumTotal += Character.getNumericValue(routingNumber.charAt(i + 1)) * 7;
                checkSumTotal += Character.getNumericValue(routingNumber.charAt(i + 2));
            }

        return ((checkSumTotal % 10) == 0);
    }

    // validates that the users account is at least 5 characters long
    public boolean isUserAccountValid() {
        return (accountNumber.length() >= 5);
    }

    // returns a snip of the bank account number such as 123271978...889
    public String sanitized() {
        return routingNumber + "..." + bankAccount.substring(bankAccount.length() - 3);
    }
}
