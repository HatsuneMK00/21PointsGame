package makise.ooad.lab2.pointgame;

import makise.ooad.lab2.utils.CardType;

import java.util.ArrayList;
import java.util.Random;

public class Dealer {
//    这边的实现你看着改
    int[][] cards;
    public Dealer(){
        cards = new int[4][13];
        for(int[] row: cards){
            for(int line : row){
                line = 4;
            }
        }
    }
    public Card deal() {
        Random rc = new Random(System.currentTimeMillis());
        int type = rc.nextInt(3);
        int point = rc.nextInt(13);
        Card tem;
        if(point==0) point=11;
        else if(point>=10) point = 10;
        else point++;
        if(type==0){
            tem = new Card(CardType.HEART,point);
        }
        else if(type==1){
            tem = new Card(CardType.SPADE,point);
        }
        else if(type==2){
            tem = new Card(CardType.CLUB,point);
        }
        else tem = new Card(CardType.DIAMOND,point);
        return tem;
    }
    public Hand start(){
        Card c1 = deal();
        Card c2 = deal();
        ArrayList<Card> startHand = new ArrayList<>();
        startHand.add(c1);
        startHand.add(c2);
        return new Hand(startHand);
    }
}
