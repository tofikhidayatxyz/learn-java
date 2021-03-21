import teller.*;

// main
public class Main {
    static int myMoney = 500000;
    static Bank bank = new Bank();
    static User user = new User(myMoney);
    static SavingBook savingBook = new SavingBook();

    public static void main(String[] args) {

        if(!bank.isOpen()) {
            System.out.println("Kembali beberapa jam atau hari lagi");
        } else {
            if(!user.onGoingToBank()) {
                // user is come to bank currently
                System.out.println("User sampai di bank");
                // user get teller
                int myQueueNumber = bank.picQueueTeller(user);
                int bankQueue =  bank.onQueue();
                while(bankQueue != myQueueNumber) {
                    System.out.println("Nomor " + bankQueue + " Masuk ke teller"); 
                    bankQueue = bank.onQueue();
                }
                // user di panggil
                System.out.println("Nomor " + bankQueue + " Masuk ke teller"); 
                boolean bankStored = bank.giveTellerMySaving(user, savingBook);

                if(bankStored) {
                    System.out.println("Saldo user sekarang adalah RP." + savingBook.getMoney());
                    user.backToHome();
                } else {
                    user.tryAnotherTime();
                }   
            }
        }
    }
}

