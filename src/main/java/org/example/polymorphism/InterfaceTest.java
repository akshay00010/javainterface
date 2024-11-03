package org.example.polymorphism;

public interface InterfaceTest {
    public static void main(String[] args) {
        UPIpayments Payments = new PhonePe();

        Payment pay = Payments.transfer("9087542345","9708543223",3000.0);
        System.out.println(pay.getTransactionId()+"status:"+pay.getStatus()+"UTR"+pay.getUTR());
        System.out.println("Balance of from account: "+PhonePe.accountBalanceMap.get("9087542345"));
        System.out.println(" to account balance: "+PhonePe.accountBalanceMap.get("9708543223"));


    }
    }

