package makise.ooad.lab2.pointgame;

import java.util.ArrayList;

//只是一个游戏的相关成员的封装
public class PointGame {
    //    可以将0号玩家固定为庄家
    private ArrayList<Player> players = new ArrayList<>();
    private Dealer dealer = new Dealer();
    private Judge judge = new Judge();
    private int round = 0;
}
