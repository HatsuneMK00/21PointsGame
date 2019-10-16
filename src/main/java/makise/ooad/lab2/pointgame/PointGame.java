package makise.ooad.lab2.pointgame;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

//只是一个游戏的相关成员的封装
@Component
public class PointGame {
    //  庄家显式储存，与player列表分开
    private House house;
    private ArrayList<Player> players = new ArrayList<>();
//    发牌员
    private Dealer dealer = new Dealer();
//    裁判
    private Judge judge = new Judge();
    private int round = 0;

    public void setHouse(House house) {
        this.house = house;
    }

    public House getHouse() {
        return house;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Judge getJudge() {
        return judge;
    }

    public void setJudge(Judge judge) {
        this.judge = judge;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
}
