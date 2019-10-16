package makise.ooad.lab2.pointgame;

import makise.ooad.lab2.entity.GameStatus;

public class Player extends Gambler {
    public Player(int id, String name, int moneyAmount) {
        super(id, name, moneyAmount);
    }

    @Override
    public void hit(Dealer dealer) {
        super.getOneCard(dealer);
    }
    public boolean setBet(int amount){
        if(money.getBalance()<amount)
            return false;
        money.subtractMoney(amount);
        setBetNum(amount);
        return true;
    }
    @Override
    public GameStatus stand() {
        GameStatus gameStatus = new GameStatus(id,getBetNum(),money.getBalance(),hand.getCards(),hand.isBusted(),2);
        return gameStatus;
    }
}
