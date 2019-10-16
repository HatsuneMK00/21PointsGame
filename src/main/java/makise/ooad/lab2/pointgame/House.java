package makise.ooad.lab2.pointgame;

import makise.ooad.lab2.entity.GameStatus;

public class House extends Gambler {
    public House(int id, String name, int moneyAmount) {
        super(id, name, moneyAmount);
    }

    @Override
    public boolean hit(Dealer dealer) {
        while(hand.getHandPoint()<=17){
            getOneCard(dealer);
            if(hand.isBusted())
                return true;
        }
        return false;
    }
}
