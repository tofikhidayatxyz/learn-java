package teller;

import java.lang.Math; 

public class Bank {
    public boolean isOpen() {
        return true;
    }

    public int picQueueTeller(User user) {
        try {
            Thread.sleep(500);
        } catch(InterruptedException exception) {
            exception.printStackTrace();
        }
        return 2;
    }

    public int onQueue() {
        int randQueue = (int) (Math.random() * 10) + 1; 
        try {
            Thread.sleep(100);
        } catch(InterruptedException exception) {
            exception.printStackTrace();
        }
        return randQueue;
    }

    public boolean giveTellerMySaving(User user, SavingBook savingBook) {
        int userMoney = user.getMoney();
        System.out.println("User memberikan uang sebanyak RP."+  userMoney +" dan buku tabungan");
        System.out.println("Menyimpan ke database bank");
        savingBook.setMoney(userMoney);
        return Math.random() < 0.5;
    }
}