package com.company;

public class TestAccount {
    String bankAccount;
    String accountNumber;
    String routingNumber;
    TestAccount(String bankAccount){
        this.bankAccount = bankAccount.replaceAll("\\s", "").replace("-", "");
        this.routingNumber = this.bankAccount.substring(0, 9);
        this.accountNumber = this.bankAccount.substring(9);
    }

    public boolean isValid() {
        if (isRoutingNumberValid() && isUserAccountValid()) {
            return true;
        }
        return false;
    }

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

            if ((checkSumTotal % 10) != 0){
                return false;
            }
            return true;
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
