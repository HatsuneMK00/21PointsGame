package makise.ooad.lab2.pointgame;

import makise.ooad.lab2.entity.GameStatus;

public class House extends Gambler {
    public House(int id, String name, int moneyAmount) {
        super(id, name, moneyAmount);
    }

    @Override
    public void hit(Dealer dealer) {
        while(hand.getHandPoint()<=17){
            getOneCard(dealer);
        }
    }

    @Override
    public GameStatus stand() {
        GameStatus gameStatus = new GameStatus(0,getBetNum(),money.getBalance(),hand.getCards(),hand.isBusted(),2);
        return gameStatus;
    }
}
