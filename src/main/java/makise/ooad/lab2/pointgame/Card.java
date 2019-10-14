package makise.ooad.lab2.pointgame;

import makise.ooad.lab2.utils.CardType;

public class Card {
    private CardType type;
    private int point;

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
