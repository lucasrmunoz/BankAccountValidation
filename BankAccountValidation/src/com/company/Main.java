package com.company;

public class Main {

    public static void main(String[] args) {
        String bankAccount = "123 2-719787826271889";
        TestAccount testAccount = new TestAccount(bankAccount);
        System.out.println("Is routing number valid: " + testAccount.isRoutingNumberValid());
        System.out.println("Is user account valid: " + testAccount.isUserAccountValid());
        System.out.println("Is valid: " + testAccount.isValid());
        System.out.println("Account: " + testAccount.sanitized());
    }
}
