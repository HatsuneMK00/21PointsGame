package makise.ooad.lab2.entity;

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
    private ArrayList<Integer> hand;
    //    指示一轮是否结束
    private boolean isEnd;
    //    指示是否爆牌
    private boolean isBust;
    //    用于显示这是当前的第几轮
    private int round;
    //    用于指示接下来是玩家行动还是电脑行动
//    0表示电脑 其他数字对应玩家id
//    这个属性注意保持数组中所有对象一致
    private int turn;

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

    public ArrayList<Integer> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Integer> hand) {
        this.hand = hand;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public boolean isBust() {
        return isBust;
    }

    public void setBust(boolean bust) {
        isBust = bust;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
