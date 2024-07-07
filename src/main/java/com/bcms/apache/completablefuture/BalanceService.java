package com.bcms.apache.completablefuture;

import java.util.concurrent.TimeUnit;

public class BalanceService {
    public static Double getAccountBalance(BankAccount account) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return account.value();
    }
}
