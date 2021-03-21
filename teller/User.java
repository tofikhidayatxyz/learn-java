package teller;


public class User {
    static int myMoney = 0;

    public User(int money) {
        myMoney = money;
    }

    public boolean onGoingToBank() {
        System.out.println("User pergi ke bank membawa uang RP." + myMoney);
        try {
            // delay for temporary while user ongoing to bank
            Thread.sleep(2000);
        } catch(InterruptedException exception) {
            exception.printStackTrace();
        }
        // indicate user is come to bank
        return false;
    }

    public int getMoney() {
        return myMoney;
    }

    public void backToHome() {
        // back to home
        System.out.println("User kembali ke rumah dududududu :)");
    }

    public void tryAnotherTime() {
        System.out.println("User gagal setor, coba lain hari / waktu yha :(");
    }

}