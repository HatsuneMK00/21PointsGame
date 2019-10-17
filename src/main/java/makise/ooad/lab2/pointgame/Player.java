package makise.ooad.lab2.pointgame;

import makise.ooad.lab2.entity.GameStatus;

public class Player extends Gambler {
    public Player(int id, String name, int moneyAmount) {
        super(id, name, moneyAmount);
    }

    @Override
    public boolean hit(Dealer dealer) {
        super.getOneCard(dealer);
        if(hand.isBusted())
            return true;
        return false;
    }
    public void setBet(int amount){
        money.subtractMoney(amount);
        setBetNum(amount);
    }
}
