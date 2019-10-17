package makise.ooad.lab2.entity;

import makise.ooad.lab2.pointgame.Card;

import java.util.ArrayList;

//这个类的数组将被json化发给前端
public class GameStatus {
    //    用户id
    private int id;
    //    赌注金额
    private int betNum;
    //    balance小于0则游戏结束
    private int balance;
    //    手牌数组 按照发牌顺序 每次在最后添加
    private ArrayList<Card> hand;
    //    玩家是否赢得游戏 -1表示输，0表示平局，1表示赢，2表示还未结算
    private int isWin;
    //    指示是否爆牌
    private boolean isBust;
    //    用于显示这是当前的第几轮

    public GameStatus(){

    }
    public GameStatus(int id,int betNum,int balance,ArrayList<Card> hand,boolean isBust,int isWin){
        this.id = id;
        this.betNum = betNum;
        this.balance = balance;
        this.hand = hand;
        this.isBust = isBust;
        this.isWin = isWin;
    }

    public int getIsWin() {
        return isWin;
    }

    public void setIsWin(int isWin) {
        this.isWin = isWin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBetNum() {
        return betNum;
    }

    public void setBetNum(int betNum) {
        this.betNum = betNum;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public boolean isBust() {
        return isBust;
    }

    public void setBust(boolean bust) {
        isBust = bust;
    }

    @Override
    public String toString() {
        return "GameStatus{" +
                "id=" + id +
                ", betNum=" + betNum +
                ", balance=" + balance +
                ", hand=" + hand +
                ", isWin=" + isWin +
                ", isBust=" + isBust +
                '}';
    }
}
