package teller;

public class SavingBook {
    // empty class just for definition
    public int myCurrentMoney = 8000000;

    public int getMoney() {
        return myCurrentMoney;
    }
    
    public void setMoney(int newBalance) {
        myCurrentMoney += newBalance;
    }
}