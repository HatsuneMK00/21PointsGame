package makise.ooad.lab2.pointgame;

public class Money {
    private int balance;
    public Money(int balance){
        this.balance=balance;
    }
    public void addMoney(int amount){
        balance+=amount;
    }

    public void subtractMoney(int amount){
        balance-=amount;
    }

    public int getBalance() {
        return balance;
    }
}
