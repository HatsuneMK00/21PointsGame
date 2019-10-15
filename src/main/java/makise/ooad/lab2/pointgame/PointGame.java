package makise.ooad.lab2.pointgame;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

//只是一个游戏的相关成员的封装
@Component
public class PointGame {
    //    可以将0号玩家固定为庄家
    private ArrayList<Player> players = new ArrayList<>();
    private Dealer dealer = new Dealer();
    private Judge judge = new Judge();
    private int round = 0;

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
