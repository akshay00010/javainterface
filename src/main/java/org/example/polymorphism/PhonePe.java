package org.example.polymorphism;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiPredicate;

public class PhonePe implements UPIpayments{

 static Map<String,Double> accountBalanceMap = new HashMap<>();


    static {
        accountBalanceMap.put("9087542345",10000.0);
        accountBalanceMap.put("9708543223",1000.0);

    }

    BiPredicate<String,Double> checkBalance=(accountNumber,amount) -> {
        Double accountBalance = accountBalanceMap.get(accountNumber);
        if (accountBalance>amount) {
            return true;
        }
        else {
            return false;
        }
    };

    @Override
    public Payment transfer(String fromMobile, String toMobile, Double amount) {
     Payment p =new Payment();
     if (checkBalance.test(fromMobile,amount)){
         Double fromAccountBalance=accountBalanceMap.get(fromMobile);
         Double toAccountBalance=accountBalanceMap.get(toMobile);
         Double fromTotalBalance = fromAccountBalance-amount;
         Double toTotalBalance =toAccountBalance +amount;
         accountBalanceMap.put(fromMobile,fromTotalBalance);
         accountBalanceMap.put(toMobile,toTotalBalance);
         p.setStatus(PaymentStatus.success.getLabel());
         p.setTransactionId(UUID.randomUUID().toString());
         p.setUTR(UUID.randomUUID().toString());
         p.setTransactionDate(new Date());


     } else {
         p.setStatus(PaymentStatus.failed.getLabel());
         p.setTransactionId(UUID.randomUUID().toString());
         p.setUTR(UUID.randomUUID().toString());
         p.setTransactionDate(new Date());



     }
     return p;
    }


    }


