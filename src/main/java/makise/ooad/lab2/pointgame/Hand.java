package makise.ooad.lab2.pointgame;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards = new ArrayList<>();
    private boolean isBusted;
    private int betNum;
    public Hand(ArrayList<Card> cards){
        isBusted=false;
        this.cards=cards;
    }

    public int getBetNum() {
        return betNum;
    }

    public void setBetNum(int betNum) {
        this.betNum = betNum;
    }

    public boolean isBusted() {
        return isBusted;
    }

    public void setBusted() {
        isBusted = true;
    }

    public boolean addCard(Card card){
        cards.add(card);
        if(getHandPoint()>21) return true;
        return false;
    }
    public int getHandPoint(){
        int result=0;
        int numOfA = 0;
        for(Card card : cards){
            result+=card.getPoint();
            if(card.getPoint()==11)
                numOfA++;
        }
        while(result>21&&numOfA>0){
            result-=10;
        }
        return result;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getHandCardAmount(){
        return cards.size();
    }
}
