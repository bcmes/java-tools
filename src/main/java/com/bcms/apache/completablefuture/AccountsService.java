package com.bcms.apache.completablefuture;

import java.util.concurrent.TimeUnit;

public class AccountsService {
    public static BankAccount getBankAccount(String accId) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new BankAccount();
    }
}
